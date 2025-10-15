Feature: Validate SD_INVOICE_PRINT01 Program Accuracy for Edge Case Scenarios  
  Ensure the SD_INVOICE_PRINT01 program produces accurate outputs for edge case scenarios.

  @TC-138
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the SAP S/4HANA Cloud system is available  
    When the user enters appropriate credentials  
    Then the user is successfully logged into the system  

  @TC-138
  Scenario: User navigates to the periodic billing section  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the periodic billing section  
    Then the periodic billing section is displayed  

  @TC-138
  Scenario Outline: User creates periodic billing documents of type 'ZPB' with edge case scenarios  
    Given the ZPB1 form template is configured in the system and test data with edge case scenarios is prepared  
    When the user creates periodic billing documents of type '<documentType>' with '<scenario>'  
    Then the periodic billing documents are created successfully  

    Examples:  
      | documentType | scenario           |  
      | ZPB          | high volume data   |  
      | ZPB          | special characters |  
      | ZPB          | null values        |  

  @TC-138
  Scenario: User triggers the output process for the billing documents  
    Given the periodic billing documents are created successfully  
    When the user triggers the output process for the billing documents  
    Then the output process is triggered without errors  

  @TC-138
  Scenario: User verifies the printed outputs for data accuracy  
    Given the output process is triggered successfully  
    When the user reviews the printed outputs  
    Then the printed outputs are accurate and match the billing data  

  @TC-138
  Scenario: User checks the printed outputs for formatting issues caused by edge case scenarios  
    Given the printed outputs are generated  
    When the user inspects the printed outputs for formatting issues  
    Then the printed outputs are correctly formatted without any issues  

  @TC-138
  Scenario: User inspects the system logs for warnings or errors during the output process  
    Given the output process is completed  
    When the user inspects the system logs  
    Then the system logs do not contain any critical errors or warnings  

  @TC-138
  Scenario: User validates the linkage between the billing documents and the printed outputs  
    Given the printed outputs are generated  
    When the user validates the linkage between the billing documents and the printed outputs  
    Then the linkage is accurate and consistent  

  @TC-138
  Scenario: User ensures the system handles edge case scenarios within acceptable time limits  
    Given the system is processing edge case scenarios  
    When the user monitors the processing time  
    Then the processing time is within acceptable limits  

  @TC-138
  Scenario: User confirms that no system crashes occurred during the process  
    Given the system is processing edge case scenarios  
    When the user observes the system behavior  
    Then the system remains operational without crashes  

  @TC-138
  Scenario: User validates the overall performance of the SD_INVOICE_PRINT01 program  
    Given the SD_INVOICE_PRINT01 program is configured in the system  
    When the user evaluates the program's performance  
    Then the program performs efficiently and meets all performance criteria  

  @TC-138
  Scenario: User ensures the program handles all edge cases correctly  
    Given the SD_INVOICE_PRINT01 program is processing edge case scenarios  
    When the user validates the program's handling of edge cases  
    Then all edge cases are handled without errors