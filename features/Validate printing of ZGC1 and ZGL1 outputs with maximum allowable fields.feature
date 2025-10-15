Feature: Validate printing of ZGC1 and ZGL1 outputs with maximum allowable fields

  @TC-88
  Scenario Outline: Validate the printing process for ZGC1 and ZGL1 outputs
    Given the user logs into the SAP system with valid credentials
    And the user navigates to the output management screen
    When the user selects the "<output_type>" output for printing using the "<template>"
    And the user initiates the printing process for "<output_type>" with maximum fields "<maximum_fields>"
    Then the "<output_type>" output is printed successfully
    And the printed "<output_type>" output is accurate and well-formatted
    And the system logs do not contain any errors or warnings
    And the system complies with operational and billing standards

    Examples:
      | output_type | template | maximum_fields |
      | ZGC1        | ZPDT     | 100            |
      | ZGL1        | ZPDT     | 100            |