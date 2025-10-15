Feature: Validate system handling of missing mandatory fields during transmission

  @TC-20
  Scenario Outline: Verify system behavior when mandatory fields are missing in billing documents
    Given the user is logged into SAP S/4HANA Cloud with appropriate credentials
    And the user navigates to the transaction "ZOTC_SALES_ORDER"
    When the user generates a billing document with document type "<Document Type>" and missing mandatory fields
    And the user triggers the outbound interface to send the billing documents to Model N
    Then the system logs errors related to missing mandatory fields
    And the system blocks the transmission of incomplete billing documents
    And clear error messages indicating missing mandatory fields are displayed to the user
    And the user is guided to correct the missing fields and retry transmission
    And the system maintains integrity by ensuring no incomplete data is transmitted
    And Model N does not receive any incomplete data
    And the system effectively handles errors related to missing mandatory fields
    And the system logs all error details for troubleshooting and audit purposes

    Examples:
      | Document Type |
      | ZF2           |
      | S1            |
      | ZG2C          |
      | ZL2C          |