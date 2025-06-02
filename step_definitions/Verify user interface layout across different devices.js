import { Given, Then, When } from "cypress-cucumber-preprocessor/steps";
import DevicePage from "../pages/devicePage";

Given("the application is accessed on a desktop device", () => {
 DevicePage.accessDesktop();
});

Then("the user interface should be clear and logical on desktop", () => {
 DevicePage.verifyUIDesktop();
});

Given("the application is accessed on a tablet device", () => {
 DevicePage.accessTablet();
});

Then("the user interface should be clear and logical on tablet", () => {
 DevicePage.verifyUITablet();
});

Given("the application is accessed on a mobile device", () => {
 DevicePage.accessMobile();
});

Then("the user interface should be clear and logical on mobile", () => {
 DevicePage.verifyUIMobile();
});

Given("the application is accessed on Chrome, Firefox, and Safari", () => {
 DevicePage.accessBrowsers();
});

Then("the UI should remain consistent across these browsers", () => {
 DevicePage.verifyUIBrowsers();
});

Given("the application is viewed on screen resolutions 1920x1080, 1280x720, and 800x600", () => {
 DevicePage.accessResolutions();
});

Then("the UI should adapt seamlessly to these screen resolutions", () => {
 DevicePage.verifyUIResolutions();
});

Given("the application is accessed on desktop, tablet, and mobile devices", () => {
 DevicePage.accessAllDevices();
});

Then("navigation elements should be accessible and functional on all devices", () => {
 DevicePage.verifyNavigationElements();
});

Then("text should be readable and appropriately sized on all screen sizes", () => {
 DevicePage.verifyTextReadability();
});

Then("images should render correctly and align well on all devices", () => {
 DevicePage.verifyImageRendering();
});

Then("buttons should function correctly and be well-placed on all devices", () => {
 DevicePage.verifyButtonFunctionality();
});

Then("form inputs should be responsive and easy to use on all devices", () => {
 DevicePage.verifyFormInputs();
});

Then("no elements or text should overlap on any device", () => {
 DevicePage.verifyNoOverlap();
});

Then("the UI should be aesthetically appealing and user-friendly", () => {
 DevicePage.verifyUIAesthetics();
});

Then("accessibility features should work correctly on all devices", () => {
 DevicePage.verifyAccessibilityFeatures();
});

Given("the application is accessed on devices capable of rotation", () => {
 DevicePage.accessRotatableDevices();
});

When("the device is rotated", () => {
 DevicePage.rotateDevice();
});

Then("the UI should adjust appropriately during device rotation", () => {
 DevicePage.verifyUIRotation();
});

Then("interactive elements should respond correctly on all devices", () => {
 DevicePage.verifyInteractiveElements();
});