package task2;

public class Rectangle implements Figure{

    int a;
    int b;
    String colorFilling;
    String colorBorder;

    public Rectangle(int a, int b, String colorFilling, String colorBorder) {
        this.a = a;
        this.b = b;
        this.colorFilling = colorFilling;
        this.colorBorder = colorBorder;
    }

    @Override
    public double perimeter() {
        return a * 2 + b * 2;
    }

    @Override
    public double square() {
        return a * b;
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
