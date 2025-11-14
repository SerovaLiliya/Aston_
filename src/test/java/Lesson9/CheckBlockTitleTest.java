package Lesson9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBlockTitleTest extends BaseTest {

    @Test
    public void testBlockTitleIsCorrect() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[contains(@class, 'pay-section')]//h2[contains(text(),'Онлайн пополнение')]")
        ));
        String actualTitle = title.getText().replace("\n", " ").trim();
        Assertions.assertEquals(
                "Онлайн пополнение без комиссии",
                actualTitle,
                "Заголовок блока должен быть 'Онлайн пополнение без комиссии'"
        );
    }
}
