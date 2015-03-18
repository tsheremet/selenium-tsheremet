package functional.lesson04;

import org.apache.commons.logging.Log;
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

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

/**
 * Created by tanya on 3/17/15.
 *
 * 1. Написать тест который Не находит элемент на страничке и падает с exception, и
 * написать второй который Не находит элемент на страницу и НЕ падает с Exception.
 * Драйвер должен корректно закрываться не зависимо от результатов теста.
 * (findElements, BeforeSuite, AfterSuite в testNG)
 * домашки сдавать как проекты на gitHub
 *
 */

public class HomeWork {
    private WebDriver driver;
    //private static Logger Log = Logger.getLogger(HomeWork.class);
    private static final By newsSectionHeader = By.xpath("//div[@id='news_list']/section[@class='items']/h2");
    private static final String newsSectionHeaderLink = "//a[contains(text(),'%s')]";

    @DataProvider
    public Object[][] keywords() {
        return new Object[][]{
                new Object[]{"Технdsології",""},
                new Object[]{"За коdsрдоном", "exception"},
                /*new Object[]{"Технології",""},
                new Object[]{"За кордоном", "exception"},
                new Object[]{"Курйози", "exception 1"}*/
        };
    }

    @BeforeTest
    public void initDriver() {
        driver = new FirefoxDriver();
    }

    @Test(dataProvider = "keywords")
    public void verifyElementsPresent(String keyword, String except) {
        driver.get("http://ukr.net");
        BasicConfigurator.configure();
        //Log.info("I'm on page");

        List<WebElement> newsSectionHeadersList = driver.findElements(newsSectionHeader);
        for (WebElement newsSectionHeaderElement : newsSectionHeadersList) {
            System.out.println(newsSectionHeaderElement.getText());

            //Assert.assertTrue(newsSectionHeaderElement.findElement(By.xpath(String.format(newsSectionHeaderLink,keyword))).isDisplayed(),String.format("Element '%s' not found.",keyword));
            Assert.assertFalse(newsSectionHeaderElement.findElement(By.xpath(String.format(newsSectionHeaderLink, keyword))).isDisplayed(), String.format("Element '%s' found.", keyword));
        }
    }

    public boolean isElementExists(By by) {
        boolean isExists = true;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            isExists = false;
        }
        return isExists;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
