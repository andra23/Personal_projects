package ro.axonsoft.internship21.company.pay;

/**
 * Reprezinta o eroare aparuta la citirea platilor.
 */
public interface PayError {
    Integer line();

    Integer type();
}
