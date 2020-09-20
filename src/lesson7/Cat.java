package lesson7;

public class Cat {
    private String name;
    private int appetite;

    //Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    private boolean fullness;

    public Cat (String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate plate){
        //Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
        //(например, в миске 10 еды, а кот пытается покушать 15-20)
        //Считаем, что если коту мало еды в тарелке, то он ее просто не трогает,
        //то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
        if (appetite <= plate.getFood()){
            plate.decreaseFood(appetite);

        //Если коту удалось покушать (хватило еды), сытость = true
            fullness = true;
        }
    }

    //вывести информацию о сытости котов в консоль
    public void fullnessInfo(){
        System.out.println(name + " fullness " + fullness);
    }
}
