package Lesson9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class CheckPaymentLogosTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.mts.by/");
    }
    @Test
    public void testPaymentLogosArePresent() {
        closeCookieBanner();
        WebElement paySection = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("pay-section")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paySection);
        WebElement logosContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]")
        ));
        List<WebElement> logos = logosContainer.findElements(By.tagName("img"));
        Assertions.assertFalse(logos.isEmpty(), "Логотипы платёжных систем отсутствуют!");
        System.out.println("Найдено логотипов платёжных систем: " + logos.size());
    }
    private void closeCookieBanner() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'cookie')]//button")
            ));
            cookieButton.click();
        } catch (Exception ignored) {
        }
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
