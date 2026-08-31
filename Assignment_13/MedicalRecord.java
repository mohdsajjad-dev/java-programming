import java.io.*;

public class MedicalRecord {

    public static void main(String[] args) {

        try {
            // Store patient details in file
            FileWriter recordWriter = new FileWriter("medicaldata.txt");

            recordWriter.write("Patient ID: 307\n");
            recordWriter.write("Name: Neha Verma\n");
            recordWriter.write("Age: 28\n");
            recordWriter.write("Diagnosis: Migraine\n");

            recordWriter.close();

            // Retrieve patient details from file
            FileReader recordReader = new FileReader("medicaldata.txt");
            BufferedReader patientReader = new BufferedReader(recordReader);

            String patientData;

            System.out.println("Patient Details:");

            while ((patientData = patientReader.readLine()) != null) {
                System.out.println(patientData);
            }

            patientReader.close();

        } catch (IOException error) {
            System.out.println("File operation failed: " + error.getMessage());
        }
    }
}