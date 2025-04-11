package task2;

public class Circle implements Figure{

    int radius;
    double pi = 3.14;
    String colorFilling;
    String colorBorder;

    public Circle(int radius, String colorFilling, String colorBorder) {
        this.radius = radius;
        this.colorFilling = colorFilling;
        this.colorBorder = colorBorder;
    }

    @Override
    public double perimeter() {
        return 2 * radius * pi ;
    }

    @Override
    public double square() {
        return pi * radius * radius;
    }

    @Override
    public void print() {
        System.out.println("Площадь: " + this.square());
        System.out.println("Периметр: " + this.perimeter());
        System.out.println("Цвет заливки: " + colorFilling);
        System.out.println("Цвет границы: " + colorBorder);
    }

    public String getColorFilling() {
        return colorFilling;
    }

    public String getColorBorder() {
        return colorBorder;
    }
}
