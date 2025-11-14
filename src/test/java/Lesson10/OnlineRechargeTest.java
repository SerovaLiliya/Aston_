package Lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class OnlineRechargeTest {

    private WebDriver driver;
    private OnlineRechargePage rechargePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); // путь к chromedriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.get("https://www.mts.by/");
        BasePage basePage = new BasePage(driver);
        basePage.clickAcceptButton(By.id("cookie-agree"));
        rechargePage = new OnlineRechargePage(driver);
    }

    @Test
    public void testOnlineRechargeWithPhoneAndAmount() {
        rechargePage.enterPhone("297777777");
        rechargePage.enterAmount("50");
        rechargePage.clickSubmit();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
