package szajner.learning.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import szajner.learning.util.AppProperties;

public class BasicTest {

    protected static String URL;
    protected AppProperties properties;
    protected WebDriver driver;

    protected BasicTest() {
        prepareProperties();
        setupGoogleChromeBrowserDriver();
    }

    private void setupGoogleChromeBrowserDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> driver.quit()));
    }

    private void prepareProperties() {
        properties = new AppProperties();
        URL = properties.get("url");
    }

}
