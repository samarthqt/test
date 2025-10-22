Feature: Promotional SMS Opt-in Verification

  @TC-14
  Scenario: User does not receive promotional SMS without opting in
    Given the user has not opted in for promotional SMS
    When a promotional SMS event is triggered
    Then no promotional SMS is received on the user's phone