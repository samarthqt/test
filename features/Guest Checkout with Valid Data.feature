Feature: Guest Checkout with Valid Data

  @TC-4
  Scenario: Verify guest users can complete the checkout process without account creation
    Given the user accesses the checkout page
    When the user navigates to the checkout page
    Then the checkout page is displayed

  @TC-4
  Scenario: Select guest checkout option
    Given items are in the cart
    When the user selects 'Checkout as Guest' option
    Then the guest checkout form is displayed

  @TC-4
  Scenario: Enter shipping address details
    Given the guest checkout form is displayed
    When the user enters shipping address details as "123 Main St, Anytown, USA"
    Then the shipping address is accepted and validated

  @TC-4
  Scenario: Select shipping method
    Given the shipping address is validated
    When the user selects a shipping method
    Then the shipping method is selected

  @TC-4
  Scenario: Enter payment details
    Given a shipping method is selected
    When the user enters payment details using a valid credit card
    Then the payment details are accepted and validated

  @TC-4
  Scenario: Review order summary
    Given the payment details are validated
    When the user reviews the order summary
    Then the order summary displays correct items and total

  @TC-4
  Scenario: Place the order
    Given the order summary is correct
    When the user clicks 'Place Order' button
    Then the order is placed successfully and a confirmation message is displayed

  @TC-4
  Scenario: Receive order confirmation email
    Given the order is placed successfully
    When the user checks their email
    Then the order confirmation email is received