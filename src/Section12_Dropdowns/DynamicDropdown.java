package Section12_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a[value='AIP']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@value='HYD'][normalize-space()='Hyderabad (HYD)'])[2]")).click();

    }

}
