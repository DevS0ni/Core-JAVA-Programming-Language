import java.awt.*;
import java.awt.event.*;

public class TextEditor extends Frame {
    private TextArea textArea;
    private String selectedText;

    public TextEditor() {
        setTitle("Text Editor");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);

        textArea = new TextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // MouseListener to handle mouse events
        textArea.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    // Left click
                    showMousePosition(e);
                    setBackground(Color.BLUE);
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    // Right click
                    showStatus("Right click at: (" + e.getX() + ", " + e.getY() + ")");
                }
            }

            public void mouseExited(MouseEvent e) {
                // Mouse exit event
                setBackground(Color.WHITE);
            }
        });

        // MouseMotionListener to handle mouse motion events
        textArea.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                // Mouse move event
                showMousePosition(e);
            }
        });

        // WindowListener to handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(textArea);
        setVisible(true);
    }

    private void showMousePosition(MouseEvent e) {
        // Display mouse position in the status bar
        showStatus("Mouse Position: (" + e.getX() + ", " + e.getY() + ")");
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}
