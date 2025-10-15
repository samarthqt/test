Feature: Validate data population in condition table 911 using bulk upload

  @TC-492
  Scenario: User prepares the bulk upload file with test data
    Given the user has access to the bulk upload program
    When the user prepares the bulk upload file with records for Sales Org, Billing Type, and Attribute 7
    Then the bulk upload file is prepared successfully

  @TC-492
  Scenario: User logs into the SAP system
    Given the user has valid credentials for the SAP system
    When the user logs into the SAP system
    Then the user is successfully logged into the SAP system

  @TC-492
  Scenario: User navigates to the bulk upload program transaction code
    Given the user is logged into the SAP system
    When the user navigates to the bulk upload program transaction code
    Then the bulk upload program screen is displayed

  @TC-492
  Scenario: User selects condition table 911 for data population
    Given the user is on the bulk upload program screen
    When the user selects condition table 911 for data population
    Then condition table 911 is selected successfully

  @TC-492
  Scenario: User uploads the prepared bulk file
    Given the user has selected condition table 911
    When the user uploads the prepared bulk file
    Then the bulk file is uploaded successfully

  @TC-492
  Scenario: User validates the file contents before processing
    Given the user has uploaded the bulk file
    When the user validates the file contents
    Then the file contents are validated, and no errors are found

  @TC-492
  Scenario: User initiates the bulk upload process
    Given the file contents are validated successfully
    When the user initiates the bulk upload process
    Then the bulk upload process starts successfully

  @TC-492
  Scenario: User monitors the upload progress in the program log
    Given the bulk upload process has started
    When the user monitors the upload progress in the program log
    Then the upload progress is displayed in the program log

  @TC-492
  Scenario: User verifies that all records are successfully uploaded to the table
    Given the upload progress is displayed in the program log
    When the user verifies the upload status
    Then all records are uploaded without errors

  @TC-492
  Scenario: User navigates to transaction code SM30 to review the uploaded data
    Given all records are uploaded successfully
    When the user navigates to transaction code SM30
    Then the uploaded data is visible in the table

  @TC-492
  Scenario: User validates that the data matches the input file
    Given the uploaded data is visible in the table
    When the user compares the uploaded data with the input file
    Then the data in the table matches the input file

  @TC-492
  Scenario: User tests the output determination logic
    Given the data in the table matches the input file
    When the user tests the output determination logic
    Then the output determination logic successfully uses the populated data