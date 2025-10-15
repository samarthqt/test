Feature: Monitor system performance during large batch ZPB1 output generation

  @TC-538
  Scenario Outline: Validate system performance during ZPB1 output generation for a large batch of ZFR documents
    Given the user is logged into the SAP S/4HANA Cloud system using valid credentials
    And a batch of <batch_size> ZFR documents exists in the periodic billing section
    When the user selects the batch of ZFR documents for processing
    And the user triggers the periodic billing workflow with ZPB1 output type selected
    Then the system's CPU and memory usage should remain within acceptable limits
    And the system's response time during batch processing should be within acceptable limits
    And the database performance should remain stable without bottlenecks
    And the system should not encounter any crashes or significant slowdowns
    And the system logs should not contain any performance-related warnings or errors
    And the batch processing time should be within the acceptable threshold
    And the ZPB1 outputs should be generated successfully for all selected ZFR documents
    And the system performance monitoring tools should not indicate any anomalies

    Examples:
      | batch_size |
      | 1000       |
      | 1500       |
      | 2000       |