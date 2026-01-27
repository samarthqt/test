package tete;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TimesheetPage extends WebReusableComponents {

    protected By timeModule = By.id("timeModule");
    protected By myTimesheetsOption = By.id("myTimesheets");
    protected By createTimesheetButton = By.id("createTimesheet");
    protected By projectDropdown = By.id("projectDropdown");
    protected By activityDropdown = By.id("activityDropdown");
    protected By hoursInput = By.id("hoursInput");
    protected By submitButton = By.id("submitButton");
    protected By statusLabel = By.id("statusLabel");

    public TimesheetPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToOrangeHRM() {
        // Dummy implementation for login
    }

    public void navigateToModule(String module) {
        waitUntilElementVisible(timeModule, 3);
        clickElement(timeModule);
    }

    public void selectOption(String option) {
        waitUntilElementVisible(myTimesheetsOption, 3);
        clickElement(myTimesheetsOption);
    }

    public void createTimesheetForCurrentWeek() {
        waitUntilElementVisible(createTimesheetButton, 3);
        clickElement(createTimesheetButton);
    }

    public void enterHoursForProjectAndActivity() {
        waitUntilElementVisible(projectDropdown, 3);
        selectByValue(projectDropdown, "ProjectName");
        waitUntilElementVisible(activityDropdown, 3);
        selectByValue(activityDropdown, "ActivityName");
        waitUntilElementVisible(hoursInput, 3);
        enterText(hoursInput, "8");
    }

    public void submitTimesheetForApproval() {
        waitUntilElementVisible(submitButton, 3);
        clickElement(submitButton);
    }

    public void verifyTimesheetStatus(String expectedStatus) {
        waitUntilElementVisible(statusLabel, 3);
        String actualStatus = getTextFromElement(statusLabel);
        Assert.assertEquals(actualStatus, expectedStatus, "Timesheet status does not match.");
    }
}