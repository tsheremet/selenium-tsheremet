package tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import steps.TestSteps;
import testlink.models.TestCase;
import testlink.models.TestSuite;

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
        TestSuite suite = new TestSuite();
        TestCase testcase1 = new TestCase();
        TestCase testcase2 = new TestCase();
        TestCase testcase3 = new TestCase();
        Assert.assertTrue(login("admin", "admin"), "Login failed");
        Assert.assertTrue(createTestSuiteStep(suite),"Test suite creation failed.");
        Assert.assertTrue(createTestCaseStep(suite, testcase1),"Test case creation failed.");
        Assert.assertTrue(createTestCaseStep(suite, testcase2),"Test case creation failed.");
        Assert.assertTrue(createTestCaseStep(suite, testcase3),"Test case creation failed.");
    }

    @AfterSuite
    public void tearDownEnv() {
        if (driver != null)
            driver.quit();
    }
}
