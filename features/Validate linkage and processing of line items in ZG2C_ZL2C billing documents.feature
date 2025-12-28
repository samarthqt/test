Feature: Validate linkage and processing of line items in ZG2C/ZL2C billing documents  
  Ensure all line items in ZG2C/ZL2C billing documents are correctly processed and linked to the original document.

  @TC-49
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged in and has access to the Finance module  

  @TC-49
  Scenario Outline: Validate creation and processing of billing correction requests and ZG2C billing documents  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the transaction for creating billing correction requests  
    Then the billing correction request creation screen is displayed  

    When the user enters the billing correction request type as "<correction_request_type>"  
    Then the system accepts the billing correction request type  

    When the user links the billing correction request to an existing billing document with "<line_items>" line items  
    Then the system successfully links the correction request to the original billing document  

    When the user saves the billing correction request  
    Then the billing correction request is saved successfully  

    When the user generates the corresponding "<billing_document_type>" billing document  
    Then the "<billing_document_type>" billing document is generated successfully  

    When the user verifies that all line items in the "<billing_document_type>" document are correctly processed and linked to the original document  
    Then all line items are accurately linked to the original document  

    When the user validates the document flow to ensure proper linkage between the correction request and the original document  
    Then the document flow shows correct linkage between all related documents  

    When the user checks for any errors or warnings in the system log  
    Then no errors or warnings are logged during the process  

    When the user verifies the financial postings for the "<billing_document_type>" document  
    Then the financial postings are accurate and reflect the corrections made  

    When the user inspects the billing document for any discrepancies in line item processing  
    Then no discrepancies are found in the line item processing  

    When the user ensures the system generates a success message upon document creation  
    Then the system displays a success message indicating the billing document was created successfully  

    Examples:  
      | correction_request_type | line_items | billing_document_type |  
      | ZRK                    | 999        | ZG2C                 |  
      | ZRK                    | 999        | ZL2C                 |