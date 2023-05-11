package Section16_TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class demo {

    @AfterTest
    void lastExecution() {
        System.out.println("This should come after Hello World");
    }

    @Test
    public void Test1() {
        System.out.println("Hello World!");
    }

    @Test
    public void Test2() {
        System.out.println("Bye!");
    }

}
