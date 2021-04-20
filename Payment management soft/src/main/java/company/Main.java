package ro.axonsoft.internship21.company;
import ro.axonsoft.internship21.company.pay.PayMetricsProcessor;
import ro.axonsoft.internship21.company.pay.PayMetricsProcessorImpl;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        PayMetricsProcessor pmp = new PayMetricsProcessorImpl();


        try {
            FileInputStream fileInput = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\ro.axonsoft.internship21\\src\\main\\java\\ro\\axonsoft\\internship21\\company\\fisier.txt");
            FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\hp\\IdeaProjects\\ro.axonsoft.internship21\\src\\main\\java\\ro\\axonsoft\\internship21\\company\\fisier_out.txt");
            pmp.process(fileInput,fileOutput);
        } catch (IOException e) {

            e.printStackTrace();
        }
        assertFalse(false);


    }
}
