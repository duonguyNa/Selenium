import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("#password")).sendKeys("learning");
        driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();

        //handle static dropdown
        WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("Consultant");

        // wait for popup to show and handle alert
        WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(8));
        popupMessage(driver, w1);
        w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));
        driver.findElement(By.cssSelector("#okayBtn")).click();

        driver.findElement(By.cssSelector("#terms")).click();
        driver.findElement(By.cssSelector("#signInBtn")).click();

        //explicit transition between 2 pages

        WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(8));
        pickItemScreen(driver, w2);
        w2.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));

        List<WebElement> items = driver.findElements(By.cssSelector("div.card-footer"));
        //System.out.println(items.size());

        for (int i = 0; i < items.size(); i++) {
            items.get(i).click();
            //driver.findElement(By.xpath("(//button[@class='btn btn-info'][normalize-space()='Add'])[i]")).click();
        }

        // check out
        driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();


    }

    private static void popupMessage(WebDriver driver, WebDriverWait w1) {
        // TODO Auto-generated method stub

    }

    private static void pickItemScreen(WebDriver driver, WebDriverWait w) {
        // TODO Auto-generated method stub

    }
}
