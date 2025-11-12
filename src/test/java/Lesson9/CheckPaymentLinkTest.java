package Lesson9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CheckPaymentLinkTest {
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
    public void testPaymentLinkWorks() {
        closeCookieBanner();

        // Находим блок "Онлайн пополнение без комиссии" по атрибуту или тексту
        WebElement paymentSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[contains(@class, 'pay-section') or .//h2[contains(text(), 'Онлайн пополнение')]]")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentSection);

        // Находим ссылку "Подробнее о сервисе" по тексту
        WebElement moreLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Подробнее о сервисе')]")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", moreLink);

        wait.until(ExpectedConditions.urlContains("poryadok-oplaty"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"),
                "Ссылка 'Подробнее о сервисе' не ведёт на нужную страницу!");
    }

    private void closeCookieBanner() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'cookie')]//button[contains(text(),'Принять')]")
            ));
            cookieButton.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector("div.cookie.show")
            ));
        } catch (Exception ignored) {}
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
