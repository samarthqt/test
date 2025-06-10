package com.framework.reusable;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.components.FrameworkParameters;
import com.framework.components.RestAssuredUtils;
import com.framework.components.ScriptHelper;
import com.framework.components.Settings;
import com.framework.cucumber.DriverManager;
import com.framework.data.DataTable;
import com.framework.report.Status;
import com.framework.selenium.SeleniumReport;
import com.framework.webcrawler.ReadProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MobileResuableComponents  extends GenericResuableComponents {
	
	
	/**
	 * The {@link DataTable} object (passed from the test script)
	 */
	protected DataTable dataTable;
	/**
	 * The {@link SeleniumReport} object (passed from the test script)
	 */
	protected SeleniumReport report;
	/**
	 * The {@link AppiumDriver} object
	 */
	@SuppressWarnings("rawtypes")
	protected AppiumDriver driver;

	/**
	 * The {@link ScriptHelper} object (required for calling one reusable library
	 * from another)
	 */
	protected ScriptHelper scriptHelper;

	/**
	 * The {@link Properties} object with settings loaded from the framework
	 * properties file
	 */
	protected Properties properties;
	/**
	 * The {@link FrameworkParameters} object
	 */
	
	/**
	 * The {@link APIReusuableLibrary} object
	 */
	protected RestAssuredUtils apiDriver;
	
	protected FrameworkParameters frameworkParameters;
	
	//private static WebDriver driver;
	private static WebDriverWait wait;
	ReadProperties propertiesReader = new ReadProperties();

	/**
	 * Constructor to initialize the {@link ScriptHelper} object and in turn the
	 * objects wrapped by it
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object
	 */
	public MobileResuableComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
		this.scriptHelper = scriptHelper;
		if (scriptHelper != null) {
			this.dataTable = scriptHelper.getDataTable();
			this.report = scriptHelper.getReport();
			this.apiDriver = scriptHelper.getApiDriver();
			this.driver = scriptHelper.getcustomDriver().getAppiumDriver();
			properties = Settings.getInstance();
			frameworkParameters = FrameworkParameters.getInstance();
		}
	}

	
	public MobileResuableComponents() {
		super();
		this.driver = DriverManager.getAppiumDriver();
	}
	
	public enum Direction {
	    UP,
	    DOWN,
	    LEFT,
	    RIGHT;
	}
	
	/**
	 * Function to enter text in element 
	 * 
	 * @param by   The {@link AppiumDriver} locator used to identify the element
	 * @param name of the element
	 */
	public void enterText(By by, String valueToEnter) {
		try { 
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(valueToEnter);
			addTestLog("Enter Text ", valueToEnter + "is entered successfully in " + by, Status.PASS);
		} catch(Exception e) {
			addTestLog("Enter Text ", valueToEnter + "is NOT entered in " + by + ". Error Message - " + e.getMessage(), Status.FAIL);
		}
	}
	
	/**
	 * Function to click element
	 * 
	 * @param by   The {@link AppiumDriver} locator used to identify the element
	 * @param name of the element
	 */
	public void ClickElement(By by) {
		driver.findElement(by).click();
		addTestLog("Click Element", by + " is clicked successfully", Status.PASS);
	}
	
	/**
	 * Performs swipe from the center of screen
	 *
	 * @param dir the direction of swipe
	 * @version java-client: 7.3.0
	 **/
	@SuppressWarnings("rawtypes")
	public void swipeScreen(Direction dir) {
	    System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

	    // Animation default time:
	    //  - Android: 300 ms
	    //  - iOS: 200 ms
	    // final value depends on your app and could be greater
	    final int ANIMATION_TIME = 200; // ms

	    final int PRESS_TIME = 200; // ms

	    int edgeBorder = 10; // better avoid edges
	    PointOption pointOptionStart, pointOptionEnd;

	    // init screen variables
	    Dimension dims = driver.manage().window().getSize();

	    // init start point = center of screen
	    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

	    switch (dir) {
	        case DOWN: // center of footer
	            pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
	            break;
	        case UP: // center of header
	            pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
	            break;
	        case LEFT: // center of left side
	            pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
	            break;
	        case RIGHT: // center of right side
	            pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
	            break;
	        default:
	            throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
	    }

	    // execute swipe using TouchAction
	    try {
	        new TouchAction(driver)
	                .press(pointOptionStart)
	                // a bit more reliable when we add small wait
	                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
	                .moveTo(pointOptionEnd)
	                .release().perform();
	    } catch (Exception e) {
	        System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
	        return;
	    }

	    // always allow swipe action to complete
	    try {
	        Thread.sleep(ANIMATION_TIME);
	    } catch (InterruptedException e) {
	        // ignore
	    }
	}
	
	/**
	 * Function to read implicit timeout from properties file
	 * 
	 */
	public Long getTime() throws Exception {
		Long waitUnit = propertiesReader.getTimeout();
		return waitUnit;
	}
	
	/**
	 * Function to wait until element is visible
	 * 
	 * @param element   The {@link WebElement} 
	 */
	protected void WaitUntilElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Function to wait until element is visible
	 * 
	 * @param by   xpath/id/classname/name for the element
	 */

	public boolean elementVisible(By by) {
		WebElement element = driver.findElement(by);
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * Function to click an element
	 * 
	 * @param element   The {@link WebElement} 
	 */
	public void clickOnElement(WebElement element){
		WaitUntilElementVisible(element);
		element.click();
	}
	
	/**
	 * Function to enter the text in an element
	 * 
	 * @param element   The {@link WebElement} 
	 * @param text To enter
	 */
	public void typeIntoElement(WebElement element, String textTotype) {
		WaitUntilElementVisible(element);
		element.sendKeys(textTotype);
	}

	/**
	 * Function to read the text attribute of an element
	 * 
	 * @param element   The {@link WebElement} 
	 */
	public String getTextFromElement(WebElement element) {
		WaitUntilElementVisible(element);
		return element.getText();
	}
	
	
	/**
	 * Function to move to an element 
	 * 
	 * @param element   The {@link WebElement} 
	 */
	public void moveToElement(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	
}
