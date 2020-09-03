package lesson2;

public class lesson2 {
    public static void main(String[] args) {
    /*
    Задание 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0
    */
        int [] arrayForChange = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arrayForChange.length; i++){
            arrayForChange[i] = arrayForChange[i] == 0 ? 1 : 0;
        }


    /*
    Задание 2. Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
    */
        int [] arrayForFill = new int [8];
        for (int i = 0; i < arrayForFill.length; i++) {
            arrayForFill[i] = i * 3;
        }
    /*
    Задание 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    пройти по нему циклом, и числа меньшие 6 умножить на 2
    */
        int [] arrayForMultip = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arrayForMultip.length; i++) {
            if (arrayForMultip[i] < 6){
                arrayForMultip[i] *= 2;
            }
        }
    /*
    Задание 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    */
        int [][] arrayDiag = new int [5][5];
        for (int i = 0; i < arrayDiag.length; i++) {
            arrayDiag[i][i] = 1;
            arrayDiag[arrayDiag.length - 1 - i][i] = 1;
        }
    /*
    Задание 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
    */
        int [] arrayMinMax = { 7, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int min = arrayMinMax[0];
        int max = arrayMinMax[0];

        for (int i = 0; i < arrayMinMax.length ; i++) {
            if (arrayMinMax[i] < min){
                min = arrayMinMax[i];
            }
            if (arrayMinMax[i] > max){
                max = arrayMinMax[i];
            }

        }
    /*
    Задание 6. Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    */
        int [] arrayBalance = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(arrayBalance));

    /*
    Задание 7. Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    */

        int [] arrayShift = {1, 2, 3, 4, 5};
        int shift = 1;
        shiftArray(arrayShift, shift);

        for (int i = 0; i < arrayShift.length ; i++) {
            System.out.println(arrayShift[i]);
        }
    }

    //Задание 6.
    static boolean checkBalance (int [] array){
        boolean check = false;
        int sumLeft = 0;
        int sumRight;
        for (int i = 0; i < array.length; i++) {
            sumRight = 0;
            sumLeft += array[i];
            for (int j = array.length - 1; j > i; j--) {
                sumRight += array[j];
            }
            if (sumLeft == sumRight){
                check = true;
                break;
            }
            }
        return check;
        }

    //Задание 7.
    static int[] shiftArray(int[] array, int shift){
        if (shift > 0) {
            for (int i = 0; i < shift ; i++) {
                int temp = array[0];
                array[0] = array[array.length - 1];
                for (int j = 1; j < array.length - 1 ; j++) {
                    array[array.length - j] = array[array.length - 1 - j];
                }
                array[1] = temp;
            }
        } else if (shift < 0){
            for (int i = 0; i > shift ; i--) {
                int temp = array[array.length - 1];
                array[array.length - 1] = array[0];
                for (int j = 1; j < array.length - 1 ; j++) {
                    array[j - 1] = array[j];
                }
                array[array.length - 2] = temp;
            }
        }

        return array;
    }


}
