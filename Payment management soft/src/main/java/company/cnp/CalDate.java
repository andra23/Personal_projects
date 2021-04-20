package ro.axonsoft.internship21.company.cnp;

/**
 * Reprezinta data de nastere a unei persoane.
 * Este formata din zi ,luna si an.
 */
public class CalDate {

    private final short year;
    private final byte month;
    private final byte day;

    /**
     * Input: year, month, day
     *Constructor cu parametri.
     *Formeaza un obiect de tip CalDate pe baza parametrilor pe care ii primeste.
     */
    public CalDate(short year, byte month, byte day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Output: year
     * Returneaza anul obiectului curent.
     */
    public short year() {
        return this.year;
    }

    /**
     * Output: month
     * Returneaza luna obiectlui curent.
     */
    public byte month() {
        return this.month;

    }

    /**
     * Output: day
     * Returneaza ziua obiectului curent.
     */
    public byte day() {
        return this.day;
    }

}

