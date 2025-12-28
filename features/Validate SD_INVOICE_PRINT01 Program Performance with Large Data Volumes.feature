Feature: Validate SD_INVOICE_PRINT01 Program Performance with Large Data Volumes  
  Ensure the SD_INVOICE_PRINT01 program handles large data volumes and complex periodic billing scenarios efficiently.  

  @TC-136  
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged into the system  

  @TC-136  
  Scenario: User navigates to the periodic billing section  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the periodic billing section  
    Then the periodic billing section is displayed  

  @TC-136  
  Scenario Outline: User creates periodic billing documents of type 'ZPB'  
    Given the ZPB1 form template is configured in the system  
      And test data with large volumes and complex scenarios is prepared  
    When the user creates multiple periodic billing documents of type '<BillingType>' with large data volumes and complex scenarios  
    Then the periodic billing documents are created successfully  

    Examples:  
      | BillingType |  
      | ZPB         |  

  @TC-136  
  Scenario: User triggers the output process for billing documents  
    Given periodic billing documents of type 'ZPB' with large data volumes are created  
    When the user triggers the output process for the billing documents  
    Then the output process is triggered without errors  

  @TC-136  
  Scenario: Monitor the performance of SD_INVOICE_PRINT01 program  
    Given the output process is triggered for billing documents  
    When the user monitors the performance of the SD_INVOICE_PRINT01 program during the output process  
    Then the program performs efficiently without any degradation  

  @TC-136  
  Scenario: Verify stability of SD_INVOICE_PRINT01 program  
    Given the output process is ongoing  
    When the user verifies the stability of the SD_INVOICE_PRINT01 program during the output process  
    Then the program remains stable throughout the process  

  @TC-136  
  Scenario: Check printed outputs for formatting issues  
    Given the output process is completed  
    When the user checks the printed outputs for formatting issues caused by edge case scenarios  
    Then the printed outputs are correctly formatted without errors  

  @TC-136  
  Scenario: Validate the accuracy of printed outputs  
    Given the printed outputs are generated  
    When the user validates the accuracy of the printed outputs  
    Then the printed outputs are accurate and match the data in the billing documents  

  @TC-136  
  Scenario: Inspect system logs for errors or warnings  
    Given the output process is completed  
    When the user inspects the system logs for any errors or warnings during the output process  
    Then the system logs do not contain any critical errors or warnings  

  @TC-136  
  Scenario: Verify linkage between billing documents and printed outputs  
    Given the printed outputs are generated  
    When the user verifies the linkage between the billing documents and the printed outputs  
    Then the linkage is accurate and consistent  

  @TC-136  
  Scenario: Ensure program handles large data volumes within acceptable time limits  
    Given the SD_INVOICE_PRINT01 program is processing large data volumes  
    When the user monitors the program's processing time  
    Then the processing time is within acceptable limits  

  @TC-136  
  Scenario: Confirm no system crashes or freezes occurred  
    Given the SD_INVOICE_PRINT01 program is handling large data volumes  
    When the user monitors the system's stability  
    Then the system remains operational without crashes or freezes