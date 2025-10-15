Feature: Verify error logging for manual uploads with a valid error file  
  Ensure the system correctly logs errors when a valid pipe-delimited input file with errors is manually uploaded.  

  @TC-507  
  Scenario: User logs into the system successfully  
    Given user has valid credentials  
    When user logs into the system  
    Then user is successfully logged in  

  @TC-507  
  Scenario: User navigates to the file upload section  
    Given user is logged into the system  
    When user navigates to the file upload section in the application  
    Then the file upload section is displayed  

  @TC-507  
  Scenario Outline: User uploads a pipe-delimited file with errors  
    Given user has access to upload files  
      And a valid pipe-delimited file with errors "<fileContent>" is prepared  
    When user selects the prepared file  
      And user chooses to upload the file  
    Then the file is uploaded successfully  
      And the system starts processing the file  

    Examples:  
      | fileContent                          |  
      | record1|field1|error1\nrecord2|field2|error2 |  

  @TC-507  
  Scenario: System detects errors during file processing  
    Given the system is processing the uploaded file  
    When the system checks for errors in the file  
    Then the system detects errors in the file  

  @TC-507  
  Scenario: User navigates to the error log section  
    Given user is logged into the system  
    When user navigates to the error log section in the application  
    Then the error log section is displayed  

  @TC-507  
  Scenario: User checks the error log for captured errors  
    Given the error log section is displayed  
    When user views the error log for the uploaded file  
    Then errors from the uploaded file are logged and displayed  

  @TC-507  
  Scenario: User verifies the clarity and accuracy of error messages  
    Given errors are displayed in the error log  
    When user reviews the error messages  
    Then the error messages are clear, accurate, and provide sufficient details for resolution  

  @TC-507  
  Scenario: User attempts remediation based on logged errors  
    Given errors are logged in the system  
    When user performs remediation actions based on the logged errors  
    Then remediation actions are successfully executed  

  @TC-507  
  Scenario: User re-uploads the corrected file  
    Given user has corrected the errors in the file  
    When user uploads the corrected file  
    Then the corrected file is uploaded successfully  

  @TC-507  
  Scenario: System verifies no errors are logged for the corrected file  
    Given the corrected file is uploaded successfully  
    When the system checks for errors in the corrected file  
    Then no errors are logged for the corrected file  

  @TC-507  
  Scenario: User logs out of the system  
    Given user is logged into the system  
    When user logs out of the system  
    Then user is successfully logged out