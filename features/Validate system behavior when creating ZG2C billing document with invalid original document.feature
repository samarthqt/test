Feature: Validate system behavior when creating ZG2C billing document with invalid original document

  @TC-520
  Scenario Outline: Prevent creation of ZG2C billing document with invalid or non-existent original document
    Given the user is logged into the SAP S/4HANA system with billing document creation permissions
    When the user navigates to the billing document creation screen using transaction code VF01
    And the user selects billing document type "<billing_document_type>" and enters the original billing document number "<original_document_number>"
    And the user attempts to save the billing document
    Then the system displays an error message "<error_message>"
    And the user logs out of the SAP S/4HANA system successfully

    Examples:
      | billing_document_type | original_document_number | error_message                                       |
      | ZG2C                  | 0000000000              | Original document is invalid or does not exist     |
      | ZG2C                  |                         | Original document is invalid or does not exist     |
      | ZG2C                  | ABCDEFGHIJ              | Original document is invalid or does not exist     |
      | ZG2C                  | 12345678901234567890    | Original document is invalid or does not exist     |