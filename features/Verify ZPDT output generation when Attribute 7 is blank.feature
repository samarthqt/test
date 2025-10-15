Feature: Verify ZPDT output generation when Attribute 7 is blank  
  Validate that the ZPDT billing output is generated when Attribute 7 is set to blank in the Payer Business Partner master data.  

  @TC-258  
  Scenario Outline: Validate ZPDT output generation for Payer Business Partner with Attribute 7 set to blank  
    Given the user is logged into the SAP system with appropriate permissions  
    And the user has access to the Payer Business Partner master data  
    When the user navigates to the Payer Business Partner master data screen  
    And the user locates Attribute 7 in the master data fields  
    And the user sets Attribute 7 to "<attribute_7_value>" and saves the changes  
    And the user creates a new billing document for the Payer Business Partner  
    And the user triggers the output determination process for the billing document  
    Then the output log should indicate that the "<billing_document_type>" output is generated as per the configuration  
    And the document flow should show the invoice sent to the customer  
    And the system logs should confirm that the process executed without errors  

    Examples:  
      | attribute_7_value | billing_document_type |  
      | Blank             | ZPDT                 |  
      | Blank             | ZPDT                 |  

  @TC-258  
  Scenario: Validate ZPDT output generation for multiple Payer Business Partners  
    Given the user repeats the process with a different Payer Business Partner having Attribute 7 set to blank  
    When the user completes the steps for output determination  
    Then the ZPDT output should be generated for the second Payer Business Partner as well  

  @TC-258  
  Scenario: Document and review test results  
    Given the user has completed the test execution  
    When the user documents the results and compares them with the expected outcomes  
    Then the results should align with the expected outcomes, confirming successful generation of ZPDT output  
    And the test report should be submitted successfully with all results documented