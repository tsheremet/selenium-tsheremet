package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by tanya on 3/20/15.
 */
public class LoginPage {
    protected WebDriver driver;
    private static final String URL = "http://demo.testlink.org/latest/login.php";
    private static final By loginInput = By.id("login");
    private static final By passwordInput = By.name("tl_password");
    private static final By loginButton = By.name("login_submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public HomePage login(String login, String password) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
