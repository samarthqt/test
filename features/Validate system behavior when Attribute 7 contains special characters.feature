Feature: Validate system behavior when Attribute 7 contains special characters

  To ensure the system correctly handles Attribute 7 populated with special characters during billing output determination.

  @TC-489
  Scenario Outline: Validate billing document creation and output determination with Attribute 7 containing special characters
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    And the user navigates to the billing document creation screen
    When the user enters the required details for billing document creation, including the payer with Attribute 7 populated with "<special_characters>"
    And the user saves the billing document
    Then the billing document is successfully created and saved with a unique document number
    When the user triggers the output determination process for the created billing document
    Then the output determination process is initiated without errors
    And the KOMKBV3 structure includes Attribute 7 with its "<special_characters>" value
    And the KOMB structure includes Attribute 7 with its "<special_characters>" value
    When the user validates the downstream output determination logic for handling Attribute 7
    Then the output determination logic processes Attribute 7 without errors or disruptions
    And the system generates the expected output based on the billing document and Attribute 7
    And the system logs contain no warnings or errors related to Attribute 7 during the output determination process
    And the generated output document reflects the correct handling of Attribute 7

    Examples:
      | special_characters          |
      | !@#$%^&*()_+[]{}|;:,.<>?    |
      | ~`'"/\-=                   |
      | (space)                    |
      | (tab)                      |

  @TC-489
  Scenario: Document the test results and close the test case
    Given the test case has been executed successfully
    When the user documents the test results
    Then the test case is marked as completed