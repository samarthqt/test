Feature: Verify system behavior for empty input file upload  
  Ensure the system handles empty file uploads by rejecting them and logging appropriate error messages.  

  @TC-511  
  Scenario: User logs in to the system successfully  
    Given the user has valid credentials  
    When the user logs in to the system  
    Then the user is successfully logged in  

  @TC-511  
  Scenario: User navigates to the file upload section  
    Given the user has access to upload files  
    When the user navigates to the file upload section  
    Then the file upload section is displayed  

  @TC-511  
  Scenario Outline: System rejects empty file uploads and logs errors  
    Given the user has navigated to the file upload section  
    When the user selects the "<file>"  
    And the user uploads the file  
    Then the system rejects the file and displays an error message  
    And the error log contains an entry indicating the empty file upload  
    And no processing occurs for the empty file  

    Examples:  
      | file            |  
      | empty_file.txt  |  
      | another_empty_file.txt |  

  @TC-511  
  Scenario: User logs out of the system  
    Given the user has completed their actions  
    When the user logs out of the system  
    Then the user is successfully logged out