Feature: Validate display restrictions for unauthorized users accessing Sales Organization 1022

  @TC-504
  Scenario Outline: Validate unauthorized user access to Sales Organization 1022
    Given user logs into the SAP S/4HANA system with "<user_credentials>"
    When user navigates to the Sales Order processing screen
    Then the system displays the Sales Order processing screen
    When user attempts to filter sales orders for Sales Organization 1022
    Then the system displays "<filter_result>"
    When user attempts to process sales orders for Sales Organization 1022
    Then the system displays "<process_result>"
    When user validates system logs for unauthorized access attempts
    Then the system logs "<log_result>"
    When user verifies access rights in the system configuration
    Then the system confirms "<access_rights>"
    When user checks the audit trail for access attempts
    Then the audit trail shows "<audit_result>"
    When user attempts to access sales orders for other organizations
    Then the system displays "<access_other_org>"
    When user validates error messages for restricted access attempts
    Then the system displays "<error_message>"
    When user generates a report of access attempts for verification
    Then the report shows "<report_result>"
    When user verifies error message configuration in the system
    Then the system confirms "<error_config>"
    When user attempts to process sales orders for other organizations
    Then the system displays "<process_other_org>"

    Examples:
      | user_credentials         | filter_result                              | process_result                                  | log_result                           | access_rights                                   | audit_result                           | access_other_org                      | error_message                                  | report_result                           | error_config                                   | process_other_org                      |
      | unauthorized credentials | No sales orders for Sales Organization 1022 | Error message indicating insufficient access rights | Unauthorized access attempts recorded | Access rights correctly configured to restrict | No unauthorized access recorded        | Access allowed to sales orders        | Appropriate error message displayed           | No unauthorized access recorded        | Error messages correctly configured to indicate insufficient access rights | Processing allowed for other organizations |