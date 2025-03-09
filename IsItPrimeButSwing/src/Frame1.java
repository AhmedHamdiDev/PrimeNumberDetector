import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;

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
        ImageIcon icon = new ImageIcon("C:\\Program Files\\Prime Detector\\Calculator.jpg");
        frame.setIconImage(icon.getImage());

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        label = new JLabel("Enter a number");
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(label);


        DisplayPanel = new JPanel();
        DisplayPanel.setLayout(new FlowLayout());
        DisplayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        DisplayPanel.setVisible(false);

        DisplayLabel = new JLabel();
        DisplayLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        textField = createJTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    TheCode code = new TheCode();
                    long number = Long.valueOf(textField.getText());
                    code.primeDetector(number);


                    if (TheCode.IsItPrime) {
                        DisplayLabel.setText(number + " is prime.");
                        DisplayLabel.setVisible(true);
                        DisplayPanel.setVisible(true);
                        DisplayPanel.add(DisplayLabel);
                    } else {
                        DisplayLabel.setText(number + " isn't prime.");
                        DisplayLabel.setVisible(true);
                        DisplayPanel.setVisible(true);
                        DisplayPanel.add(DisplayLabel);
                    }

                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(frame, "Please Enter a Valid Number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(textField);

        button = new JButton("Enter");
        button.setFocusable(false);
        button.setBackground(Color.lightGray);
        button.setForeground(Color.black);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TheCode code = new TheCode();
                    Long number = Long.valueOf(textField.getText());
                    code.primeDetector(number);


                    if (TheCode.IsItPrime) {
                        DisplayLabel.setText(number + " is prime.");
                        DisplayLabel.setVisible(true);
                        DisplayPanel.setVisible(true);
                        DisplayPanel.add(DisplayLabel);
                    } else {
                        DisplayLabel.setText(number + " isn't prime.");
                        DisplayLabel.setVisible(true);
                        DisplayPanel.setVisible(true);
                        DisplayPanel.add(DisplayLabel);
                    }

                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(frame, "Please Enter a Valid Number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(button);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(DisplayPanel, BorderLayout.CENTER);
    }


    public void show() {
        frame.setVisible(true);
    }

    private JTextField createJTextField() {
        JTextField textField = new JTextField(10);

        return textField;

    }
}

