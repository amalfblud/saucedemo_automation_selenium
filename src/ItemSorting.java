import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemSorting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        driver.get("https://www.saucedemo.com/");

        try {
            login(driver, wait);
            verify1(driver, wait);
            sort(driver, wait);
            verify2(driver, wait);

            System.out.println("Mntp dahh");
        } catch (Exception e) {
            System.out.println("Error coyy: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static void login(WebDriver driver, WebDriverWait wait) {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        waitToLoad(wait, "app_logo");
    }

    public static void verify1(WebDriver driver, WebDriverWait wait) {
        waitToLoad(wait, "inventory_item_name");
        waitToLoad(wait, "inventory_item_price");

        List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name"));
        List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price"));

        for (int i = 0; i < 2; i++) {
            System.out.println((i + 1) + ". Item's name: " + itemNames.get(i).getText());
            System.out.println((i + 1) + ". Item's price: " + itemPrices.get(i).getText());
        }
    }

    public static void sort(WebDriver driver, WebDriverWait wait) {
        Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropdown.selectByValue("hilo");
        System.out.println("Sorting applied: Price (High to Low)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void verify2(WebDriver driver, WebDriverWait wait) {
        waitToLoad(wait, "inventory_item_name");
        waitToLoad(wait, "inventory_item_price");

        List<WebElement> sortedItemNames = driver.findElements(By.className("inventory_item_name"));
        List<WebElement> sortedItemPrices = driver.findElements(By.className("inventory_item_price"));

        System.out.println("\nAfter Sorting:");
        for (int i = 0; i < 2; i++) {
            System.out.println((i + 1) + ". Item's name: " + sortedItemNames.get(i).getText());
            System.out.println((i + 1) + ". Item's price: " + sortedItemPrices.get(i).getText());
        }
    }

    public static void waitToLoad(WebDriverWait wait, String elementClass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementClass)));
    }
}
