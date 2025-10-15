Feature: Validate daily extraction job for direct sales data transmission  
  Ensure the daily extraction job successfully transmits direct sales data to Model N.  

  @TC-19  
  Scenario: User logs in to SAP S/4HANA Cloud with valid credentials  
    Given the user has valid credentials  
    When the user logs in to SAP S/4HANA Cloud  
    Then the user is successfully logged in  

  @TC-19  
  Scenario: User navigates to the job scheduling interface  
    Given the user is logged into SAP S/4HANA Cloud  
    When the user navigates to the job scheduling interface  
    Then the job scheduling interface is displayed  

  @TC-19  
  Scenario: User verifies the schedule of the daily extraction job  
    Given the job scheduling interface is displayed  
    When the user verifies the schedule of the daily extraction job  
    Then the job schedule is verified and set to run at the correct time  

  @TC-19  
  Scenario: User executes the daily extraction job  
    Given the daily extraction job is scheduled  
    When the user waits for the job to execute or manually triggers it  
    Then the daily extraction job is executed successfully  

  @TC-19  
  Scenario: User monitors the job's execution in system logs  
    Given the daily extraction job is executed  
    When the user monitors the job's execution in the system logs  
    Then the job execution logs show successful completion without errors  

  @TC-19  
  Scenario: User verifies the extracted data includes all required fields  
    Given the daily extraction job is executed successfully  
    When the user verifies the extracted data  
    Then the extracted data includes Product Number, Ship-to, Sold-to, Quantity, Amount, and Invoice Number  

  @TC-19  
  Scenario: User validates the extracted data matches the system data  
    Given the extracted data includes all required fields  
    When the user validates the extracted data against the system data  
    Then the extracted data matches the system data accurately  

  @TC-19  
  Scenario: User confirms the data is successfully transmitted to Model N  
    Given the extracted data matches the system data  
    When the user confirms the data transmission to Model N  
    Then the data is transmitted successfully to Model N  

  @TC-19  
  Scenario: User verifies the received data in Model N  
    Given the data is transmitted to Model N  
    When the user logs in to Model N and verifies the received data  
    Then Model N displays all received data correctly  

  @TC-19  
  Scenario: User checks logs in SAP S/4HANA for transmission errors  
    Given the data is transmitted to Model N  
    When the user checks the logs in SAP S/4HANA for any errors during transmission  
    Then no errors are found in the logs  

  @TC-19  
  Scenario: User validates the integrity of transmitted data in Model N  
    Given Model N displays all received data correctly  
    When the user validates the integrity of the transmitted data in Model N  
    Then the data integrity is maintained, and no discrepancies are found  

  @TC-19  
  Scenario: User ensures Model N processes the transmitted data  
    Given the transmitted data is validated in Model N  
    When the user ensures Model N processes the transmitted data for rebate and administrative fee calculations  
    Then Model N processes the data without errors