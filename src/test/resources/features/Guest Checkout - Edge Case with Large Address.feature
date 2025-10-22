Feature: Guest Checkout - Edge Case with Large Address

  @TC-35
  Scenario Outline: User completes guest checkout with a very long shipping address
    Given the user navigates to the shopping cart page
    When the user selects "Proceed to Checkout" as a guest user
    And the user enters a shipping address "<address>" in the address field
    Then the shipping address is accepted if within character limits
    And the user completes the checkout process
    Then the checkout completes successfully with the long address

    Examples:
      | address                                                                                          |
      | 123 Main Street, Apartment 101, Building 5, Complex Name, Long City Name, State, Country, 12345-6789 |