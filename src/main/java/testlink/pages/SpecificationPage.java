package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;


/**
 * Created by tanya on 3/20/15.
 */
public class SpecificationPage extends AbstractPage {
    private static final By treeFrameTitle = By.xpath("//h1[@class='title'][contains(text(),'Navigator - Test Specification')]");
    private static final By workFrameTitle = By.className("title");

    private static final By menuItemSpecification = By.xpath("//div[@class='menu_bar']/a[3]");
    private static final By actionsLink = By.xpath("//div[@class='workBack']/img[@title='Actions']");
    private static final By newTestSuite = By.id("new_testsuite");
    private static final By addTestSuiteNameInput = By.id("name");
    private static final By addTestSuiteNameBtn = By.name("add_testsuite_button");
    private static final By treeTestSuiteNames = By.xpath("//div[@id='tree_div']/li[@class='x-tree-node']/a");



    public SpecificationPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.findElement(menuItemSpecification).click();
    }

    public boolean isOpened() {
        switchToWorkFrame();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(workFrameTitle));
        return !driver.findElements(workFrameTitle).isEmpty();
    }


    public boolean openSpecificationPage() {
        open();
        return isOpened();
    }

    public void addTestSuite(String name) {
        driver.findElement(actionsLink).click();
        driver.findElement(newTestSuite).click();
        driver.findElement(addTestSuiteNameInput).sendKeys(name);
        driver.findElement(addTestSuiteNameBtn).click();
    }

    public boolean isTestSuiteCreated(String name) {
        switchToTreeFrame();
        List<WebElement> testSuiteNameList = driver.findElements(treeTestSuiteNames);
        for (WebElement testSuiteNameItem : testSuiteNameList) {
            Assert.assertEquals(testSuiteNameItem.getText(), name, String.format("Element '%s' wasn't found", name));
        }
        return true;
    }
}
