package ro.axonsoft.internship21.company.pay;

import java.io.*;

/**
 * Proceseaza paltile (citire din fisier, procesare, afisare).
 */
public interface PayMetricsProcessor {
    void process(InputStream in, OutputStream out) throws IOException;
}
