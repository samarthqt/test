Feature: Validate error handling for invalid Attribute 1 value in Billing Due Program

  @TC-159
  Scenario Outline: Validate Attribute 1 value in Billing Due Program
    Given user logs into the SAP S/4HANA Cloud system with valid credentials
    When user navigates to the billing due program
    And user enters "<Attribute1>" for Attribute 1 in the relevant field
    And user enters "<Attribute2>" for Attribute 2 in the respective field
    And user enters Subtype as "<Subtype>"
    And user executes the billing due program
    Then system "<ExecutionOutcome>"
    And system logs display "<LogDetails>"
    And user attempts to proceed with the billing document creation despite the error
    Then system "<ProcessingOutcome>"
    When user corrects Attribute 1 value to "<CorrectedAttribute1>"
    And user re-executes the billing due program
    Then billing due program executes "<ReExecutionOutcome>"
    And no invalid billing documents are present in the system
    And system is ready for further processing

    Examples:
      | Attribute1      | Attribute2 | Subtype | ExecutionOutcome                   | LogDetails                          | ProcessingOutcome          | CorrectedAttribute1 | ReExecutionOutcome            |
      | InvalidValue1   | ValidData  | 10      | halts execution and displays error | detailed error information logged  | prevents further processing | ValidValue1         | successfully with no errors   |
      | InvalidValue2   | ValidData  | 10      | halts execution and displays error | detailed error information logged  | prevents further processing | ValidValue2         | successfully with no errors   |
      | Blank           | ValidData  | 10      | halts execution and displays error | detailed error information logged  | prevents further processing | ValidValue3         | successfully with no errors   |
      | ValidValue1     | ValidData  | 10      | executes successfully              | no errors logged                   | allows further processing   | ValidValue1         | successfully with no errors   |