package Lesson9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("https://www.mts.by/");
        closeCookieBanner();
    }

    protected void closeCookieBanner() {
        try {
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'cookie')]//button[contains(text(),'Принять')]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptButton);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'cookie') and contains(@class,'show')]")
            ));
        } catch (TimeoutException e) {
            System.out.println("Cookie-баннер не появился — продолжаем.");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
