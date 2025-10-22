Feature: SMS Notifications for Key Events and Promotional Messages

  @14
  Scenario Outline: User receives SMS notifications for key events
    Given the user has a registered phone number
    When the user performs a key event "<Event>"
    Then the user should receive an SMS notification for "<Event>"

    Examples:
      | Event                  |
      | order confirmation     |
      | shipping update        |
      | delivery notification  |
      | password recovery      |
      | account change         |

  @14
  Scenario Outline: User receives promotional SMS
    Given the user has opted in to marketing communications
    And the user complies with local regulations
    When the user is eligible for promotional messages
    Then the user should receive a promotional SMS

    Examples:
      | OptedIn | CompliesWithRegulations |
      | true    | true                    |
      | false   | false                   |