import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ECommerce {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        Thread.sleep(3000);
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Create a list of needed items:
        String[] neededItems = {"Brocolli", "Cucumber", "Beetroot"};

        addCart(driver, neededItems, w);
    }

    public static void addCart(WebDriver driver, String[] neededItems, WebDriverWait w) {

        // change list of string to array list
        List<String> neededItemsList = Arrays.asList(neededItems);
        // get all products
        List<WebElement> Items = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        // iterate through all products to find matching name with needed items
        for (int i = 0; i < Items.size(); i++) {
            String[] itemName = Items.get(i).getText().split("-");
            String formattedName = itemName[0].trim();

            if (neededItemsList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
                if (j == neededItems.length) {
                    break;
                }
            }
        }

        // go to cart

        driver.findElement(By.cssSelector("img[alt='Cart'")).click();
        driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
    }
}
