package Lesson9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckPaymentLinkTest extends BaseTest {

    @Test
    public void testPaymentLinkWorks() {
        WebElement paymentSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[contains(@class,'pay-section')]//h2[contains(text(),'Онлайн пополнение')]/ancestor::section")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentSection);
        WebElement moreLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//section[contains(@class,'pay-section')]//a[contains(@href,'poryadok-oplaty')]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", moreLink);
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty"));
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("poryadok-oplaty"),
                "Ссылка 'Подробнее о сервисе' не ведёт на нужную страницу!"
        );
    }
}
