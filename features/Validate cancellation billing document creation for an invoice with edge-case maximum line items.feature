Feature: Validate cancellation billing document creation for an invoice with edge-case maximum line items  
  Ensure that the system handles invoices with exactly 999 line items during cancellation billing document creation.  

  @TC-6  
  Scenario: User logs into the SAP system  
    Given the user has valid credentials  
    When the user logs into the SAP system  
    Then the user is successfully logged in and navigates to the SAP home screen  

  @TC-6  
  Scenario: User navigates to the VF11 transaction for invoice cancellation  
    Given the user is on the SAP home screen  
    When the user navigates to the VF11 transaction for invoice cancellation  
    Then the VF11 transaction screen is displayed  

  @TC-6  
  Scenario Outline: User enters the original invoice number for cancellation  
    Given the user is on the VF11 transaction screen  
    When the user enters the original invoice number <InvoiceNumber> in the cancellation screen  
    Then the original invoice number is accepted and displayed on the screen  

    Examples:  
      | InvoiceNumber |  
      | INV99999      |  

  @TC-6  
  Scenario Outline: User selects the cancellation document type  
    Given the user has entered the original invoice number in the cancellation screen  
    When the user selects the cancellation document type <CancellationType>  
    Then the cancellation document type <CancellationType> is selected successfully  

    Examples:  
      | CancellationType |  
      | S1              |  

  @TC-6  
  Scenario: User initiates the cancellation process  
    Given the user has selected the cancellation document type  
    When the user executes the cancellation process  
    Then the cancellation process is initiated without errors  

  @TC-6  
  Scenario: Cancellation billing document is created  
    Given the cancellation process is initiated  
    When the system processes the cancellation  
    Then a cancellation billing document is successfully created with document type S1  

  @TC-6  
  Scenario: Cancellation document references the original invoice number  
    Given the cancellation billing document is created  
    When the user reviews the cancellation document  
    Then the cancellation document correctly references the original invoice number  

  @TC-6  
  Scenario: All line items are reversed accurately  
    Given the cancellation document references the original invoice number  
    When the user validates the line items  
    Then all 999 line items in the original invoice are reversed accurately without discrepancies  

  @TC-6  
  Scenario: Document flow linkage is confirmed  
    Given the cancellation billing document is created  
    When the user navigates to the document flow  
    Then the document flow shows proper linkage between the original invoice and the cancellation document  

  @TC-6  
  Scenario: System updates the status of the original invoice  
    Given the cancellation billing document is created  
    When the user reviews the status of the original invoice  
    Then the system updates the status of the original invoice to 'Cancelled'  

  @TC-6  
  Scenario: Financial postings are accurate  
    Given the cancellation billing document is created  
    When the user reviews the financial postings for the cancellation document  
    Then the financial postings are accurate, and there are no discrepancies  

  @TC-6  
  Scenario: User logs out of the SAP system  
    Given the user has completed the cancellation process  
    When the user logs out of the SAP system  
    Then the user is logged out successfully