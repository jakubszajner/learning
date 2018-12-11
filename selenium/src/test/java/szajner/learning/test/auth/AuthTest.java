package szajner.learning.test.auth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import szajner.learning.test.BasicTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@DisplayName("Login page tests")
public class AuthTest extends BasicTest {

    private static Logger logger = LoggerFactory.getLogger(AuthTest.class);

    @Test
    @DisplayName("Check login page default values")
    void loginPageDisplayedValues() {
        WebElement header = driver.findElement(By.tagName("h2"));
        WebElement emailInput = driver.findElement(By.id("inputEmail"));
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type=submit]"));

        assertEquals(properties.get("login.title"), header.getText());
        assertEquals(properties.get("login.email"), emailInput.getAttribute("placeholder"));
        assertEquals(properties.get("login.pass"), passwordInput.getAttribute("placeholder"));
        assertEquals(properties.get("login.button"), loginButton.getText());
    }

    @Test
    @DisplayName("Check if login page displays alert")
    void loginPageDisplayedError() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type=submit]"));
        WebElement loginInput = driver.findElement(By.id("inputEmail"));
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));

        assertEquals(properties.get("login.button"), loginButton.getText());

        loginInput.sendKeys("Some email address");
        passwordInput.sendKeys("Some wrong password");
        loginButton.click();

        WebElement errorMessage = new WebDriverWait(driver, 3)
                .until(visibilityOfElementLocated(By.cssSelector(".alert-danger")));

        assertEquals(properties.get("login.failed"), errorMessage.getText());
    }

}
