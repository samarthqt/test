Feature: Validate edge case handling for maximum length Site_ID and CMO_ID values

  @TC-328
  Scenario Outline: Validate system behavior for maximum length Site_ID and CMO_ID values
    Given the user uploads an inbound file containing Site_ID "<Site_ID>" and CMO_ID "<CMO_ID>"
    When the user triggers the inbound interface processing manually
    Then the system starts processing without any issues
    And the Plant is determined accurately based on the CMO_ID "<CMO_ID>"
    And the Ship To and Sold To partners are resolved correctly using the Site_ID "<Site_ID>"
    And no warnings or errors related to field length are observed in the logs
    And the maximum length values are stored correctly in the database
    And the system processes all maximum length records successfully
    And the processed data matches the input file exactly
    And the system performs efficiently without degradation
    And the system adheres to the defined field length validation rules
    And the downstream workflows process the data without issues
    And the audit trail captures all processing details accurately

    Examples:
      | Site_ID                                | CMO_ID                                 |
      | 987654321098765432109876543210987654   | 123456789012345678901234567890123456   |