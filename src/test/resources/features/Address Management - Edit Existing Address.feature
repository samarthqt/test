Feature: Address Management - Edit Existing Address
  Ensure users can edit an existing shipping address in their profile.

  @TC-37
  Scenario: User edits an existing address in their profile
    Given the user is logged into their account
    When the user navigates to the 'My Account' section
    Then the user account page is displayed
    And an existing address is present in the profile
    When the user selects the 'Addresses' section
    Then the addresses section is displayed
    When the user chooses an existing address to edit
    Then the edit address form is displayed
    When the user modifies the address to "789 Oak Avenue, Anytown, USA, 12345"
    And the user saves the changes
    Then the edited address is saved in the user's account
    And the edited address appears correctly in the list of addresses