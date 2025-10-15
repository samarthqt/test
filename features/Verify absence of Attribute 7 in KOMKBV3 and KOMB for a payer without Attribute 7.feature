Feature: Verify absence of Attribute 7 in KOMKBV3 and KOMB for a payer without Attribute 7

  @TC-556
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-556
  Scenario: User navigates to the billing document creation transaction
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing document creation transaction
    Then the billing document creation screen is displayed

  @TC-556
  Scenario Outline: User creates a billing document for a payer without Attribute 7 in the master data
    Given the payer master data does not have Attribute 7 configured
    And there is a billing document for a customer without Attribute 7 populated
    When the user creates a billing document for the payer
    Then the billing document is created successfully

  @TC-556
  Scenario: User triggers the output determination process for the billing document
    Given the billing document is created successfully
    And the configuration allows output determination using KOMKBV3 and KOMB
    When the user triggers the output determination process for the billing document
    Then the output determination process is triggered without errors

  @TC-556
  Scenario: User accesses debugging tools to inspect KOMKBV3 and KOMB structures
    Given the output determination process is triggered
    When the user accesses the debugging tools
    Then the debugging tools are successfully accessed

  @TC-556
  Scenario Outline: User validates the absence of Attribute 7 in the structures
    Given the user is inspecting the communication structures
    When the user validates the absence of Attribute 7 in the "<structure>" structure
    Then Attribute 7 is not present in the "<structure>" structure

    Examples:
      | structure |
      | KOMKBV3   |
      | KOMB      |

  @TC-556
  Scenario: User verifies no errors or warnings during the output determination process
    Given the output determination process is completed
    When the user checks for errors or warnings
    Then no errors or warnings are logged

  @TC-556
  Scenario: User generates a report confirming the absence of Attribute 7
    Given the absence of Attribute 7 is validated in the communication structures
    When the user generates a report
    Then the report confirms the absence of Attribute 7

  @TC-556
  Scenario: User saves changes and exits the system
    Given all validations and reports are completed
    When the user saves the changes and exits the system
    Then the changes are saved, and the user exits the system