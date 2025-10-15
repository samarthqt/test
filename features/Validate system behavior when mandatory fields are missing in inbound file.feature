Feature: Validate system behavior when mandatory fields are missing in inbound file

  @TC-324
  Scenario: User logs into the SAP system successfully
    Given user has valid credentials
    When user logs into the SAP system
    Then user is logged in successfully

  @TC-324
  Scenario: User navigates to the inbound file upload interface
    Given user is logged into the SAP system
    When user navigates to the inbound file upload interface
    Then inbound file upload interface is displayed

  @TC-324
  Scenario Outline: Validate missing mandatory fields in inbound file processing
    Given user navigates to the inbound file upload interface
    When user uploads the inbound file with missing <mandatory_field>
    And user triggers the inbound interface processing manually
    Then processing logs display error messages specifying the missing <mandatory_field>
    And no sales orders are created for the files with missing mandatory fields
    And error logs provide detailed descriptions of the missing fields
    And user interface displays notifications about the missing fields
    And system integrity is maintained with no incomplete or incorrect sales orders

    Examples:
      | mandatory_field     |
      | Lisbon Order ID     |
      | Sales Area          |