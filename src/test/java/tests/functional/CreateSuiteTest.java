package tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import steps.TestSteps;

/**
 * Created by tanya on 3/20/15.
 */
public class CreateSuiteTest extends TestSteps {

    @BeforeSuite
    public void initEnv() {
        driver = new FirefoxDriver();
    }

    @Test
    public void createTestSuite() {
        Assert.assertTrue(login("admin", "admin"), "Login failed");
        Assert.assertTrue(openSpecificationPage());
        createTestSuiteStep();
    }

    @AfterSuite
    public void tearDownEnv() {
        if (driver != null)
            driver.quit();
    }
}
