import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProfilePage from "../pages/profilePage";

Given("I am logged into the COCO application as an {string} with username {string} and password {string}", (role, username, password) => {
 ProfilePage.login(role, username, password);
});

When("I navigate to the profile page", () => {
 ProfilePage.visitProfilePage();
});

Then("I should see the 'Release' label with the appropriate value", () => {
 ProfilePage.verifyReleaseLabel();
});

Then("I should see the 'Last Deployed Date' label with the appropriate value", () => {
 ProfilePage.verifyLastDeployedDateLabel();
});