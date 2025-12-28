Feature: Validate output rendering for cancellation billing documents with minimum page number  
  Ensure the system handles cancellation billing documents with a single page and renders output correctly.

  @TC-371
  Scenario Outline: Validate cancellation billing document rendering process  
    Given the user logs in to the SAP S/4HANA system with valid credentials  
    And the user navigates to transaction VF03 to view the cancellation billing document with the number "<cancellation_billing_document_number>"  
    And the system displays the cancellation billing document details with output type "<output_type>" and print program "<print_program>"  
    When the user executes the output rendering process using output type "<output_type>"  
    Then the system updates the form "<form_name>" as per requirements  
    And the system displays the updated form "<form_name>" with correct formatting  
    And the header text is updated to "<header_text>"  
    And the page number is replaced with the original invoice number "<original_invoice_number>"  
    And the reference invoice number "<reference_invoice_number>" is displayed correctly  
    And the footer shows page numbering at the bottom-right as "<footer_page_numbering>"  
    And the Period Covered and Incoterms sections are omitted  
    And the printed output matches all specified formatting requirements  
    And no errors are logged during the rendering process  
    And the rendered output is saved successfully  

    Examples:  
      | cancellation_billing_document_number | output_type | print_program         | form_name                  | header_text            | original_invoice_number | reference_invoice_number | footer_page_numbering |  
      | 3000001239                           | ZPBL        | SD_INVOICE_PRINT01    | ZOTC_CON_INV_DT_FORM       | INVOICE CANCELLATION   | 123456789               | 987654321                | 1 of 1                |