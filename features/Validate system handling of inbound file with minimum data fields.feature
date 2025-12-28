Feature: Validate system handling of inbound file with minimum data fields  
  Ensure the system handles inbound files with the minimum required data fields correctly.  

  @TC-351  
  Scenario: User logs in to SAP S/4HANA system  
    Given the user has valid SAP S/4HANA credentials  
    When the user logs in to the SAP S/4HANA system  
    Then the user is successfully logged in  

  @TC-351  
  Scenario: User navigates to the Sales Order processing screen  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the Sales Order processing screen  
    Then the Sales Order processing screen is displayed  

  @TC-351  
  Scenario Outline: User uploads pipe-delimited file with minimum required data fields  
    Given the user is on the Sales Order processing screen  
    When the user uploads a pipe-delimited file with "<data_fields>" using the inbound interface  
    Then the system processes the file and identifies the minimum required data fields  

    Examples:  
      | data_fields      |  
      | minimum required |  

  @TC-351  
  Scenario: User attempts to display or process sales orders from the uploaded file  
    Given the user has uploaded a pipe-delimited file with minimum required data fields  
    When the user attempts to display or process sales orders from the uploaded file  
    Then the system processes the file successfully and creates sales orders  

  @TC-351  
  Scenario: User checks the system log for errors or warnings related to the uploaded file  
    Given the user has uploaded a pipe-delimited file with minimum required data fields  
    When the user checks the system log for errors or warnings  
    Then no errors or warnings are logged, and the file is processed successfully  

  @TC-351  
  Scenario: User verifies created sales orders contain minimum required data fields  
    Given the user has processed the uploaded file  
    When the user views the created sales orders  
    Then the sales orders contain the minimum required data fields  

  @TC-351  
  Scenario: System generates notifications for successful file processing  
    Given the user has successfully uploaded and processed a file  
    When the system completes processing  
    Then notifications are sent to relevant stakeholders indicating successful processing  

  @TC-351  
  Scenario: Processed file is archived for audit purposes  
    Given the user has successfully processed a file  
    When the system archives the file  
    Then the processed file is accessible for audit  

  @TC-351  
  Scenario Outline: System prevents processing of files with less than minimum required data fields  
    Given the user is on the Sales Order processing screen  
    When the user uploads a pipe-delimited file with "<data_fields>" using the inbound interface  
    Then the system rejects the file  

    Examples:  
      | data_fields           |  
      | less than minimum     |  

  @TC-351  
  Scenario: Created sales orders are displayed correctly in the Sales Order processing screen  
    Given the user has successfully processed a file  
    When the user views the created sales orders in the Sales Order processing screen  
    Then the sales orders are displayed correctly with the minimum required data fields  

  @TC-351  
  Scenario: System logs all processing details for the uploaded file  
    Given the user has successfully processed a file  
    When the user checks the system logs  
    Then all processing details for the uploaded file are logged and accessible  

  @TC-351  
  Scenario: System handles subsequent uploads with the same minimum data fields consistently  
    Given the user has successfully uploaded and processed a previous file  
    When the user uploads another file with the same minimum data fields  
    Then the system consistently processes the file successfully