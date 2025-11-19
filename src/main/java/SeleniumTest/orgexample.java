import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class orgexample {
    public static void main(String[] args) {
        // Автоматически скачается и настроится нужный chromedriver
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("Заголовок страницы: " + driver.getTitle());
        driver.quit();
    }
}
