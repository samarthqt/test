Feature: Validate system behavior when output condition record for ZPDT is missing during billing creation  
  Ensure the system logs an error and does not proceed with ZPDT determination when the output condition record is missing. Attribute 7 is correctly propagated to KOMKBV3.

  @TC-305
  Scenario: User logs in and accesses the billing module  
    Given the user logs into the SAP S/4HANA system with appropriate credentials  
    Then the user is successfully logged in and has access to the billing module  

  @TC-305
  Scenario: User navigates to the billing creation transaction  
    Given the user navigates to the billing creation transaction VF01  
    Then the billing creation screen is displayed  

  @TC-305
  Scenario Outline: Validate system behavior when output condition record for ZPDT is missing  
    Given the user enters the required details to create a billing document that meets ZPDT determination criteria  
    When the user saves the billing document to trigger the output determination process  
    Then the system logs "<error_message>" indicating the missing output condition record  
    And ZPDT determination does not proceed  
    And no unintended outputs are generated  
    And the system behavior aligns with the configured rules for missing condition records  
    And the billing document does not contain residual or incorrect data  
    And the error message is clear and actionable  

    Examples:  
      | error_message                                |  
      | Missing output condition record for ZPDT    |  

  @TC-305
  Scenario: User documents findings and discusses corrective actions  
    Given the user documents the error logs and verifies the business impact of the missing condition record  
    Then the findings are discussed with relevant stakeholders  
    And corrective actions are planned