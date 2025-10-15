Feature: Validate system rejection of inbound file with missing delimiters  
  Ensure the system rejects an inbound file with missing delimiters and provides appropriate error handling and notifications.

  @TC-349
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has valid SAP S/4HANA credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged into the system  

  @TC-349
  Scenario: User navigates to the Sales Order processing screen  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the Sales Order processing screen  
    Then the Sales Order processing screen is displayed  

  @TC-349
  Scenario Outline: Validate file upload with missing delimiters  
    Given the user is on the Sales Order processing screen  
    When the user uploads a pipe-delimited file with "<file_status>" delimiters using the inbound interface  
    Then the system "<system_behavior>" the file  
    And the system "<error_handling>"  

    Examples:  
      | file_status         | system_behavior           | error_handling                                  |  
      | missing delimiters  | rejects                   | logs an error indicating missing delimiters     |  
      | correct delimiters  | accepts and processes     | creates valid sales orders in the system       |  

  @TC-349
  Scenario: Verify no sales orders are displayed or processed from an invalid file  
    Given the user has uploaded a file with missing delimiters  
    When the user attempts to display or process sales orders from the uploaded file  
    Then no sales orders are displayed or processed  

  @TC-349
  Scenario: Validate user-friendly and actionable error message  
    Given the user has uploaded a file with missing delimiters  
    When the system logs an error  
    Then the error message provides clear details about the missing delimiters and corrective actions  

  @TC-349
  Scenario: Validate system rejection of future uploads with missing delimiters  
    Given the user has previously uploaded a file with missing delimiters  
    When the user attempts to upload another file with missing delimiters  
    Then the system consistently rejects the file  

  @TC-349
  Scenario: Verify error log entries are stored for audit purposes  
    Given the user has uploaded a file with missing delimiters  
    When the system logs an error  
    Then the error log entries are stored and accessible for audit  

  @TC-349
  Scenario: Validate system notifications for errors in the uploaded file  
    Given the user has uploaded a file with missing delimiters  
    When the system logs an error  
    Then notifications are sent to the relevant stakeholders with error details