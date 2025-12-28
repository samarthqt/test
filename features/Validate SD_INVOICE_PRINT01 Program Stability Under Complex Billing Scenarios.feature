Feature: Validate SD_INVOICE_PRINT01 Program Stability Under Complex Billing Scenarios  
  Ensure the SD_INVOICE_PRINT01 program maintains stability under complex periodic billing scenarios.  

  @TC-137  
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged into the system  

  @TC-137  
  Scenario: User navigates to the periodic billing section  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the periodic billing section  
    Then the periodic billing section is displayed  

  @TC-137  
  Scenario: ZPB1 form template is configured in the system  
    Given the ZPB1 form template is created and assigned to the periodic billing process  
    Then the ZPB1 form template is successfully configured in the system  

  @TC-137  
  Scenario: Test data with complex periodic billing scenarios are prepared  
    Given the system is configured for complex periodic billing scenarios  
    Then test data with complex periodic billing scenarios are successfully prepared  

  @TC-137  
  Scenario Outline: User creates periodic billing documents of type 'ZPB' with complex scenarios  
    Given the system is configured for complex periodic billing scenarios  
    When the user creates multiple periodic billing documents of type "<billingType>" with complex scenarios  
    Then the periodic billing documents are created successfully  

    Examples:  
      | billingType |  
      | ZPB         |  

  @TC-137  
  Scenario: User triggers the output process for billing documents  
    Given periodic billing documents of type 'ZPB' are created  
    When the user triggers the output process for the billing documents  
    Then the output process is triggered without errors  

  @TC-137  
  Scenario: Monitor stability of the SD_INVOICE_PRINT01 program  
    Given the output process for the billing documents is triggered  
    When the user monitors the stability of the SD_INVOICE_PRINT01 program during the output process  
    Then the program remains stable throughout the process  

  @TC-137  
  Scenario: Verify printed outputs for data accuracy  
    Given the output process for the billing documents is triggered  
    When the user verifies the printed outputs for data accuracy  
    Then the printed outputs are accurate and match the billing data  

  @TC-137  
  Scenario: Check printed outputs for formatting issues  
    Given the printed outputs are generated  
    When the user checks the printed outputs for formatting issues  
    Then the printed outputs are correctly formatted without any issues  

  @TC-137  
  Scenario: Inspect system logs for warnings or errors during the output process  
    Given the output process for the billing documents is triggered  
    When the user inspects the system logs for any warnings or errors during the output process  
    Then the system logs do not contain any critical errors or warnings  

  @TC-137  
  Scenario: Validate linkage between billing documents and printed outputs  
    Given the billing documents and printed outputs are generated  
    When the user validates the linkage between the billing documents and the printed outputs  
    Then the linkage is accurate and consistent  

  @TC-137  
  Scenario: Ensure system handles complex scenarios within acceptable time limits  
    Given the system is processing complex scenarios  
    When the user monitors the processing time  
    Then the processing time is within acceptable limits  

  @TC-137  
  Scenario: Confirm no system crashes occurred during the process  
    Given the system is processing complex scenarios  
    When the user monitors the system stability  
    Then the system remains operational without crashes  

  @TC-137  
  Scenario: Validate overall performance of the SD_INVOICE_PRINT01 program  
    Given the SD_INVOICE_PRINT01 program is configured in the system  
    When the user validates the overall performance of the program  
    Then the program performs efficiently and meets all performance criteria