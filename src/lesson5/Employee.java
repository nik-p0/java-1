package lesson5;

public class Employee {
    String name;
    String position;
    String mail;
    int phoneNum;
    int salary;
    int age;

    Employee (String name, String position, String mail, int phoneNum, int salary, int age){
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.age = age;
    }
    public void getInfo (){
        System.out.println();
        System.out.println("Имя: " + name);
        System.out.println("Дожность: " + position);
        System.out.println("Почта: " + mail);
        System.out.println("Номер телефона: " + phoneNum);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }
}