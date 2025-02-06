import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveCart2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

        try {
            login(driver, wait);
            addtocart(driver, wait);
            removecart(driver, wait);

            System.out.println("Mntp breee ");
        } catch (Exception e) {
            System.out.println("Error cokkk : " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    // Login
    public static void login(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        waitForPageLoad(wait, "title");
    }

    // Add to Cart
    public static void addtocart(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        WebElement itemLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_4_title_link")));
        itemLink.click();
        WebElement itemText = driver.findElement(By.cssSelector("[data-test='inventory-item-name']"));
        System.out.println("Item's Name: " + itemText.getText());
        driver.findElement(By.id("add-to-cart")).click();
        waitForPageLoad(wait, "shopping_cart_badge");
    }

    // Cart Page
    public static void removecart(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        WebElement cartElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='shopping-cart-link']")));
        cartElement.click();
        WebElement pageText = driver.findElement(By.className("title"));
        System.out.println("Page: " + pageText.getText());
        WebElement itemText = driver.findElement(By.className("inventory_item_name"));
        System.out.println("Verify Item: " + itemText.getText());
        Thread.sleep(2000);
        // Remove from Cart
        WebElement removeCartElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack")));
        removeCartElement.click();
        Thread.sleep(2000);
    }

    // Wait for page element to load
    private static void waitForPageLoad(WebDriverWait wait, String elementClass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementClass)));
    }
}
