import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPositive {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        driver.get("https://www.saucedemo.com/");

        try {
            WebElement usernameField = driver.findElement(By.id("user-name"));
            usernameField.sendKeys("standard_user");
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("secret_sauce");
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // 1st header verification
            WebElement headerElement = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("app_logo")));
            String fheaderText = headerElement.getText();
            System.out.println("First Header Verification: " + fheaderText);

            // 2nd header verification
            WebElement header2Element = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
            String sheaderText = header2Element.getText();
            System.out.println("Secondary Header Verification: " + sheaderText);

            System.out.println("Mntp dahh coyyy");
        } catch (Exception e) {
            System.out.println("Error ngab :( = " + e.getMessage());
        } finally {
            driver.quit();
        }

    }
}
