package Section14_Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\duonguy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture all elements into list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tbody"));
        System.out.println("Element list is " + elementsList);

        //capture text of all web elements into new (original) list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        System.out.println("Original list is " + originalList);


        //sort on the original list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());


        //compare two lists
        Assert.assertTrue(originalList.equals(sortedList));


        //get price of beans

        //search function

        driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

        List<WebElement> sortedVeggie = veggies.stream().filter(veggie -> veggie.getText().contains("Rice"))
                .collect(Collectors.toList());

        Assert.assertEquals(veggies.size(), sortedVeggie.size());

        List<String> price = elementsList.stream().filter(s -> s.getText().contains("Beans"))
                .map(s -> getPrice(s)).collect(Collectors.toList());
        price.forEach(a -> System.out.println(a));

    }

    private static String getPrice(WebElement s) {
        // TODO Auto-generated method stub
        //String priceValue = s.findElement(By.xpath("tr/td[2]")).getText();
        String priceValue = s.findElement(By.xpath("//following-sibling::td[1]")).getText();
        return priceValue;


    }

}
