package lesson3;

import java.util.Random;
import java.util.Scanner;

public class lesson3 {

    static int randNum (){
        Random random = new Random();
        return random.nextInt(10);
    }

    static int getNum (){
        Scanner scanner = new Scanner(System.in);

        do {
            if (scanner.hasNextInt()){
                return scanner.nextInt();
            }
            System.out.println("Введите целое число");
            scanner.nextLine();
        } while (true);
    }

    static void game(){
        int rNum = randNum();

        for (int i = 3; i > 0; i--)  {
            System.out.println("Введите число");
            int userNum = getNum();
            if (userNum == rNum){
                System.out.println("Вы угадали");
                break;
            } else if (userNum > rNum){
                System.out.println("Загаданное число меньше осталось " + (i-1) + " попыток");
            } else {
                System.out.println("Загаданное число больше осталось " + (i-1) + " попыток");
            }
            if (i == 1){
                System.out.println();
                System.out.println("Вы не угадали, было загадано число " + rNum);

        }

        }
        newGameReq();
    }
    static void newGameReq(){
        System.out.println();
        System.out.println("Сыграть еще раз? 1 - да, другое число - нет");
        int answer = getNum();
        if (answer == 1){
            game();
        }
    }

    public static void main(String[] args) {

        System.out.println("Угадайте число от 0 до 9.");
        game();


    }




}
