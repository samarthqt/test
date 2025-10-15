Feature: Verify system behavior when copy control routine fails to clear VBRK-KUNAG and VBRK-REGIO for ZFCB

  @TC-218
  Scenario Outline: Validate the behavior of the system during billing document creation with copy control routine
    Given the user is logged into the SAP S/4HANA system with valid credentials
    And a source sales order "<Source Sales Order>" exists with populated VBRK-KUNAG as "<VBRK-KUNAG>" and VBRK-REGIO as "<VBRK-REGIO>"
    When the user navigates to the billing document creation transaction
    And the user enters the source sales order number "<Source Sales Order>" and target billing document type "<Billing Document Type>"
    And the user executes the copy control routine to generate the billing document
    And the copy control routine has a defect preventing clearing of VBRK-KUNAG and VBRK-REGIO
    Then the values of VBRK-KUNAG and VBRK-REGIO in the generated billing document remain as "<VBRK-KUNAG>" and "<VBRK-REGIO>"
    And the system logs an error indicating that VBRK-KUNAG and VBRK-REGIO were not cleared
    And the billing document creation process is halted and no document is saved
    When the user attempts to save the billing document despite the warning
    Then the system prevents saving the document and displays an error message "<Error Message>"

    Examples:
      | Source Sales Order | Billing Document Type | VBRK-KUNAG   | VBRK-REGIO   | Error Message                 |
      | 67890              | ZFCB                  | Customer002  | Region002    | "Error: Fields not cleared"  |

  @TC-218
  Scenario: Reset and validate the copy control routine functionality
    Given the user has introduced a defect in the copy control routine
    When the user resets the copy control routine to its original configuration
    And the user re-tests the billing document creation process with source sales order "67890" and billing document type "ZFCB"
    Then the billing document is successfully created with cleared VBRK-KUNAG and VBRK-REGIO fields