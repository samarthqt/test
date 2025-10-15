Feature: Validate creation of cancellation billing document for an invoice with maximum line items  
  Ensure that the system successfully creates a cancellation billing document for an invoice with the maximum allowable line items.  

  @TC-4  
  Scenario Outline: Validate the cancellation process for an invoice with maximum line items  
    Given the user is logged into the SAP system with valid credentials  
    And the user navigates to the VF11 transaction for invoice cancellation  
    And the cancellation document type "<cancellationDocumentType>" is configured in the system  
    When the user enters the original invoice number "<originalInvoiceNumber>" in the cancellation screen  
    And the user selects the cancellation document type as "<cancellationDocumentType>"  
    And the user initiates the cancellation process  
    Then a cancellation billing document is created with document type "<cancellationDocumentType>"  
    And the cancellation document references the original invoice number "<originalInvoiceNumber>"  
    And all line items in the original invoice are reversed accurately  
    And the document flow shows proper linkage between the original invoice and the cancellation document  
    And the system updates the status of the original invoice to "Cancelled"  
    And the financial postings for the cancellation document are accurate  
    And the user logs out of the SAP system successfully  

    Examples:  
      | originalInvoiceNumber | cancellationDocumentType |  
      | INV12345              | S1                       |