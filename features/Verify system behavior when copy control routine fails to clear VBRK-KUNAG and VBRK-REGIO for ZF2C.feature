Feature: Verify system behavior when copy control routine fails to clear VBRK-KUNAG and VBRK-REGIO for ZF2C

  @TC-217
  Scenario Outline: Validate system behavior during billing document creation with copy control routine
    Given the user is logged into the SAP S/4HANA system
    And a source sales order "<Source Sales Order>" exists with populated VBRK-KUNAG "<VBRK-KUNAG>" and VBRK-REGIO "<VBRK-REGIO>"
    When the user navigates to the billing document creation transaction
    And the user enters the source sales order "<Source Sales Order>" and target billing document type "<Billing Document Type>"
    And the user executes the copy control routine to generate the billing document
    And a defect in the copy control routine prevents clearing of VBRK-KUNAG and VBRK-REGIO
    Then the generated billing document retains VBRK-KUNAG "<VBRK-KUNAG>" and VBRK-REGIO "<VBRK-REGIO>"
    And the system logs an error or warning indicating that VBRK-KUNAG and VBRK-REGIO were not cleared
    And the billing document creation process is halted with no document saved
    When the user attempts to save the billing document despite the warning
    Then the system prevents saving the document and displays an error message "<Error Message>"
    When the user documents the observed error message for analysis
    Then the error message is documented successfully
    When the user resets the copy control routine to its original configuration
    And the user re-tests the billing document creation process
    Then the billing document is successfully created with cleared VBRK-KUNAG and VBRK-REGIO fields

    Examples:
      | Source Sales Order | VBRK-KUNAG   | VBRK-REGIO   | Billing Document Type | Error Message                          |
      | 12345              | Customer001 | Region001    | ZF2C                  | "VBRK-KUNAG and VBRK-REGIO not cleared" |