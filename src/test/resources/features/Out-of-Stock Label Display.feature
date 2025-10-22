Feature: Out-of-Stock Label Display

  @TC-55
  Scenario Outline: Verify that an out-of-stock label is shown when the product is unavailable
    Given the user navigates to the "<productName>" product detail page
    Then the product detail page is displayed
    And the user checks for the out-of-stock label
    Then the out-of-stock label is displayed prominently

    Examples:
      | productName |
      | Tablet Z    |