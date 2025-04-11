public class Dog extends Animal{

    public void toRun(int distance) {
        int maxDistance = 500;
        if (distance > maxDistance) System.out.println("Собака пробежала: " + maxDistance + "м.");
        else System.out.println("Собака пробежала: " + distance + "м.");
    }

    public void toSwim(int distance) {
        int maxDistance = 10;
        if (distance > maxDistance) System.out.println("Собака проплыла: " + maxDistance + "м.");
        else System.out.println("Собака проплыла: " + distance + "м.");
    }

}
