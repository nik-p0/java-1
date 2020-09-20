package Lesson6;

public class Cat extends Animal {
    public Cat (double maxRunDistance, double maxSwimDistance, double maxJumpHeight){
        super (maxRunDistance , maxSwimDistance, maxJumpHeight);
    }
    @Override
    public void swim(double distance){
        System.out.println("кот не умеет плавать");
    }
}
