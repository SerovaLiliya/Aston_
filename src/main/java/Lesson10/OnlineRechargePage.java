package Lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlineRechargePage extends BasePage {

    private By phoneInput = By.id("connection-phone");
    private By amountInput = By.id("connection-sum");
    private By submitButton = By.cssSelector("button.button.button__default[type='submit']"); // Новый локатор для кнопки "Продолжить"
    private By successMessage = By.id("success-message");
    private By phoneError = By.id("connection-phone-error");
    private By amountError = By.id("amount-error");

    public OnlineRechargePage(WebDriver driver) {
        super(driver);
    }

    public void enterPhone(String phone) {
        WebElement phoneElement = waitForVisibility(phoneInput);
        phoneElement.clear();
        phoneElement.sendKeys(phone);
    }

    public void enterAmount(String amount) {
        WebElement amountElement = waitForVisibility(amountInput);
        amountElement.clear();
        amountElement.sendKeys(amount);
    }

    public void clickSubmit() {
        waitForVisibility(submitButton).click();
    }
}
