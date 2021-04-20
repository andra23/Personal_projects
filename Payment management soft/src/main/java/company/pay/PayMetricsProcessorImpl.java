package ro.axonsoft.internship21.company.pay;
import ro.axonsoft.internship21.company.cnp.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Implementarea clasei PayMetricsProcessor
 */
public class PayMetricsProcessorImpl implements PayMetricsProcessor {
    private InputStream in;
    private OutputStream out;
    private CnpValidator cnpVal = new CnpValidatorImpl();

    /**
     * Input: InputStream, OuputStream
     * Proceseaza platile si afiseaza in fisier informatiile cerute.
     * @throws IOException
     */
    @Override
    public void process(InputStream paymentsInputStream, OutputStream metricsOutputStream) throws IOException {
        Pair pair = readFromFile(paymentsInputStream);
        Serializable payMetrics = new PayMetricsImpl(pair);
        payMetrics.writeObject(metricsOutputStream);

    }

    /**
     * Input: InputStream
     * Ouput: Pair
     * Citeste fiecare linie din fisier si o valideaza.
     * Daca linia prezinta erori, acestea sunt adaugate intr-o lista formata din obiecte de tip PayError.
     * In caz contrar, se formeaza un obiect de tip Payment si se stocheaza intr-un vector.
     * Vectorul de obiecte "Payment" si lista de erori se incapsuleaza intr un obiect de tip Pair.
     * @throws IOException
     */
    public Pair readFromFile(InputStream in) throws IOException {
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        Vector<Payment> repo = new Vector<>();
        List<PayError> errorsList = new ArrayList<>();
        int currentLine = -1;
        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {
                currentLine++;
                if (lineValidator(line)) {
                    PayError lineError = new PayErrorImpl(currentLine + 1, 0);
                    errorsList.add(lineError);
                    continue;
                }
                String[] components = line.split(";");
                CnpParts CNP;
                try {
                    CNP = cnpVal.validateCnp(components[0]);
                } catch (CnpException e) {
                    PayError cnpError = new PayErrorImpl(currentLine + 1, 1);
                    errorsList.add(cnpError);
                    continue;
                }
                if (payAmountValidator(components[1])) {
                    PayError payAmountError = new PayErrorImpl(currentLine + 1, 2);
                    errorsList.add(payAmountError);
                    continue;
                }

                BigDecimal plata = new BigDecimal(components[1]);
                Payment p = new Payment(CNP, plata);
                repo.add(p);


            }
        }
        Pair p = new Pair(repo, errorsList);
        return p;

    }

    /**
     * Input: String
     * Ouput: Boolean
     * Valideaza un string. ( O linie citita din fisier).
     * Se verifica daca fiecare caracter din string este compatibil cu posibilele caractere care pot aparea intr-o linie valida.
     */
    public boolean lineValidator(String line) {

        for (int i = 0; i < line.length(); i++) {
            if ("0123456789;.- ".indexOf(line.charAt(i)) == -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Input: String
     * Ouput: Boolean
     * Valideaza suma paltii.
     *Se verifica daca aceasta contine doar cifre si characterul ".".
     * Caracterul punct poate aparea doar o singura data.
     */
    public boolean payAmountValidator(String payAmount) {
        int count=0;
        for (int i = 0; i < payAmount.length(); i++) {
            if ("0123456789.".indexOf(payAmount.charAt(i)) == -1) {
                return true;

            }
            if(Character.toString(payAmount.charAt(i)).matches(";")){
                count++;
            }
        }
        if(count>1) return true;

        return false;
    }


}

