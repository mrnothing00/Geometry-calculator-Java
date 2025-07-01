import javax.swing.SwingUtilities;

public class GeometryCalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GeometryCalculatorFrame calculatorFrame = new GeometryCalculatorFrame();
            calculatorFrame.setVisible(true);
        });
    }
}
