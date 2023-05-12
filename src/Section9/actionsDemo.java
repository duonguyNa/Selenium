package Section9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);

        //move mouse then right click
        WebElement move = driver.findElement(By.id("nav-link-accountList"));
        a.moveToElement(move).contextClick().build().perform();
        // move to search box and enter hello in capital
        a.moveToElement(driver.findElement(By.id("nav-search-bar-form"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();


    }

}
