package ro.axonsoft.internship21.company.pay;

import java.util.List;
import java.util.Vector;

/**
 * Reprezinta o pereche formata dintr-un vector ce contine platile efectuate si o lista ce contine
 * erorile aparute la citirea din fisier.
 */
public class Pair {
    private Vector<Payment> repo;
    private List<PayError> list;

    /**
     * Input: Vector<Payment>, List<PayError>
     * Constrcutor cu parametri.
     */
    Pair(Vector<Payment> repo, List<PayError> list) {
        this.repo = repo;
        this.list = list;
    }

    /**
     * Output: Vector</Payment>
     * Returneaza platile citite din fisier.
     */
    public Vector<Payment> getRepo() {
        return this.repo;
    }

    /**
     * Output: List</PayError>
     * Returneaza erorile aparute la citirea din fiser.
     */
    public List<PayError> getList() {
        return this.list;
    }
}
