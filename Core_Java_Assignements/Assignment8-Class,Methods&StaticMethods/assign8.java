import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Q.1: Using AWT package, write a Java program to create an applet window.
// Add two TextField named as tf1 and tf2. Display the sum result by pressing enter key.
public class CalculatorApplet extends Applet {
    private TextField tf1, tf2;
    private Label resultLabel;

    public void init() {
        setLayout(new FlowLayout());

        // Initialize controls
        tf1 = new TextField(10);
        tf2 = new TextField(10);
        resultLabel = new Label("Result:");

        // Add controls to the applet window
        add(new Label("Number 1:"));
        add(tf1);
        add(new Label("Number 2:"));
        add(tf2);
        add(resultLabel);

        // Add ActionListener to perform calculation on pressing enter key
        tf2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateSum();
            }
        });
    }

    private void calculateSum() {
        int number1 = Integer.parseInt(tf1.getText());
        int number2 = Integer.parseInt(tf2.getText());
        int sum = number1 + number2;

        resultLabel.setText("Result: " + sum);
    }
}

// Q.2: Write a Java program to create an applet window.
// Add four Button controls (addbtn, subbtn, mulbtn, divbtn) and a TextArea (ta1).
// Display arithmetic operation results onto the TextArea.
class ArithmeticApplet extends Applet {
    private TextArea ta1;
    private int i = 10, j = 20;

    public void init() {
        setLayout(new FlowLayout());

        // Initialize controls
        ta1 = new TextArea(10, 30);
        Button addbtn = new Button("Add");
        Button subbtn = new Button("Subtract");
        Button mulbtn = new Button("Multiply");
        Button divbtn = new Button("Divide");

        // Add controls to the applet window
        add(addbtn);
        add(subbtn);
        add(mulbtn);
        add(divbtn);
        add(ta1);

        // Add ActionListener to perform arithmetic operations
        addbtn.addActionListener(e -> ta1.append("Addition: " + (i + j) + "\n"));
        subbtn.addActionListener(e -> ta1.append("Subtraction: " + (i - j) + "\n"));
        mulbtn.addActionListener(e -> ta1.append("Multiplication: " + (i * j) + "\n"));
        divbtn.addActionListener(e -> ta1.append("Division: " + ((double) i / j) + "\n"));
    }
}

// Q.3: Create a frame window with title "Frame Example" and set background color.
// Set the size of the frame as "Width = 400" and "Height = 400". Allow closing from the close button.
class ExampleFrame extends Frame {
    public ExampleFrame() {
        // Set frame properties
        setTitle("Frame Example");
        setBackground(Color.lightGray);
        setSize(400, 400);

        // Allow closing from the close button
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        ExampleFrame frame = new ExampleFrame();
        frame.setVisible(true);
    }
}

// Q.4: Using AWT package, write a Java program to create an applet window.
// Add number of buttons with FlowLayout manager and specified gaps.
class ButtonAppletFlowLayout extends Applet {
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
// Add buttons with BorderLayout manager and specified gaps.
class ButtonAppletBorderLayout extends Applet {
    public void init() {
        setLayout(new BorderLayout(20, 30));

        // Add buttons to the applet window
        add(new Button("North"), BorderLayout.NORTH);
        add(new Button("South"), BorderLayout.SOUTH);
        add(new Button("East"), BorderLayout.EAST);
        add(new Button("West"), BorderLayout.WEST);
        add(new Button("Center"), BorderLayout.CENTER);
    }
}

// Q.6: Using AWT package, write a Java program to create a frame window.
// Give the title of the frame as "Example of BorderLayout Manager".
// Set the size of the frame as "Width = 300" and "Height = 400".
// Add buttons with BorderLayout manager and specified gaps. Allow closing from the close button.
class BorderLayoutExample extends Frame {
    public BorderLayoutExample() {
        // Set frame properties
        setTitle("Example of BorderLayout Manager");
        setSize(300, 400);

        // Allow closing from the close button
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        // Add buttons with BorderLayout manager
        setLayout(new BorderLayout(20, 30));
        add(new Button("North"), BorderLayout.NORTH);
        add(new Button("South"), BorderLayout.SOUTH);
        add(new Button("East"), BorderLayout.EAST);
        add(new Button("West"), BorderLayout.WEST);
        add(new Button("Center"), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        BorderLayoutExample frame = new BorderLayoutExample();
        frame.setVisible(true);
    }
}
