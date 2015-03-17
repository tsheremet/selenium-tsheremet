package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by tanya on 3/13/15.
 */
public class FirstTest {
    WebDriver driver;
    private static final By searchInput = By.id("lst-ib");
    private static final By searchUrl = By.className("_Rm");
    private static final By searchNextBtn = By.id("pnnext");

    @DataProvider
    public Object[][] keywords() {
        return new Object[][] {
              //  new Object[] {"word", "ukr,net"},
                new Object[] {"осциллограф", "www.tehencom.com/.../Oscilloscopes.htm"}
        };
    }

    @Test(dataProvider = "keywords")
    public void firstTest(String keyword, String url)  throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("https://google.com.ua");
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(keyword);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
        Thread.sleep(500);
        /*
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("cite")));
            for (WebElement cite : driver.findElements(By.tagName("cite"))) {
         */

        ArrayList<String> urlsList = new ArrayList<String>();
        urlsList = getUrls(urlsList);

        driver.findElement(searchNextBtn).click();

        urlsList = getUrls(urlsList);



        driver.findElement(searchNextBtn).click();

        try {
            for (int i=0; i < driver.findElements(searchUrl).size(); i++) {
                urlsList.add(driver.findElements(searchUrl).get(i).getText());
                System.out.println(i+" = "+urlsList.get(i));
            }

            for (String urlText : urlsList) {

                if (urlText.equals(url)) {
                    System.out.println("Gotcha!");
                    break;
                } else {
                    //click next page

                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getUrls(ArrayList<String> list) {
        try {
            for (int i=0; i < driver.findElements(searchUrl).size(); i++) {
                list.add(driver.findElements(searchUrl).get(i).getText());
                System.out.println(i+" = "+list.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
