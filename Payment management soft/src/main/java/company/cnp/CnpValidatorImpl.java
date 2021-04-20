package ro.axonsoft.internship21.company.cnp;

import java.util.Calendar;
import java.util.Vector;

/**
 * Implementarea clasei CnpValidator.
 */
public class CnpValidatorImpl implements CnpValidator {
    /**
     * Input: String
     * Output: CnpParts
     * @throws CnpException
     * Valideaza un obiect de tip CNP.
     * 1) Verifica daca cnp-ul contine exact 13 cifre.
     * 2) Verifica daca cnp-ul este foarmat doar din cifre.
     * 3) Pe baza algortimului de verificare a validitatii unui cnp, verifica daca cifrele din cnp pot forma un cod valid.
     * Formeaza un obiect de tip CnpParts pe baza informatiilor din stringul primir ca parametru.
     * Cetatenilor din celelalte sectoare ale Municipiului Bucuresti  li se atributie codul 40 ( pentru judet).
     */
    @Override
    public CnpParts validateCnp(String cnp) throws CnpException {
        if (cnp.length() != 13) {
            throw new CnpException("Incorrect number of digits.");
        }
        if (!cnp.matches("[0-9]+")) {
            throw new CnpException("Incorrect format.The cnp contains letters.");
        }
        Vector<Integer> cifreCnp = new Vector<>();
        int C = Integer.parseInt(String.valueOf(cnp.charAt(12)));
        for (int i = 0; i < cnp.length() - 1; i++) {
            cifreCnp.add(Integer.parseInt(String.valueOf(cnp.charAt(i))));

        }
        String constanta = "279146358279";
        Vector<Integer> cifreConst = new Vector<>();

        for (int i = 0; i < constanta.length(); i++) {
            cifreConst.add(Integer.parseInt(String.valueOf(constanta.charAt(i))));

        }
        int sum = 0;

        for (int i = 0; i < 12; i++) {
            int prod = 1;
            prod = prod * cifreCnp.get(i) * cifreConst.get(i);
            sum = sum + prod;
        }
        if (sum % 11 != C) {
            throw new CnpException("Invalid cnp");
        }
        int S = Integer.parseInt(String.valueOf(cnp.charAt(0)));
        CnpPartsImpl.Sex sex = CnpPartsImpl.Sex.fromCode(S);
        short year = 0;
        if (S == 1 || S == 2) {
            year = Short.parseShort("19" + cnp.charAt(1) + cnp.charAt(2));
        } else if (S == 3 || S == 4) {
            year = Short.parseShort("18" + cnp.charAt(1) + cnp.charAt(2));
        } else if (S == 5 || S == 6) {
            year = Short.parseShort("20" + cnp.charAt(1) + cnp.charAt(2));
        } else {
            if (S > Calendar.getInstance().get(Calendar.YEAR) % 100) {
                year = Short.parseShort("20" + cnp.charAt(1) + cnp.charAt(2));
            } else {
                year = Short.parseShort("19" + cnp.charAt(1) + cnp.charAt(2));

            }
        }
        byte month = Byte.parseByte(String.valueOf(cnp.charAt(3)) + cnp.charAt(4));
        byte day = Byte.parseByte(String.valueOf(cnp.charAt(5)) + cnp.charAt(6));

        CalDate birthDate = new CalDate(year, month, day);
        CnpPartsImpl.Judet judet = null;

        int codJudet = Integer.parseInt(String.valueOf(cnp.charAt(7)) + cnp.charAt(8));
        if (S >= 41 && S <= 48) {
            judet = CnpPartsImpl.Judet.BU;
        } else {

            judet = CnpPartsImpl.Judet.getById(codJudet);
        }

        Integer orderNumber = Integer.parseInt(String.valueOf(cnp.charAt(9)) + cnp.charAt(10) + cnp.charAt(11));

        CnpParts CNP = new CnpPartsImpl(sex, birthDate, judet, orderNumber, C);
        return CNP;


    }
}
