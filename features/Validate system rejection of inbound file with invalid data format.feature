Feature: Validate system rejection of inbound file with invalid data format  

  @TC-348  
  Scenario Outline: Validate the system's handling of inbound files with different data formats  
    Given the user is logged into the SAP S/4HANA system using valid credentials  
    And the user navigates to the Sales Order processing screen  
    When the user uploads a file with "<file_format>" data format using the inbound interface  
    Then the system "<expected_result>"  
    And the system logs "<error_message>" if applicable  

    Examples:  
      | file_format         | expected_result                      | error_message                                |  
      | invalid data format | rejects the file                    | invalid data format detected                |  
      | blank file          | rejects the file                    | file is empty                               |  
      | valid data format   | accepts and processes the file      |                                            |  

  @TC-348  
  Scenario: Verify that no sales orders are displayed or processed from an invalid file  
    Given the user uploads a file with an invalid data format using the inbound interface  
    When the user attempts to display or process sales orders from the uploaded file  
    Then no sales orders are displayed or processed  

  @TC-348  
  Scenario: Validate the error message for an invalid file format  
    Given the user uploads a file with an invalid data format using the inbound interface  
    When the system identifies the invalid data format  
    Then the error message provides clear details about the invalid data format and corrective actions  

  @TC-348  
  Scenario: Retry upload with a valid file format  
    Given the user uploads a file with a valid data format using the inbound interface  
    Then the system accepts and processes the file successfully  

  @TC-348  
  Scenario: Verify that the corrected file creates valid sales orders  
    Given the user uploads a file with a valid data format using the inbound interface  
    When the system processes the file  
    Then valid sales orders are created and displayed in the system  

  @TC-348  
  Scenario: Ensure the system prevents future uploads of files with invalid formats  
    Given the user uploads a file with an invalid data format using the inbound interface  
    When the system identifies the invalid data format  
    Then the system consistently rejects files with invalid formats in future uploads  

  @TC-348  
  Scenario: Ensure error log entries are stored for audit purposes  
    Given the user uploads a file with an invalid data format using the inbound interface  
    When the system identifies the invalid data format  
    Then error log entries are stored and accessible for audit  

  @TC-348  
  Scenario: Validate system notifications for errors in uploaded files  
    Given the user uploads a file with an invalid data format using the inbound interface  
    When the system identifies the invalid data format  
    Then notifications are sent to the relevant stakeholders with error details