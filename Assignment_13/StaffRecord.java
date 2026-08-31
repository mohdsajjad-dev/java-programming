import java.io.*;

public class StaffRecord {

    public static void main(String[] args) {

        try {
            // Store employee details in file
            FileWriter fileOut = new FileWriter("staffdata.txt");

            fileOut.write("Employee ID: 205\n");
            fileOut.write("Name: Arjun Mehta\n");
            fileOut.write("Department: Finance\n");
            fileOut.write("Salary: 52000\n");

            fileOut.close();

            // Retrieve employee details from file
            FileReader fileIn = new FileReader("staffdata.txt");
            BufferedReader dataReader = new BufferedReader(fileIn);

            String record;

            System.out.println("Employee Details:");

            while ((record = dataReader.readLine()) != null) {
                System.out.println(record);
            }

            dataReader.close();

        } catch (IOException error) {
            System.out.println("File operation failed: " + error.getMessage());
        }
    }
}