package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Created by tanya on 3/17/15.
 */
public class FindJob {
    private WebDriver driver;
    private static final By jobPositions = By.id("job_positions");

    @Test
    public void findJob() {
        driver = new FirefoxDriver();
        driver.get("http://valvesoftware.com/jobs/job_postings.html");

        String job1 = "Psychologist";
        String job2 = "Software Engineer";

        Assert.assertTrue(driver.findElement(jobPositions).findElement(By.xpath(String.format("//div[contains(text(),'%s')]", job1))).isDisplayed(),"Job openings for " + job1 + "doesn't exist.");
        Assert.assertTrue(driver.findElement(jobPositions).findElement(By.cssSelector("div[id*='software_engineer']")).isDisplayed(),"Job openings for " + job2 + " doesn't exist.");
        //Assert.assertTrue(driver.findElement(jobPositions).findElement(By.cssSelector("div:contains('Software Engineer')")).isDisplayed(),"Job openings for " + job2 + " doesn't exist.");

    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
