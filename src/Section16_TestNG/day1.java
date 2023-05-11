package Section16_TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day1 {
    @Test(groups = "smoke")
    public void Test3() {
        System.out.println("a");
    }

    @Test(dataProvider = "getData")
    public void Test4(String username, String password) {
        System.out.println("b");
        System.out.println(username);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] getData() {
        //create 3 sets of data with this format: (username, password)
        Object[][] data = new Object[3][2]; //which means 3 sets of data with 2 values each

        data[0][0] = "firstUserName";
        data[0][1] = "1";

        data[1][0] = "secondUserName";
        data[1][1] = "2";

        data[2][0] = "thirdUserName";
        data[2][1] = "3";


        return data;
    }
}
