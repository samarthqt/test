package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class ProjectOptionsPage extends WebReusableComponents {

    protected By projectsDropdown = By.id("projectsDropdown");
    protected By projectAlphaOption = By.xpath("//option[text()='Project Alpha']");
    protected By requirementsTile = By.id("requirementsTile");
    protected By generateOption = By.id("generateOption");
    protected By validateOption = By.id("validateOption");
    protected By fixOption = By.id("fixOption");
    protected By logoutButton = By.id("logoutButton");
    protected By homeScreen = By.id("homeScreen");

    public ProjectOptionsPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToCOCO() {
        // Implement login logic
        launchUrl(getAppUrl());
        maximizeWindow();
        // Assume login steps are performed here
    }

    public void navigateToHomeScreen() {
        waitUntilElementVisible(homeScreen, 3);
        Assert.assertTrue(isElementVisible(homeScreen), "Home screen is not visible.");
    }

    public void verifyHomeScreenOptions() {
        Assert.assertTrue(isElementVisible(projectsDropdown), "Projects dropdown is not visible on home screen.");
    }

    public void verifyProjectAssignment() {
        // Implement project assignment verification
        Assert.assertTrue(isElementVisible(projectAlphaOption), "Project Alpha option is not available.");
    }

    public void locateProjectsDropdown() {
        waitUntilElementVisible(projectsDropdown, 3);
    }

    public void verifyProjectsDropdownVisibility() {
        Assert.assertTrue(isElementVisible(projectsDropdown), "Projects dropdown is not visible.");
    }

    public void clickProjectsDropdown() {
        clickElement(projectsDropdown);
    }

    public void verifyDropdownExpansion() {
        Assert.assertTrue(isElementVisible(projectAlphaOption), "Dropdown did not expand correctly.");
    }

    public void selectProjectAlpha() {
        clickElement(projectAlphaOption);
    }

    public void verifyProjectAlphaNavigation() {
        // Implement navigation verification
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("ProjectAlpha"), "Navigation to Project Alpha failed.");
    }

    public void locateRequirementsTile() {
        waitUntilElementVisible(requirementsTile, 3);
    }

    public void verifyRequirementsTileVisibility() {
        Assert.assertTrue(isElementVisible(requirementsTile), "Requirements tile is not visible.");
    }

    public void clickRequirementsTile() {
        clickElement(requirementsTile);
    }

    public void verifyOptionsDisplayed() {
        Assert.assertTrue(isElementVisible(generateOption), "Generate option is not visible.");
        Assert.assertTrue(isElementVisible(validateOption), "Validate option is not visible.");
        Assert.assertTrue(isElementVisible(fixOption), "Fix option is not visible.");
    }

    public void verifyOptionLabels() {
        WebElement generate = findElement(generateOption);
        WebElement validate = findElement(validateOption);
        WebElement fix = findElement(fixOption);
        Assert.assertEquals(generate.getText(), "Generate", "Generate option label mismatch.");
        Assert.assertEquals(validate.getText(), "Validate", "Validate option label mismatch.");
        Assert.assertEquals(fix.getText(), "Fix", "Fix option label mismatch.");
    }

    public void selectGenerateOption() {
        clickElement(generateOption);
    }

    public void verifyGenerateFunctionality() {
        // Implement generate functionality verification
        Assert.assertTrue(isElementVisible(By.id("generateSuccess")), "Generate functionality failed.");
    }

    public void returnToRequirementsTile() {
        navigateBack();
        verifyRequirementsTileVisibility();
    }

    public void verifyRequirementsTileWithOptions() {
        verifyRequirementsTileVisibility();
        verifyOptionsDisplayed();
    }

    public void selectValidateOption() {
        clickElement(validateOption);
    }

    public void verifyValidateFunctionality() {
        // Implement validate functionality verification
        Assert.assertTrue(isElementVisible(By.id("validateSuccess")), "Validate functionality failed.");
    }

    public void selectFixOption() {
        clickElement(fixOption);
    }

    public void verifyFixFunctionality() {
        // Implement fix functionality verification
        Assert.assertTrue(isElementVisible(By.id("fixSuccess")), "Fix functionality failed.");
    }

    public void verifyNoErrors() {
        Assert.assertFalse(isElementVisible(By.id("errorMessage")), "Errors are present on the page.");
    }

    public void logoutFromCOCO() {
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isElementVisible(By.id("loginPage")), "Logout was not successful.");
    }
}