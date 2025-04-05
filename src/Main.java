import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("land cruiser", "01.02.2004", "toyota", "Япония", 2000000, true);
        productsArray[1] = new Product("land cruiser", "02.04.2005", "toyota", "Япония", 2500000, false);
        productsArray[2] = new Product("land cruiser", "02.02.2006", "toyota", "Япония", 2900000, true);
        productsArray[3] = new Product("land cruiser", "01.09.2007", "toyota", "Япония", 3500000, false);
        productsArray[4] = new Product("land cruiser", "04.11.2008", "toyota", "Япония", 1900000, true);
    }
}