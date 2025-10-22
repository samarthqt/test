Feature: Customer Reviews and Ratings Display

  @TC-56
  Scenario: User views customer reviews and ratings on a product page
    Given user navigates to the product detail page for "Headphones A"
    When user scrolls to the reviews and ratings section
    Then customer reviews and ratings are displayed correctly