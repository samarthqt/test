Feature: Validate processing of Attribute 7 with maximum boundary values in billing output determination

  Ensure that the system can successfully process Attribute 7 with maximum boundary values in the field catalog (ZPDT) during billing output determination. Attribute 7 in the payer master data must be populated with maximum boundary values (e.g., maximum length strings, special characters).

  @TC-280
  Scenario Outline: Verify Attribute 7 processing with boundary values in billing output determination
    Given the user is logged into the SAP system with valid credentials
    And the user navigates to the transaction for maintaining payer master data
    When the user populates Attribute 7 in the payer master data with "<attribute_value>"
    And the user saves the changes to the payer master data
    And the user navigates to the field catalog configuration screen (ZPDT)
    Then Attribute 7 is included in the field catalog
    When the user creates a new billing document with standard data
    And the user triggers the output determination process for the billing document
    Then the output determination logs show that Attribute 7 with "<attribute_value>" is processed successfully
    And the generated output reflects the processed Attribute 7 values correctly
    And no data integrity issues are identified in the output

    Examples:
      | attribute_value                                            |
      | AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA       |  # Maximum length string
      | @#$%^&*()_+{}:<>?                                          |  # Special characters
      |                                                            |  # Blank value
      | AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA |  # Exceeding maximum length string
      | ABC123                                                    |  # Alphanumeric value

  @TC-280
  Scenario: Document test results and close the session
    Given the user has completed the output determination process for the billing document
    When the user documents the test results
    Then the session is closed successfully