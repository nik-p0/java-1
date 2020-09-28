package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Base extends JFrame {
    public Base(){

        setVisible(true);
        setTitle("Крестики - нолики");
        setSize(455, 520);
        setLocation(650, 500);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GameField gameField = GameField.getInstance();
        JPanel panel = new JPanel(new GridLayout());
        add(panel, BorderLayout.SOUTH);
        add(gameField, BorderLayout.CENTER);
        JButton start = new JButton("Начать новую игру");
        JButton end = new JButton("Закончить игру");
        panel.add(start);
        panel.add(end);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameField.startNewGame();
            }
        });
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        gameField.startNewGame();
    }
}
