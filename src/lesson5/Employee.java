package lesson5;

public class Employee {
    private String name;
    private String position;
    private String mail;
    private String phoneNum;
    private int salary;
    private int age;

    Employee (String name, String position, String mail, String phoneNum, int salary, int age){
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void printInfo (){
        System.out.println();
        System.out.println("Имя: " + name);
        System.out.println("Дожность: " + position);
        System.out.println("Почта: " + mail);
        System.out.println("Номер телефона: " + phoneNum);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }
}