import java.applet.Applet;
import java.awt.*;

// Q.1: Write a Java program to create a skeleton of an applet.
public class MyApplet extends Applet {
    // Q.2: Write a Java program to create an applet window with a yellow background.
    public void init() {
        setBackground(Color.yellow);
    }

    // Q.2: Draw a string “Hello World” onto the applet window at position (40,60).
    // Set the font color as red, type as “Arial”, and size as 30.
    public void paint(Graphics g) {
        g.setColor(Color.red);
        Font font = new Font("Arial", Font.PLAIN, 30);
        g.setFont(font);
        g.drawString("Hello World", 40, 60);
    }
}

// Q.3: Write a Java program to create an applet window.
// Set background color as red. Draw shapes with labels at specific positions.
class ShapesApplet extends Applet {
    public void init() {
        setBackground(Color.red);
    }

    public void paint(Graphics g) {
        // Draw shapes with labels
        g.setColor(Color.green);
        g.drawRect(50, 50, 100, 50);
        g.drawString("Rectangle", 120, 75);

        g.setColor(Color.blue);
        g.drawOval(200, 50, 80, 80);
        g.drawString("Circle", 260, 120);

        g.setColor(Color.orange);
        int[] xPoints = {400, 450, 500};
        int[] yPoints = {50, 150, 50};
        g.drawPolygon(xPoints, yPoints, 3);
        g.drawString("Triangle", 450, 150);
    }
}

// Q.4: Using AWT package, write a Java program to create an applet window.
// Add buttons with FlowLayout manager and specified gaps.
class ButtonApplet extends Applet {
    public void init() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));

        // Add buttons to the applet window
        add(new Button("Button 1"));
        add(new Button("Button 2"));
        add(new Button("Button 3"));
        add(new Button("Button 4"));
    }
}

// Q.5: Using AWT package, write a Java program to create an applet window.
// Add Label, Button, and TextField controls with FlowLayout manager and specified gaps.
class ControlsApplet extends Applet {
    private Label lbl1;
    private Button btn1;
    private TextField tf1;

    public void init() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));

        // Initialize controls
        lbl1 = new Label("Hello");
        btn1 = new Button("OK");
        tf1 = new TextField(15);

        // Add controls to the applet window
        add(lbl1);
        add(btn1);
        add(tf1);

        // Q.6: By clicking on the “OK” button, the label of Label control is displayed onto the TextField.
        btn1.addActionListener(e -> tf1.setText(lbl1.getText()));
    }
}

// Q.7: Write an Applet Program To Do Calculation Based On Selected Operator From Choice Using ActionListener.
class CalculatorApplet extends Applet {
    private TextField num1, num2, result;
    private Choice operator;

    public void init() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));

        // Initialize controls
        num1 = new TextField(10);
        num2 = new TextField(10);
        result = new TextField(10);

        operator = new Choice();
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");

        // Add controls to the applet window
        add(new Label("Number 1:"));
        add(num1);
        add(new Label("Number 2:"));
        add(num2);
        add(new Label("Operator:"));
        add(operator);
        add(new Label("Result:"));
        add(result);

        // Add ActionListener to perform calculation
        operator.addItemListener(e -> calculate());
    }

    private void calculate() {
        double number1 = Double.parseDouble(num1.getText());
        double number2 = Double.parseDouble(num2.getText());

        String selectedOperator = operator.getSelectedItem();
        double calculatedResult = 0;

        switch (selectedOperator) {
            case "+":
                calculatedResult = number1 + number2;
                break;
            case "-":
                calculatedResult = number1 - number2;
                break;
            case "*":
                calculatedResult = number1 * number2;
                break;
            case "/":
                if (number2 != 0) {
                    calculatedResult = number1 / number2;
                } else {
                    result.setText("Cannot divide by zero");
                    return;
                }
                break;
            default:
                result.setText("Invalid operator");
                return;
        }

        result.setText(String.valueOf(calculatedResult));
    }
}
