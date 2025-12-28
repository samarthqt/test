Feature: Verify daily billing document creation includes only orders with INV_READY='Y'

  @TC-436
  Scenario Outline: Validate orders included in daily billing documents based on INV_READY status
    Given user is logged into the SAP S/4HANA Cloud system with appropriate credentials
    And Attribute 3 is configured as "<Attribute3>" for the Ship-to BP
    And orders with INV_READY="<INV_READY>" exist in the system
    When user navigates to the billing due program using the transaction code for billing
    And user executes the billing due program in background mode
    Then the job execution status is "<JobStatus>" in the job log
    And the generated billing documents include orders with INV_READY='Y'
    And the generated billing documents exclude orders with INV_READY='N'
    And the billing documents are correctly posted to accounting
    And the system logs confirm "<LogStatus>" execution of the billing process
    And all processed orders in the billing documents have a status of 'Billed'
    And the overall accuracy of the generated billing documents meets all configuration requirements

    Examples:
      | Attribute3 | INV_READY | JobStatus   | LogStatus       |
      | ZD         | Y         | Completed   | error-free      |
      | ZD         | N         | Completed   | error-free      |

  @TC-436
  Scenario: Verify Attribute 3 is configured as 'ZD' for the Ship-to BP
    Given user is logged into the SAP S/4HANA Cloud system with appropriate credentials
    When user verifies the configuration of Attribute 3 for the Ship-to BP
    Then Attribute 3 is confirmed to be 'ZD'

  @TC-436
  Scenario: Validate the display of billing documents in the billing document overview
    Given user is logged into the SAP S/4HANA Cloud system with appropriate credentials
    And user has executed the billing due program in background mode
    When user retrieves the generated billing documents from the billing document overview
    Then billing documents are displayed in the billing document overview