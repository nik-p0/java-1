package Lesson6;

import java.util.Random;

public class Lesson6 {

    public static void main(String[] args) {
        Random random = new Random();
        Cat cat = new Cat(150 + random.nextInt(100), random.nextInt(5), 1.5 + random.nextInt(2));
        Dog dog = new Dog(400 + random.nextInt(200), 8 + random.nextInt(5), 0.5 + random.nextInt(1));


        System.out.println("Cat");
        System.out.println();
        cat.run(200);
        cat.swim(10);
        cat.jump(2);


        System.out.println("Dog");
        System.out.println();
        dog.run(500);
        dog.swim(10);
        dog.jump(1.1);
    }
}
