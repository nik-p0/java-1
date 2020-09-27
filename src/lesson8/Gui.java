package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
    public static String message;
    public static int x;
    public static int y;
    public Gui(){

        setVisible(true);

        setSize(300, 300);
        setLocation(650, 200);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel2 = new JPanel(new GridLayout(1, 1));
        JLabel label = new JLabel(message);
        panel2.add(label);
        add(panel2, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(3, 3));

        JButton btn1 = new JButton("" + Lesson8.map[0][0]);
        panel.add(btn1);


        JButton btn2 = new JButton("" + Lesson8.map[0][1]);
        panel.add(btn2);

        JButton btn3 = new JButton("" + Lesson8.map[0][2]);
        panel.add(btn3);

        JButton btn4 = new JButton("" + Lesson8.map[1][0]);
        panel.add(btn4);

        JButton btn5 = new JButton("" + Lesson8.map[1][1]);
        panel.add(btn5);

        JButton btn6 = new JButton("" + Lesson8.map[1][2]);
        panel.add(btn6);

        JButton btn7 = new JButton("" + Lesson8.map[2][0]);
        panel.add(btn7);

        JButton btn8 = new JButton("" + Lesson8.map[2][1]);
        panel.add(btn8);

        JButton btn9 = new JButton("" + Lesson8.map[2][2]);
        panel.add(btn9);

        add(panel, BorderLayout.CENTER);

    }
}

