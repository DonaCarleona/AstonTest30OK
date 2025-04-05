import java.util.Date;

public class Product {
    private String name;
    private String createDate;
    private String manufacturer;
    private String countryOfManufacture;
    private double price;
    private boolean booking;

    public Product(String name, String createDate, String manufacturer, String countryOfManufacture, double price, boolean booking) {
        this.name = name;
        this.createDate = createDate;
        this.manufacturer = manufacturer;
        this.countryOfManufacture = countryOfManufacture;
        this.price = price;
        this.booking = booking;
    }

    public void printInfo() {
        System.out.println("Наименование: " + name);
        System.out.println("Дата производства: " + createDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfManufacture);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования покупателем: " + booking);
    }



}
