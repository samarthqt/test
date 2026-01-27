package tete;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RecruitmentPage extends WebReusableComponents {

    public RecruitmentPage() {
        PageFactory.initElements(driver, this);
    }

    protected By recruitmentModule = By.id("menu_recruitment_viewRecruitmentModule");
    protected By vacancyDropdown = By.id("vacancyDropdown");
    protected By addCandidateButton = By.id("btnAddCandidate");
    protected By firstNameField = By.id("addCandidate_firstName");
    protected By lastNameField = By.id("addCandidate_lastName");
    protected By emailField = By.id("addCandidate_email");
    protected By resumeUpload = By.id("addCandidate_resume");
    protected By saveButton = By.id("btnSave");
    protected By candidateList = By.id("candidateList");

    public void loginToApplication() {
        // Implement login logic here
    }

    public void navigateToModule(String moduleName) {
        waitUntilElementVisible(recruitmentModule, 3);
        clickElement(recruitmentModule);
    }

    public void selectVacancy(String vacancyName) {
        waitUntilElementVisible(vacancyDropdown, 3);
        selectByVisibleText(vacancyDropdown, vacancyName);
    }

    public void clickButton(String buttonName) {
        if (buttonName.equals("Add Candidate")) {
            waitUntilElementVisible(addCandidateButton, 3);
            clickElement(addCandidateButton);
        }
    }

    public void fillCandidateDetails() {
        waitUntilElementVisible(firstNameField, 3);
        enterText(firstNameField, "John");
        enterText(lastNameField, "Doe");
        enterText(emailField, "john.doe@example.com");
    }

    public void uploadResume() {
        waitUntilElementVisible(resumeUpload, 3);
        uploadFile(resumeUpload, "/path/to/resume.pdf");
    }

    public void saveCandidateInformation() {
        waitUntilElementVisible(saveButton, 3);
        clickElement(saveButton);
    }

    public void verifyCandidateListed(String vacancyName) {
        waitUntilElementVisible(candidateList, 3);
        boolean candidateListed = getWebElementList(candidateList)
            .stream()
            .anyMatch(item -> item.getText().contains("John Doe"));
        Assert.assertTrue(candidateListed, "Candidate is not listed under the vacancy.");
    }
}