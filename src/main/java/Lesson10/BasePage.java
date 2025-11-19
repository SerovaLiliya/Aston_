package Lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    public void clickAcceptButton(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }
}
