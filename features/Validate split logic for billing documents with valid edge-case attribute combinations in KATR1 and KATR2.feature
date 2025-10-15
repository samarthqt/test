Feature: Validate split logic for billing documents with valid edge-case attribute combinations in KATR1 and KATR2  
  Ensure that billing documents are split correctly based on edge-case combinations of KATR1 and KATR2 attributes.  

  @TC-211  
  Scenario Outline: Validate user login with authorized credentials  
    Given the user has valid credentials with access to billing-related transactions  
    When the user logs into the SAP S/4HANA system  
    Then the user should be successfully logged in  

    Examples:  
      | Username   | Password   | Authorization Status |  
      | validUser1 | validPass1 | Authorized           |  
      | validUser2 | validPass2 | Authorized           |  

  @TC-211  
  Scenario Outline: Create sales orders with edge-case combinations of KATR1 and KATR2  
    Given the user navigates to the sales order creation screen  
    When the user enters edge-case combinations of KATR1 "<KATR1>" and KATR2 "<KATR2>" attributes  
    Then sales orders should be created successfully with the specified attribute combinations  

    Examples:  
      | KATR1      | KATR2      |  
      | EdgeCase1  | EdgeCaseA  |  
      | EdgeCase2  | EdgeCaseB  |  
      | EdgeCase3  | EdgeCaseC  |  

  @TC-211  
  Scenario Outline: Execute the billing process for created sales orders  
    Given the user has created sales orders with edge-case attributes  
    When the user executes the billing process  
    Then billing documents should be generated based on the sales orders  

    Examples:  
      | SalesOrderID | BillingDocumentType |  
      | SO12345      | TypeA               |  
      | SO67890      | TypeB               |  

  @TC-211  
  Scenario Outline: Validate split logic for billing documents  
    Given the billing documents are generated  
    When the user validates the split logic for the billing documents  
    Then the billing documents should be split correctly based on the edge-case attribute combinations  

    Examples:  
      | BillingDocumentID | SplitLogicStatus |  
      | BD12345           | Correct          |  
      | BD67890           | Correct          |  

  @TC-211  
  Scenario: Verify document flow for split billing documents  
    Given the billing documents are split  
    When the user reviews the document flow  
    Then the document flow should accurately reflect the linkage between sales orders and split billing documents  

  @TC-211  
  Scenario: Check system performance metrics during billing process  
    Given the billing process is executed  
    When the user monitors system performance metrics  
    Then the system performance should remain optimal without any delays or errors  

  @TC-211  
  Scenario: Ensure data integrity of billing documents  
    Given the billing documents are generated  
    When the user reviews the data in the billing documents  
    Then all relevant fields should be populated correctly without discrepancies  

  @TC-211  
  Scenario: Validate accounting entries from split billing documents  
    Given the split billing documents are created  
    When the user reviews the accounting entries  
    Then the accounting entries should be accurate and align with the split logic applied  

  @TC-211  
  Scenario: Review audit logs for the billing process  
    Given the billing process has been executed  
    When the user reviews the audit logs  
    Then the audit logs should show no errors or warnings related to the split logic  

  @TC-211  
  Scenario: Verify output rendering for split billing documents  
    Given the split billing documents are generated  
    When the user reviews the output documents  
    Then the output documents should be correctly formatted and reflect the split logic  

  @TC-211  
  Scenario: Test integration with downstream systems for split billing documents  
    Given the split billing documents are created  
    When the user validates the integration with downstream systems  
    Then the downstream systems should receive and process the split billing documents without issues  

  @TC-211  
  Scenario: Validate user notifications during the billing process  
    Given the billing process is executed  
    When the user reviews notifications or alerts generated  
    Then the user should receive appropriate notifications or alerts if any issues occur during the split process