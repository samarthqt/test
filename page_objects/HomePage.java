package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class HomePage extends WebReusableComponents {

    protected By categoriesDropdown = By.id("categoriesDropdown");
    protected By electronicsCategory = By.xpath("//a[text()='Electronics']");
    protected By searchBar = By.id("searchBar");
    protected By searchResults = By.cssSelector(".search-results");
    protected By paginationControls = By.cssSelector(".pagination-controls");
    protected By filteringOptions = By.cssSelector(".filter-options");
    protected By sortingOptions = By.cssSelector(".sort-options");
    protected By productDetails = By.cssSelector(".product-details");
    protected By homeButtonOrLogo = By.id("homeButtonOrLogo");
    protected By invalidQueryMessage = By.id("invalidQueryMessage");
    protected By longInputFeedback = By.id("longInputFeedback");
    protected By scriptPreventionMessage = By.id("scriptPreventionMessage");
    protected By sqlInjectionPreventionMessage = By.id("sqlInjectionPreventionMessage");
    protected By emptyQueryPrompt = By.id("emptyQueryPrompt");
    protected By truncatedInputFeedback = By.id("truncatedInputFeedback");

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication() {
        // Implement login logic
    }

    public void navigateToHomepage() {
        // Implement navigation logic
    }

    public void verifyHomepageNavigationOptions() {
        // Implement verification logic
    }

    public void verifyProductCategoriesDefined() {
        waitUntilElementVisible(categoriesDropdown, 3);
        Assert.assertTrue(isElementDisplayed(categoriesDropdown), "Product categories are not defined.");
    }

    public void clickCategoriesDropdown() {
        waitUntilElementVisible(categoriesDropdown, 3);
        clickElement(categoriesDropdown);
    }

    public void verifyDropdownMenuExpansion() {
        waitUntilElementVisible(electronicsCategory, 3);
        Assert.assertTrue(isElementDisplayed(electronicsCategory), "Dropdown menu did not expand.");
    }

    public void selectElectronicsCategory() {
        waitUntilElementVisible(electronicsCategory, 3);
        clickElement(electronicsCategory);
    }

    public void verifyElectronicsCategoryProducts() {
        waitUntilElementVisible(searchResults, 3);
        Assert.assertTrue(isElementDisplayed(searchResults), "Electronics category products are not displayed.");
    }

    public void enterKeywordInSearchBar(String keyword) {
        waitUntilElementVisible(searchBar, 3);
        enterText(searchBar, keyword);
        pressEnter(searchBar);
    }

    public void verifySearchResults(String keyword) {
        waitUntilElementVisible(searchResults, 3);
        boolean resultsRelevant = getWebElementList(searchResults)
            .stream()
            .allMatch(result -> result.getText().contains(keyword));
        Assert.assertTrue(resultsRelevant, "Search results are not relevant.");
    }

    public void verifyRelevanceOfDisplayedProducts() {
        // Implement verification logic
    }

    public void searchForKeywordWithMultiplePages() {
        // Implement search logic
    }

    public void verifyPaginationControls() {
        waitUntilElementVisible(paginationControls, 3);
        Assert.assertTrue(isElementDisplayed(paginationControls), "Pagination controls are not visible.");
    }

    public void navigateToSearchResultsPage() {
        // Implement navigation logic
    }

    public void verifyFilteringOptionsVisibility() {
        waitUntilElementVisible(filteringOptions, 3);
        Assert.assertTrue(isElementDisplayed(filteringOptions), "Filtering options are not visible.");
    }

    public void applyFilteringOptions() {
        // Implement filtering logic
    }

    public void verifySortingOptionsVisibility() {
        waitUntilElementVisible(sortingOptions, 3);
        Assert.assertTrue(isElementDisplayed(sortingOptions), "Sorting options are not visible.");
    }

    public void applySortingOptions() {
        // Implement sorting logic
    }

    public void verifyProductDetailsDisplay() {
        waitUntilElementVisible(productDetails, 3);
        boolean detailsCorrect = getWebElementList(productDetails)
            .stream()
            .allMatch(detail -> detail.getText().contains("Name") && detail.getText().contains("Price") && detail.getText().contains("Rating"));
        Assert.assertTrue(detailsCorrect, "Product details are not correctly displayed.");
    }

    public void clickOnProduct() {
        WebElement product = getWebElementList(productDetails).get(0);
        product.click();
    }

    public void verifyProductDetailPageRedirection() {
        // Implement verification logic
    }

    public void navigateToAnyPage() {
        // Implement navigation logic
    }

    public void verifySearchBarVisibility() {
        waitUntilElementVisible(searchBar, 3);
        Assert.assertTrue(isElementDisplayed(searchBar), "Search bar is not visible.");
    }

    public void verifySearchBarAccessibility() {
        // Implement verification logic
    }

    public void useHomeButtonOrLogo() {
        waitUntilElementVisible(homeButtonOrLogo, 3);
        clickElement(homeButtonOrLogo);
    }

    public void verifyHomepageNavigation() {
        // Implement verification logic
    }

    public void clickSearchBar() {
        waitUntilElementVisible(searchBar, 3);
        clickElement(searchBar);
    }

    public void enterSearchQuery(String query) {
        waitUntilElementVisible(searchBar, 3);
        enterText(searchBar, query);
    }

    public void verifyInvalidQueryMessage() {
        waitUntilElementVisible(invalidQueryMessage, 3);
        String message = getTextFromElement(invalidQueryMessage);
        Assert.assertEquals(message, "Invalid query.", "Invalid query message not displayed.");
    }

    public void verifyLongInputHandling() {
        waitUntilElementVisible(longInputFeedback, 3);
        String feedback = getTextFromElement(longInputFeedback);
        Assert.assertEquals(feedback, "Input too long.", "Long input feedback not displayed.");
    }

    public void verifyScriptPreventionMessage() {
        waitUntilElementVisible(scriptPreventionMessage, 3);
        String message = getTextFromElement(scriptPreventionMessage);
        Assert.assertEquals(message, "Invalid query.", "Script prevention message not displayed.");
    }

    public void verifySQLInjectionPreventionMessage() {
        waitUntilElementVisible(sqlInjectionPreventionMessage, 3);
        String message = getTextFromElement(sqlInjectionPreventionMessage);
        Assert.assertEquals(message, "Invalid query.", "SQL injection prevention message not displayed.");
    }

    public void verifyEmptyQueryPrompt() {
        waitUntilElementVisible(emptyQueryPrompt, 3);
        String prompt = getTextFromElement(emptyQueryPrompt);
        Assert.assertEquals(prompt, "Please enter a valid query.", "Empty query prompt not displayed.");
    }

    public void verifyTruncatedInputFeedback() {
        waitUntilElementVisible(truncatedInputFeedback, 3);
        String feedback = getTextFromElement(truncatedInputFeedback);
        Assert.assertEquals(feedback, "Input truncated.", "Truncated input feedback not displayed.");
    }
}