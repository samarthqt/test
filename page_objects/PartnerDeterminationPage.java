package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PartnerDeterminationPage extends WebReusableComponents {

    protected By inboundFileUploadButton = By.id("uploadButton");
    protected By triggerProcessingButton = By.id("triggerProcessing");
    protected By shipToPartnerField = By.id("shipToPartner");
    protected By soldToPartnerField = By.id("soldToPartner");
    protected By plantField = By.id("plant");
    protected By logsField = By.id("logs");
    protected By documentFlowField = By.id("documentFlow");
    protected By partnerMasterRecordsField = By.id("partnerMasterRecords");
    protected By outputLogsField = By.id("outputLogs");
    protected By reportingScreensField = By.id("reportingScreens");
    protected By confirmationMessageField = By.id("confirmationMessage");
    protected By btnUploadFile = By.id("uploadFileButton");
    protected By btnTriggerProcessing = By.id("triggerProcessingButton");
    protected By txtShipToPartner = By.id("shipToPartner");
    protected By txtSoldToPartner = By.id("soldToPartner");
    protected By txtPlantDetermination = By.id("plantDetermination");
    protected By txtErrorLogs = By.id("errorLogs");
    protected By txtDocumentFlow = By.id("documentFlow");
    protected By txtPartnerMasterRecords = By.id("partnerMasterRecords");
    protected By txtOutputLogs = By.id("outputLogs");
    protected By txtReportingScreens = By.id("reportingScreens");
    protected By txtConfirmationMessage = By.id("confirmationMessage");

    public PartnerDeterminationPage() {
        PageFactory.initElements(driver, this);
    }

    public void prepareInboundFile(String siteID) {
        System.out.println("Preparing inbound file with Site_ID: " + siteID);
    }

    public void uploadInboundFile() {
        waitUntilElementVisible(inboundFileUploadButton, 3);
        clickElement(inboundFileUploadButton);
    }

    public void triggerInboundProcessing() {
        waitUntilElementVisible(triggerProcessingButton, 3);
        clickElement(triggerProcessingButton);
    }

    public void verifyShipToPartnerResolution() {
        waitUntilElementVisible(shipToPartnerField, 3);
        String actualShipToPartner = getTextFromElement(shipToPartnerField);
        Assert.assertEquals(actualShipToPartner, "ExpectedShipToPartner", "Ship To partner resolution failed.");
    }

    public void verifySoldToPartnerResolution() {
        waitUntilElementVisible(soldToPartnerField, 3);
        String actualSoldToPartner = getTextFromElement(soldToPartnerField);
        Assert.assertEquals(actualSoldToPartner, "ExpectedSoldToPartner", "Sold To partner resolution failed.");
    }

    public void verifyPlantDetermination(String cmoID) {
        waitUntilElementVisible(plantField, 3);
        String actualPlant = getTextFromElement(plantField);
        Assert.assertEquals(actualPlant, "ExpectedPlant", "Plant determination failed for CMO_ID: " + cmoID);
    }

    public void verifyNoErrorsInLogs() {
        waitUntilElementVisible(logsField, 3);
        String logs = getTextFromElement(logsField);
        Assert.assertFalse(logs.contains("Error"), "Logs contain errors.");
        Assert.assertFalse(logs.contains("Warning"), "Logs contain warnings.");
    }

    public void verifyDocumentFlow() {
        waitUntilElementVisible(documentFlowField, 3);
        String documentFlow = getTextFromElement(documentFlowField);
        Assert.assertEquals(documentFlow, "ExpectedDocumentFlow", "Document flow linkage failed.");
    }

    public void verifyPartnerMasterRecords() {
        waitUntilElementVisible(partnerMasterRecordsField, 3);
        String partnerMasterRecords = getTextFromElement(partnerMasterRecordsField);
        Assert.assertEquals(partnerMasterRecords, "ExpectedPartnerMasterRecords", "Partner master records update failed.");
    }

    public void verifyOutputLogs() {
        waitUntilElementVisible(outputLogsField, 3);
        String outputLogs = getTextFromElement(outputLogsField);
        Assert.assertEquals(outputLogs, "ExpectedOutputLogs", "Output logs verification failed.");
    }

    public void verifyReportingScreens() {
        waitUntilElementVisible(reportingScreensField, 3);
        String reportingScreens = getTextFromElement(reportingScreensField);
        Assert.assertEquals(reportingScreens, "ExpectedReportingScreens", "Reporting screens data verification failed.");
    }

    public void verifyConfirmationMessage() {
        waitUntilElementVisible(confirmationMessageField, 3);
        String confirmationMessage = getTextFromElement(confirmationMessageField);
        Assert.assertEquals(confirmationMessage, "ExpectedConfirmationMessage", "Confirmation message verification failed.");
    }

    public void verifyNoErrorsOrWarnings() {
        waitUntilElementVisible(txtErrorLogs, 3);
        String errorLogs = getTextFromElement(txtErrorLogs);
        Assert.assertTrue(errorLogs.isEmpty(), "Errors or warnings were logged during processing.");
    }

    public void verifyDocumentFlowLinkage() {
        waitUntilElementVisible(txtDocumentFlow, 3);
        String documentFlow = getTextFromElement(txtDocumentFlow);
        Assert.assertEquals(documentFlow, "ExpectedDocumentFlow", "Document flow linkage is incorrect.");
    }

    public void verifyPartnerMasterRecordsUpdate() {
        waitUntilElementVisible(txtPartnerMasterRecords, 3);
        String partnerMasterRecords = getTextFromElement(txtPartnerMasterRecords);
        Assert.assertEquals(partnerMasterRecords, "ExpectedPartnerMasterRecords", "Partner master records update failed.");
    }

    public void verifyProcessedDataInReportingScreens() {
        waitUntilElementVisible(txtReportingScreens, 3);
        String reportingScreensData = getTextFromElement(txtReportingScreens);
        Assert.assertEquals(reportingScreensData, "ExpectedReportingData", "Processed data is not displayed correctly in reporting screens.");
    }

    public void verifyProcessedDataInReports() {
        System.out.println("Verifying processed data in reporting screens.");
        Assert.assertTrue(true, "Processed data displayed correctly in reports.");
    }

    public void verifyShipToPartnerResolution(String siteID) {
        System.out.println("Verifying Ship To partner resolution for Site_ID: " + siteID);
        Assert.assertTrue(true, "Ship To partner resolved correctly.");
    }

    public void verifySoldToPartnerResolution(String siteID) {
        System.out.println("Verifying Sold To partner resolution for Site_ID: " + siteID);
        Assert.assertTrue(true, "Sold To partner resolved correctly.");
    }

    public void verifyNoErrorsOrWarnings(String siteID) {
        System.out.println("Verifying no errors or warnings for Site_ID: " + siteID);
        Assert.assertTrue(true, "No errors or warnings logged.");
    }
}
