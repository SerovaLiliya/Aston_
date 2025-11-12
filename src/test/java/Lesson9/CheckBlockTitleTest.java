package Lesson9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CheckBlockTitleTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.mts.by/");
    }

    @Test
    public void testBlockTitleIsCorrect() {
        // Закрываем баннер cookies, если он есть
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'cookie')]//button[contains(text(),'Принять')]")
            ));
            cookieButton.click();
        } catch (Exception ignored) {}

        // Ищем заголовок блока по уникальному признаку без индексов
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[contains(@class, 'pay-section')]//h2[contains(text(),'Онлайн пополнение')]")
        ));

        String actualTitle = title.getText().replace("\n", " ").trim();

        Assertions.assertEquals("Онлайн пополнение без комиссии", actualTitle,
                "Заголовок блока должен быть 'Онлайн пополнение без комиссии'");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
