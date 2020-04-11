import java.awt.*;
import javax.swing.*;
public class gui {
    public static void start() {
        ImageIcon carta = new ImageIcon("retro.jpg");
        JFrame f1 = new JFrame("scopa");
        JPanel nordp = new JPanel();
        JPanel sudp = new JPanel();
        JPanel centerp = new JPanel();
        JPanel eastp = new JPanel();
        JLabel img = new JLabel(carta);
        f1.setLayout(new BorderLayout());
        f1.add(nordp, BorderLayout.NORTH);
        f1.add(centerp, BorderLayout.CENTER);
        f1.add(eastp, BorderLayout.EAST);
        f1.add(sudp, BorderLayout.SOUTH);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setBounds(0,0,1080,720);
        nordp.setBackground(Color.red);
        sudp.setBackground(Color.green);
        eastp.setBackground(Color.cyan);
        centerp.setBackground(Color.white);
        nordp.setLayout(new GridLayout(1,10));
        nordp.add(img);


    }
}
