package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by tanya on 3/13/15.
 */
public class FirstTest {

    @Test
    public void firstTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://bash.im");
        driver.quit();
    }
}
