Feature: Validate updates to the cross-reference table ZOTC_CROSSREFTAB for new document types

  @TC-524
  Scenario: User accesses the cross-reference table ZOTC_CROSSREFTAB
    Given the user has access to the SAP system
    When the user navigates to the cross-reference table ZOTC_CROSSREFTAB
    Then the cross-reference table is accessible without errors

  @TC-524
  Scenario: User reviews existing mappings in the cross-reference table
    Given the user is viewing the cross-reference table ZOTC_CROSSREFTAB
    When the user reviews the existing mappings in the table
    Then the existing mappings are displayed correctly

  @TC-524
  Scenario Outline: User adds mappings for new document types
    Given the user is viewing the cross-reference table ZOTC_CROSSREFTAB
    When the user adds a mapping for the new document type "<DocumentType>"
    Then the mapping for the document type "<DocumentType>" is added successfully

    Examples:
      | DocumentType |
      | ZF2          |
      | S1           |
      | ZG2C         |
      | ZL2C         |

  @TC-524
  Scenario: User saves changes to the cross-reference table
    Given the user has added new mappings to the cross-reference table
    When the user saves the changes
    Then the changes are saved successfully without errors

  @TC-524
  Scenario Outline: User validates new mappings using sample data for billing flows
    Given the user has added new mappings to the cross-reference table
    When the user validates the new mappings using sample data for "<BillingFlowType>"
    Then the new mappings for "<BillingFlowType>" are validated successfully

    Examples:
      | BillingFlowType   |
      | direct billing    |
      | indirect billing  |

  @TC-524
  Scenario: User triggers a test data transmission to Model N
    Given the user has validated the new mappings
    When the user triggers a test data transmission to Model N
    Then the test data transmission is successful
    And the mappings are verified

  @TC-524
  Scenario: User monitors system logs for errors during data transmission
    Given the user has triggered a test data transmission to Model N
    When the user monitors the system logs
    Then no errors are found in the logs during the transmission

  @TC-524
  Scenario: User verifies that updated mappings do not impact existing configurations
    Given the user has updated the mappings in the cross-reference table
    When the user verifies the impact on existing configurations
    Then the existing configurations remain unaffected by the updates

  @TC-524
  Scenario: User ensures the table is updated with accurate and complete information
    Given the user has updated the cross-reference table ZOTC_CROSSREFTAB
    When the user reviews the updated table
    Then the table is updated with accurate and complete information without omissions

  @TC-524
  Scenario: User validates mappings against business rules and requirements
    Given the user has updated the mappings in the cross-reference table
    When the user validates the mappings against business rules and requirements
    Then the mappings comply with business rules and requirements

  @TC-524
  Scenario: User documents changes and validations for audit purposes
    Given the user has completed all validations for the updated mappings
    When the user documents the changes and validations performed
    Then the changes and validations are documented successfully for audit purposes