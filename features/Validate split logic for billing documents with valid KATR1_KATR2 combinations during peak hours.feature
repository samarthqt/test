Feature: Validate split logic for billing documents with valid KATR1/KATR2 combinations during peak hours  
  Ensure the system correctly splits billing documents based on KATR1 and KATR2 combinations during peak operational hours.  

  @TC-213  
  Scenario Outline: User logs into the system during peak operational hours  
    Given the user has valid credentials with authorization for billing-related transactions  
    When the user logs into the SAP S/4HANA system during peak operational hours  
    Then the user should successfully access billing-related transactions  

    Examples:  
      | User Credentials | Expected Outcome |  
      | Valid            | Success          |  
      | Invalid          | Failure          |  

  @TC-213  
  Scenario Outline: Create sales orders with valid KATR1 and KATR2 combinations  
    Given the user has prepared test data with sales orders containing valid KATR1 and KATR2 combinations  
    When the user creates sales orders with the specified attribute combinations  
    Then the sales orders should be created successfully  

    Examples:  
      | KATR1   | KATR2   | Expected Outcome |  
      | Value1  | ValueA  | Success          |  
      | Value2  | ValueB  | Success          |  

  @TC-213  
  Scenario: Initiate the billing process for the created sales orders during peak hours  
    Given the user has created sales orders with valid KATR1 and KATR2 combinations  
    When the user initiates the billing process during peak hours  
    Then billing documents should be generated for all sales orders without errors  

  @TC-213  
  Scenario Outline: Validate the split logic applied to billing documents  
    Given billing documents are generated for sales orders  
    When the user validates the split logic based on KATR1 and KATR2 combinations  
    Then the billing documents should be split correctly  

    Examples:  
      | KATR1   | KATR2   | Expected Split Outcome |  
      | Value1  | ValueA  | Correct Split          |  
      | Value2  | ValueB  | Correct Split          |  

  @TC-213  
  Scenario: Monitor system performance during the peak-hour billing process  
    Given the user is initiating the billing process during peak hours  
    When the user monitors system performance metrics  
    Then the system performance should remain stable without degradation  

  @TC-213  
  Scenario: Validate document flow for split billing documents  
    Given billing documents are split based on KATR1 and KATR2 combinations  
    When the user validates the document flow  
    Then the document flow should accurately reflect the linkage between sales orders and billing documents  

  @TC-213  
  Scenario: Check the accuracy of accounting entries for split billing documents  
    Given billing documents are split based on KATR1 and KATR2 combinations  
    When the user checks the accounting entries  
    Then the accounting entries should be accurate and aligned with the applied split logic  

  @TC-213  
  Scenario: Review audit logs for the peak-hour billing process  
    Given the billing process is completed during peak hours  
    When the user reviews the audit logs  
    Then the audit logs should show no errors or warnings related to the split logic execution  

  @TC-213  
  Scenario: Validate output rendering for split billing documents  
    Given billing documents are split based on KATR1 and KATR2 combinations  
    When the user validates the output rendering  
    Then the output documents should be correctly formatted and reflect the split logic  

  @TC-213  
  Scenario: Test integration with downstream systems for split billing documents  
    Given billing documents are split based on KATR1 and KATR2 combinations  
    When the user tests integration with downstream systems  
    Then the downstream systems should receive and process the split billing documents without issues  

  @TC-213  
  Scenario: Validate user notifications during the peak-hour billing process  
    Given the billing process is running during peak hours  
    When the user validates notifications or alerts  
    Then the user should receive appropriate notifications if any issues occur during the process  

  @TC-213  
  Scenario: Ensure system handles peak-hour operations within limits  
    Given the system is processing data during peak hours  
    When the user monitors memory and processing limits  
    Then the system should process all data within acceptable limits without crashes or errors