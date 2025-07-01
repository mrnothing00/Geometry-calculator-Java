import java.awt.event.*;

public class MenuActionListener implements ActionListener {
    private GeometryCalculatorFrame frame;

    public MenuActionListener(GeometryCalculatorFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand().toLowerCase();
        frame.setCurrentShape(command);
        frame.updateLabels(command);
        frame.setFieldsEditable(command);
        frame.clearFields();
    }
}
