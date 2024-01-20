import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 25/12/2023
 * Time      : 8:14 CH
 * Filename  : Main
 */public class Main {
    public static void main(String[] args) {

        String filePath = "demo.sql"; // Thay thế bằng đường dẫn file của bạn
        String regex = "'\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\+\\d{4}'";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result" + ".sql"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                String updatedLine = matcher.replaceAll("CURRENT_TIMESTAMP");
                writer.write(updatedLine + "\n");
            }
            System.out.println("File updated successfully!");

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
//        String input = "2023-12-25T19:18:46.509+0700";
//        String regex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\+\\d{4}";
//
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//
//        if (matcher.matches()) {
//            System.out.println("The input string matches the specified format.");
//        } else {
//            System.out.println("The input string does not match the specified format.");
//        }
    }
}
