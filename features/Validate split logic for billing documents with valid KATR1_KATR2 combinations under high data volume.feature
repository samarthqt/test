Feature: Validate split logic for billing documents with valid KATR1/KATR2 combinations under high data volume  
  Ensure the system can handle high data volumes while correctly splitting billing documents based on KATR1 and KATR2 combinations.  

  @TC-212  
  Scenario: User logs in to the SAP S/4HANA system with authorized credentials  
    Given the user has authorized credentials for high-volume billing  
    When the user logs in to the SAP S/4HANA system  
    Then the user successfully accesses billing-related transactions  

  @TC-212  
  Scenario Outline: Create bulk sales orders with valid KATR1 and KATR2 combinations  
    Given the user has access to create sales orders  
    When the user creates a bulk set of sales orders with "<KATR1>" and "<KATR2>" combinations  
    Then the sales orders are created successfully with the specified attribute combinations  

    Examples:  
      | KATR1   | KATR2   |  
      | Value1  | ValueA  |  
      | Value2  | ValueB  |  
      | Value3  | ValueC  |  

  @TC-212  
  Scenario: Initiate billing process for high-volume sales orders  
    Given high-volume sales orders with valid KATR1 and KATR2 combinations exist  
    When the user initiates the billing process for these sales orders  
    Then billing documents are generated for all sales orders without errors  

  @TC-212  
  Scenario: Validate correct split logic for billing documents  
    Given billing documents are generated for high-volume sales orders  
    When the user validates the split logic based on KATR1 and KATR2 combinations  
    Then the split logic is applied accurately for all generated billing documents  

  @TC-212  
  Scenario: Monitor system performance during high-volume billing  
    Given the high-volume billing process is underway  
    When the user monitors system performance metrics  
    Then the system performance remains stable without degradation  

  @TC-212  
  Scenario: Validate document flow for split billing documents  
    Given billing documents are split based on KATR1 and KATR2 combinations  
    When the user validates the document flow  
    Then the document flow accurately reflects the linkage between sales orders and billing documents  

  @TC-212  
  Scenario: Check accuracy of accounting entries for split billing documents  
    Given the split billing documents are generated  
    When the user checks the accounting entries  
    Then the accounting entries are accurate and align with the applied split logic  

  @TC-212  
  Scenario: Review audit logs for high-volume billing process  
    Given the high-volume billing process is completed  
    When the user reviews the audit logs  
    Then the audit logs show no errors or warnings related to the split logic execution  

  @TC-212  
  Scenario: Validate output rendering for split billing documents  
    Given the split billing documents are generated  
    When the user validates the output rendering  
    Then the output documents are correctly formatted and reflect the split logic  

  @TC-212  
  Scenario: Test integration with downstream systems for split billing documents  
    Given the split billing documents are generated  
    When the user tests integration with downstream systems  
    Then downstream systems receive and process the split billing documents without issues  

  @TC-212  
  Scenario: Validate user notifications during high-volume billing process  
    Given the high-volume billing process is underway  
    When the user validates notifications or alerts  
    Then users receive appropriate notifications if any issues occur during the process  

  @TC-212  
  Scenario: Ensure system handles high data volume within limits  
    Given the system is processing high data volumes  
    When the user monitors memory and processing limits  
    Then the system processes all data within acceptable limits without crashes or errors