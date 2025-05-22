import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestMTCOnlineWithPageObject {

    WebDriver driver;
    MTCPageObject mtcPageObject;
    PaymentFormPageObject paymentFormPageObject;

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        mtcPageObject = new MTCPageObject(driver);
        mtcPageObject.toAgree();
    }


    @Test
    public void mtcLabelTest() {
        Assertions.assertEquals("Онлайн пополнение\n" +
                "без комиссии", mtcPageObject.getLabel());

    }

    @Test
    public void mtcPartnerTest() {
        Assertions.assertEquals(5, mtcPageObject.getPartnerSize());
    }

    @Test
    public void mtcClickTest() {
        mtcPageObject.clickLinkInfo();

        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
    }

    @Test
    public void testWordConnection() throws InterruptedException {
        mtcPageObject.testConnectionForm();
    }

    @Test
    public void testWordInternet() throws InterruptedException {
        mtcPageObject.testInternetForm();
    }

    @Test
    public void testWordInstallment() throws InterruptedException {
        mtcPageObject.testInstallmentForm();
    }

    @Test
    public void testWordToPay() throws InterruptedException {
        mtcPageObject.testToPayForm();
    }

    @Test
    public void testPaymentForm() throws InterruptedException {
        mtcPageObject.fillConnectForm();

        //Понимаю что конструкция странная, но сайт все время тормозит. А с фремами придумала только такое переключение
        Thread.sleep(10000);
        driver.switchTo().parentFrame();
        Thread.sleep(10000);
        driver.switchTo().frame(1);

        paymentFormPageObject = new PaymentFormPageObject(driver);
        paymentFormPageObject.testForm();
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }
}
