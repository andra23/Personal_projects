package ro.axonsoft.internship21.company.pay;

import java.math.BigDecimal;

/**
 * PayMetrics este o clasa ce extrage informatiile cerute utilizand anumite metode.
 */
public interface PayMetrics  {
    BigDecimal averagePaymentAmount();
    Integer bigPayments();
    Integer smallPayments();
    Integer paymentsByMinors();
    BigDecimal totalAmountCapitalCity();
    Integer foreigners();
    PayError errors();

}
