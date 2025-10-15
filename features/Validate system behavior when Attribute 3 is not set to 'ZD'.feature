Feature: Validate system behavior when Attribute 3 is not set to 'ZD'

  @TC-437
  Scenario Outline: Ensure the system excludes orders with Attribute 3 not set to 'ZD' from the daily billing batch
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    And the user confirms that the billing due program is active and accessible
    When the user navigates to the billing due program using the transaction code for billing
    And the user verifies that Attribute 3 is configured as "<Attribute 3 Value>" for the Ship-to BP with ID "<Ship-to BP ID>"
    And the user executes the billing due program in background mode
    And the user monitors the job execution status in the job log
    Then the job execution status is "<Job Status>"
    And the user retrieves the generated billing documents from the billing document overview
    And the user verifies that orders with Attribute 3 not equal to 'ZD' are excluded from the billing batch
    And the user validates that the billing documents are correctly posted to accounting
    And the user checks the system logs for any errors or warnings during the billing process
    And the user verifies the status of all processed orders in the billing documents is "<Order Status>"
    And the user validates the overall accuracy of the generated billing documents
    And the system ensures that no orders with Attribute 3 not equal to 'ZD' are processed

    Examples:
      | Attribute 3 Value | Ship-to BP ID | Job Status  | Order Status |
      | ZM                | 10002         | Completed   | Billed       |
      | ZN                | 10003         | Completed   | Billed       |
      | ZP                | 10004         | Completed   | Billed       |