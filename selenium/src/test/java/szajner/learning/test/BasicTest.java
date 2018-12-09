package szajner.learning.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTest {

    protected static final String URL = "http://localhost:7070";
    protected WebDriver driver;

    protected BasicTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> driver.quit()));
    }

}
