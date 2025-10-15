Feature: Validate creation of billing correction request with maximum line items for ZG2C/ZL2C documents

  @TC-47
  Scenario Outline: User creates a billing correction request linked to an original billing document with maximum line items
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    And the user has access to the Finance module
    When the user navigates to the transaction for creating billing correction requests
    And the user enters the billing correction request type as "<billingCorrectionRequestType>"
    And the user links the billing correction request to an existing billing document with "<lineItems>" line items
    Then the system successfully links the correction request to the original billing document
    And all "<lineItems>" line items are displayed in the correction request without truncation
    When the user saves the billing correction request
    Then the billing correction request is saved successfully
    When the user generates the corresponding "<billingDocumentType>" billing document
    Then the "<billingDocumentType>" billing document is generated successfully
    And all "<lineItems>" line items in the "<billingDocumentType>" document are correctly processed and linked to the original document
    And the system performance remains within acceptable limits
    And the document flow shows correct linkage between all related documents
    And no errors or warnings are logged during the process
    And the financial postings for the "<billingDocumentType>" document are accurate and reflect the corrections made

    Examples:
      | billingCorrectionRequestType | lineItems | billingDocumentType |
      | ZRK                          | 999       | ZG2C                |
      | ZRK                          | 999       | ZL2C                |