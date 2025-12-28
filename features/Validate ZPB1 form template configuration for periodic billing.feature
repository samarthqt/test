Feature: Validate ZPB1 form template configuration for periodic billing

  @TC-419
  Scenario: User navigates to the Form Management application
    Given the user logs in to the SAP S/4HANA Cloud system
    When the user navigates to the Form Management application
    Then the Form Management application is displayed successfully
    And the form base template "ZPDT" is available in the system

  @TC-419
  Scenario: User searches for the ZPB1 form template
    Given the necessary configuration for the ZPB1 form template creation has been completed
    When the user searches for the form template named "ZPB1"
    Then the ZPB1 form template is found in the system
    And the billing document type "ZFS" and document type "ZPB" are configured in the system

  @TC-419
  Scenario: User views the configuration details of the ZPB1 form template
    Given the ZPB1 form template is found in the system
    When the user opens the configuration details of the ZPB1 form template
    Then the configuration details of the ZPB1 form template are displayed
    And the document type is "ZPB"

  @TC-419
  Scenario: User verifies the association of the ZPB1 template with document types
    Given the configuration details of the ZPB1 form template are displayed
    When the user verifies the association of the ZPB1 template with document type "ZPB" and billing document type "ZFS"
    Then the ZPB1 template is correctly associated with document type "ZPB" and billing document type "ZFS"

  @TC-419
  Scenario: User checks periodic billing fields for alignment with ZPDT template structure
    Given the ZPB1 form template configuration details are displayed
    When the user checks the periodic billing fields in the ZPB1 template for alignment with the ZPDT template structure
    Then the periodic billing fields are aligned with the ZPDT template structure
    And the periodic billing fields include "Field1", "Field2", and "Field3"

  @TC-419
  Scenario Outline: User modifies and reverts a field in the ZPB1 template
    Given the ZPB1 form template configuration details are displayed
    When the user modifies a field "<field_name>" in the ZPB1 template to test edit functionality
    Then the field "<field_name>" is modified successfully, and the change is saved
    When the user reverts the field "<field_name>" modification to its original value
    Then the field "<field_name>" is reverted successfully, and the original value is restored

    Examples:
      | field_name  |
      | Field1      |
      | Field2      |
      | Field3      |

  @TC-419
  Scenario: User saves the configuration changes in the ZPB1 template
    Given the user has modified and reverted fields in the ZPB1 template
    When the user saves the configuration changes
    Then the configuration changes are saved successfully

  @TC-419
  Scenario: User activates the ZPB1 template
    Given the ZPB1 template is not already activated
    When the user activates the ZPB1 template
    Then the ZPB1 template is activated successfully

  @TC-419
  Scenario: User generates a periodic billing document of type ZPB
    Given the ZPB1 template is activated
    When the user generates a periodic billing document of type "ZPB"
    Then the periodic billing document of type "ZPB" is generated successfully

  @TC-419
  Scenario: User verifies the ZPB1 form is assigned to the billing document
    Given a periodic billing document of type "ZPB" is generated
    When the user verifies the assignment of the ZPB1 form to the generated billing document
    Then the ZPB1 form is correctly assigned to the billing document

  @TC-419
  Scenario: User prints the ZPB1 form and verifies the output
    Given the ZPB1 form is assigned to the billing document
    When the user prints the ZPB1 form
    Then the ZPB1 form is printed successfully
    And the output is correctly formatted with all necessary fields included