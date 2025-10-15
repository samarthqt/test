Feature: Validate copy control routine processes null VBRK-KUNAG and VBRK-REGIO fields gracefully

  @TC-460
  Scenario Outline: Validate the creation of a billing document with null values in VBRK-KUNAG and VBRK-REGIO fields
    Given the user logs into the SAP S/4HANA system with appropriate credentials
    And the user navigates to the billing document creation transaction
    When the user inputs the source sales order number "<source_sales_order>" in the relevant field
    And the user sets the target billing document type to "<billing_document_type>"
    And the user executes the process to create the billing document
    Then the billing document is successfully created without any errors
    When the user navigates to the display billing document transaction
    And the user retrieves the newly created billing document by entering its document number
    Then the billing document details are displayed
    And the VBRK-KUNAG field in the billing document header is "<vbrk_kunag_value>"
    And the VBRK-REGIO field in the billing document header is "<vbrk_regio_value>"
    And the routine processes null or missing values gracefully without errors
    And the user logs the results of the test case execution
    Then the user logs out from the SAP S/4HANA system

    Examples:
      | source_sales_order | billing_document_type | vbrk_kunag_value | vbrk_regio_value |
      | SO00000            | ZF2C                  | NULL             | NULL             |
      | SO00001            | ZFCB                  | NULL             | NULL             |

  @TC-460
  Scenario: Validate successful login and logout from the SAP S/4HANA system
    Given the user logs into the SAP S/4HANA system with appropriate credentials
    Then the user successfully logs into the system
    When the user logs out from the SAP S/4HANA system
    Then the user is logged out of the system