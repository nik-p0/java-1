package lesson5;

public class lesson5 {
    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];

        employeesArray[0] = new Employee("Иван Иванов", "Директор", "ii1@mail.ru", "11111", 100000, 45);
        employeesArray[1] = new Employee("Петр Петров", "ЗамДир", "pp1@mail.ru", "22222", 90000, 30);
        employeesArray[2] = new Employee("Алексей Алексеев", "Бухгалтер", "aa1@mail.ru", "33333", 80000, 60);
        employeesArray[3] = new Employee("Александр Александров", "Юрист", "aa2@mail.ru", "44444", 70000, 35);
        employeesArray[4] = new Employee("Иван Сидоров", "Водитель", "ip1@mail.ru", "55555", 60000, 50);

        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getAge() > 40){
                employeesArray[i].printInfo();
            }

        }
    }
}
