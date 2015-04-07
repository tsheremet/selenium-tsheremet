package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by tanya on 3/20/15.
 */
public class SpecificationPage extends AbstractPage {
    //private static Logger Log = Logger.getLogger(SpecificationPage.class.getName());

    private static Logger Log = LoggerFactory.getLogger(SpecificationPage.class);
    private static final By treeFrameTitle = By.className("title");
    private static final By workFrameTitle = By.className("title");

    private static final By menuItemSpecification = By.xpath("//div[@class='menu_bar']/a[3]");
    private static final By actionsLink = By.xpath("//div[@class='workBack']/img[@title='Actions']");
    private static final By newTestSuite = By.id("new_testsuite");
    private static final By addTestSuiteNameInput = By.id("name");
    private static final By addTestSuiteNameBtn = By.name("add_testsuite_button");
    private static final By treeTestSuiteNamesList = By.className("x-tree-node-el");
    private static final By treeTestSuiteNames = By.xpath("//div[@id='tree_div']/li[@class='x-tree-node']/li[@class='x-tree-node']");
    private static final By newTestCase = By.id("create_tc");
    private static final By addTestCaseNameInput = By.id("testcase_name");
    private static final By addTestCaseNameBtn = By.id("do_create_button");
    private static final By addAnotherCaseAfterBtn = By.id("stay_here");
    private static final By expandTestSuiteIcon = By.xpath("//img[@class='x-tree-elbow-plus']");
    private static final By createTestStepBtn = By.name("create_step");
    private static final By newTestStepAction = By.tagName("br");
    private static final By newTestStepActionText = By.xpath("//span[@id='cke_steps']/iframe");
    private static final By newTestStepExpectedResult = By.xpath("//tr[@id='new_step']/span[@id='cke_expected_results']");
    private static final By newTestStepSaveBtn = By.id("do_update_step");


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

    public boolean isInTreeFrame() {
        switchToWorkFrame();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(treeFrameTitle));
        return !driver.findElements(treeFrameTitle).isEmpty();
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

    public boolean isTestSuiteCreated(String suiteName) {
        switchToTreeFrame();
        List<WebElement> testSuiteNameList = driver.findElements(treeTestSuiteNamesList);
        for (WebElement testSuiteNameItem : testSuiteNameList) {
            if (testSuiteNameItem.getText().contains(suiteName)) {
                Log.info(String.format("Test suite with name '%s' created.",suiteName));
                return true;
            }
        }
        return false;
    }

    public void addTestCase(String suiteName, String caseName) {
        switchToTreeFrame();
        driver.findElement(treeTestSuiteNamesList).findElement(By.xpath(String.format("//span[contains(text(),'%s')]", suiteName))).click();
        switchToWorkFrame();
        driver.findElement(actionsLink).click();
        Log.info(String.format("Start creating test case with name '%s'",caseName));
        driver.findElement(newTestCase).click();
        driver.findElement(addTestCaseNameInput).sendKeys(caseName);
        driver.findElement(addTestCaseNameBtn).click();
    }

    public boolean isTestCaseCreated(String suiteName, String caseName) {
        switchToTreeFrame();
        WebElement findSuite = driver.findElement(treeTestSuiteNamesList).findElement(By.xpath(String.format("//span[contains(text(),'%s')]", suiteName)));
        findSuite.findElement(expandTestSuiteIcon).click();
        Log.info(findSuite.findElement(By.xpath("//ancestor::div[@class='x-tree-node-el']/ul[@class='x-tree-node-ct']/li")).getText());

        List<WebElement> testSuiteNameList = driver.findElements(treeTestSuiteNamesList);
        for (WebElement testSuiteNameItem : testSuiteNameList) {
            if (testSuiteNameItem.getText().contains(caseName)) {
                Log.info(String.format("Test case with name '%s' created.",caseName));
                return true;
            }
        }
        return false;
    }

    public void addTestStep(String suiteName, String caseName) {
        /*switchToTreeFrame();
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(treeTestSuiteNamesList).findElement(By.xpath(String.format("//span[contains(text(),'%s')]", suiteName))));

        Log.info("Double click on TS");
        driver.findElement(treeTestSuiteNamesList).findElement(By.xpath(String.format("//span[contains(text(),'%s')]", caseName))).click();
        */


        driver.findElement(createTestStepBtn).click();
        Log.info("Start creating test step");
        //switchToWorkFrame();
        //Log.info("I've got text = " + driver.findElement(newTestStepAction).getText());
        driver.findElement(newTestStepActionText).sendKeys("some text");
        driver.findElement(newTestStepExpectedResult).sendKeys("some result");
        driver.findElement(newTestStepSaveBtn).click();
        driver.findElement(newTestStepActionText).sendKeys("some text");
        driver.findElement(newTestStepExpectedResult).sendKeys("some result");
        driver.findElement(newTestStepSaveBtn).click();
        driver.findElement(newTestStepActionText).sendKeys("some text");
        driver.findElement(newTestStepExpectedResult).sendKeys("some result");
        driver.findElement(newTestStepSaveBtn).click();
    }
}
