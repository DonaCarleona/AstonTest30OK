public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(10);
        cat.toRun(10);
        cat.toSwim(10);

        Dog dog = new Dog();
        dog.toRun(10);
        dog.toSwim(10);

        Bowl bowl = new Bowl();
        bowl.addToVolume(40);
        Cat catTwo = new Cat(30);
        Cat catThree = new Cat(10);

        Cat[] cats = new Cat[3];
        cats[0] = cat;
        cats[1] = catTwo;
        cats[2] = catThree;

        for (Cat value : cats) {
            if (value.toEat(bowl)) System.out.println("Кошка наелась");
            else System.out.println("Покормите кота");
        }

    }
}