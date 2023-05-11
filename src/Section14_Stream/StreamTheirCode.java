package Section14_Stream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamTheirCode {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr//th[1]")).click();

        //capture all the Webelements into a list

        List<WebElement> ElementList = driver.findElements(By.xpath("//tr//td[1]"));

        //get text of each webelement into new list (original list) using java streams

        List<String> OriginalList = ElementList.stream().map(s -> s.getText()).collect(Collectors.toList());

        System.out.println("Original list of elements is: " + OriginalList);

        //sort on the new list -sorted list

        List<String> SortedList = OriginalList.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted list of elements is: " + SortedList);

        //compare original list with sorted list to check if it is in sorted list

        Assert.assertTrue(OriginalList.equals(SortedList));

        List<Object> price;

        //Get the price of selected veggie

        do {

            List<WebElement> Row = driver.findElements(By.xpath("//tr//td[1]"));

            price = Row.stream().filter(s -> s.getText().contains("Rice")).map(s -> getveggieprice(s)).collect(Collectors.toList());

            price.forEach(a -> System.out.println(a));

            if (price.size() < 1) {

                driver.findElement(By.cssSelector("[aria-label='Next']"));

            }

        } while (price.size() < 1);

    }

    private static Object getveggieprice(WebElement s) {

        String PriceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

        return PriceValue;

    }

}




