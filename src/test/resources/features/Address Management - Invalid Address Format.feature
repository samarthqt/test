Feature: Address Management - Invalid Address Format

  @TC-38
  Scenario Outline: Validate that the system prevents saving addresses with invalid formats
    Given the user is logged into their account
    When the user navigates to the 'My Account' section
    Then the user account page is displayed
    When the user selects the 'Addresses' section
    Then the addresses section is displayed
    When the user chooses to add a new address
    Then the add new address form is displayed
    When the user enters "<address>" in the address fields
    And the user tries to save the invalid address
    Then an error message is displayed indicating invalid address format

    Examples:
      | address |
      | 123     |