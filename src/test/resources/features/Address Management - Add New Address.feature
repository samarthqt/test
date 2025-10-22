Feature: Address Management - Add New Address

  @TC-36
  Scenario Outline: User adds a new shipping address in their profile
    Given the user is logged into their account
    When the user navigates to the 'My Account' section
    Then the user sees their account page displayed
    When the user selects the 'Addresses' section
    Then the user sees the addresses section displayed
    When the user chooses to add a new address
    Then the user sees the add new address form displayed
    When the user enters "<address>" in the address fields
    And the user saves the new address
    Then the new address is saved in the user's account
    And the new address appears in the list of addresses

    Examples:
      | address                           |
      | 456 Elm Street, Anytown, USA, 12345 |