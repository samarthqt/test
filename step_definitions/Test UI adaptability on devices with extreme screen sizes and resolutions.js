import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import DevicePage from "../pages/devicePage";

Given("Device {int} with screen size {float} inches and resolution {string}", (deviceNumber, screenSize, resolution) => {
 DevicePage.setDevice(deviceNumber, screenSize, resolution);
});

When("I launch the application", () => {
 DevicePage.launchApplication();
});

Then("the application UI should load correctly without any distortion", () => {
 DevicePage.verifyUILoadsCorrectly();
});

When("I navigate through the main menu", () => {
 DevicePage.navigateMainMenu();
});

Then("all menu items should be visible and accessible", () => {
 DevicePage.verifyMenuItemsVisibility();
});

When("I adjust the screen brightness and contrast settings", () => {
 DevicePage.adjustScreenSettings();
});

Then("UI elements should remain visible and distinguishable", () => {
 DevicePage.verifyUIElementsVisibility();
});

When("I perform a swipe gesture on the main screen", () => {
 DevicePage.performSwipeGesture();
});

Then("the swipe gesture should be recognized and executed smoothly", () => {
 DevicePage.verifySwipeGestureExecution();
});

Given("devices with extreme screen sizes and resolutions", () => {
 DevicePage.setExtremeDevices();
});

When("I rotate the screen to portrait and landscape orientations", () => {
 DevicePage.rotateScreen();
});

Then("UI should adapt without loss of functionality", () => {
 DevicePage.verifyUIAdaptability();
});

When("I interact with buttons, sliders, and input fields", () => {
 DevicePage.interactWithElements();
});

Then("all interactive elements should be operable and responsive", () => {
 DevicePage.verifyInteractiveElements();
});

When("I operate the application", () => {
 DevicePage.operateApplication();
});

Then("the application should run smoothly without lag or crashes", () => {
 DevicePage.verifyApplicationPerformance();
});