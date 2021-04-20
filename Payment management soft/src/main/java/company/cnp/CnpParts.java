package ro.axonsoft.internship21.company.cnp;

/**
 * Reprezinta un cod CNP avand urmatorul format: S|AA|LL|ZZ|JJ|NNN|C unde:
 * S - sexul
 * AA - anul
 * LL - luna
 * JJ - Judetul
 * NNN - numarul de ordine
 * C - cifra de control
 */
public interface CnpParts {
    Sex sex();

    Boolean foreigner();

    CalDate birthDate();

    Judet Judet();

    Integer orderNumber();

    /**
     * Reprezinta un judet.
     * Aceste pot lua valori de la 1 la 40 + 51,52.
     */
    enum Judet {
        AB(1), AG(3), AR(2), BU(40), BC(4), BH(5), BN(6), BR(9), BT(7), BV(8), BZ(10),
        CJ(12), CL(51), CS(11), CT(13), CV(14), DB(15), DJ(16), GJ(18), GL(17), GR(52),
        HD(20), HR(19), IF(23), IL(21), IS(22), MH(25), MM(24), MS(26), NT(27), OT(28),
        PH(29), SB(32), SJ(31), SM(30), SV(33), TL(36), TM(35), TR(34), VL(38), VN(39),
        VS(37);

        private int id;

        /**
         * Input: id
         * Constructor cu parametri.
         * Formeaza un obiect de tip "Judet".
         */
        Judet(int id) {
            this.id = id;
        }

        /**
         * Input: id
         * Output: boolean
         * Compara doua judete dupa cod si returneaza o valoare de tip booelan.
         */
        public boolean equals(int id) {
            if (this.id == id) {
                return true;
            }
            return false;
        }

        /**
         * Input: id
         * Ouput: Judet (poate arunca erori)
         * Cauta un judet dupa id si returneaza cele doua cifre din prescurtarea lui.
         */
        public static Judet getById(int id) {
            for (Judet e : values()) {
                if (e.equals(id)) return e;
            }
            throw new IllegalArgumentException();

        }
    }

    /**
     * Reprezinta genul persoanei: M, F sau U unde:
     * M - masculin
     * F - feminin
     * U - necunoscut
     */
    enum Sex {
        M, F, U;

        /**
         * Input: id
         * Output: Sex
         * Returneaza sexul in functie de id-ul corespunzator.
         */
        public static Sex fromCode(int id) {
            switch (id) {
                case 1:
                    return M;
                case 2:
                    return F;
                case 3:
                    return M;
                case 4:
                    return F;
                case 5:
                    return M;
                case 6:
                    return F;
                case 7:
                    return M;
                case 8:
                    return F;
                case 9:
                    return M;

                default:
                    return null;
            }
        }

    }
}


