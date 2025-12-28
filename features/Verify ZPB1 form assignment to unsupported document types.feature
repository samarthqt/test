Feature: Verify ZPB1 form assignment to unsupported document types

  @TC-422
  Scenario Outline: Validate the assignment of ZPB1 form template to billing documents
    Given the user is logged into the SAP S/4HANA Cloud system and navigates to the Billing application
    And the ZPB1 form template is created and activated in the system
    When the user creates a billing document of type <documentType>
    And the user attempts to assign the ZPB1 form template to the billing document
    Then the system <systemBehavior>
    And the user reviews the <errorMessage>
    When the user modifies the document type to ZPB and attempts to assign the template again
    Then the ZPB1 form template is successfully assigned to the billing document
    And the user verifies the association of the ZPB1 form template with the modified billing document
    When the user generates the billing document output
    Then the billing document output is generated successfully and the content is correct
    When the user prints the ZPB1 form
    Then the ZPB1 form is printed successfully and the output is correct
    When the user checks for errors or warnings during the process
    Then no errors or warnings are encountered
    And the user validates the alignment of the printed form with the ZPB1 template structure
    When the user saves the generated billing document for future reference
    Then the billing document is saved successfully
    And the system logs the error for unsupported document type assignment

    Examples:
      | documentType | systemBehavior                              | errorMessage                                           |
      | ZXX          | prevents assigning the form template       | "ZPB1 form template cannot be assigned to unsupported document type." |
      | ZFS          | allows assigning the form template         | "No error message is displayed."                      |