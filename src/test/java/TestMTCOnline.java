import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestMTCOnline {

    WebDriver driver;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        //Борюсь с формой куки
        try {
            List<WebElement> agree = driver.findElements(By.xpath("//*[@id=\"cookie-agree\"]"));
            if(!agree.isEmpty()) {
                agree.get(0).click();
            }
        } catch (ElementNotInteractableException ignored) {

        }
    }


    @Test
    public void mtcLabelTest() {
        WebElement label = driver.findElement(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        Assertions.assertEquals("Онлайн пополнение\n" +
                "без комиссии", label.getText());

    }

    @Test
    public void mtcPartnerTest() {
        List<WebElement> partners = driver.findElements(By.xpath("//*[@class=\"pay__partners\"]/ul/li"));
        Assertions.assertEquals(5, partners.size());
    }

    @Test
    public void mtcClickTest() {
        WebElement linkInfoService = driver.findElement(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        linkInfoService.click();


        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
            driver.getCurrentUrl());
    }

    @Test
    public void mtcFormTest() {
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phone.sendKeys("297777777");

        WebElement summ = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        summ.sendKeys("42");

        WebElement enter = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        enter.click();

    }

    @AfterEach
    public void closeDriver() {
       driver.close();
    }
}
