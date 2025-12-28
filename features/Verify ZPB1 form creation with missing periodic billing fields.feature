Feature: Verify ZPB1 form creation with missing periodic billing fields

  @TC-421
  Scenario Outline: Validate mandatory periodic billing fields during ZPB1 form creation
    Given the user is logged into the SAP S/4HANA Cloud system and navigates to the Form Management application
    And the form base template "ZPDT" is available in the system
    And the billing document type "<billing_document_type>" and document type "<document_type>" are configured in the system
    When the user selects the option to create a new form template
    And the user chooses the base template "<base_template>"
    And the user enters the name "<form_template_name>" for the new form template
    And the user associates the new template with document type "<document_type>" and billing document type "<billing_document_type>"
    And the user populates the periodic billing fields, leaving out the mandatory field "<missing_field>"
    Then the system prevents saving the template and displays an error message indicating the missing field "<missing_field>"
    When the user reviews the error message
    Then the error message clearly identifies the missing field "<missing_field>"
    When the user populates the missing field "<missing_field>" and attempts to save the template again
    Then the template is saved successfully

    Examples:
      | billing_document_type | document_type | base_template | form_template_name | missing_field |
      | ZFS                   | ZPB           | ZPDT          | ZPB1               | Field1        |

  @TC-421
  Scenario: Activate the ZPB1 form template and verify configuration
    Given the user has successfully created and saved the ZPB1 form template
    When the user activates the template
    Then the template is activated successfully
    And the configuration is verified

  @TC-421
  Scenario: Generate and assign periodic billing document using ZPB1 template
    Given the user has an activated ZPB1 form template
    When the user generates a periodic billing document of type ZPB and assigns the template
    Then the periodic billing document is generated successfully
    And the template is assigned

  @TC-421
  Scenario: Print the ZPB1 form and verify output
    Given the user has successfully generated a periodic billing document using the ZPB1 template
    When the user prints the form
    Then the form is printed successfully
    And the output is correct