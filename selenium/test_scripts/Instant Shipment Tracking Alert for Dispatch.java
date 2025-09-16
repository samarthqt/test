package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class DynamicsLoginPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }
}

package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrdersModulePage extends WebReusableComponents {

    protected By ordersModuleLink = By.id("ordersModule");
    protected By orderIdField = By.id("orderId");
    protected By btnUpdateShipmentStatus = By.id("updateShipmentStatus");
    protected By alertSystemLink = By.id("alertSystem");
    protected By customerAlertMessage = By.id("customerAlertMessage");

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModuleLink, 3);
        clickElement(ordersModuleLink);
    }

    public void selectOrderById(String orderId) {
        waitUntilElementVisible(orderIdField, 3);
        enterText(orderIdField, orderId);
    }

    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(btnUpdateShipmentStatus, 3);
        selectByValue(btnUpdateShipmentStatus, status);
    }

    public void checkAlertSystem() {
        waitUntilElementVisible(alertSystemLink, 3);
        clickElement(alertSystemLink);
    }

    public void verifyCustomerAlert(String expectedAlert) {
        waitUntilElementVisible(customerAlertMessage, 3);
        String actualAlert = getTextFromElement(customerAlertMessage);
        Assert.assertEquals(actualAlert, expectedAlert, "Customer alert message does not match.");
    }
}

package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicsLoginSteps extends DynamicsLoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("Log in to the Dynamics 365 system with valid credentials")
    public void logInToDynamics365() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }
}

package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrdersModuleSteps extends OrdersModulePage {

    private TestHarness testHarness = new TestHarness();

    @When("Navigate to the 'Orders' module")
    public void navigateToOrdersModule() {
        navigateToOrdersModule();
    }

    @When("Select the order with ID {string}")
    public void selectOrderWithId(String orderId) {
        selectOrderById(orderId);
    }

    @When("Update the shipment status to {string}")
    public void updateShipmentStatus(String status) {
        updateShipmentStatus(status);
    }

    @When("Check the alert system for outgoing alerts")
    public void checkAlertSystem() {
        checkAlertSystem();
    }

    @Then("Verify the alert received by the customer")
    public void verifyCustomerAlert() {
        String expectedAlert = testHarness.getData("AlertData", "ExpectedCustomerAlert");
        verifyCustomerAlert(expectedAlert);
    }
}