Feature: Test edge case with empty field mappings in condition table 911  
  Ensure the system handles empty field mappings in condition table 911 gracefully, allowing proper error handling and successful completion of the process after corrections.

  @TC-297
  Scenario: Verify access sequence maintenance screen is displayed  
    Given the user navigates to transaction V/07 for maintaining access sequences  
    Then the access sequence maintenance screen should be displayed  

  @TC-297
  Scenario: Verify access sequence Z002 is displayed for editing  
    Given the user searches for and selects access sequence Z002  
    Then the access sequence Z002 should be displayed for editing  

  @TC-297
  Scenario: Verify condition table 911 is added to the access sequence  
    Given the user adds condition table 911 to the access sequence  
    Then condition table 911 should be added to the access sequence  

  @TC-297
  Scenario Outline: Validate saving access sequence with and without field mappings  
    Given the user attempts to save the access sequence with field mappings set to "<field_mappings>"  
    Then the system should display "<expected_result>"  

    Examples:  
      | field_mappings | expected_result                                      |  
      | empty          | Error message indicating that field mappings are missing |  
      | populated      | Access sequence is saved successfully                |  

  @TC-297
  Scenario: Verify output determination after populating field mappings  
    Given the user populates the field mappings and saves the access sequence  
    When the user activates the access sequence  
    Then output determination should work correctly  

  @TC-297
  Scenario: Verify documentation of system behavior and error handling  
    Given the user observes the system behavior and error handling  
    Then the user should document the system behavior and error handling successfully