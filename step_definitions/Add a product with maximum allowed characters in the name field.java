package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductPage;

public class ProductSteps extends ProductPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User is logged into the admin panel")
    public void userIsLoggedIntoTheAdminPanel() {
        loginToAdminPanel();
    }

    @When("User navigates to the product addition page")
    public void userNavigatesToTheProductAdditionPage() {
        navigateToProductAdditionPage();
    }

    @Then("Product addition page is displayed successfully")
    public void productAdditionPageIsDisplayedSuccessfully() {
        verifyProductAdditionPageDisplayed();
    }

    @Then("Product addition interface must be accessible")
    public void productAdditionInterfaceMustBeAccessible() {
        verifyProductAdditionInterfaceAccessible();
    }

    @When("User enters 255 'A' characters in the 'Product Name' field")
    public void userEntersMaxCharactersInProductNameField() {
        enterProductName("A".repeat(255));
    }

    @Then("The 'Product Name' field is populated with 255 'A' characters")
    public void productNameFieldIsPopulatedWithMaxCharacters() {
        verifyProductNameFieldPopulated("A".repeat(255));
    }

    @When("User enters '200' in the 'Product Price' field")
    public void userEntersProductPrice() {
        enterProductPrice("200");
    }

    @Then("The 'Product Price' field is populated with '200'")
    public void productPriceFieldIsPopulated() {
        verifyProductPriceFieldPopulated("200");
    }

    @When("User enters 'Sample Description' in the 'Product Description' field")
    public void userEntersProductDescription() {
        enterProductDescription("Sample Description");
    }

    @Then("The 'Product Description' field is populated with 'Sample Description'")
    public void productDescriptionFieldIsPopulated() {
        verifyProductDescriptionFieldPopulated("Sample Description");
    }

    @When("User selects 'Home Appliances' from the 'Product Category' dropdown")
    public void userSelectsProductCategory() {
        selectProductCategory("Home Appliances");
    }

    @Then("The 'Product Category' field is set to 'Home Appliances'")
    public void productCategoryFieldIsSet() {
        verifyProductCategoryFieldSet("Home Appliances");
    }

    @When("User clicks on the 'Save' button to add the product")
    public void userClicksOnSaveButton() {
        clickSaveButton();
    }

    @Then("The product is successfully added to the product list with the name containing 255 'A' characters")
    public void productIsSuccessfullyAdded() {
        verifyProductAddedToList("A".repeat(255));
    }

    @Then("The product appears in the product list with the correct name")
    public void productAppearsInProductList() {
        verifyProductInListWithCorrectName();
    }

    @Then("The product name is stored correctly in the database with 255 'A' characters")
    public void productNameStoredInDatabase() {
        verifyProductNameInDatabase("A".repeat(255));
    }

    @When("User attempts to edit the product name to exceed the maximum allowed characters")
    public void userAttemptsToExceedMaxCharacters() {
        attemptToExceedMaxCharacters();
    }

    @Then("An error message is displayed indicating the maximum character limit is exceeded")
    public void errorMessageDisplayedForMaxCharacters() {
        verifyErrorMessageForMaxCharacters();
    }

    @Then("The user interface displays the full product name without truncation")
    public void uiDisplaysFullProductName() {
        verifyUIDisplaysFullProductName();
    }

    @When("User logs out and logs back in")
    public void userLogsOutAndBackIn() {
        logoutAndLogin();
    }

    @Then("The product name remains intact with 255 'A' characters")
    public void productNameRemainsIntact() {
        verifyProductNameIntact("A".repeat(255));
    }

    @When("User attempts to search for the product using the full name")
    public void userSearchesForProductUsingFullName() {
        searchProductUsingFullName("A".repeat(255));
    }

    @Then("The product is successfully found using the full name in search")
    public void productFoundUsingFullName() {
        verifyProductFoundUsingFullName();
    }

    @Then("The product details page displays the full product name correctly")
    public void productDetailsPageDisplaysFullName() {
        verifyProductDetailsPageDisplaysFullName();
    }

    @Then("The system remains stable and responsive with the maximum character name")
    public void systemRemainsStable() {
        verifySystemStability();
    }

    @Then("The layout and design display the long name without any issues")
    public void layoutAndDesignDisplayLongName() {
        verifyLayoutAndDesign();
    }
}