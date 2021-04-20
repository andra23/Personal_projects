package ro.axonsoft.internship21.company.pay;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Serializeaza un obiect de tip PayMetrics.
 */
public interface Serializable {
    public void writeObject(OutputStream out) throws IOException;
}
