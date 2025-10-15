Feature: Verify ZPB1 form template creation using ZPDT template  
  Ensure that the ZPB1 form template is created by reusing the ZPDT template and tailored for periodic billing.  

  @TC-418  
  Scenario: Verify navigation to the Form Management application  
    Given the user logs in to the SAP S/4HANA Cloud system  
    When the user navigates to the Form Management application  
    Then the Form Management application is displayed successfully  

  @TC-418  
  Scenario Outline: Verify creation of a new form template using ZPDT as base  
    Given the necessary configuration for the ZPB1 form template creation is completed  
    When the user selects the option to create a new form template  
    And the user chooses the "<base_template>" template as the base for the new form template  
    And the user enters "<new_template_name>" for the new form template  
    And the user associates the new template with document type "<document_type>" and billing document type "<billing_document_type>"  
    And the user populates the fields required for periodic billing, ensuring alignment with the ZPDT template structure  
    And the user reviews the configuration of the new template to ensure all details are accurate  
    And the user saves the new template  
    And the user activates the new template  
    Then the new template is created, saved, and activated successfully  

    Examples:  
      | base_template | new_template_name | document_type | billing_document_type |  
      | ZPDT          | ZPB1              | ZPB           | ZFS                  |  

  @TC-418  
  Scenario: Verify periodic billing document generation  
    Given the ZPB1 form template is activated successfully  
    When the user generates a periodic billing document of type ZPB  
    Then the periodic billing document of type ZPB is generated successfully  

  @TC-418  
  Scenario: Verify assignment of ZPB1 form to billing document  
    Given a periodic billing document of type ZPB is generated  
    When the user verifies that the ZPB1 form is assigned to the generated billing document  
    Then the ZPB1 form is correctly assigned to the billing document  

  @TC-418  
  Scenario: Verify printing and output of ZPB1 form  
    Given the ZPB1 form is assigned to the billing document  
    When the user prints the ZPB1 form  
    Then the ZPB1 form is printed successfully  
    And the output is correctly formatted with all necessary fields included