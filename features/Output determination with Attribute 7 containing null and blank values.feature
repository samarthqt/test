Feature: Output determination with Attribute 7 containing null and blank values  
  Ensure that the system handles null and blank values for Attribute 7 during billing output determination without errors.  

  @TC-286  
  Scenario Outline: Validate Attribute 7 handling in payer master data and output determination process  
    Given the user logs into the SAP system with valid credentials  
    And the field catalog for billing output includes Attribute 7  
    When the user navigates to the transaction for maintaining payer master data  
    And the user populates Attribute 7 in the payer master data with "<attribute_value>"  
    And the user saves the changes to the payer master data  
    And the user navigates to the field catalog configuration screen  
    Then the system displays the field catalog configuration screen  
    And Attribute 7 is included in the field catalog  
    When the user creates a new billing document with standard data  
    And the user triggers the output determination process for the billing document  
    Then the output determination process is triggered without errors  
    And the logs show that Attribute 7 with "<attribute_value>" is processed correctly with default behavior applied  
    And the generated output is correct, reflecting default behavior for Attribute 7  
    And no data integrity issues are identified in the output  

    Examples:  
      | attribute_value |  
      | null            |  
      | blank           |  

  @TC-286  
  Scenario: Document test results and close the session  
    Given the user has completed the output determination process testing  
    When the user documents the test results  
    Then the test results are documented successfully  
    And the session is closed successfully