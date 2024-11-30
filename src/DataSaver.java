import java.io.*;
import java.util.*;
import java.util.regex.*;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        while (true) {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter ID Number (6 digits): ");
            String id = scanner.nextLine();
            while (!Pattern.matches("\\d{6}", id)) {
                System.out.print("Invalid ID. Enter again (6 digits): ");
                id = scanner.nextLine();
            }
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Year of Birth: ");
            String year = scanner.nextLine();

            // Create CSV record
            String record = String.format("%s, %s, %s, %s, %s", firstName, lastName, id, email, year);
            records.add(record);

            System.out.print("Do you want to enter another record? (y/n): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")) {
                break;
            }
        }

        // Ask for file name and save the data
        System.out.print("Enter file name (with .csv extension): ");
        String fileName = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
