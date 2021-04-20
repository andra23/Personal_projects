package ro.axonsoft.internship21.company.pay;
import ro.axonsoft.internship21.company.cnp.CnpParts;
import java.math.BigDecimal;

/**
 * Reprezinta o plata.
 */
public class Payment {
    private CnpParts cnp;
    private BigDecimal paymentAmount;

    /**
     * Input: CnpParts, BigDecimal.
     * Constrctor cu parametri.
     * Formeaza o inregistrare ce contine cnp ul si plata.
     */
    public Payment(CnpParts cnp, BigDecimal pA) {
        this.cnp = cnp;
        this.paymentAmount = pA;
    }

    /**
     * Ouput: BigDecimal.
     *Returneaza suma platii.
     */
    public BigDecimal getPaymentAmount() {
        return this.paymentAmount;
    }

    /**
     * Input: CnpParts.
     *Returneaza cnp-ul persoanei care a facut plata.
     */
    public CnpParts getCnp() {
        return this.cnp;
    }
}
