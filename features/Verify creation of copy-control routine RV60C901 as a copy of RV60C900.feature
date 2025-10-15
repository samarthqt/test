Feature: Verify creation of copy-control routine RV60C901 as a copy of RV60C900

  @TC-546
  Scenario: User logs into the SAP system and accesses the VOFM configuration screen
    Given the user has valid credentials
    When the user logs into the SAP system
    Then the user navigates to the VOFM configuration screen
    And the VOFM configuration screen is displayed

  @TC-546
  Scenario: User selects the option to create a new copy-control routine
    Given the user is on the VOFM configuration screen
    When the user selects the option to create a new copy-control routine
    Then the system prompts the user to specify the source routine to be copied

  @TC-546
  Scenario Outline: User creates a new copy-control routine
    Given the user is prompted to specify the source routine
    When the user enters "<source_routine>" as the source routine
    And the user specifies "<new_routine>" as the new routine name
    Then the system accepts the input
    And the system displays "<new_routine>" for editing

    Examples:
      | source_routine | new_routine |
      | RV60C900       | RV60C901    |

  @TC-546
  Scenario: User verifies that the new routine contains the same logic and rules as the source routine
    Given the user has created the new routine RV60C901
    When the user reviews the logic and rules of RV60C901
    Then the user verifies that RV60C901 contains the same logic and rules as RV60C900

  @TC-546
  Scenario: User saves the new copy-control routine
    Given the user has verified the logic and rules of RV60C901
    When the user saves the new routine RV60C901
    Then RV60C901 is successfully saved in the system

  @TC-546
  Scenario: User transports the configuration to the test environment
    Given the user has successfully saved RV60C901
    When the user transports the configuration to the test environment
    Then the transport request for RV60C901 is successfully created and moved to the test environment

  @TC-546
  Scenario: User validates the presence of the new routine in the test environment
    Given the user has transported the configuration to the test environment
    When the user validates the presence of RV60C901 in the test environment
    Then RV60C901 is available and functional in the test environment

  @TC-546
  Scenario: User documents the creation and transport process
    Given the user has validated the presence of RV60C901 in the test environment
    When the user documents the creation and transport process for audit purposes
    Then the documentation is complete and accurate

  @TC-546
  Scenario: User verifies that the routine is listed under available copy-control routines
    Given the user is in the test environment
    When the user checks the list of available copy-control routines
    Then RV60C901 is listed and selectable

  @TC-546
  Scenario: User checks the functional specification
    Given the user has verified the routine in the test environment
    When the user checks the functional specification for RV60C901
    Then the user ensures that all functional requirements are satisfied

  @TC-546
  Scenario: User performs a peer review of the configuration
    Given the user has completed the functional specification check
    When the user performs a peer review of the configuration
    Then the peer review confirms that RV60C901 is correctly configured

  @TC-546
  Scenario: User signs off on the configuration and updates the project tracker
    Given the user has completed the peer review
    When the user signs off on the configuration
    And the user updates the status in the project tracker
    Then the configuration is approved and the status is updated