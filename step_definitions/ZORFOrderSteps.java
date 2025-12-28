package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.ZORFOrderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZORFOrderSteps extends ZORFOrderPage {

    @Given("the Lisbon system sends a payload with status {PayloadStatus} to S/4HANA")
    public void theLisbonSystemSendsPayload(String payloadStatus) {
        sendPayloadToS4HANA(payloadStatus);
    }

    @When("the user monitors the interface processing in S/4HANA")
    public void theUserMonitorsInterfaceProcessing() {
        monitorInterfaceProcessing();
    }

    @Then("the interface should process the payload successfully without errors")
    public void theInterfaceProcessesPayloadSuccessfully() {
        verifyInterfaceProcessingSuccess();
    }

    @Then("a ZORF order should be created in the S/4HANA system")
    public void aZORFOrderShouldBeCreated() {
        verifyZORFOrderCreation();
    }

    @Then("the ZORF order should reference the original ZOR order correctly")
    public void theZORFOrderReferencesOriginalZOROrder() {
        verifyZORFOrderReferencesOriginalZOROrder();
    }

    @Then("the ZORF order should adhere to the Sales Area {SalesArea}")
    public void theZORFOrderAdheresToSalesArea(String salesArea) {
        verifyZORFOrderSalesArea(salesArea);
    }

    @Then("the original ZOR order status should be updated to reflect the cancellation")
    public void theOriginalZOROrderStatusUpdated() {
        verifyOriginalZOROrderStatusUpdate();
    }

    @Then("the system logs should not contain any errors or warnings during the order creation process")
    public void theSystemLogsShouldBeErrorFree() {
        verifySystemLogs();
    }

    @Then("the ZORF order should contain all mandatory fields and data as per the business requirements")
    public void theZORFOrderContainsMandatoryFields() {
        verifyMandatoryFieldsInZORFOrder();
    }

    @Then("the integration between Lisbon and S/4HANA should function as expected")
    public void theIntegrationFunctionsAsExpected() {
        verifyIntegrationBetweenLisbonAndS4HANA();
    }

    @Then("the ZORF order should be visible in the relevant order management reports")
    public void theZORFOrderVisibleInReports() {
        verifyZORFOrderVisibilityInReports();
    }

    @Then("the financial postings related to the ZORF order should be accurate")
    public void theFinancialPostingsShouldBeAccurate() {
        verifyFinancialPostingsForZORFOrder();
    }

    @Then("the audit logs should provide complete traceability of the order creation process")
    public void theAuditLogsProvideTraceability() {
        verifyAuditLogsForOrderCreation();
    }
}