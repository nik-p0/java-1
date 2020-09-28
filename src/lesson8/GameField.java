package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameField extends JPanel {
    private static GameField instance = null;
    static final int FIELD_SIZE = 450;
    static final int winCon = 3;
    static final char DOT_EMPTY = '.';
    boolean gameOver = false;
    int cellSize;
    int x;
    int y;
    static char [][] map;
    String gameOverMessage = "";

    public static synchronized GameField getInstance(){
        if(instance == null){
            instance = new GameField();
        }
        return instance;
    }

    void startNewGame() {
        gameOver = false;
        cellSize = FIELD_SIZE / winCon;
        map = new char[winCon][winCon];
        repaint();
        for (int i = 0; i < winCon; i++) {
            for (int j = 0; j < winCon; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

    }

    private GameField(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX() / cellSize;
                y = e.getY() / cellSize;
                if (!gameOver){
                    game();
                }
            }
        });
    }
    void game(){
        Player player = new Player('X');
        AI ai = new AI('O', player.sign);
        if (!gameOver) {
            if (player.turn(x, y)) {
                if (player.win()) {
                    gameOver = true;
                    gameOverMessage = "Вы выиграли!";
                }
                if (isMapFull()) {
                    gameOver = true;
                    gameOverMessage = "Ничья!";
                }
                repaint();
                if (!gameOver) {
                    ai.turn();
                }
                if (ai.win()) {
                    gameOver = true;
                    gameOverMessage = "Вы проиграли!";
                }
                repaint();
                if (isMapFull() && !ai.win()) {
                    gameOver = true;
                    gameOverMessage = "Ничья!";
                }
            }
        }
    }

    boolean isCellValid(int x, int y){
        if (x < 0 || x > winCon || y < 0 || y > winCon){
            return false;
        }
        if (map[x][y] == DOT_EMPTY){
            return true;
        }
        return false;

    }

    public boolean isMapFull(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWinner(char symb){
        int line;
        int column;
        int diag;
        int diagOp;

        for (int i = 0; i < winCon; i++) {
            line = 0;
            column = 0;
            diag = 0;
            diagOp = 0;
            for (int j = 0; j < winCon ; j++) {

                if (map[i][j] == symb){
                    line++;
                } else {
                    line = 0;
                }
                if (line == winCon) return true;

                if (map[j][i] == symb){
                    column++;
                } else {
                    column = 0;
                }
                if (column == winCon) return true;

                if (map[j][j] == symb){
                    diag++;
                } else {
                    diag = 0;
                }
                if (diag == winCon) return true;

                if (map[j][winCon - j - 1] == symb){
                    diagOp++;
                } else {
                    diagOp = 0;
                }
                if (diagOp == winCon) return true;
            }
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <= winCon; i++) {
            g.drawLine(0, i * cellSize, FIELD_SIZE, i * cellSize);
            g.drawLine(i * cellSize, 0, i * cellSize, FIELD_SIZE);
        }
        for (int i = 0; i < winCon; i++) {
            for (int j = 0; j < winCon; j++) {
                if (map[i][j] != DOT_EMPTY) {
                    if (map[i][j] == 'X') {
                        g.setColor(Color.RED);
                        g.drawLine((i * cellSize), (j * cellSize), (i + 1) * cellSize, (j + 1) * cellSize);
                        g.drawLine((i + 1) * cellSize, (j * cellSize), (i * cellSize), (j + 1) * cellSize);
                    }
                    if (map[i][j] == 'O') {
                        g.setColor(Color.BLUE);
                        g.drawOval((i * cellSize), (j * cellSize), cellSize, cellSize);
                    }
                }
            }
        }

        if (gameOver) {
            g.setColor(Color.BLACK);
            g.fillRect(0, FIELD_SIZE / 2, FIELD_SIZE, FIELD_SIZE / 8);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Tahoma", 10, 40));
            g.drawString(gameOverMessage, 100, 19 * FIELD_SIZE / 32);
        }

    }
}
