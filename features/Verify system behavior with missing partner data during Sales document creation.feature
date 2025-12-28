Feature: Verify system behavior with missing partner data during Sales document creation

  @TC-195
  Scenario: User logs into the SAP system
    Given user navigates to the SAP system login page
    When user enters valid credentials
    Then user is successfully logged in and navigates to the main dashboard

  @TC-195
  Scenario Outline: Verify the system handles missing partner data during Sales document creation
    Given user configures the FV45C003 routine in the SAP system
    When user navigates to the transaction code for creating Sales documents "<transaction_code>"
    And user inputs the Billing document ID "<billing_document_id>" in the reference field
    And user selects the Sales document type "<sales_document_type>" for creation
    And user executes the FV45C003 routine for copying partner data
    Then the routine processes the Billing document and identifies missing partner data "<missing_partner_data>"
    And the system copies unique partner data from reference items to the header
    And user saves the Sales document and finalizes creation
    Then the Sales document is saved successfully with all required data

    Examples:
      | transaction_code | billing_document_id | sales_document_type | missing_partner_data |
      | VA01             | ZL2                 | ZCR                 | Bill-to and Ship-to  |

  @TC-195
  Scenario Outline: Verify document flow and data consistency
    Given user navigates to the document flow
    Then the document flow shows correct linkage between the Billing document "<billing_document_id>" and the newly created Sales document
    When user checks the header-level partner data for completeness
    Then the header-level partner data is complete and matches the copied reference data
    And user validates the item-level data consistency with the Billing document
    Then the item-level data is consistent with the original Billing document

    Examples:
      | billing_document_id |
      | ZL2                 |

  @TC-195
  Scenario Outline: Generate and verify the Sales document report
    When user generates a report of the created Sales document
    Then the generated report accurately reflects the Sales document details

    Examples:
      | billing_document_id |
      | ZL2                 |

  @TC-195
  Scenario: User logs out of the SAP system
    Given user is on the SAP system main dashboard
    When user logs out of the system
    Then user is logged out successfully