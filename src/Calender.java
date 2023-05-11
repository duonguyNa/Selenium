import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //choose round trip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        //choose destinations
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a[value='AIP']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@value='HYD'][normalize-space()='Hyderabad (HYD)'])[2]")).click();

        //choose date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();


        //check if calender is enabled

        if (driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("1")) {
            System.out.println("Return date is enabled");
        }

    }

}
