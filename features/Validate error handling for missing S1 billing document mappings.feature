Feature: Validate error handling for missing S1 billing document mappings

  @TC-383
  Scenario Outline: Validate system behavior when S1 billing document type mappings are missing
    Given the user is logged into the SAP system with valid credentials
    And S1 billing document type mappings are removed from the ZOTC_CROSSREFTAB table
    When the user navigates to the "<sales_program>" program interface
    And the user attempts to process a "<transaction_type>" with the S1 billing document type
    Then the system displays an error message indicating missing mappings for S1 billing document type
    And no billing documents or transactions are created in the system

    Examples:
      | sales_program             | transaction_type            |
      | Direct Sales processing   | sales order creation        |
      | Indirect Sales processing | indirect sales transaction  |

  @TC-383
  Scenario: Verify successful login to the SAP system
    Given the user logs into the SAP system with valid credentials
    Then the user is logged into the SAP system successfully

  @TC-383
  Scenario: Verify successful logout from the SAP system
    Given the user is logged into the SAP system
    When the user logs out of the SAP system
    Then the user is logged out of the SAP system successfully