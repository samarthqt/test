Feature: Validate invoice cancellation with maximum line items

  @TC-3
  Scenario Outline: Validate invoice cancellation process with maximum line items
    Given the user navigates to the VF11 cancellation screen
    When the user enters the invoice number "<Invoice_Number>" in the cancellation screen
    And the user selects the cancellation document type "<Cancellation_Document_Type>"
    And the user executes the cancellation process
    Then the system processes the cancellation and creates a cancellation billing document
    And the cancellation document references the original invoice number "<Invoice_Number>"
    And the original billing details are reversed accurately
    And the cancellation document is linked to the original invoice in the document flow
    And the financial postings reflect the reversal of the original invoice
    And the system processes maximum line items efficiently without delays or errors
    And the tax details are reversed accurately for all line items
    And the cancellation document is accessible in reporting and audit logs

    Examples:
      | Invoice_Number | Cancellation_Document_Type |
      | INV45678       | S1                         |