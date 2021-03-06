package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by tanya on 3/20/15.
 */
public class HomePage extends AbstractPage {
    private static final String URL = "http://demo.testlink.org/latest/index.php";
    private static final By titlebarFrame = By.name("titlebar");
    private static final By version = By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink 1.9.13')]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public boolean isOpened() {
        switchToTitleBar();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(version));
        return !driver.findElements(version).isEmpty();
    }
}
