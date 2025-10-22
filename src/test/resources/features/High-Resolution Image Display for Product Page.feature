Feature: High-Resolution Image Display for Product Page

  @TC-57
  Scenario: User views high-resolution image on product detail page
    Given the user navigates to the 'Camera B' product detail page
    Then the product detail page is displayed
    When the user selects the product image to view in high resolution
    Then the high-resolution image is displayed and can be zoomed in