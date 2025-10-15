Feature: Validate data consistency in VBRP table for ZG2C billing documents  
  Ensure that the VBRP table reflects correct sign conventions and consistent data for ZG2C billing documents.

  @TC-518
  Scenario: User logs into the SAP S/4HANA system
    Given the user has access to billing document data
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-518
  Scenario: User navigates to the VBRP table
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the VBRP table using transaction code SE16N
    Then the VBRP table is displayed

  @TC-518
  Scenario Outline: User searches for a ZG2C billing document in the VBRP table
    Given the user is on the VBRP table
    When the user searches for the billing document "<billing_document>"
    Then the billing document "<billing_document>" is found in the VBRP table

    Examples:
      | billing_document |
      | 1122334455       |

  @TC-518
  Scenario Outline: Verify PSTYV field values for item categories
    Given the user has located the billing document "<billing_document>" in the VBRP table
    When the user verifies the PSTYV field for item category "<item_category>"
    Then the PSTYV field for "<item_category>" items shows "<expected_value>"

    Examples:
      | billing_document | item_category | expected_value |
      | 1122334455       | L2N           | positive       |
      | 1122334455       | G2N           | negative       |

  @TC-518
  Scenario: Verify linkage between billing document and original document
    Given the user has located the billing document 1122334455 in the VBRP table
    When the user checks the linkage between the billing document and the original document
    Then the linkage is accurate and consistent

  @TC-518
  Scenario: Validate financial impact of billing document data
    Given the user has located the billing document 1122334455 in the VBRP table
    When the user validates the financial impact of the billing document data
    Then the financial data is accurate and consistent with the billing document details

  @TC-518
  Scenario: Generate a report for data consistency in the VBRP table
    Given the user has located the billing document 1122334455 in the VBRP table
    When the user generates a report to verify the consistency of data
    Then the report shows consistent data with no discrepancies

  @TC-518
  Scenario: Export VBRP table data for the billing document
    Given the user has located the billing document 1122334455 in the VBRP table
    When the user exports the VBRP table data for the billing document to a file
    Then the data is successfully exported

  @TC-518
  Scenario: Share exported file with the audit team
    Given the user has successfully exported the VBRP table data for the billing document
    When the user shares the exported file with the audit team for review
    Then the audit team confirms the accuracy of the data

  @TC-518
  Scenario: User logs out of the SAP S/4HANA system
    Given the user has completed the required actions
    When the user logs out of the SAP S/4HANA system
    Then the user is logged out successfully

  @TC-518
  Scenario: Document test results and observations
    Given the user has completed the validation and verification tasks
    When the user documents the test results and observations
    Then the test results and observations are documented successfully