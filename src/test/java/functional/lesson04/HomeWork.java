package functional.lesson04;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;


/**
 * Created by tanya on 3/17/15.
 *
 * 1. Написать тест который Не находит элемент на страничке и падает с exception, и
 * написать второй который Не находит элемент на странице и НЕ падает с Exception.
 * Драйвер должен корректно закрываться не зависимо от результатов теста.
 * (findElements, BeforeSuite, AfterSuite в testNG)
 * домашки сдавать как проекты на gitHub
 *
 */

public class HomeWork {
    private WebDriver driver;
    private static Logger Log = Logger.getLogger(HomeWork.class.getName());
    private static final By notExistedElement = By.xpath("//div[@id='gjsghdskj']");
    private static final By newsSectionHeader = By.xpath("//div[@id='news_list']/section[@class='items']/h2");
    public final String URL = "http://ukr.net";

    @DataProvider
    public Object[][] keywordExist() {
        return new Object[][]{
                new Object[]{"Технології"}
        };
    }

    @DataProvider
    public Object[][] keywordNotExist() {
        return new Object[][]{
                new Object[]{"Техноdsлогії"}
        };
    }

    @BeforeTest
    public void initDriver() {
        driver = new FirefoxDriver();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void findElementWithException1() {

        boolean elementPresent=false;

        driver.get("http://www.amazon.com/");
        WebElement element = driver.findElement(By.cssSelector(".nav-input[class='nav']"));
        elementPresent = true;
        Assert.assertTrue(!elementPresent);

    }

    @Test
    public void checkElementPresentWithException() {
        Log.info("Test 'checkElementPresentWithException' starts");
        driver.get(URL);
        driver.findElement(notExistedElement).isDisplayed();
        Log.info("Element Not Found");
    }

    @Test(dataProvider = "keywordNotExist")
    public void verifyElementPresent(String keyword) {
        Log.info("Test 'verifyElementPresent' starts");
        driver.get(URL);
        try {
            List<WebElement> newsList = driver.findElements(newsSectionHeader);
            for (WebElement newsElement : newsList) {
                //Log.info(newsElement.getText());
                Assert.assertNotEquals(newsElement.getText(), keyword, String.format("Element '%s' was found", keyword));
            }
            Log.info("Element Not Found");
        } catch (ElementNotFoundException elementNotFoundException) {
            Log.info("ElementNotFoundException thrown: " + elementNotFoundException);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException thrown: " + noSuchElementException);
        }
    }

    @Test(dataProvider = "keywordNotExist")
    public void verifyElementPresentWithException(String keyword) {
        Log.info("Test 'verifyElementPresentWithException' starts");
        driver.get(URL);
        List<WebElement> newsList = driver.findElements(newsSectionHeader);
        for (WebElement newsElement : newsList) {
            //Log.info(newsElement.getText());
            Assert.assertEquals(newsElement.getText(),keyword,String.format("Element '%s' was found",keyword));
        }
        Log.info("Element Not Found");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
