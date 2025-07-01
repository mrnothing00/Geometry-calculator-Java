import java.io.*;
import javax.swing.*;

public class FileManager {
    public static void writeToFile(String shape, double value, String operation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("geometry_data.txt", true))) {
            writer.write(String.format("%s: %s = %.2f%n", shape, operation, value));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
