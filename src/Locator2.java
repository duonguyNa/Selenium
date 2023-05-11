import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locator2 {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        // invoke browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String name = "rahul";


        //compare message when login successfully
        String password = getPassword(driver);


        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.cssSelector("button.submit.signInBtn")).click();
        Thread.sleep(2000);
        //System.out.println(driver.findElement(By.cssSelector("p")).getText());
        //Assert.assertEquals(driver.findElement(By.cssSelector("p")).getText(), "You are successfully logged in.");
        //Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Hello "+ name + ",");


        //log out
        //driver.findElement(By.cssSelector("button.logout-btn")).click();
        //driver.close();


    }

    //extract password
    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] pwdArray = passwordText.split("'");
        String[] pwdArray2 = pwdArray[1].split("'");
        String password = pwdArray2[0];

        return password;


    }
}
