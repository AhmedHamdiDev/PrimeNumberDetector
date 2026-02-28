import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame1 {
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JLabel label;
    private JButton button;
    private JLabel DisplayLabel;
    private JPanel DisplayPanel;

    public Frame1() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Prime Detector");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("resources/Calculator.jpg"));
        frame.setIconImage(icon.getImage());

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        label = new JLabel("Enter a number");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(label);

        ActionListener primeCheckListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long number = Long.parseLong(textField.getText().trim());

                    if (TheCode.primeDetector(number)) {
                        DisplayLabel.setText(number + " is prime.");
                    } else {
                        DisplayLabel.setText(number + " isn't prime.");
                    }

                    if (!DisplayPanel.isVisible()) {
                        DisplayPanel.setVisible(true);
                        DisplayPanel.add(DisplayLabel);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please Enter a Valid Number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };


        DisplayPanel = new JPanel();
        DisplayPanel.setLayout(new FlowLayout());
        DisplayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        DisplayPanel.setVisible(false);

        DisplayLabel = new JLabel();
        DisplayLabel.setFont(new Font("Serif", Font.BOLD, 30));

        textField = createJTextField();
        textField.addActionListener(primeCheckListener);
        panel.add(textField);

        button = new JButton("Enter");
        button.setFocusable(false);
        button.setBackground(Color.lightGray);
        button.setForeground(Color.black);
        button.addActionListener(primeCheckListener);

        panel.add(button);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(DisplayPanel, BorderLayout.CENTER);
    }


    public void show() {
        frame.setVisible(true);
    }

    private JTextField createJTextField() {
        return new JTextField(10);
    }
}
