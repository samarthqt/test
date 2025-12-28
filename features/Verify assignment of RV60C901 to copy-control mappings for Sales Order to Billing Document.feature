Feature: Verify assignment of RV60C901 to copy-control mappings for Sales Order to Billing Document

  @TC-547
  Scenario: User logs into the SAP system and navigates to the VOFM configuration screen
    Given the user has access to the SAP system
    When the user navigates to the VOFM configuration screen
    Then the VOFM configuration screen is displayed

  @TC-547
  Scenario: User selects the option to assign a copy-control routine to Sales Order to Billing Document mappings
    Given the user is on the VOFM configuration screen
    When the user selects the option to assign a copy-control routine to Sales Order to Billing Document mappings
    Then the system displays the mapping configuration screen

  @TC-547
  Scenario Outline: User chooses the mapping for Sales Order item category to Billing Document item category
    Given the user is on the mapping configuration screen
    When the user chooses the mapping for Sales Order item category "<SalesOrderCategory>" to Billing Document item category "<BillingDocumentCategory>"
    Then the selected mapping is displayed for editing

    Examples:
      | SalesOrderCategory | BillingDocumentCategory |
      | ZOR                | ZF2C                    |

  @TC-547
  Scenario: User assigns RV60C901 as the copy-control routine for the selected mapping
    Given the user is editing the mapping for Sales Order item category ZOR to Billing Document item category ZF2C
    When the user assigns RV60C901 as the copy-control routine for the selected mapping
    Then RV60C901 is assigned to the mapping without errors

  @TC-547
  Scenario: User saves the configuration changes
    Given the user has assigned RV60C901 to the mapping
    When the user saves the configuration changes
    Then the changes are successfully saved in the system

  @TC-547
  Scenario: User transports the configuration to the test environment
    Given the configuration changes are saved
    When the user transports the configuration to the test environment
    Then the transport request for the updated mapping is successfully created and moved to the test environment

  @TC-547
  Scenario: User validates the presence of the updated mapping in the test environment
    Given the configuration is transported to the test environment
    When the user validates the presence of the updated mapping
    Then the mapping with RV60C901 is available and functional in the test environment

  @TC-547
  Scenario: User executes a test Sales Order to Billing Document copy process using the updated mapping
    Given the updated mapping is available in the test environment
    When the user executes a test Sales Order to Billing Document copy process using the updated mapping
    Then the copy process executes without errors

  @TC-547
  Scenario: User verifies the functional specification to ensure all requirements are met
    Given the updated mapping is functional in the test environment
    When the user verifies the functional specification
    Then all functional requirements for the mapping are satisfied

  @TC-547
  Scenario: User performs a peer review of the configuration
    Given the updated mapping is functional and meets all requirements
    When the user performs a peer review of the configuration
    Then the peer review confirms that the mapping is correctly configured

  @TC-547
  Scenario: User documents the assignment process for audit purposes
    Given the configuration is reviewed and approved
    When the user documents the assignment process
    Then the documentation is complete and accurate

  @TC-547
  Scenario: User signs off on the configuration and updates the status in the project tracker
    Given the assignment process is documented
    When the user signs off on the configuration and updates the status in the project tracker
    Then the configuration is approved and the status is updated