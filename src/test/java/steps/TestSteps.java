package steps;

import org.openqa.selenium.WebDriver;
import testlink.pages.LoginPage;

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
}
