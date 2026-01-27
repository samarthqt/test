package tata;
import com.pageobjects.TimesheetPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TimesheetSteps extends TimesheetPage {

    @Given("the employee is logged on to the OrangeHRM system")
    public void theEmployeeIsLoggedOnToTheOrangeHRMSystem() {
        loginToOrangeHRM();
    }

    @When("the user goes to the {string} module and selects {string}")
    public void theUserGoesToTheModuleAndSelects(String module, String option) {
        navigateToModule(module);
        selectOption(option);
    }

    @When("creates a timesheet for the current week")
    public void createsATimesheetForTheCurrentWeek() {
        createTimesheetForCurrentWeek();
    }

    @When("the user enters hours for a specific project and activity for each day of the week")
    public void theUserEntersHoursForASpecificProjectAndActivityForEachDayOfTheWeek() {
        enterHoursForProjectAndActivity();
    }

    @When("the user submits the timesheet for approval")
    public void theUserSubmitsTheTimesheetForApproval() {
        submitTimesheetForApproval();
    }

    @Then("the timesheet status changes to {string}")
    public void theTimesheetStatusChangesTo(String status) {
        verifyTimesheetStatus(status);
    }
}