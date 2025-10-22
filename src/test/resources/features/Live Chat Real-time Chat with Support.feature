Feature: Live Chat Real-time Chat with Support

  @13
  Scenario Outline: User initiates a live chat during shopping journey
    Given the user is on the "<page>" page
    When the user initiates a conversation with a live agent
    Then the chat request should be acknowledged or assigned to an agent within "<response time>"

    Examples:
      | page      | response time      |
      | product   | less than 30 seconds |
      | cart      | less than 30 seconds |
      | checkout  | less than 30 seconds |

  @13
  Scenario Outline: User receives automated message when agents are unavailable
    Given the user is on the "<page>" page
    When the user initiates a conversation with a live agent
    And agents are unavailable
    Then the user should receive an automated message
    And the message should offer a way to leave a message or provide estimated wait times

    Examples:
      | page      |
      | product   |
      | cart      |
      | checkout  |