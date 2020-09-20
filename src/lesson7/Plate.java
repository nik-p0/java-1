package lesson7;

import java.util.Scanner;

public class Plate {
    private int food;

    public Plate(int food){
        this.food = food;
    }

    public void showInfo(){
        System.out.println("В тарелке " + food + " еды");
    }

    public void decreaseFood(int a){
        food -= a;
    }

    public int getFood(){
        return food;
    }

    //Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void addFood(){
        Scanner scanner = new Scanner(System.in);
        int foodPlus;

        do {
            showInfo();
            System.out.println("Сколько еды добавить?");
            foodPlus = scanner.nextInt();
                if (foodPlus < 0){
                    System.out.println("Воровать у котиков нельзя!");
                }else if (foodPlus == 0){
                    System.out.println("Не экономьте на котах!");
                }
        } while(foodPlus <=0);

        food += foodPlus;
        showInfo();
    }
}
