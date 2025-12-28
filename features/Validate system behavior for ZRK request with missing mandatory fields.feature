Feature: Validate system behavior for ZRK request with missing mandatory fields  
Ensure that the system prevents submission of a ZRK request when mandatory fields are missing, and validates the workflow routing for corrected requests.

  @TC-243
  Scenario: User logs in to the SAP system with authorized credentials  
    Given the user has valid credentials authorized to create ZRK requests  
    When the user logs in to the SAP system  
    Then the user is successfully logged in and redirected to the SAP home screen  

  @TC-243
  Scenario: User navigates to the Billing Correction Request creation module  
    Given the user is logged in to the SAP system  
    When the user navigates to the Billing Correction Request creation module  
    Then the Billing Correction Request creation screen is displayed  

  @TC-243
  Scenario: User selects the document type as ZRK  
    Given the user is on the Billing Correction Request creation screen  
    When the user selects the document type as ZRK  
    Then the document type ZRK is selected successfully  

  @TC-243
  Scenario Outline: Validate system rejection for missing mandatory fields in ZRK request  
    Given the user has selected the document type as ZRK  
    When the user leaves mandatory fields such as "<mandatory_field>" empty  
    And the user submits the ZRK request for workflow routing  
    Then the system rejects the ZRK request  
    And the system displays an error message indicating the missing "<mandatory_field>"  
    And no workflow is triggered for the rejected request  
    And the error message details are logged in the system for audit purposes  

    Examples:  
      | mandatory_field      |  
      | customer ID          |  
      | invoice number       |  

  @TC-243
  Scenario: User edits the rejected request and resubmits it with mandatory fields populated  
    Given the user is editing the rejected ZRK request  
    When the user populates all mandatory fields  
    And the user submits the corrected ZRK request for workflow routing  
    Then the corrected ZRK request is submitted successfully  
    And the workflow is triggered  

  @TC-243
  Scenario: Verify workflow routing for the corrected ZRK request  
    Given the corrected ZRK request has been submitted successfully  
    When the workflow is triggered  
    Then the workflow routing is initiated as per the configured rules  

  @TC-243
  Scenario: Review system logs for the corrected ZRK request  
    Given the corrected ZRK request has been submitted successfully  
    When the user reviews the system logs  
    Then the system logs confirm successful submission and routing of the corrected request