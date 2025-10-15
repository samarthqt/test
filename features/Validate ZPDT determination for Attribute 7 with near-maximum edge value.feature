Feature: Validate ZPDT determination for Attribute 7 with near-maximum edge value  
  Ensure that ZPDT output determination handles near-maximum edge values for Attribute 7 correctly.  

  @TC-313  
  Scenario: User logs into the SAP system successfully  
    Given the user has the necessary SAP system access and authorizations  
    When the user logs into the SAP system with proper credentials  
    Then the user is logged into the SAP system successfully  

  @TC-313  
  Scenario: User navigates to the billing document creation screen  
    Given the user is logged into the SAP system  
    When the user navigates to the transaction code for creating billing documents  
    Then the billing document creation screen is displayed  

  @TC-313  
  Scenario: User creates a billing document with Attribute 7 set to a near-maximum edge value  
    Given the user is on the billing document creation screen  
    When the user creates a billing document and populates Attribute 7 with the value "999998"  
    Then the billing document is created successfully with Attribute 7 set to "999998"  

  @TC-313  
  Scenario: User triggers the output determination process  
    Given the billing document is created with Attribute 7 set to "999998"  
    When the user saves the billing document and triggers the output determination process  
    Then the output determination process is triggered successfully  

  @TC-313  
  Scenario: User verifies ZPDT output determination for Attribute 7  
    Given the output determination process is triggered  
    When the user verifies the ZPDT output for Attribute 7 with value "999998"  
    Then the ZPDT output is determined and applied correctly  

  @TC-313  
  Scenario: User checks for errors or warnings in the logs  
    Given the output determination process is completed  
    When the user checks the logs for any errors or warnings related to output determination  
    Then no errors or warnings are logged, and the output determination is successful  

  @TC-313  
  Scenario: User previews the output for the billing document  
    Given the output determination process is completed  
    When the user navigates to the output preview screen for the billing document  
    Then the output preview screen displays the ZPDT output correctly  

  @TC-313  
  Scenario: User validates output data compliance with business rules  
    Given the ZPDT output is displayed in the output preview screen  
    When the user validates the output data for compliance with business rules  
    Then the output data matches the expected format and complies with business rules  

  @TC-313  
  Scenario: User generates a report for the billing document and associated outputs  
    Given the ZPDT output determination process is completed  
    When the user generates a report for the billing document and associated outputs  
    Then the report is generated successfully, showing ZPDT output determination details  

  @TC-313  
  Scenario: User verifies Attribute 7 value in output determination logs  
    Given the ZPDT output determination process is completed  
    When the user verifies the Attribute 7 value in the output determination logs  
    Then the Attribute 7 value "999998" is correctly logged in the output determination process  

  @TC-313  
  Scenario: User documents test results and observations  
    Given the test steps and validations are completed  
    When the user documents the test results and any observations  
    Then the test results are documented with all steps and validations marked as successful  

  @TC-313  
  Scenario: User validates system performance for near-maximum edge value processing  
    Given the system processes the billing document with Attribute 7 set to "999998"  
    When the user evaluates the system performance during processing  
    Then the system processes the edge value efficiently without any performance degradation