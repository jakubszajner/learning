package szajner.learning.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@DisplayName("Login page tests")
public class AuthTest extends BasicTest{

    @Test
    @DisplayName("Check login page default values")
    void loginPageDisplayedValues() {
        WebElement header = driver.findElement(By.tagName("h2"));
        WebElement emailInput = driver.findElement(By.id("inputEmail"));
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type=submit]"));

        assertEquals("Please sign in", header.getText());
        assertEquals("Email address", emailInput.getAttribute("placeholder"));
        assertEquals("Password", passwordInput.getAttribute("placeholder"));
        assertEquals("Sign in", loginButton.getText());
    }

    @Test
    @DisplayName("Check if login page displays alert")
    void loginPageDisplayedError() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type=submit]"));
        WebElement loginInput = driver.findElement(By.id("inputEmail"));
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));

        assertEquals("Sign in", loginButton.getText());

        loginInput.sendKeys("Some email address");
        passwordInput.sendKeys("Some wrong password");
        loginButton.click();

        WebElement errorMessage = new WebDriverWait(driver, 3)
                        .until(visibilityOfElementLocated(By.cssSelector(".alert-danger")));

        assertEquals("Login failed!", errorMessage.getText());
    }

}
