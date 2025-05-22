import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MTCPageObject {
    private final WebDriver driver;

    By agreeBy = By.xpath("//*[@id=\"cookie-agree\"]");
    By labelBy = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    By partnersBy = By.xpath("//*[@class=\"pay__partners\"]/ul/li");
    By linkInfoBy = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");
    By phoneConnectBy = By.xpath("//*[@id=\"connection-phone\"]");
    By summConnectBy = By.xpath("//*[@id=\"connection-sum\"]");
    By emailConnectBy = By.xpath("//*[@id=\"connection-email\"]");
    By submitConnectBy = By.xpath("//*[@id=\"pay-connection\"]/button");
    By selectBy = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    By connectSelectBy = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p");
    By internetSelectBy = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p");
    By installmentSelectBy = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p");
    By toPaySelectBy = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p");
    By phoneInternetBy = By.xpath("//*[@id=\"internet-phone\"]");
    By summInternetBy = By.xpath("//*[@id=\"internet-sum\"]");
    By emailInternetBy = By.xpath("//*[@id=\"internet-email\"]");
    By scoreInstallmentBy = By.xpath("//*[@id=\"score-instalment\"]");
    By summInstallmentBy = By.xpath("//*[@id=\"internet-sum\"]");
    By emailInstallmentBy = By.xpath("//*[@id=\"internet-email\"]");
    By scoreToPayBy = By.xpath("//*[@id=\"score-arrears\"]");
    By summToPayBy = By.xpath("//*[@id=\"internet-sum\"]");
    By emailToPayBy = By.xpath("//*[@id=\"internet-email\"]");

    public MTCPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public MTCPageObject toAgree() {
        try {
            List<WebElement> agrees = driver.findElements(agreeBy);
            if (!agrees.isEmpty()) {
                agrees.get(0).click();
            }
        } catch (ElementNotInteractableException ignored) {

        }
        return this;
    }

    public String getLabel() {
        return driver.findElement(labelBy).getText();
    }

    public int getPartnerSize() {
        return driver.findElements(partnersBy).size();
    }

    public void clickLinkInfo() {
        driver.findElement(linkInfoBy).click();
    }

    public void fillConnectForm() {
        WebElement phone = driver.findElement(phoneConnectBy);
        phone.sendKeys("297777777");

        WebElement summ = driver.findElement(summConnectBy);
        summ.sendKeys("42");

        WebElement submit = driver.findElement(submitConnectBy);
        submit.click();
    }

    public void changeSelectValue(String value) {
        driver.findElement(linkInfoBy);
        WebElement select = driver.findElement(selectBy);
        select.click();
        switch (value) {
            case ("connect"):
                driver.findElement(connectSelectBy).click();
                break;
            case ("internet"):
                driver.findElement(internetSelectBy).click();
                break;
            case ("installment"):
                driver.findElement(installmentSelectBy).click();
                break;
            case ("toPay"):
                driver.findElement(toPaySelectBy).click();
                break;
        }
    }
    public void testConnectionForm() {
        changeSelectValue("connect");
        Assertions.assertEquals("Номер телефона", driver.findElement(phoneConnectBy).getAttribute("placeholder"));
        Assertions.assertEquals("Сумма", driver.findElement(summConnectBy).getAttribute("placeholder"));
        Assertions.assertEquals("E-mail для отправки чека", driver.findElement(emailConnectBy).getAttribute("placeholder"));
    }

    public void testInternetForm() {
        changeSelectValue("internet");
        Assertions.assertEquals("Номер абонента", driver.findElement(phoneInternetBy).getAttribute("placeholder"));
        Assertions.assertEquals("Сумма", driver.findElement(summInternetBy).getAttribute("placeholder"));
        Assertions.assertEquals("E-mail для отправки чека", driver.findElement(emailInternetBy).getAttribute("placeholder"));
    }

    public void testInstallmentForm() {
        changeSelectValue("installment");
        Assertions.assertEquals("Номер счета на 44", driver.findElement(scoreInstallmentBy).getAttribute("placeholder"));
        Assertions.assertEquals("Сумма", driver.findElement(summInstallmentBy).getAttribute("placeholder"));
        Assertions.assertEquals("E-mail для отправки чека", driver.findElement(emailInstallmentBy).getAttribute("placeholder"));
    }

    public void testToPayForm() {
        changeSelectValue("toPay");
        Assertions.assertEquals("Номер счета на 2073", driver.findElement(scoreToPayBy).getAttribute("placeholder"));
        Assertions.assertEquals("Сумма", driver.findElement(summToPayBy).getAttribute("placeholder"));
        Assertions.assertEquals("E-mail для отправки чека", driver.findElement(emailToPayBy).getAttribute("placeholder"));
    }
}