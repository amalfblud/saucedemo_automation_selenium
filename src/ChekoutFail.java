import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChekoutFail {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        driver.get("https://www.saucedemo.com/");

        try {
            login(driver, wait);
            addItemToCart(driver, wait);
            checkout(driver, wait);

            System.out.println("Mntp dahh coyyy");
        } catch (Exception e) {
            System.out.println("Error ngab :( : " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static void login(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    public static void addItemToCart(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        WebElement itemLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_4_title_link")));
        itemLink.click();
        WebElement itemText = driver.findElement(By.cssSelector(".inventory_details_name.large_size"));
        System.out.println("Item's Name: " + itemText.getText());
        driver.findElement(By.id("add-to-cart")).click();
    }

    public static void checkout(WebDriver driver, WebDriverWait wait) throws InterruptedException {

    }
}
