package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.PrintOutputPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class PrintOutputSteps extends PrintOutputPage {

    @Given("the user logs into the SAP system with valid credentials")
    public void theUserLogsIntoTheSAPSystemWithValidCredentials() {
        loginToSAP();
    }

    @Given("the user navigates to the output management screen")
    public void theUserNavigatesToTheOutputManagementScreen() {
        navigateToOutputManagementScreen();
    }

    @When("the user selects the {string} output for printing using the {string}")
    public void theUserSelectsTheOutputForPrintingUsingTheTemplate(String outputType, String template) {
        selectOutputForPrinting(outputType, template);
    }

    @When("the user initiates the printing process for {string} with maximum fields {string}")
    public void theUserInitiatesThePrintingProcessForOutputTypeWithMaximumFields(String outputType, String maximumFields) {
        initiatePrintingProcess(outputType, maximumFields);
    }

    @Then("the {string} output is printed successfully")
    public void theOutputIsPrintedSuccessfully(String outputType) {
        verifyOutputPrintedSuccessfully(outputType);
    }

    @Then("the printed {string} output is accurate and well-formatted")
    public void thePrintedOutputIsAccurateAndWellFormatted(String outputType) {
        verifyOutputAccuracyAndFormatting(outputType);
    }

    @Then("the system logs do not contain any errors or warnings")
    public void theSystemLogsDoNotContainAnyErrorsOrWarnings() {
        verifySystemLogsForErrorsOrWarnings();
    }

    @Then("the system complies with operational and billing standards")
    public void theSystemCompliesWithOperationalAndBillingStandards() {
        verifyComplianceWithStandards();
    }
}