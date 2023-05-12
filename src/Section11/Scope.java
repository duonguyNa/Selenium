package Section11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //1. count the number of text link in page
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2. count the number of text link in just footer
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        System.out.println(footer.findElements(By.tagName("a")).size());

        //3. get the number of text link in the 1st column only
        WebElement column1 = footer.findElement(By.xpath("//body[1]/div[6]/table[1]/tbody[1]/tr[1]/td[1]"));
        System.out.println(column1.findElements(By.tagName("a")).size());

        //4. click on each text link to see if they works
        for (int i = 1; i < column1.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            column1.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }

        //get all windows
        Set<String> allWindows = driver.getWindowHandles();

        //iterator through all windows
        Iterator<String> windows = allWindows.iterator();

        while (windows.hasNext()) {
            driver.switchTo().window(windows.next());
            System.out.println(driver.getTitle());

        }

    }

}
