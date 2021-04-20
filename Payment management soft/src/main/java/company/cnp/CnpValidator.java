package ro.axonsoft.internship21.company.cnp;

/**
 * Valideaza un obiect de tip CnpParts.
 */
public interface CnpValidator {
    CnpParts validateCnp(String cnp) throws CnpException;

}

