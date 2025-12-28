Feature: Verify cancellation billing document creation for original invoice cancellation  
  Ensure that the system creates a cancellation billing document accurately for an original invoice cancellation. Ensure the original invoice exists in the system with valid pricing, quantities, taxes, and line items.  

  @TC-1  
  Scenario Outline: Validate the cancellation billing document creation process  
    Given the user navigates to the VF11 cancellation screen  
    When the user enters the original invoice number "<Invoice Number>"  
    Then the original invoice details are retrieved and displayed accurately  
    When the user selects the cancellation document type "<Cancellation Document Type>"  
    Then the cancellation document type is selected successfully  
    When the user executes the cancellation process  
    Then the system processes the cancellation and creates a cancellation billing document  
    And the cancellation billing document references the original invoice number correctly  
    And the original billing details (pricing, quantities, taxes, and line items) are reversed accurately  
    And the cancellation document is linked to the original invoice in the document flow  
    And the financial postings reflect the reversal of the original invoice accurately  
    And the cancellation document type matches the configured type "<Configured Cancellation Document Type>"  
    And the tax reversal details are accurate in the cancellation document  
    And the cancellation document is accessible in reporting and audit logs  

    Examples:  
      | Invoice Number | Cancellation Document Type | Configured Cancellation Document Type |  
      | INV12345       | S1                        | S1                                    |