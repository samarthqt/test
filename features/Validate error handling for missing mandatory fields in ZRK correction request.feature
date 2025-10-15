Feature: Validate error handling for missing mandatory fields in ZRK correction request  
  Ensure the system prevents submission of ZRK correction requests with missing mandatory fields and displays appropriate error messages.  

  @TC-93  
  Scenario: User logs in to the SAP system  
    Given the user has valid credentials  
    When the user logs in to the SAP system  
    Then the user is successfully logged in  

  @TC-93  
  Scenario: User navigates to the billing correction form  
    Given the user has appropriate permissions to create correction requests  
    When the user navigates to the billing correction form  
    Then the billing correction form is displayed  

  @TC-93  
  Scenario: User selects 'ZRK' as the correction request type  
    Given the user is on the billing correction form  
    When the user selects 'ZRK' as the correction request type  
    Then the 'ZRK' correction request type is selected  

  @TC-93  
  Scenario Outline: Validate system response for missing mandatory fields  
    Given the user is on the billing correction form and the correction request type is 'ZRK'  
    When the user leaves the "<mandatory_field>" field blank  
    And the user fills in other mandatory fields with valid data  
    And the user submits the form  
    Then the system prevents submission  
    And the system displays an error message indicating the "<mandatory_field>" field is missing  

    Examples:  
      | mandatory_field       |  
      | Customer ID           |  
      | Billing Document Number |  

  @TC-93  
  Scenario: Verify error message specifies the missing field  
    Given the user has submitted the form with a missing mandatory field  
    When the system displays an error message  
    Then the error message clearly specifies the missing field  

  @TC-93  
  Scenario: Validate system behavior when navigating away with unsaved changes  
    Given the user has submitted the form with a missing mandatory field  
    When the user attempts to navigate away from the form without correcting the error  
    Then the system prompts the user to save or discard changes  

  @TC-93  
  Scenario: User corrects the missing field and resubmits the form  
    Given the user has submitted the form with a missing mandatory field  
    When the user corrects the missing field  
    And the user resubmits the form  
    Then the system accepts the correction request  
    And the system displays a success message  

  @TC-93  
  Scenario: Verify the correction request is saved in the system  
    Given the user has successfully submitted the correction request  
    When the user verifies the correction request in the system  
    Then the correction request is successfully saved with all mandatory fields populated  

  @TC-93  
  Scenario: User logs out of the SAP system  
    Given the user is logged into the SAP system  
    When the user logs out  
    Then the user is successfully logged out