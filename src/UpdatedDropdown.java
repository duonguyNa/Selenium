import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(4000);
        // get number of checkboxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$chk_IndArm")).isSelected());
        driver.findElement(By.name("ctl00$mainContent$chk_IndArm")).click();
        Assert.assertTrue(driver.findElement(By.name("ctl00$mainContent$chk_IndArm")).isSelected());

        // System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_IndArm")).isSelected());

        // choose 4 adults using while loop
        int i = 1;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption"));
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        //// choose 3 children using for loop

        for (i = 1; i < 4; i++) {
            driver.findElement(By.id("hrefIncChd")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("india")) {
                option.click();
                break;
            }
        }

    }

}
