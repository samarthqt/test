Feature: Validate output rendering for cancellation billing documents with maximum page numbers  
  Ensure the system handles cancellation billing documents with maximum page numbers and renders the output correctly.

  @TC-372
  Scenario: User logs in to the SAP S/4HANA system with valid credentials  
    Given the user has valid credentials  
    When the user logs in to the SAP S/4HANA system  
    Then the user is successfully logged in and navigates to the SAP home screen  

  @TC-372
  Scenario: User navigates to transaction VF03 to view the cancellation billing document  
    Given the cancellation billing document number "3000001240" is available in the system  
    When the user navigates to transaction VF03  
    Then the cancellation billing document details are displayed  
    And the Output Type "ZPBL" is configured  
    And the Print Program "SD_INVOICE_PRINT01" is set up  

  @TC-372
  Scenario: User executes the output rendering process using Output Type ZPBL  
    Given the Output Type "ZPBL" and Print Program "SD_INVOICE_PRINT01" are set up  
    When the user executes the output rendering process  
    Then the output rendering process is executed successfully  
    And the form "ZOTC_CON_INV_DT_FORM" is updated as per requirements  

  @TC-372
  Scenario: User verifies that the updated form is used  
    Given the form "ZOTC_CON_INV_DT_FORM" is updated  
    When the user views the rendered form  
    Then the form "ZOTC_CON_INV_DT_FORM" is displayed with updated formatting  

  @TC-372
  Scenario: User checks that the header text is updated to "INVOICE CANCELLATION"  
    Given the cancellation billing document is rendered  
    When the user views the header text  
    Then the header text is displayed as "INVOICE CANCELLATION"  

  @TC-372
  Scenario: User validates that the page number is replaced with the Original Invoice Number  
    Given the cancellation billing document is rendered  
    When the user views the page numbering  
    Then the page number is replaced with the Original Invoice Number  

  @TC-372
  Scenario: User confirms that the Reference Invoice Number is displayed  
    Given the cancellation billing document is rendered  
    When the user views the Reference Invoice Number  
    Then the Reference Invoice Number is correctly displayed  

  @TC-372
  Scenario: User ensures the footer shows page numbering at the bottom-right  
    Given the cancellation billing document has multiple pages  
    When the user views the footer on each page  
    Then the footer displays page numbering correctly at the bottom-right (e.g., "1 of 10", "2 of 10", etc.)  

  @TC-372
  Scenario: User verifies that the Period Covered and Incoterms sections are omitted  
    Given the cancellation billing document is rendered  
    When the user views the document content  
    Then the Period Covered and Incoterms sections are not displayed  

  @TC-372
  Scenario: User validates the printed output for accuracy and formatting  
    Given the cancellation billing document is rendered  
    When the user prints the document  
    Then the printed output matches all specified formatting requirements  

  @TC-372
  Scenario: User checks system logs for any errors during the rendering process  
    Given the output rendering process is completed  
    When the user reviews the system logs  
    Then no errors are logged during the rendering process  

  @TC-372
  Scenario: User saves the rendered output for future reference  
    Given the cancellation billing document is rendered  
    When the user saves the rendered output  
    Then the rendered output is saved successfully