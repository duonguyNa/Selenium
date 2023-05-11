package Section13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class handleSSL {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        FirefoxOptions option1 = new FirefoxOptions();
        EdgeOptions option2 = new EdgeOptions();
        options.setAcceptInsecureCerts(true);

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

    }

}
