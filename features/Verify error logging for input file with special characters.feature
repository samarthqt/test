Feature: Verify error logging for input file with special characters  
  Ensure the system logs errors correctly when the input file contains special characters.  

  @TC-509  
  Scenario: User logs into the system successfully  
    Given the user has valid credentials  
    When the user logs into the system  
    Then the user is successfully logged in  

  @TC-509  
  Scenario: User navigates to the file upload section  
    Given the user has access to upload files  
    When the user navigates to the file upload section in the application  
    Then the file upload section is displayed  

  @TC-509  
  Scenario Outline: User uploads a file with special characters and verifies error logging  
    Given the user has access to upload files  
    And the system is configured for error logging  
    When the user selects the prepared pipe-delimited input file "<file_content>"  
    And the user uploads the file  
    Then the system starts processing the file  
    And the system detects errors in the file containing special characters  
    When the user navigates to the error log section  
    Then the error log section is displayed  
    And the errors from the uploaded file are logged and displayed in the error log  
    When the user verifies the error messages for clarity and accuracy  
    Then the error messages are clear, accurate, and provide sufficient details for resolution  

    Examples:  
      | file_content                                   |  
      | record1|field1|error1!@#\nrecord2|field2|error2$%^ |  

  @TC-509  
  Scenario: User attempts remediation based on logged errors  
    Given the user has access to the error log section  
    When the user attempts remediation based on the logged errors  
    Then remediation actions are successfully executed  

  @TC-509  
  Scenario: User re-uploads the corrected file  
    Given the user has corrected the errors in the file  
    When the user uploads the corrected file  
    Then the corrected file is uploaded successfully  

  @TC-509  
  Scenario: User verifies no errors are logged for the corrected file  
    Given the corrected file has been uploaded  
    When the user checks the error log  
    Then no errors are logged for the corrected file  

  @TC-509  
  Scenario: User logs out of the system  
    Given the user is logged into the system  
    When the user logs out of the system  
    Then the user is successfully logged out