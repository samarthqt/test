Feature: Validate error message for invalid credit card information during payment process

  @TC-42
  Scenario Outline: User enters invalid credit card details and receives an error message
    Given the user navigates to the shopping cart page
    And the shopping cart page is displayed with the selected product
    When the user proceeds to checkout
    And the checkout page is displayed
    And the user selects "Credit Card" as the payment method
    And the credit card payment form is displayed
    And the user enters invalid credit card details with number "<CreditCardNumber>", expiration date "<ExpirationDate>", and CVV "<CVV>"
    And the user tries to complete the payment process
    Then an error message is displayed indicating invalid credit card information

    Examples:
      | CreditCardNumber    | ExpirationDate | CVV |
      | 1234567890123456    | 12/25          | 123 |