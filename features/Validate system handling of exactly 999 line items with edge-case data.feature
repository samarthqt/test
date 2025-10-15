Feature: Validate system handling of exactly 999 line items with edge-case data

  @TC-545
  Scenario: User navigates to the billing due program in the SAP system
    Given the user is logged into the SAP system
    When the user navigates to the billing due program
    Then the billing due program interface is displayed successfully

  @TC-545
  Scenario: User verifies a billing document with 999 line items is ready for processing
    Given the billing document ID is "BD999EDGE"
    And the billing document contains exactly 999 line items with edge-case data
    Then the billing document is ready for processing

  @TC-545
  Scenario: User selects the source document with exactly 999 line items containing edge-case data
    Given the source document contains 999 line items with edge-case data
    When the user selects the source document
    Then the system selects the source document without errors

  @TC-545
  Scenario: User executes the program to create billing documents
    Given the user has selected the source document with exactly 999 line items
    When the user executes the program to create billing documents
    Then the program executes successfully, initiating the billing document creation process

  @TC-545
  Scenario: User verifies the system creates a single billing document
    Given the program has been executed to create billing documents
    When the system processes the source document
    Then the system creates one billing document containing all 999 line items with edge-case data

  @TC-545
  Scenario: User checks that the resulting billing document is posted to accounting successfully
    Given the billing document has been created
    When the system posts the billing document to accounting
    Then the billing document is posted to accounting without errors

  @TC-545
  Scenario: User navigates to the accounting module and locates the posted billing document
    Given the billing document has been posted to accounting
    When the user navigates to the accounting module
    Then the billing document is visible and accurately recorded in the accounting module

  @TC-545
  Scenario: User verifies the line item details in the billing document
    Given the billing document contains 999 line items
    When the user reviews the line item details in the billing document
    Then all 999 line items are present and accurately recorded, including edge-case data

  @TC-545
  Scenario: User checks the document header details for accuracy
    Given the billing document has been created
    When the user reviews the document header details
    Then the document header contains correct and complete information, including edge-case data

  @TC-545
  Scenario: User validates the document type and numbering sequence
    Given the billing document has been created
    When the user reviews the document type and numbering sequence
    Then the document type and numbering sequence are correct as per the configuration

  @TC-545
  Scenario: User reviews the processing logs for any errors or warnings
    Given the billing document creation process has been completed
    When the user reviews the processing logs
    Then the logs show no errors or warnings related to document splitting or posting

  @TC-545
  Scenario: User verifies the system's performance during the creation process
    Given the billing document creation process has been completed
    When the user observes the system's performance
    Then the system performs optimally without delays or crashes

  @TC-545
  Scenario: User confirms that the document is available for downstream processes
    Given the billing document has been created and posted
    When the user checks the document's availability for downstream processes
    Then the billing document is available for further processing without any issues