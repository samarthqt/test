package tata;
import com.pageobjects.RecruitmentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecruitmentSteps extends RecruitmentPage {

    @Given("the recruiter is logged into the OrangeHRM application")
    public void theRecruiterIsLoggedIntoTheOrangeHRMApplication() {
        loginToApplication();
    }

    @When("the user navigates to the {string} module")
    public void theUserNavigatesToTheModule(String moduleName) {
        navigateToModule(moduleName);
    }

    @When("selects a specific {string}")
    public void selectsASpecificVacancy(String vacancyName) {
        selectVacancy(vacancyName);
    }

    @When("clicks the {string} button")
    public void clicksTheButton(String buttonName) {
        clickButton(buttonName);
    }

    @When("the user fills in the candidate's first name, last name, and email")
    public void theUserFillsInTheCandidatesDetails() {
        fillCandidateDetails();
    }

    @When("uploads the candidate's resume")
    public void uploadsTheCandidatesResume() {
        uploadResume();
    }

    @When("saves the candidate's information")
    public void savesTheCandidatesInformation() {
        saveCandidateInformation();
    }

    @Then("the new candidate is listed under the selected {string}")
    public void theNewCandidateIsListedUnderTheSelectedVacancy(String vacancyName) {
        verifyCandidateListed(vacancyName);
    }
}