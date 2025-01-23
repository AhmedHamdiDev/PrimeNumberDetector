import javax.swing.*;
import javax.swing.UIManager.*;
import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("An error has occurred.");
                }

                Frame1 frame1 = new Frame1();
                frame1.show();
            }
        });
    }
}