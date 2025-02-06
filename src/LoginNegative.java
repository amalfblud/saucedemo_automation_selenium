import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginNegative {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        driver.get("https://www.saucedemo.com/");

        try {
            WebElement usernameField = driver.findElement(By.id("user-name"));
            usernameField.sendKeys("user");
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("pass");
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Error Message
            WebElement errorMessage = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
            String errorText = errorMessage.getText(); // Get the error message text
            System.out.println("Negative Login Test - Error: " + errorText);

            System.out.println("Mntp dahh coyyy");
        } catch (Exception e) {
            System.out.println("Error ngab :( : " + e.getMessage());
        } finally {
            driver.quit();
        }

    }
}
