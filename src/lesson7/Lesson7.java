package lesson7;

public class Lesson7 {
    public static void main(String[] args) {

        //Создать массив котов и тарелку с едой
        Plate plate = new Plate(10);

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Dusya", 5);
        cats[1] = new Cat("Barsik", 7);
        cats[2] = new Cat("Murzik", 6);
        cats[3] = new Cat("Murka", 5);
        cats[4] = new Cat("Matroskin", 8);

        plate.addFood();
        for (int i = 0; i < cats.length; i++) {
            //попросить всех котов покушать из этой тарелки
            cats[i].eat(plate);
            //и потом вывести информацию о сытости котов в консоль
            cats[i].fullnessInfo();
        }
    }
}
