package ro.axonsoft.internship21.company.pay;

/**
 * Implementarea clasei PayError.
 */
public class PayErrorImpl implements PayError {
    private Integer line;
    private Integer type;

    /**
     * Input: line, type( 0 - linie, 1- Cnp, 2 plata)
     * Constrcutor cu parametri.
     * Formeaza un obiect de tip PayError.
     */
    PayErrorImpl(Integer line, Integer type) {
        this.line = line;
        this.type = type;
    }

    /**
     * Input: Integer
     * Rturneaza linia.
     */
    @Override
    public Integer line() {
        return line;
    }

    /**
     * Input: Integer.
     * Retureaza tipul.
     */
    @Override
    public Integer type() {
        return type;
    }

}
