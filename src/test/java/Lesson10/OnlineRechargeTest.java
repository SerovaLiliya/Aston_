package Lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OnlineRechargeTest {
    private WebDriver driver;
    private OnlineRechargePage page;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new OnlineRechargePage(driver);
    }
    @Test
    public void testEmptyFieldsForAllServices() {
        driver.get("https://mts.by");

        page.closeCookieIfPresent();
        Assert.assertEquals(page.getText(page.phoneField), "");
        Assert.assertEquals(page.getText(page.amountField), "");
    }

    @Test
    public void testOnlineRechargeWithPhoneAndAmount() {
        driver.get("https://mts.by");
        page.closeCookieIfPresent();
        page.enterPhone("297777777");
        page.enterAmount("10");
        page.enterCardDetails("", "", "");
        page.clickContinue();
        Assert.assertEquals(page.getPopupAmount(), "10 BYN"); // заменить на реальное отображение суммы
        Assert.assertEquals(page.getPopupPhone(), "297777777");
        Assert.assertEquals(page.getText(page.cardNumberField), "");
        Assert.assertEquals(page.getText(page.cardExpiryField), "");
        Assert.assertEquals(page.getText(page.cardCvvField), "");
        Assert.assertTrue(page.countPaymentIcons() > 0, "Нет иконок платежных систем");
    }
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

