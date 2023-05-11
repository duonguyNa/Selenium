import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class windowsHandles {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        //move mouse and click link
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector(".blinkingText"))).click().build().perform();

        //capture 2 windows
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parentWindow = it.next();
        String childWindow = it.next();

        //switch to child window:
        driver.switchTo().window(childWindow);

        //get text containing username
        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        //switch to parent window
        driver.switchTo().window(parentWindow);
        driver.findElement(By.cssSelector("#username")).sendKeys(email);


    }

}
