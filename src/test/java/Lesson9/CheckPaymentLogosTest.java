package Lesson9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckPaymentLogosTest extends BaseTest {

    @Test
    public void testPaymentLogosArePresent() {
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
}
