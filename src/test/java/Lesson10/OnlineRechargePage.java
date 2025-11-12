package Lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnlineRechargePage extends BasePage {
    public By phoneField = By.id("phone"); // заменить на реальный локатор
    public By amountField = By.id("amount");
    public By cardNumberField = By.id("cardNumber");
    public By cardExpiryField = By.id("cardExpiry");
    public By cardCvvField = By.id("cardCvv");
    public By continueButton = By.id("continueBtn");
    public By popupAmount = By.cssSelector(".popup-amount");
    public By popupPhone = By.cssSelector(".popup-phone");
    public By paymentIcons = By.cssSelector(".payment-icons img");
    public By cookieCloseButton = By.id("cookieClose");
    public OnlineRechargePage(WebDriver driver) {
        super(driver);
    }
    public void closeCookieIfPresent() {
        if (isDisplayed(cookieCloseButton)) {
            click(cookieCloseButton);
        }
    }
    public void enterPhone(String phone) {
        type(phoneField, phone);
    }
    public void enterAmount(String amount) {
        type(amountField, amount);
    }
    public void enterCardDetails(String number, String expiry, String cvv) {
        type(cardNumberField, number);
        type(cardExpiryField, expiry);
        type(cardCvvField, cvv);
    }
    public void clickContinue() {
        click(continueButton);
    }
    public String getPopupAmount() {
        return getText(popupAmount);
    }
    public String getPopupPhone() {
        return getText(popupPhone);
    }
    public int countPaymentIcons() {
        return driver.findElements(paymentIcons).size();
    }
}

