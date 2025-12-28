Feature: Verify successful triggering of Invoice List output during VF23 execution with Output Type ZPIL

  @TC-441
  Scenario Outline: Validate the successful execution and output generation for Invoice List in VF23 with Output Type ZPIL
    Given the user logs into the SAP S/4HANA system using "<credentials>"
    And the user navigates to the VF23 transaction
    When the user inputs the required parameters to select an invoice list document "<invoice_list_document>"
    And the user executes the transaction to trigger the Invoice List output
    Then the system triggers the Invoice List output successfully
    And the system confirms that Output Type "<output_type>" is triggered
    And the output includes all invoices linked to the selected invoice list document
    And the generated output uses the "<program_name>" program
    And the output is generated using the "<form_name>" form
    And the output aligns with the functional specification requirements
    And the output format matches the documented scope
    And the output is error-free and complete
    And the user saves and exports the output for further verification if required

    Examples:
      | credentials       | invoice_list_document | output_type | program_name         | form_name               |
      | valid credentials | existing document     | ZPIL        | SD_INVOICE_PRINT01   | ZOTC_CON_INV_DT_FORM    |