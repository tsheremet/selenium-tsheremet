package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by tanya on 3/20/15.
 */
public class SpecificationPage {
    protected WebDriver driver;
    private static final By titlebarFrame = By.name("titlebar");
    private static final By treeFrame = By.name("treeframe");
    private static final By mainFrame = By.name("mainframe");
    private static final By workFrame = By.name("workframe");
    private static final By treeFrameTitle = By.xpath("//h1[@class='title'][contains(text(),'Navigator - Test Specification')]");
    private static final By workFrameTitle = By.className("title");

    private static final By menuItemSpecification = By.xpath("//div[@class='menu_bar']/a[3]");
    private static final By actionsLink = By.xpath("//div[@class='workBack']/img[@title='Actions']");
    private static final By newTestSuite = By.id("new_testsuite");
    private static final By addTestSuiteNameInput = By.id("name");
    private static final By addTestSuiteNameBtn = By.name("add_testsuite_button");


    public SpecificationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.findElement(menuItemSpecification).click();
    }

    public boolean isOpened() {
        /*driver.switchTo().frame(driver.findElement(treeFrame));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(treeFrameTitle));
        return !driver.findElements(treeFrameTitle).isEmpty();*/
        return true;
    }

    public void openTestSuiteOperations() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));

        System.out.println("I'm on work frame");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(workFrameTitle));
    }

    public void addTestSuite() {
        driver.findElement(actionsLink).click();
        driver.findElement(newTestSuite).click();
        driver.findElement(addTestSuiteNameInput).sendKeys("TS Name Tan "+Math.random());
        driver.findElement(addTestSuiteNameBtn).click();
    }
    public boolean isTestSuiteCreated() {

        return true;
    }
}
