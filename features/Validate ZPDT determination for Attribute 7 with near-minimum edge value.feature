Feature: Validate ZPDT determination for Attribute 7 with near-minimum edge value  
  Ensure that ZPDT output determination handles near-minimum edge values for Attribute 7 correctly.  

  @TC-312  
  Scenario: User logs into the SAP system with proper credentials  
    Given the user has access to the SAP system with necessary authorizations  
    When the user logs into the SAP system  
    Then the user is logged into the SAP system successfully  

  @TC-312  
  Scenario: User navigates to the billing document creation screen  
    Given the user is logged into the SAP system  
    When the user navigates to the transaction code for creating billing documents  
    Then the billing document creation screen is displayed  

  @TC-312  
  Scenario: User creates a billing document with Attribute 7 set to near-minimum edge value  
    Given the billing document creation screen is displayed  
    When the user creates a billing document and populates Attribute 7 with the near-minimum edge value of 1  
    Then the billing document is created successfully with Attribute 7 set to 1  

  @TC-312  
  Scenario: User triggers the output determination process for the billing document  
    Given the billing document is created successfully with Attribute 7 set to 1  
    When the user saves the billing document and triggers the output determination process  
    Then the output determination process is triggered successfully  

  @TC-312  
  Scenario: Verify ZPDT output determination for Attribute 7 with edge value  
    Given the output determination process is triggered successfully  
    When the user verifies the ZPDT output determination for Attribute 7 with value 1  
    Then the ZPDT output is determined and applied correctly  

  @TC-312  
  Scenario: Verify logs for output determination process  
    Given the output determination process is triggered successfully  
    When the user checks the logs for any errors or warnings related to output determination  
    Then no errors or warnings are logged, and the output determination is successful  

  @TC-312  
  Scenario: User navigates to the output preview screen  
    Given the output determination process is triggered successfully  
    When the user navigates to the output preview screen for the billing document  
    Then the output preview screen displays the ZPDT output correctly  

  @TC-312  
  Scenario: Validate output data compliance with business rules  
    Given the output preview screen displays the ZPDT output correctly  
    When the user validates the output data  
    Then the output data matches the expected format and complies with business rules  

  @TC-312  
  Scenario: Generate a report for the billing document and outputs  
    Given the output determination process is triggered successfully  
    When the user generates a report of the billing document and associated outputs  
    Then the report is generated successfully, showing ZPDT output determination details  

  @TC-312  
  Scenario: Verify Attribute 7 value in output determination logs  
    Given the output determination process is triggered successfully  
    When the user verifies that Attribute 7 value is reflected correctly in the output determination logs  
    Then Attribute 7 value (1) is correctly logged in the output determination process  

  @TC-312  
  Scenario: Document the test results  
    Given all validations for the billing document are completed  
    When the user documents the test results and any observations  
    Then the test results are documented with all steps and validations marked as successful  

  @TC-312  
  Scenario: Validate system performance when processing the edge value  
    Given the output determination process is triggered successfully  
    When the user validates system performance while processing the edge value  
    Then the system processes the edge value efficiently without any performance degradation