import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frame1 frame1 = new Frame1();
                frame1.show();
            }
        });
    }
}