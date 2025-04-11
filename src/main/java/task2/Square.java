package task2;

public class Square implements Figure{

    int a;
    String colorFilling;
    String colorBorder;

    public Square(int a, String colorFilling, String colorBorder) {
        this.a = a;
        this.colorFilling = colorFilling;
        this.colorBorder = colorBorder;
    }

    @Override
    public double perimeter() {
        return a * 4;
    }

    @Override
    public double square() {
        return a * a;
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
