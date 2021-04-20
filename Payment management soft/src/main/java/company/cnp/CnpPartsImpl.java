package ro.axonsoft.internship21.company.cnp;

/**
 * Implementarea clasei CnpParts.
 */
public class CnpPartsImpl implements CnpParts {

    private Sex sex;
    private CalDate birthDate;
    private Judet judet;
    private Integer orderNumber;
    private Integer checkDigit;

    /**
     * Input: Sex, CalDate, Judet, Integer, Integer
     * Constructor cu parametri.
     * Creaza un CNP pe baza valorilor pe care le primeste ca parametri.
     */
    CnpPartsImpl(Sex s, CalDate b, Judet j, Integer o, Integer c) {
        this.sex = s;
        this.birthDate = b;
        this.judet = j;
        this.orderNumber = o;
        this.checkDigit = c;
    }

    /**
     * Constrcutor implicit.( fara parametri).
     * Atribuie fiecarui atribut o valoare default ( null).
     */
    public CnpPartsImpl() {
        this.sex = null;
        this.birthDate = null;
        this.judet = null;
        this.orderNumber = null;
        this.checkDigit = 0;
    }

    /**
     * Ouput: Sex
     * Returneaza genul persoanei.
     */
    @Override
    public Sex sex() {
        return this.sex;
    }

    /**
     * Ouput: boolean
     * Verifica daca persoana careia ii este atribuit cnp-ul respectiv este cetatean strain sau nu.
     */
    @Override
    public Boolean foreigner() {
        if (this.sex == Sex.U) {
            return true;
        }
        return false;
    }

    /**
     * Ouput: birthDate
     * Returneaza data de nastere.
     */
    @Override
    public CalDate birthDate() {
        return this.birthDate;
    }

    /**
     * Ouput: Judet
     * Rturneaza judetul.
     */
    @Override
    public Judet Judet() {
        return this.judet;
    }

    /**
     * Outpur: orderNumber
     * Returneaza nuamrul de ordine din cnp.
     */
    @Override
    public Integer orderNumber() {
        return this.orderNumber;

    }

}






