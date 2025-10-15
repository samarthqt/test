Feature: Verify that VBRK-KUNAG and VBRK-REGIO fields are cleared for ZFCB billing document type

  @TC-459
  Scenario Outline: Validate the creation of a ZFCB billing document and ensure fields are cleared
    Given the user logs into the SAP S/4HANA system with valid credentials
    And a source sales order "<source_sales_order>" exists with populated fields VBRK-KUNAG "<customer_field>" and VBRK-REGIO "<region_field>"
    When the user navigates to the billing document creation transaction
    And the user inputs the source sales order number "<source_sales_order>"
    And the user sets the target billing document type to "<billing_document_type>"
    And the user executes the process to create the billing document
    Then the billing document is successfully created
    When the user navigates to the display billing document transaction
    And the user retrieves the newly created billing document by entering its document number
    Then the VBRK-KUNAG field in the billing document header is empty
    And the VBRK-REGIO field in the billing document header is empty
    And no additional customer or region data is carried forward to the billing document

    Examples:
      | source_sales_order | customer_field | region_field | billing_document_type |
      | SO67890            | 200002         | EU           | ZFCB                 |