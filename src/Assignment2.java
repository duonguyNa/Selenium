import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("Nguyen Thuy Duong");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("duonguy@tibco.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("12345");
        driver.findElement(By.id("exampleCheck1")).click();

        WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select gender = new Select(genderDropdown);
        gender.selectByVisibleText("Female");

        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("03031999");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();

        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());

    }

}
