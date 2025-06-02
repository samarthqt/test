package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ARFunctionalityPage;

public class ARFunctionalitySteps extends ARFunctionalityPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I have opened the application on an unsupported browser")
    public void iHaveOpenedTheApplicationOnAnUnsupportedBrowser() {
        openApplicationOnUnsupportedBrowser();
    }

    @Then("the application should display a clear error message indicating that the browser is unsupported for AR functionality")
    public void theApplicationShouldDisplayAClearErrorMessageIndicatingThatTheBrowserIsUnsupportedForARFunctionality() {
        verifyUnsupportedBrowserErrorMessage();
    }

    @Given("I attempt to access AR features using an unsupported device")
    public void iAttemptToAccessARFeaturesUsingAnUnsupportedDevice() {
        accessARFeaturesOnUnsupportedDevice();
    }

    @Then("an error message should be displayed indicating that the device is not supported for AR functionality")
    public void anErrorMessageShouldBeDisplayedIndicatingThatTheDeviceIsNotSupportedForARFunctionality() {
        verifyUnsupportedDeviceErrorMessage();
    }

    @Given("I check the application documentation")
    public void iCheckTheApplicationDocumentation() {
        checkApplicationDocumentation();
    }

    @Then("the documentation should clearly list supported devices and browsers for AR functionality")
    public void theDocumentationShouldClearlyListSupportedDevicesAndBrowsersForARFunctionality() {
        verifySupportedDevicesAndBrowsersInDocumentation();
    }

    @Given("I try accessing AR features using a supported device and browser")
    public void iTryAccessingARFeaturesUsingASupportedDeviceAndBrowser() {
        accessARFeaturesOnSupportedDeviceAndBrowser();
    }

    @Then("AR functionality should work without displaying any error messages")
    public void arFunctionalityShouldWorkWithoutDisplayingAnyErrorMessages() {
        verifyARFunctionalityWorks();
    }

    @Given("AR functionality is active")
    public void arFunctionalityIsActive() {
        activateARFunctionality();
    }

    @When("I switch to an unsupported browser")
    public void iSwitchToAnUnsupportedBrowser() {
        switchToUnsupportedBrowser();
    }

    @Then("the application should immediately display an error message indicating the browser is unsupported")
    public void theApplicationShouldImmediatelyDisplayAnErrorMessageIndicatingTheBrowserIsUnsupported() {
        verifyImmediateUnsupportedBrowserErrorMessage();
    }

    @Given("I attempt to access non-AR features on an unsupported browser")
    public void iAttemptToAccessNonARFeaturesOnAnUnsupportedBrowser() {
        accessNonARFeaturesOnUnsupportedBrowser();
    }

    @Then("non-AR features should function normally without error messages")
    public void nonARFeaturesShouldFunctionNormallyWithoutErrorMessages() {
        verifyNonARFeaturesFunctionNormally();
    }

    @Given("I change device settings to simulate unsupported device conditions")
    public void iChangeDeviceSettingsToSimulateUnsupportedDeviceConditions() {
        simulateUnsupportedDeviceConditions();
    }

    @Then("the application should detect the unsupported conditions and display an appropriate error message")
    public void theApplicationShouldDetectTheUnsupportedConditionsAndDisplayAnAppropriateErrorMessage() {
        verifyUnsupportedConditionsErrorMessage();
    }

    @Given("an error message is displayed for unsupported browser/device")
    public void anErrorMessageIsDisplayedForUnsupportedBrowserDevice() {
        triggerUnsupportedBrowserDeviceErrorMessage();
    }

    @Then("the error message should include guidance or links to supported browsers/devices")
    public void theErrorMessageShouldIncludeGuidanceOrLinksToSupportedBrowsersDevices() {
        verifyGuidanceInErrorMessage();
    }

    @Given("there are different unsupported conditions")
    public void thereAreDifferentUnsupportedConditions() {
        setupDifferentUnsupportedConditions();
    }

    @Then("error messages should be consistent and clear regardless of the unsupported condition")
    public void errorMessagesShouldBeConsistentAndClearRegardlessOfTheUnsupportedCondition() {
        verifyConsistencyOfErrorMessages();
    }

    @Given("I attempt to use AR functionality with outdated device software")
    public void iAttemptToUseARFunctionalityWithOutdatedDeviceSoftware() {
        useARFunctionalityWithOutdatedSoftware();
    }

    @Then("an error message should indicate the software version is unsupported for AR functionality")
    public void anErrorMessageShouldIndicateTheSoftwareVersionIsUnsupportedForARFunctionality() {
        verifyOutdatedSoftwareErrorMessage();
    }

    @Given("I attempt to access AR functionality with unsupported conditions")
    public void iAttemptToAccessARFunctionalityWithUnsupportedConditions() {
        accessARFunctionalityWithUnsupportedConditions();
    }

    @Then("the application should log unsupported access attempts for auditing purposes")
    public void theApplicationShouldLogUnsupportedAccessAttemptsForAuditingPurposes() {
        verifyLoggingOfUnsupportedAccessAttempts();
    }

    @Given("an unsupported condition is detected")
    public void anUnsupportedConditionIsDetected() {
        detectUnsupportedCondition();
    }

    @Then("error messages should be displayed promptly without delay")
    public void errorMessagesShouldBeDisplayedPromptlyWithoutDelay() {
        verifyPromptDisplayOfErrorMessages();
    }

    @Given("there is a network failure during AR functionality access on an unsupported device")
    public void thereIsANetworkFailureDuringARFunctionalityAccessOnAnUnsupportedDevice() {
        simulateNetworkFailureOnUnsupportedDevice();
    }

    @Then("the application should prioritize displaying the unsupported device error message over network failure messages")
    public void theApplicationShouldPrioritizeDisplayingTheUnsupportedDeviceErrorMessageOverNetworkFailureMessages() {
        verifyPriorityOfUnsupportedDeviceErrorMessage();
    }

    @Given("I test the application on a device with unsupported hardware specifications")
    public void iTestTheApplicationOnADeviceWithUnsupportedHardwareSpecifications() {
        testOnUnsupportedHardwareSpecifications();
    }

    @Then("an error message should clearly indicate the hardware specifications are unsupported")
    public void anErrorMessageShouldClearlyIndicateTheHardwareSpecificationsAreUnsupported() {
        verifyUnsupportedHardwareErrorMessage();
    }

    @Given("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        displayErrorMessage();
    }

    @Then("the error message should be available in multiple languages based on user settings")
    public void theErrorMessageShouldBeAvailableInMultipleLanguagesBasedOnUserSettings() {
        verifyLocalizationOfErrorMessages();
    }
}