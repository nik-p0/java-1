package Lesson6;

public class Animal {
    protected double maxRunDistance;
    protected double maxSwimDistance;
    protected double maxJumpHeight;

    public Animal(double maxRunDistance, double maxSwimDistance, double maxJumpHeight){
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    private boolean check(double actual, double max){
        if (actual <= max){
            return true;
        } else{
            return false;
        }
    }

    public void run(double distance){
        System.out.println("Run is " + check(distance, maxRunDistance));
    }
    public void swim(double distance){
        System.out.println("Swim is " + check(distance, maxSwimDistance));
    }
    public void jump(double height){
        System.out.println("Jump is " + check(height, maxJumpHeight));
    }
}
