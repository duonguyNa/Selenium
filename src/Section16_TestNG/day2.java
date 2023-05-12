package Section16_TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 {


    @Parameters({"URL", "APIKey"})
    @Test
    public void Test5(String username, String key) {
        System.out.println("c");
        System.out.println(username);
        System.out.println(key);

    }

    @Test(groups = "smoke")
    public void Test6() {
        System.out.println("d");
    }

}
