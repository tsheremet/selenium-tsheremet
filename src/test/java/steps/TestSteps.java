package steps;

import org.openqa.selenium.WebDriver;
import testlink.pages.LoginPage;
import testlink.pages.SpecificationPage;

/**
 * Created by tanya on 3/20/15.
 */
public class TestSteps {
    protected WebDriver driver;

    public boolean login(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        return loginPage.login(login,password).isOpened();
    }

    public boolean openSpecificationPage() {
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        return specificationPage.isOpened();
    }

    public void createTestSuiteStep() {
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.openTestSuiteOperations();
        specificationPage.addTestSuite();
    }
}
