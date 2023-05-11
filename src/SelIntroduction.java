import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //
        // invoke the browser in Chrome
        /*
         * System.setProperty("webdriver.chrome.driver",
         * "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
         * WebDriver driver = new ChromeDriver();
         * driver.get("https://www.facebook.com/");
         * System.out.println(driver.getTitle());
         * System.out.println(driver.getCurrentUrl()); driver.quit();
         */


        /*
         * // invoke the browser in firefox System.setProperty("webdriver.gecko.driver",
         * "C:\\Users\\duonguy\\Downloads\\geckodriver-v0.32.0-win64\\geckodriver.exe");
         * WebDriver driverFirefox = new FirefoxDriver();
         * driverFirefox.get("https://www.youtube.com/watch?v=jbPdUcEiZ1s");
         * System.out.println(driverFirefox.getTitle()); //driverFirefox.quit();
         */


        // invoke the browser in Microsoft Edge
        System.setProperty("webdriver.edge.driver", "C:\\Users\\duonguy\\Downloads\\edgedriver_win32\\msedgedriver.exe");
        WebDriver driverEgde = new EdgeDriver();
        driverEgde.get("https://www.youtube.com/watch?v=jbPdUcEiZ1s");
        System.out.println(driverEgde.getTitle());
        //driverFirefox.quit();

    }

}
