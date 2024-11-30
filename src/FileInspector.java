import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser("src"); // Open in 'src' directory
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String fileName = file.getName();
            int linesCount = 0, wordsCount = 0, charsCount = 0;

            try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
                String line;
                while ((line = reader.readLine()) != null) {
                    linesCount++;
                    wordsCount += line.split("\\s+").length;
                    charsCount += line.length();
                }

                // Print results
                System.out.println("File: " + fileName);
                System.out.println("Lines: " + linesCount);
                System.out.println("Words: " + wordsCount);
                System.out.println("Characters: " + charsCount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

