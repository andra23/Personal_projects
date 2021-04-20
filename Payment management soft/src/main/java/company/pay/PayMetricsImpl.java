package ro.axonsoft.internship21.company.pay;

import ro.axonsoft.internship21.company.cnp.CnpParts;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

/**
 * Implementarea clasei PayMetrics.
 */
public class PayMetricsImpl implements PayMetrics, Serializable {

    private Pair pair;
    private PayError error;

    /**
     * Input: Pair
     * Constrcutor cu parametri.
     */

    PayMetricsImpl(Pair pair) {
        this.pair = pair;

    }

    /**
     * Ouput: BigDecimal
     * Calculeaza media tuturor platilor efectuate.
     */
    @Override
    public BigDecimal averagePaymentAmount() {
        BigDecimal average;
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < pair.getRepo().size(); i++) {
            sum = sum.add(pair.getRepo().get(i).getPaymentAmount());

        }
        average = sum.divide(BigDecimal.valueOf(pair.getRepo().size()), 3, RoundingMode.CEILING);
        return average;

    }

    /**
     * Ouput: Integer
     * Calculeaza nuamrul de palti a caror valoarea este mai mare sau egala cu 5000 RON.
     */
    @Override
    public Integer bigPayments() {
        int contor = 0;
        for (int i = 0; i < pair.getRepo().size(); i++) {
            int res = pair.getRepo().get(i).getPaymentAmount().compareTo(BigDecimal.valueOf(5000));
            if (res >= 0) {
                contor++;
            }
        }
        return contor;
    }

    /**
     * Ouput: Integer
     *Calculeaza nuamrul de plati a caror valoarea este mai mica de 5000 RON.
     */
    @Override
    public Integer smallPayments() {
        int contor = 0;
        for (int i = 0; i < pair.getRepo().size(); i++) {
            int res = pair.getRepo().get(i).getPaymentAmount().compareTo(BigDecimal.valueOf(5000));
            if (res < 0) {
                contor++;
            }
        }
        return contor;
    }

    /**
     *Calculeaza nuamrul de palti efectuate de persoane care nu au implinit vasrta majoratului.
     */
    @Override
    public Integer paymentsByMinors() {
        int contor = 0;
        for (int i = 0; i < pair.getRepo().size(); i++) {
            short year = pair.getRepo().get(i).getCnp().birthDate().year();
            byte month = pair.getRepo().get(i).getCnp().birthDate().month();
            byte day = pair.getRepo().get(i).getCnp().birthDate().day();
            LocalDate today = LocalDate.now();                          //Today's date
            LocalDate birthday = LocalDate.of(year, month, day);  //Birth date
            Period p = Period.between(birthday, today);
            if (p.getYears() < 18) {
                contor++;
            }
        }
        return contor;
    }

    /**
     * Ouput: Bigdecimal.
     *Calculeaza numarul de plati efectuate de cetateni romani nascuti in Bucuresti.
     */
    @Override
    public BigDecimal totalAmountCapitalCity() {
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < pair.getRepo().size(); i++) {
            if (!pair.getRepo().get(i).getCnp().foreigner() && pair.getRepo().get(i).getCnp().Judet().compareTo(CnpParts.Judet.BU) == 1) {
                sum = sum.add(pair.getRepo().get(i).getPaymentAmount());
            }

        }
        return sum;
    }

    /**
     * Output: Integer
     *Calculeaza numarul de persoane straine care au efectuat palti.
     */
    @Override
    public Integer foreigners() {
        int contor = 0;
        for (int i = 0; i < pair.getRepo().size(); i++) {
            if (pair.getRepo().get(i).getCnp().foreigner()) {
                contor++;
            }
        }
        return contor;
    }

    /**
     * Ouput: PayError.
     * Returneaza o eroare ( linia si tipul ei).
     */
    @Override
    public PayError errors() {
        return this.error;

    }

    /**
     * Input: OutputStream
     * Serializeaza un obiect de tip PayMetrics.
     * @throws IOException
     */
    @Override
    public void writeObject(OutputStream out) throws IOException {

        OutputStreamWriter osw = new OutputStreamWriter(out);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("Average payment amount: " + averagePaymentAmount());
        bw.newLine();
        bw.write("Small payments: " + smallPayments());
        bw.newLine();
        bw.write("Big payments: " + bigPayments());
        bw.newLine();
        bw.write("Payments by minors: " + paymentsByMinors());
        bw.newLine();
        bw.write("Total amount capital city (BU): " + totalAmountCapitalCity());
        bw.newLine();
        bw.write("Foreigners: " + foreigners());
        bw.newLine();
        bw.write("Errors: ");
        if (pair.getList().size() == 0) {
            bw.write("There are no errors.");
        }
        bw.newLine();
        for (int i = 0; i < pair.getList().size(); i++) {

            bw.write("       Line: " + String.valueOf(pair.getList().get(i).line()));
            bw.newLine();
            bw.write("       Type: " + (String.valueOf(pair.getList().get(i).type())));
            bw.newLine();
            bw.newLine();
        }


        bw.close();

    }
}
