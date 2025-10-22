Feature: Address Management - Delete Address

  @TC-39
  Scenario: User deletes a shipping address from their profile
    Given the user is logged into their account
    And at least one address is present in the profile
    When the user navigates to the 'My Account' section
    Then the user account page is displayed
    When the user selects the 'Addresses' section
    Then the addresses section is displayed
    When the user selects an address to delete
    Then address options are displayed
    When the user chooses the 'Delete' option for the selected address
    Then a confirmation prompt is displayed
    When the user confirms the deletion
    Then the address is deleted from the user's profile
    And the deleted address is not listed in the user's addresses