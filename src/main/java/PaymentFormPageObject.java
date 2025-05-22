import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentFormPageObject {
    private final WebDriver driver;

    public PaymentFormPageObject(WebDriver driver) {
        this.driver = driver;
    }

    By payment = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span");
    By paymentButton = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button");
    By phone = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span");
    By cardNumber = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label");
    By dayBy = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label");
    By fio = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label");
    By cvc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label");
    By partner = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div");

    public void testForm() {
        Assertions.assertEquals("42.00 BYN", driver.findElement(payment).getText());
        Assertions.assertEquals("Оплата: Услуги связи Номер:375297777777", driver.findElement(phone).getText());
        Assertions.assertEquals("Номер карты", driver.findElement(cardNumber).getText());
        Assertions.assertEquals("Срок действия", driver.findElement(dayBy).getText());
        Assertions.assertEquals("Имя и фамилия на карте", driver.findElement(fio).getText());
        Assertions.assertEquals("CVC", driver.findElement(cvc).getText());
        Assertions.assertEquals("Оплатить 42.00 BYN", driver.findElement(paymentButton).getText());
        Assertions.assertTrue(driver.findElement(partner).isEnabled());

    }
}
