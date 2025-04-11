package task2;

public interface Figure {

    double perimeter();

    double square();

    default double perimeterDefault(int a) {
        return a * 4;
    }

    void print();

}
