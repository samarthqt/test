# Modern Web Testing with Enhanced Selenium 4.x Features
# This feature demonstrates the modern WebDriver capabilities

Feature: Modern Web Testing with Enhanced Selenium Features
  As a test automation engineer
  I want to use modern Selenium 4.x features
  So that I can create more robust and maintainable tests

  Background:
    Given the application is ready for testing

  @ModernWeb @Login
  Scenario: Modern Login with Enhanced Features
    When Launch Application using "LoginTest"
    Then verify login page displayed successfully
    When User enters userCredentials in text field
    And User clicks Login button
    Then verify home page displayed successfully

  @ModernWeb @Shopping
  Scenario: Modern Shopping Cart with Relative Locators
    When Launch Application using "SeleniumPracticeTest4"
    And User enters userCredentials in text field
    And User clicks Login button
    Then verify home page displayed successfully
    When User clicks SauceLabBackPack button
    Then User should see SauceLabBackPack Page
    When User clicks AddToCart button
    And User clicks Cart button
    Then User should see SauceLabBackPack Product
    When User clicks Remove button
    Then User should see NoProduct in Cart

  @ModernWeb @Checkout
  Scenario: Modern Checkout Process with Smart Waits
    When Launch Application using "CheckoutTest"
    And User enters userCredentials in text field
    And User clicks Login button
    Then verify home page displayed successfully
    When User clicks AddToCart button
    And User clicks Cart button
    Then User should see SauceLabBackPack Product
    When User clicks CheckOut button
    And User enters Checkout information
    And User clicks Continue button
    And User clicks Finish button
    Then User should see ThankYouOrder Page

  @ModernWeb @Navigation
  Scenario: Modern Navigation with Menu Interactions
    When Launch Application using "NavigationTest"
    And User enters userCredentials in text field
    And User clicks Login button
    Then verify home page displayed successfully
    When User clicks TopMenu button
    And User clicks AllItem button
    And User clicks LogOut button

  @ModernWeb @Products
  Scenario: Modern Product Browsing with Enhanced Locators
    When Launch Application using "ProductTest"
    And User enters userCredentials in text field
    And User clicks Login button
    Then verify home page displayed successfully
    When User clicks SauceLabBikeLight button
    Then User should see SauceLabBikeLight Page

  @ModernWeb @ErrorHandling
  Scenario: Modern Error Handling with Smart Waits
    When Launch Application using "ErrorTest"
    And User enters invalid credentials
    And User clicks Login button
    Then verify error message displayed successfully

  @ModernWeb @Form
  Scenario: Modern Form Interaction with Enhanced Features
    When Launch Application using "FormTest"
    Then enter automation practice form details
    And submit the entered details

  @ModernWeb @Performance
  Scenario: Performance Monitoring and Statistics
    When Launch Application using "PerformanceTest"
    And User enters userCredentials in text field
    And User clicks Login button
    Then verify home page displayed successfully
    And User gets performance statistics

  @ModernWeb @ModernInteractions
  Scenario: Modern Interaction Methods
    When Launch Application using "InteractionTest"
    And User enters userCredentials in text field
    And User clicks Login button
    Then verify home page displayed successfully
    When User scrolls to element "footer"
    And User hovers over element "shopping_cart_link"
    And User double clicks element "login-button"
    And User right clicks element "user-name"

  @ModernWeb @RelativeLocators
  Scenario: Using Relative Locators for Element Finding
    When Launch Application using "RelativeTest"
    And User enters userCredentials in text field
    And User clicks Login button
    Then verify home page displayed successfully
    When User finds element above "user-name" relative to "password"
    And User finds element below "login-button" relative to "password"
    And User finds element near "shopping_cart_link" relative to "login-button"

  @ModernWeb @ShadowDOM
  Scenario: Shadow DOM Interaction (if available)
    When Launch Application using "ShadowTest"
    And User enters userCredentials in text field
    And User clicks Login button
    Then verify home page displayed successfully
    When User interacts with shadow DOM element ".shadow-content" in host "lucom-wci-form"

  @ModernWeb @CustomConditions
  Scenario: Custom Wait Conditions
    When Launch Application using "CustomTest"
    And User enters userCredentials in text field
    And User clicks Login button
    Then User waits for custom condition "page_load"
    And User waits for custom condition "element_enabled"

  @ModernWeb @Functional
  Scenario: Functional Test Script Execution
    Given run functional test script for "LoginTest" from "testdata/functional-tests.json"