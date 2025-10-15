Feature: Validate system performance during creation of ZG2C/ZL2C documents with maximum line items  
  Ensure the system maintains optimal performance when processing billing documents with the maximum number of line items.  

  @TC-48  
  Scenario: User logs into the SAP S/4HANA system with appropriate credentials  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged in and has access to the Finance module  

  @TC-48  
  Scenario Outline: Validate billing correction request creation and ZL2C document generation  
    Given the user navigates to the transaction for creating billing correction requests  
    When the user enters the billing correction request type as "<billingCorrectionRequestType>"  
    And the user links the billing correction request to an existing billing document with "<lineItems>" line items  
    And the user saves the billing correction request  
    And the user generates the corresponding "<billingDocumentType>" billing document  
    Then the "<billingDocumentType>" billing document is generated successfully  
    And the system response time during the document generation process is within acceptable limits  
    And all line items in the "<billingDocumentType>" document are correctly processed and linked to the original document  

    Examples:  
      | billingCorrectionRequestType | lineItems | billingDocumentType |  
      | ZRK1                         | 999       | ZL2C                |  

  @TC-48  
  Scenario: Validate document flow linkage  
    Given the user has generated a ZL2C document  
    When the user validates the document flow  
    Then the document flow shows correct linkage between all related documents  

  @TC-48  
  Scenario: Validate system logs for errors or warnings  
    Given the user has completed the ZL2C document generation process  
    When the user checks the system logs  
    Then no errors or warnings are logged during the process  

  @TC-48  
  Scenario: Verify financial postings for ZL2C document  
    Given the user has generated a ZL2C document  
    When the user verifies the financial postings for the ZL2C document  
    Then the financial postings are accurate and reflect the corrections made  

  @TC-48  
  Scenario: Review system performance metrics  
    Given the user has completed the ZL2C document generation process  
    When the user reviews the system performance metrics such as CPU usage and memory consumption  
    Then the system performance metrics are within acceptable thresholds