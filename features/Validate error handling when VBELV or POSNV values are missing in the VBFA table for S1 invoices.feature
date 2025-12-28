Feature: Validate error handling when VBELV or POSNV values are missing in the VBFA table for S1 invoices

  @TC-64
  Scenario Outline: Ensure the system logs an error and prevents Ext Link ID generation when VBELV or POSNV values are missing
    Given the user logs into the SAP S/4 HANA system with valid credentials
    And an S1 invoice with number "<invoice_number>" exists in the system
    And VBELV and POSNV values are missing in the VBFA table for the invoice
    When the user navigates to the transaction code for creating invoices
    And the user creates an S1 invoice with the required details and saves it
    Then the S1 invoice is successfully created
    And the user accesses the VBFA table to verify the absence of VBELV and POSNV values for the created invoice
    Then VBFA table shows missing VBELV and POSNV values for the S1 invoice
    When the user attempts to generate the Ext Link ID for the S1 invoice
    Then the system logs an error indicating missing VBELV or POSNV values
    And the Ext Link ID is not generated
    When the user attempts to transmit the invoice data to Model N
    Then data transmission to Model N is blocked due to missing values
    And the error message explicitly states the issue with missing VBELV or POSNV values
    And the system maintains data integrity and does not partially transmit any data
    And the error handling process is consistent with business requirements

    Examples:
      | invoice_number |
      | INV12345       |