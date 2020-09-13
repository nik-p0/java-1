import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lesson4 {



    static char [][] map;
    static final int SIZE = 5;

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

    static void printMap(){
        for (int i = 0; i <= SIZE; i++) {
            System.out.print( i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void humanTurn(){
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;

        do {
            System.out.println("Введите координаты в формате Х У");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        }while(!isCellValid(x, y));

        map[y][x] = DOT_X;
    }

    /*
    4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
    */

    static void aiTurn(){
        Random random = new Random();
        int x = 0;
        int y = 0;
        boolean aiWin = false;
        boolean humanWin = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(isCellValid(i, j)){
                    map[j][i] = DOT_O;
                    if (isWinner(DOT_O)){
                        x = i;
                        y = j;
                        aiWin = true;
                    }
                    map[j][i] = DOT_EMPTY;
                }
            }
          }
        if(!aiWin){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if(isCellValid(i, j)){
                        map[j][i] = DOT_X;
                        if (isWinner(DOT_X)){
                            x = i;
                            y = j;
                            humanWin = true;
                    }
                    map[j][i] = DOT_EMPTY;

                }
            }
          }
        }
        if (!aiWin && !humanWin) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);

            } while (!isCellValid(x, y));
        }
        map[y][x] = DOT_O;
        System.out.println("Компьютер походил " + (x+1) + " и " + (y+1) );
    }

    static boolean isCellValid(int x, int y){
        if (x < 0 || x >= SIZE || y < 0 || y >=SIZE){
            return false;
        }
        if (map[y][x] == DOT_EMPTY){
            return true;
        }
        return false;
    }


    /*
    3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
         Очень желательно не делать это просто набором условий для каждой из возможных ситуаций
    */

    /*
    Работает частично - если размер поля и условие победы совпадают, все ноормально, но
    если поле, например, 5 на 5 и условие победы 3 символа подряд, работает только для координат
    в пределах 3 на 3.
    Не могу понять почему не работает сдвиг(shift в цикле).
    */
    
    /*static boolean isWinner (char symb){
        char [] arrayCheck;
        arrayCheck = new char[winCon];
        for (int i = 0; i < winCon; i++) {
            arrayCheck[i] = symb;
        }

        char [] bufferMapLine;
        bufferMapLine = new char[winCon];

        char [] bufferMapColumn;
        bufferMapColumn = new char[winCon];

        char [] bufferDiag;
        bufferDiag = new char[winCon];

        char [] bufferDiagOp;
        bufferDiagOp = new char[winCon];


        for (int shift = 0; shift <= SIZE - winCon ; shift++) {
            for (int i = 0; i < winCon; i++) {
                for (int j = 0; j < winCon; j++) {
                    bufferMapLine[j] = map[i + shift][j + shift];
                    bufferMapColumn[j] = map[j + shift][i + shift];
                    bufferDiag[j] = map[j + shift][j + shift];
                    bufferDiagOp[j] = map[winCon - 1 - j + shift][j + shift];
                }
                    if (Arrays.equals(bufferMapLine, arrayCheck) ||
                        Arrays.equals(bufferMapColumn, arrayCheck) ||
                        Arrays.equals(bufferDiag, arrayCheck) ||
                        Arrays.equals(bufferDiagOp, arrayCheck)) {
                        return true;
                    }

            }
        }

        return false;
    }
    */
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



    public static void main(String[] args) {
        initMap();
        printMap();

        while(true){
            humanTurn();
            printMap();

            if (isWinner(DOT_X)){
                System.out.println("Победил человек!");
                break;
            }
            if(isMapFull()){
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();

            if (isWinner(DOT_O)){
                System.out.println("Т-1000 победил!");
                break;
            }
            if(isMapFull()){
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Игра окончена!");

    }
}
