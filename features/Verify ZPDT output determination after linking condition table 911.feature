Feature: Verify ZPDT output determination after linking condition table 911

  @TC-292
  Scenario Outline: Validate output determination using condition table 911 within access sequence Z002
    Given the user has authorization to create and test billing scenarios
    And condition table "<Condition Table ID>" is created, activated, and populated with test data
    And access sequence "<Access Sequence ID>" is updated to include condition table "<Condition Table ID>"
    When the user creates a new billing document with type "<Billing Document Type>"
    Then the billing document is created successfully
    And the billing document includes Sales Org "<Sales Org>", Billing Type "<Billing Type>", and Attribute 7 "<Attribute 7>"
    When the user triggers output determination for the billing document
    Then the system references condition table "<Condition Table ID>" during output determination
    And the output determination considers Sales Org "<Sales Org>", Billing Type "<Billing Type>", and Attribute 7 "<Attribute 7>" values
    And the derived output records are accurate and complete
    When the user saves and finalizes the billing document
    Then the billing document is saved successfully
    When the user executes a test billing scenario to validate the output determination
    Then the output determination works correctly in the test scenario
    And no errors or issues are found in the logs
    When the user reviews the document flow
    Then the document flow confirms correct output determination and linkage
    When the user tests additional billing scenarios
    Then the output determination behaves consistently across scenarios
    And test results are documented, and output determination is confirmed

    Examples:
      | Condition Table ID | Access Sequence ID | Billing Document Type | Sales Org | Billing Type | Attribute 7 |
      | 911                | Z002               | ZPDT                  | 1000      | F2           | 10          |