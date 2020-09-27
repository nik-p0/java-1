package lesson8;

public class Lesson8 {

    static char [][] map;
    static final int SIZE = 3;
    static final int winCon = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static boolean isCellValid(int x, int y){
        if (map[y][x] == DOT_EMPTY){
            return true;
        }
        return false;
    }

    static boolean isWinner(char symb){
        int line;
        int column;
        int diag;
        int diagOp;

        for (int i = 0; i < SIZE; i++) {
            line = 0;
            column = 0;
            diag = 0;
            diagOp = 0;
            for (int j = 0; j <SIZE ; j++) {

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

                if (map[j][SIZE - j - 1] == symb){
                    diagOp++;
                } else {
                    diagOp = 0;
                }
                if (diagOp == winCon) return true;
            }
        }
        return false;
    }

    static boolean isMapFull(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    static void humanTurn(){
        int x = Gui.x;
        int y = Gui.y;
        do {
            Gui.message = "Ваш ход";
        }while(!isCellValid(x, y));

        map[y][x] = DOT_X;
    }


    public static void main(String[] args) {
        initMap();

        Gui gameWindow = new Gui();


    }
}
