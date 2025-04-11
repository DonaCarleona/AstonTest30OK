import task1.Bowl;
import task1.Cat;
import task1.Dog;
import task2.Circle;
import task2.Figure;
import task2.Rectangle;
import task2.Square;

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

        testBowl(cats, bowl);

        Circle circle = new Circle(10,"Синий", "Красный");
        circle.print();
        Rectangle rectangle = new Rectangle(10,20, "Зеленый", "Желтый");
        rectangle.print();
        Square square = new Square(20, "Оранжевый", "Черный");
        square.print();
    }

    public static void testBowl(Cat[] cats, Bowl bowl) {
        for (Cat value : cats) {
            if (value.toEat(bowl)) System.out.println("Кошка наелась");
            else System.out.println("Покормите кота");
        }
    }

}