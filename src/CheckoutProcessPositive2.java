import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutProcessPositive2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        driver.get("https://www.saucedemo.com/");

        try {
            login(driver, wait);
            addItemToCart(driver, wait);
            checkout(driver, wait);
            completeCheckout(driver, wait);

            System.out.println("Mntp dahh coyyy");
        } catch (Exception e) {
            System.out.println("Error ngab :( : " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    // Login Process
    private static void login(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        waitForPageLoad(wait, "app_logo");
    }

    // Add item to Cart
    private static void addItemToCart(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        WebElement itemLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_4_title_link")));
        itemLink.click();
        WebElement itemText = driver.findElement(By.cssSelector(".inventory_details_name.large_size"));
        System.out.println("Item's Name: " + itemText.getText());
        driver.findElement(By.id("add-to-cart")).click();
        waitForPageLoad(wait, "shopping_cart_badge");
    }

    // Checkout Process
    private static void checkout(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.findElement(By.className("shopping_cart_link")).click();
        waitForPageLoad(wait, "title");
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Lionel");
        driver.findElement(By.id("last-name")).sendKeys("Messi");
        driver.findElement(By.id("postal-code")).sendKeys("301910");
        driver.findElement(By.id("continue")).click();
        waitForPageLoad(wait, "summary_total_label");
    }

    // Complete Checkout
    private static void completeCheckout(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.findElement(By.id("finish")).click();
        WebElement completeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[data-test='complete-header']")));
        System.out.println("Checkout complete: " + completeMessage.getText());
    }

    // Wait for page element to load
    private static void waitForPageLoad(WebDriverWait wait, String elementClass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementClass)));
    }
}
