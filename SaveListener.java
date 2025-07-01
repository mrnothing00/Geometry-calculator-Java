import java.awt.event.*;
import java.io.*;
import javax.swing.JTextArea;

public class SaveListener implements ActionListener {
    private JTextArea displayArea;

    public SaveListener(JTextArea displayArea) {
        this.displayArea = displayArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("shapes.dat"))) {
            out.writeObject(displayArea.getText());
            displayArea.append("Data saved successfully.\n");
        } catch (IOException ex) {
            displayArea.append("Error saving data: " + ex.getMessage() + "\n");
        }
    }
}