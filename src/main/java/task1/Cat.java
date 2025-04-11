package task1;

public class Cat extends Animal{

    int satiety;

    public Cat(int satiety) {
        this.satiety = satiety;
    }

    public void toRun(int distance) {
        int maxDistance = 200;
        if (distance > maxDistance) System.out.println("Кошка пробежала: " + maxDistance + "м.");
        else System.out.println("Кошка пробежала: " + distance + "м.");
    }

    public void toSwim(int distance) {
        System.out.println("Кошки не плавают");
    }

    public boolean toEat(Bowl bowl) {
        if(bowl.getVolume() >= satiety) {
            bowl.getFromVolume(satiety);
            return true;
        }
        return false;
    }
}
