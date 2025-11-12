package Lesson9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CheckPaymentFormTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("https://www.mts.by/");
    }

    @Test
    public void testMobilePaymentContinueButton() {
        closeCookieBanner();
        WebElement paySection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pay-section")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paySection);
        WebElement servicesTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='pay-section']//button[normalize-space()='Услуги связи']")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", servicesTab);
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone-number' or @id='connection-phone']")
        ));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='pay-section']//button[contains(.,'Продолжить')]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@id,'sum') or contains(@name,'sum')]")
        ));
        Assertions.assertTrue(amountField.isDisplayed(),
                "После нажатия 'Продолжить' не появилось поле суммы или форма оплаты!");
    }

    private void closeCookieBanner() {
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
        driver.quit();
    }
}
