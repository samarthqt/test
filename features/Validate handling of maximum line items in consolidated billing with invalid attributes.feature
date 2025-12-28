Feature: Validate handling of maximum line items in consolidated billing with invalid attributes

  @TC-166
  Scenario Outline: Validate system behavior when invalid attributes are provided in the Billing Due Program
    Given the user has logged into the SAP S/4HANA Cloud system with appropriate credentials and has access to the Finance module
    And the user navigates to the Billing Due Program
    When the user enters Attribute 1 as "<Attribute1>" and Attribute 2 as "<Attribute2>"
    And the user attempts to execute the Billing Due Program
    Then the system <SystemBehavior>
    And the system displays an error message "<ErrorMessage>" if applicable
    And the user checks the system logs for detailed error information
    Then the logs contain "<LogDetails>"
    When the user generates an error report
    Then the error report accurately reflects "<ReportDetails>"
    When the user corrects the attribute values to "<CorrectedAttribute1>" and "<CorrectedAttribute2>"
    And the user reattempts execution
    Then the system accepts the corrected attributes and allows the program to execute successfully

    Examples:
      | Attribute1      | Attribute2 | SystemBehavior                        | ErrorMessage                        | LogDetails                            | ReportDetails                     | CorrectedAttribute1 | CorrectedAttribute2 |
      | Invalid_Value   | 30         | halts execution                       | Invalid Attribute Error             | Detailed information about the error | Invalid attribute issue reflected | Valid_Value         | 30                  |
      |                 | 30         | halts execution                       | Attribute 1 cannot be blank         | Attribute 1 is missing               | Missing attribute issue reflected | Valid_Value         | 30                  |
      | Valid_Value     |             | halts execution                       | Attribute 2 cannot be blank         | Attribute 2 is missing               | Missing attribute issue reflected | Valid_Value         | 30                  |
      | Valid_Value     | -1         | halts execution                       | Attribute 2 must be a positive value| Invalid value for Attribute 2        | Invalid value issue reflected     | Valid_Value         | 30                  |
      | Valid_Value     | 30         | allows execution successfully         |                                    | No errors                            | No issues                         | Valid_Value         | 30                  |