package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by tanya on 3/24/15.
 */
public class AbstractPage {
    protected WebDriver driver;
    private static final By titlebarFrame = By.name("titlebar");
    private static final By treeFrame = By.name("treeframe");
    private static final By mainFrame = By.name("mainframe");
    private static final By workFrame = By.name("workframe");
    private static final By detailsFrame = By.xpath("//iframe[contains(title(),'details')]");

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void switchToTitleBar() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(titlebarFrame));
    }

    protected void switchToTreeFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(treeFrame));
    }

    protected void switchToWorkFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));
    }

    protected void switchToDetailsFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));
        driver.switchTo().frame(driver.findElement(detailsFrame));
    }
}
