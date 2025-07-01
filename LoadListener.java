import java.awt.event.*;
import java.io.*;
import javax.swing.JTextArea;

public class LoadListener implements ActionListener {
    private JTextArea displayArea;

    public LoadListener(JTextArea displayArea) {
        this.displayArea = displayArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("shapes.dat"))) {
            String data = (String) in.readObject();
            displayArea.append("Loaded data:\n" + data);
        } catch (IOException | ClassNotFoundException ex) {
            displayArea.append("Error loading data: " + ex.getMessage() + "\n");
        }
    }
}
