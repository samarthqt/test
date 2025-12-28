Feature: Validate system behavior when Ship-to Business Partner attributes (KATR1/KATR2) are missing during billing document creation

  @TC-207
  Scenario: User logs in to the SAP S/4HANA system
    Given the user has appropriate authorization for billing document creation
    When the user logs in to the SAP S/4HANA system
    Then the user successfully accesses the billing module

  @TC-207
  Scenario Outline: Create a sales order without maintaining Ship-to Business Partner attributes
    Given the user is in the sales order creation module
    When the user creates a sales order without maintaining Ship-to Business Partner attributes "<KATR1>" and "<KATR2>"
    Then the sales order is created successfully but lacks the required attributes

    Examples:
      | KATR1 | KATR2 |
      |       |       |

  @TC-207
  Scenario: Execute the billing process to generate billing documents
    Given the user has created a sales order without maintaining Ship-to Business Partner attributes
    When the user executes the billing process
    Then the system halts billing document creation due to missing attributes

  @TC-207
  Scenario: Observe the system response and validate error handling
    Given the billing document creation is halted due to missing attributes
    When the user observes the system response
    Then the system displays an error message indicating missing attributes

  @TC-207
  Scenario: Verify no billing documents are created
    Given the billing document creation is halted
    When the user checks the list of generated billing documents
    Then no billing documents are created

  @TC-207
  Scenario: Check the system logs for detailed error messages
    Given the billing document creation is halted
    When the user reviews the system logs
    Then the system logs provide clear details about the missing attributes

  @TC-207
  Scenario: Validate data integrity and prevention of incorrect billing
    Given the billing document creation is halted due to missing attributes
    When the user validates the system data
    Then the system maintains data integrity and prevents incorrect billing

  @TC-207
  Scenario: Verify customer communication records for discrepancies
    Given the billing document creation is halted
    When the user checks the customer communication records
    Then no communication records are updated due to halted billing

  @TC-207
  Scenario: Check the configuration settings for split logic
    Given the user accesses the configuration settings
    When the user reviews the settings for split logic
    Then the configuration settings highlight the requirement for Ship-to Business Partner attributes

  @TC-207
  Scenario: Validate system recovery from missing attribute errors
    Given the billing document creation is halted due to missing attributes
    When the user maintains the missing attributes and reprocesses the billing
    Then the system allows recovery and reprocessing after attributes are maintained

  @TC-207
  Scenario: Verify no accounting postings are created for halted billing documents
    Given the billing document creation is halted
    When the user checks the accounting postings
    Then no accounting postings are made due to halted billing

  @TC-207
  Scenario: Ensure tax calculations are not triggered for halted billing documents
    Given the billing document creation is halted
    When the user checks the tax calculations
    Then tax calculations are not performed due to halted billing