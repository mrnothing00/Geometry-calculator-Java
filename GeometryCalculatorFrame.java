import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GeometryCalculatorFrame extends JFrame {
    private JTextField lengthField, widthField, radiusField, baseField, heightField;
    private JButton calculateButton, volumeButton;
    private JLabel shapeNameLabel, formulaLabel;
    private JMenuItem circleItem, rectangleItem, triangleItem, sphereItem, cubeItem, cylinderItem, cuboidItem, coneItem;
    private String currentShape;
    private JTextArea displayArea;

    public GeometryCalculatorFrame() {
        setTitle("Geometry Calculator");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenuBar();
        createMainLayout();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu shapeMenu = new JMenu("Shapes");
        shapeMenu.setMnemonic(KeyEvent.VK_S);

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.setMnemonic(KeyEvent.VK_L);
        loadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_E);

        MenuActionListener menuListener = new MenuActionListener(this);

        circleItem = createMenuItem("Circle", KeyEvent.VK_1, menuListener);
        rectangleItem = createMenuItem("Rectangle", KeyEvent.VK_2, menuListener);
        triangleItem = createMenuItem("Triangle", KeyEvent.VK_3, menuListener);
        sphereItem = createMenuItem("Sphere", KeyEvent.VK_4, menuListener);
        cubeItem = createMenuItem("Cube", KeyEvent.VK_5, menuListener);
        cylinderItem = createMenuItem("Cylinder", KeyEvent.VK_6, menuListener);
        cuboidItem = createMenuItem("Cuboid", KeyEvent.VK_7, menuListener);
        coneItem = createMenuItem("Cone", KeyEvent.VK_8, menuListener);

        shapeMenu.add(circleItem);
        shapeMenu.add(rectangleItem);
        shapeMenu.add(triangleItem);
        shapeMenu.add(sphereItem);
        shapeMenu.add(cubeItem);
        shapeMenu.add(cylinderItem);
        shapeMenu.add(cuboidItem);
        shapeMenu.add(coneItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        menuBar.add(shapeMenu);
        menuBar.add(fileMenu);
        menuBar.add(exitItem);

        setJMenuBar(menuBar);

        saveItem.addActionListener(new SaveListener(displayArea));
        loadItem.addActionListener(new LoadListener(displayArea));
        exitItem.addActionListener(e -> System.exit(0));
    }

    private JMenuItem createMenuItem(String shape, int keyEvent, MenuActionListener listener) {
        JMenuItem item = new JMenuItem(shape);
        item.setAccelerator(KeyStroke.getKeyStroke(keyEvent, ActionEvent.CTRL_MASK));
        item.addActionListener(listener);
        return item;
    }

    private JButton createButton(String operation) {
        JButton button = new JButton(operation);
        button.addActionListener(e -> performCalculation(operation.toLowerCase()));
        return button;
    }

    private void createMainLayout() {
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel(new GridLayout(2, 1));
        shapeNameLabel = new JLabel("Select a shape", SwingConstants.CENTER);
        formulaLabel = new JLabel("", SwingConstants.CENTER);
        northPanel.add(shapeNameLabel);
        northPanel.add(formulaLabel);

        add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(15, 1));

        lengthField = new JTextField(5);
        widthField = new JTextField(5);
        radiusField = new JTextField(5);
        baseField = new JTextField(5);
        heightField = new JTextField(5);

        centerPanel.add(new JLabel("Length (CM)"));
        centerPanel.add(lengthField);
        centerPanel.add(new JSeparator());

        centerPanel.add(new JLabel("Width (CM)"));
        centerPanel.add(widthField);
        centerPanel.add(new JSeparator());

        centerPanel.add(new JLabel("Radius (CM)"));
        centerPanel.add(radiusField);
        centerPanel.add(new JSeparator());

        centerPanel.add(new JLabel("Base (CM)"));
        centerPanel.add(baseField);
        centerPanel.add(new JSeparator());

        centerPanel.add(new JLabel("Height (CM)"));
        centerPanel.add(heightField);
        centerPanel.add(new JSeparator());

        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        calculateButton = createButton("Calculate Surface Area");
        volumeButton = createButton("Calculate Volume");
        buttonPanel.add(calculateButton);
        buttonPanel.add(volumeButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setRows(10);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        southPanel.add(buttonPanel, BorderLayout.NORTH);
        southPanel.add(scrollPane, BorderLayout.CENTER);

        add(southPanel, BorderLayout.SOUTH);
    }

    public void updateLabels(String shape) {
        switch (shape) {
            case "circle":
                shapeNameLabel.setText("Circle");
                formulaLabel.setText("<html>Area = π * Radius^2</html>");
                break;
            case "rectangle":
                shapeNameLabel.setText("Rectangle");
                formulaLabel.setText("<html>Area = Length * Width</html>");
                break;
            case "triangle":
                shapeNameLabel.setText("Triangle");
                formulaLabel.setText("<html>Area = 0.5 * Base * Height</html>");
                break;
            case "sphere":
                shapeNameLabel.setText("Sphere");
                formulaLabel.setText("<html>Surface Area = 4 * π * Radius^2<br>Volume = (4/3) * π * Radius^3</html>");
                break;
            case "cube":
                shapeNameLabel.setText("Cube");
                formulaLabel.setText("<html>Surface Area = 6 * Length^2<br>Volume = Length^3</html>");
                break;
            case "cylinder":
                shapeNameLabel.setText("Cylinder");
                formulaLabel.setText("<html>Surface Area = 2 * π * Radius * (Radius + Height)<br>Volume = π * Radius^2 * Height</html>");
                break;
            case "cuboid":
                shapeNameLabel.setText("Cuboid");
                formulaLabel.setText("<html>Surface Area = 2 * (Length*Width + Width*Height + Height*Length)<br>Volume = Length * Width * Height</html>");
                break;
            case "cone":
                shapeNameLabel.setText("Cone");
                formulaLabel.setText("<html>Surface Area = π * Radius * (Radius + Height)<br>Volume = (1/3) * π * Radius^2 * Height</html>");
                break;
        }
    }

    public void setFieldsEditable(String shape) {
        lengthField.setEditable(false);
        widthField.setEditable(false);
        radiusField.setEditable(false);
        baseField.setEditable(false);
        heightField.setEditable(false);

        switch (shape) {
            case "circle":
                radiusField.setEditable(true);
                break;
            case "rectangle":
                lengthField.setEditable(true);
                widthField.setEditable(true);
                break;
            case "triangle":
                baseField.setEditable(true);
                heightField.setEditable(true);
                break;
            case "sphere":
                radiusField.setEditable(true);
                break;
            case "cube":
                lengthField.setEditable(true);
                break;
            case "cylinder":
                radiusField.setEditable(true);
                heightField.setEditable(true);
                break;
            case "cuboid":
                lengthField.setEditable(true);
                widthField.setEditable(true);
                heightField.setEditable(true);
                break;
            case "cone":
                radiusField.setEditable(true);
                heightField.setEditable(true);
                break;
        }
    }

    public void clearFields() {
        lengthField.setText("");
        widthField.setText("");
        radiusField.setText("");
        baseField.setText("");
        heightField.setText("");
    }

    private void performCalculation(String operation) {
        if (currentShape == null) {
            JOptionPane.showMessageDialog(this, "Please select a shape first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Shape shape;
            switch (currentShape) {
                case "circle":
                    shape = new Circle(Double.parseDouble(radiusField.getText()));
                    break;
                case "rectangle":
                    shape = new Rectangle(Double.parseDouble(lengthField.getText()), Double.parseDouble(widthField.getText()));
                    break;
                case "triangle":
                    shape = new Triangle(Double.parseDouble(baseField.getText()), Double.parseDouble(heightField.getText()));
                    break;
                case "sphere":
                    shape = new Sphere(Double.parseDouble(radiusField.getText()));
                    break;
                case "cube":
                    shape = new Cube(Double.parseDouble(lengthField.getText()));
                    break;
                case "cylinder":
                    shape = new Cylinder(Double.parseDouble(radiusField.getText()), Double.parseDouble(heightField.getText()));
                    break;
                case "cuboid":
                    shape = new Cuboid(Double.parseDouble(lengthField.getText()), Double.parseDouble(widthField.getText()), Double.parseDouble(heightField.getText()));
                    break;
                case "cone":
                    shape = new Cone(Double.parseDouble(radiusField.getText()), Double.parseDouble(heightField.getText()));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown shape: " + currentShape);
            }

            double result;
            if (operation.contains("surface")) {
                result = ShapeCalculator.calculateSurfaceArea(shape);
            } else {
                result = ShapeCalculator.calculateVolume(shape);
            }

            String unit = operation.contains("surface") ? " cm²" : " cm³";
            FileManager.writeToFile(currentShape, result, operation.contains("surface") ? "Surface Area" : "Volume");
            displayArea.append(String.format("%s: %s = %.2f%s%n", currentShape, operation.contains("surface") ? "Surface Area" : "Volume", result, unit));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setCurrentShape(String shape) {
        this.currentShape = shape;
    }
}
