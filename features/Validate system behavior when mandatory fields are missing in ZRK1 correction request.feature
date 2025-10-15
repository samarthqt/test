Feature: Validate system behavior when mandatory fields are missing in ZRK1 correction request  
  Ensure the system rejects ZRK1 correction requests with missing mandatory fields and does not allow submission.  

  @TC-97  
  Scenario: User logs into the SAP system and accesses the billing correction form  
    Given the user has valid credentials and appropriate permissions to create correction requests  
    When the user logs into the SAP system  
    Then the user is successfully logged in  

    When the user navigates to the billing correction form  
    Then the billing correction form is displayed  

  @TC-97  
  Scenario Outline: Validate submission of ZRK1 correction request with missing mandatory fields  
    Given the user has navigated to the billing correction form  
    When the user selects "<correction_request_type>" as the correction request type  
    And the user leaves all mandatory fields blank  
    And the user attempts to submit the form  
    Then the system prevents submission and displays an error message indicating mandatory fields are missing  

    When the user attempts to bypass the error message and submit the form again  
    Then the system continues to block submission and displays the same error message  

    When the user verifies if any correction request is created in the system  
    Then no correction request is created in the system  

    Examples:  
      | correction_request_type |  
      | ZRK1                   |  

  @TC-97  
  Scenario: User discards changes and exits the billing correction form  
    Given the user has attempted to submit the form with missing mandatory fields  
    When the user attempts to navigate away from the form without correcting the errors  
    Then the system prompts the user to save or discard changes  

    When the user chooses to discard the changes and exit the form  
    Then the changes are discarded, and the user is redirected to the previous page  

  @TC-97  
  Scenario: User logs out and verifies no incomplete correction requests exist  
    Given the user has completed their actions in the billing correction form  
    When the user logs out of the SAP system  
    Then the user is successfully logged out  

    When the user logs back into the SAP system  
    Then the user verifies no incomplete correction requests exist  
    And no incomplete correction requests are found in the system