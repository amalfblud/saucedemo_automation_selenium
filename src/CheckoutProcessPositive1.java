import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutProcessPositive1 {
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
                        WebElement itemLink = wait.until(
                                        ExpectedConditions.visibilityOfElementLocated(By.id("item_4_title_link")));
                        itemLink.click();
                        Thread.sleep(2000);
                        // Verify Items
                        WebElement itemElement = driver
                                        .findElement(By.cssSelector(".inventory_details_name.large_size"));
                        String itemText = itemElement.getText();
                        System.out.println("Item's Name: " + itemText);
                        // Add To Cart Button
                        WebElement addtcButton = driver.findElement(By.id("add-to-cart"));
                        addtcButton.click();
                        // Verify Items On Cart Symbol
                        WebElement cartElement = wait
                                        .until(ExpectedConditions.visibilityOfElementLocated(
                                                        By.className("shopping_cart_badge")));
                        String cartTotal = cartElement.getText();
                        System.out.println("Items Total: " + cartTotal);
                        Thread.sleep(2000);

                        // Checkout Process
                        WebElement chartLink = driver.findElement(By.className("shopping_cart_link"));
                        chartLink.click();
                        // Verify Items On Cart
                        WebElement cartPageElement = wait
                                        .until(ExpectedConditions.visibilityOfElementLocated(
                                                        By.className("title")));
                        String cartPage = cartPageElement.getText();
                        System.out.println("Page: " + cartPage);
                        Thread.sleep(2000);
                        // Checkout Item
                        WebElement checkoutButton = driver.findElement(By.id("checkout"));
                        checkoutButton.click();

                        // Checkout Form
                        WebElement firstnameForm = driver.findElement(By.id("first-name"));
                        firstnameForm.sendKeys("Lionel");
                        WebElement surnameForm = driver.findElement(By.id("last-name"));
                        surnameForm.sendKeys("Messi");
                        WebElement postalForm = driver.findElement(By.id("postal-code"));
                        postalForm.sendKeys("301910");
                        Thread.sleep(2000);
                        // Continue Porcess
                        WebElement continueButton = driver.findElement(By.id("continue"));
                        continueButton.click();

                        // Summary Page
                        WebElement summaryElement = wait
                                        .until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
                        String summaryPage = summaryElement.getText();
                        System.out.println("Page: " + summaryPage);
                        WebElement totalCOElement = wait
                                        .until(ExpectedConditions.visibilityOfElementLocated(
                                                        By.className("summary_total_label")));
                        String totalCOPage = totalCOElement.getText();
                        System.out.println("Total Price: " + totalCOPage);
                        Thread.sleep(2000);
                        // Finish Process
                        WebElement finishButton = driver.findElement(By.id("finish"));
                        finishButton.click();

                        // Checkout Complete Page
                        WebElement completeMessage = wait
                                        .until(ExpectedConditions
                                                        .visibilityOfElementLocated(By.cssSelector(
                                                                        "h2[data-test='complete-header']")));
                        String completeText = completeMessage.getText();
                        System.out.println("Checkout complete: " + completeText);
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
