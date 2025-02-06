import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        driver.get("https://www.saucedemo.com/");

        try {
            // Login
            WebElement usernameField = driver.findElement(By.id("user-name"));
            usernameField.sendKeys("standard_user");
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("secret_sauce");
            Thread.sleep(2000);
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Verify Login
            WebElement headerElement = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("app_logo")));
            String headerText = headerElement.getText();
            System.out.println("Website Name/Logo: " + headerText);
            Thread.sleep(3000);

            // Open Item
            WebElement itemLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_4_title_link")));
            itemLink.click();
            Thread.sleep(2000);
            // Verify Items
            WebElement itemElement = driver.findElement(By.cssSelector(".inventory_details_name.large_size"));
            String itemText = itemElement.getText();
            System.out.println("Item's Name: " + itemText);
            // Add To Cart Button
            WebElement addtcButton = driver.findElement(By.id("add-to-cart"));
            addtcButton.click();
            // Verify Items On Cart Symbol
            WebElement chartElement = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
            String chartTotal = chartElement.getText();
            System.out.println("Items Total: " + chartTotal);
            Thread.sleep(2000);

            // Output
            System.out.println("Mntp dahh coyyy");
        } catch (Exception e) {
            System.out.println("Error ngab :( : " + e.getMessage());
        } finally {
            driver.quit();
        }

    }
}
