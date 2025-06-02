package com.cucumber.steps;

import com.page_objects.MobilePerformancePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobilePerformanceSteps extends MobilePerformancePage {

    @Given("an unlocked iPhone X device with iOS 12")
    public void anUnlockedIPhoneXDeviceWithIOS12() {
        setupIOSDevice("iPhone X", "iOS 12");
    }

    @Given("normal network conditions with 100Mbps speed")
    public void normalNetworkConditionsWith100MbpsSpeed() {
        setupNetworkConditions(100);
    }

    @When("the user navigates to the application home page on the mobile browser")
    public void theUserNavigatesToTheApplicationHomePageOnTheMobileBrowser() {
        navigateToHomePage();
    }

    @When("starts a timer as the page begins loading")
    public void startsATimerAsThePageBeginsLoading() {
        startLoadingTimer();
    }

    @Then("the application loads within 3 seconds")
    public void theApplicationLoadsWithin3Seconds() {
        verifyLoadingTime(3);
    }

    @Given("an Android 8.0+ device")
    public void anAndroid80PlusDevice() {
        setupAndroidDevice("Android 8.0+");
    }

    @Given("the application is loaded on a mobile device")
    public void theApplicationIsLoadedOnAMobileDevice() {
        verifyApplicationLoaded();
    }

    @Then("all application features are functional")
    public void allApplicationFeaturesAreFunctional() {
        verifyApplicationFunctionality();
    }

    @Then("no errors are present in the mobile browser console")
    public void noErrorsArePresentInTheMobileBrowserConsole() {
        checkBrowserConsoleErrors();
    }

    @Then("the application layout and design appear correctly")
    public void theApplicationLayoutAndDesignAppearCorrectly() {
        verifyLayoutAndDesign();
    }

    @Given("slightly reduced network conditions")
    public void slightlyReducedNetworkConditions() {
        setupNetworkConditions(50);
    }

    @Then("the application still loads within 3 seconds")
    public void theApplicationStillLoadsWithin3Seconds() {
        verifyLoadingTime(3);
    }

    @Given("the application is accessed repeatedly")
    public void theApplicationIsAccessedRepeatedly() {
        accessApplicationRepeatedly();
    }

    @Then("repeated access does not affect loading time")
    public void repeatedAccessDoesNotAffectLoadingTime() {
        verifyConsistentLoadingTime();
    }

    @Given("peak hour conditions")
    public void peakHourConditions() {
        setupPeakHourConditions();
    }

    @Then("no performance degradation is observed")
    public void noPerformanceDegradationIsObserved() {
        verifyPerformanceStability();
    }

    @Then("loading times are logged accurately for all devices")
    public void loadingTimesAreLoggedAccuratelyForAllDevices() {
        logLoadingTimes();
    }

    @Given("the application has been updated")
    public void theApplicationHasBeenUpdated() {
        updateApplication();
    }

    @Then("loading times remain consistent")
    public void loadingTimesRemainConsistent() {
        verifyConsistentLoadingTime();
    }

    @Given("various mobile browsers are used")
    public void variousMobileBrowsersAreUsed() {
        setupVariousBrowsers();
    }

    @Then("the application loads within 3 seconds on all tested mobile browsers")
    public void theApplicationLoadsWithin3SecondsOnAllTestedMobileBrowsers() {
        verifyLoadingTimeAcrossBrowsers(3);
    }

    @Then("the application is optimized and loads efficiently on mobile devices")
    public void theApplicationIsOptimizedAndLoadsEfficientlyOnMobileDevices() {
        verifyMobileOptimization();
    }
}