package tests.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tanya on 4/7/15.
 */
public class ParallelGridTest {
    @Test
    public void secondThreadTest() throws MalformedURLException {
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9999/wd/hub"), DesiredCapabilities.firefox());
        driver.get("http://rozetka.com.ua/");
        driver.findElement(By.className("header-search-input-text"));
        driver.quit();
    }
}
