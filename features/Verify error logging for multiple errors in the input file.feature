Feature: Verify error logging for multiple errors in the input file  
  Ensure the system logs all errors when the input file contains multiple errors.

  @TC-508
  Scenario: User logs into the system  
    Given the user has valid credentials  
    When the user logs into the system  
    Then the user is successfully logged in  

  @TC-508
  Scenario: User navigates to the file upload section  
    Given the user has access to upload files  
    When the user navigates to the file upload section in the application  
    Then the file upload section is displayed  

  @TC-508
  Scenario: User selects a prepared pipe-delimited input file with multiple errors  
    Given the user has prepared a pipe-delimited file with multiple errors  
    When the user selects the prepared file  
    Then the file is selected successfully  

  @TC-508
  Scenario: User uploads the selected file  
    Given the system is configured for error logging  
    When the user uploads the selected file  
    Then the file is uploaded successfully and the system starts processing it  

  @TC-508
  Scenario: System detects errors during file processing  
    Given the system is processing the uploaded file  
    When the user monitors the system for error detection  
    Then the system detects all errors in the file during processing  

  @TC-508
  Scenario: User navigates to the error log section  
    Given the file has been processed  
    When the user navigates to the error log section in the application  
    Then the error log section is displayed  

  @TC-508
  Scenario: User checks the error log for captured errors  
    Given the system has logged errors during file processing  
    When the user checks the error log  
    Then all errors from the uploaded file are logged and displayed in the error log  

  @TC-508
  Scenario: User verifies error messages for clarity and accuracy  
    Given the error log contains logged errors  
    When the user verifies the error messages  
    Then the error messages are clear, accurate, and provide sufficient details for resolution  

  @TC-508
  Scenario: User attempts remediation based on the logged errors  
    Given the user has reviewed the logged errors  
    When the user attempts remediation actions based on the errors  
    Then the remediation actions are successfully executed  

  @TC-508
  Scenario: User re-uploads the corrected file  
    Given the user has corrected the input file  
    When the user re-uploads the corrected file  
    Then the corrected file is uploaded successfully  

  @TC-508
  Scenario: User verifies no errors are logged for the corrected file  
    Given the corrected file has been processed  
    When the user checks the error log  
    Then no errors are logged for the corrected file  

  @TC-508
  Scenario: User logs out of the system  
    Given the user has completed all actions  
    When the user logs out of the system  
    Then the user is successfully logged out