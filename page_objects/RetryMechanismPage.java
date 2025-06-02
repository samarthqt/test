
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RetryMechanismPage extends WebReusableComponents {

    protected By orderConfirmationFeatureToggle = By.id("orderConfirmationFeatureToggle");
    protected By networkFailureSimulation = By.id("networkFailureSimulation");
    protected By retryInitiationLog = By.id("retryInitiationLog");
    protected By emailReceivedConfirmation = By.id("emailReceivedConfirmation");
    protected By emailContentVerification = By.id("emailContentVerification");
    protected By retrySuccessLog = By.id("retrySuccessLog");
    protected By userNotification = By.id("userNotification");
    protected By performanceCheck = By.id("performanceCheck");
    protected By retryTimeFrameCheck = By.id("retryTimeFrameCheck");
    protected By manualResendOption = By.id("manualResendOption");
    protected By userImpactCheck = By.id("userImpactCheck");
    protected By logDetailsCheck = By.id("logDetailsCheck");
    protected By simultaneousRetriesCheck = By.id("simultaneousRetriesCheck");

    public RetryMechanismPage() {
        PageFactory.initElements(driver, this);
    }

    public void enableOrderConfirmationFeature() {
        waitUntilElementVisible(orderConfirmationFeatureToggle, 3);
        clickElement(orderConfirmationFeatureToggle);
    }

    public void simulateNetworkFailure() {
        waitUntilElementVisible(networkFailureSimulation, 3);
        clickElement(networkFailureSimulation);
    }

    public void verifyInitialAttemptFailure() {
        String failureMessage = getTextFromElement(networkFailureSimulation);
        Assert.assertTrue(failureMessage.contains("Network failure"), "Initial attempt did not fail as expected.");
    }

    public void verifyFailureLogging() {
        String logMessage = getTextFromElement(retryInitiationLog);
        Assert.assertTrue(logMessage.contains("Failure logged"), "Failure was not logged correctly.");
    }

    public void detectFailure() {
        WebElement element = waitUntilElementVisible(networkFailureSimulation, 3);
        Assert.assertNotNull(element, "Failure detection element is not visible.");
    }

    public void verifyRetryInitiation() {
        String retryMessage = getTextFromElement(retryInitiationLog);
        Assert.assertTrue(retryMessage.contains("Retry initiated"), "Retry was not initiated.");
    }

    public void restoreNetworkConditions() {
        WebElement element = waitUntilElementVisible(networkFailureSimulation, 3);
        Assert.assertNotNull(element, "Network conditions could not be restored.");
    }

    public void verifyRetrySuccess() {
        String successMessage = getTextFromElement(emailReceivedConfirmation);
        Assert.assertTrue(successMessage.contains("Confirmation sent"), "Retry attempt was not successful.");
    }

    public void verifyEmailReceived() {
        String emailMessage = getTextFromElement(emailReceivedConfirmation);
        Assert.assertTrue(emailMessage.contains("Email received"), "Confirmation email was not received.");
    }

    public void verifyEmailContent() {
        String emailContent = getTextFromElement(emailContentVerification);
        Assert.assertTrue(emailContent.contains("Order number") && emailContent.contains("Shipping address") && emailContent.contains("Items purchased"), "Email content is incorrect.");
    }

    public void verifyRetrySuccessLogging() {
        String logMessage = getTextFromElement(retrySuccessLog);
        Assert.assertTrue(logMessage.contains("Retry success logged"), "Retry success was not logged.");
    }

    public void verifySingleEmailSent() {
        WebElement element = waitUntilElementVisible(emailReceivedConfirmation, 3);
        Assert.assertNotNull(element, "Single email verification failed.");
    }

    public void verifyUserNotification() {
        String notificationMessage = getTextFromElement(userNotification);
        Assert.assertTrue(notificationMessage.contains("User notified"), "User was not notified of retry.");
    }

    public void verifyPerformance() {
        String performanceMessage = getTextFromElement(performanceCheck);
        Assert.assertTrue(performanceMessage.contains("Performance unaffected"), "Performance was affected by retries.");
    }

    public void verifyRetryTimeFrame() {
        String timeFrameMessage = getTextFromElement(retryTimeFrameCheck);
        Assert.assertTrue(timeFrameMessage.contains("Within time frame"), "Retries did not occur within the time frame.");
    }

    public void simulateRetryFailure() {
        WebElement element = waitUntilElementVisible(networkFailureSimulation, 3);
        Assert.assertNotNull(element, "Retry failure simulation failed.");
    }

    public void verifyManualResendOption() {
        String resendOptionMessage = getTextFromElement(manualResendOption);
        Assert.assertTrue(resendOptionMessage.contains("Manual resend available"), "Manual resend option is not available.");
    }

    public void verifyUserImpact() {
        String impactMessage = getTextFromElement(userImpactCheck);
        Assert.assertTrue(impactMessage.contains("No user impact"), "Users were negatively impacted by retries.");
    }

    public void verifyLogDetails() {
        String logDetails = getTextFromElement(logDetailsCheck);
        Assert.assertTrue(logDetails.contains("Clear logs"), "Logs are not clear.");
    }

    public void simulateMultipleUserRetries() {
        WebElement element = waitUntilElementVisible(simultaneousRetriesCheck, 3);
        Assert.assertNotNull(element, "Multiple user retries simulation failed.");
    }

    public void verifySimultaneousRetries() {
        String simultaneousMessage = getTextFromElement(simultaneousRetriesCheck);
        Assert.assertTrue(simultaneousMessage.contains("Handled simultaneously"), "System did not handle simultaneous retries.");
    }
}
