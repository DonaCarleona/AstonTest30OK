import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
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
    @Feature("Задание номер 1")
    @Severity(SeverityLevel.MINOR)
    @Link("http://test.com")
    @Issue("https://test.com")
    @DisplayName("Проверка наименование формы")
    public void mtcLabelTest() {
        Assertions.assertEquals("Онлайн пополнение\n" +
                "без комиссии", mtcPageObject.getLabel());

    }

    @Test
    @Feature("Задание номер 1")
    @Severity(SeverityLevel.MINOR)
    @Link("http://test.com")
    @Issue("https://test.com")
    @DisplayName("Проверка наличия партнеров")
    public void mtcPartnerTest() {
        Assertions.assertEquals(5, mtcPageObject.getPartnerSize());
    }

    @Test
    @Feature("Задание номер 1")
    @Severity(SeverityLevel.MINOR)
    @Link("http://test.com")
    @Issue("https://test.com")
    @DisplayName("Проверка перехода")
    public void mtcClickTest() {
        mtcPageObject.clickLinkInfo();

        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
    }

    @Test
    @Feature("Задание номер 1")
    @Severity(SeverityLevel.CRITICAL)
    @Link("http://test.com")
    @Issue("https://test.com")
    @DisplayName("Проверка формы подключения")
    public void testWordConnection() throws InterruptedException {
        mtcPageObject.testConnectionForm();
    }

    @Test
    @Feature("Задание номер 1")
    @Severity(SeverityLevel.CRITICAL)
    @Link("http://test.com")
    @Issue("https://test.com")
    @DisplayName("Проверка формы подключения к Интернету")
    public void testWordInternet() throws InterruptedException {
        mtcPageObject.testInternetForm();
    }

    @Test
    @Feature("Задание номер 1")
    @Severity(SeverityLevel.MINOR)
    @Link("http://test.com")
    @Issue("https://test.com")
    @DisplayName("Проверка формы подключения продления")
    public void testWordInstallment() throws InterruptedException {
        mtcPageObject.testInstallmentForm();
    }

    @Test
    @Feature("Задание номер 1")
    @Severity(SeverityLevel.MINOR)
    @Link("http://test.com")
    @Issue("https://test.com")
    @DisplayName("Проверка формы подключения оплаты")
    public void testWordToPay() throws InterruptedException {
        mtcPageObject.testToPayForm();
    }

    @Test
    @Feature("Задание номер 2")
    @Severity(SeverityLevel.BLOCKER)
    @Link("http://test.com")
    @Issue("https://test.com")
    @DisplayName("Проверка формы оплаты")
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
