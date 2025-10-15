Feature: Validate system error handling for Invoice List generation with missing Output Type ZPIL

  @TC-203
  Scenario Outline: User attempts to generate an Invoice List when Output Type ZPIL is not configured
    Given the user logs into the SAP S/4HANA system with valid credentials
    And the user has access to the VF23 transaction
    And at least one invoice list document exists in the system
    When the user navigates to the VF23 transaction
    And the user inputs the invoice list document number "<invoice_list_document_number>"
    And Output Type ZPIL is not configured
    And the user executes the transaction to trigger the Invoice List output
    Then the system displays an error message "<error_message>"
    And no output is generated for the Invoice List
    And the process is halted
    And the user documents the error message details for analysis
    And the user logs out of the SAP S/4HANA system

    Examples:
      | invoice_list_document_number | error_message                            |
      | INVLIST001                   | Output Type ZPIL is not configured       |
      | INVLIST002                   | Output Type ZPIL is not assigned         |
      | INVLIST003                   | Missing configuration for Output Type ZPIL |