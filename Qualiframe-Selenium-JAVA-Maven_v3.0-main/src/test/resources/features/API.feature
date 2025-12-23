Feature: Validating Place API

  @api
  Scenario Outline: Verify if employee is getting addded succesfully using create API
    Given Access "<url>" with "<headers>" for "<tc_id>"
    When Send "<method>"
    Then verify request is success with status "<code>"
    And verify "status" in response body is "success"

    Examples:
      | tc_id            | url                | headers | method | code |
      | APIPracticeTest1 | GetEmployeeDetails | NA      | GET    | 200  |

  Scenario Outline: Verify if employee is getting addded succesfully using create API
    Given Access "<url>" with "<headers>" for "<tc_id>"
    When Send "<method>" with request body "<payload>"
    Then verify request is success with status "<code>"
    And verify "status" in response body is "success"
    And verify "data.id" in response body is "2225"

    Examples:
      | tc_id            | url               | headers | method | payload         | code |
      | APIPracticeTest2 | AddEmployeeDetail | NA      | POST   | EmployeesDetail | 200  |

  @graphql
  Scenario Outline: Execute GraphQL query to fetch data
    Given Access GraphQL endpoint "<url>" with "<headers>" for "<tc_id>"
    When Execute GraphQL query "<query>" with variables "<variables>"
    Then verify GraphQL request is success with status "<code>"
    And verify GraphQL response has no errors
    And verify GraphQL data path "<dataPath>" is "<expectedValue>"

    Examples:
      | tc_id         | url                    | headers | query                                    | variables | code | dataPath           | expectedValue |
      | GraphQLTest1  | GraphQLEndpoint        | header2 | query { country(code: \"US\") { name } } | NA        | 200  | country.name       | United States |
      | GraphQLTest2  | GraphQLEndpoint        | header2 | query { countries { code name } }        | NA        | 200  | countries[0].name   | Andorra       |

  @graphql @graphql-mutation
  # IMPORTANT: Mutation scenarios require:
  # 1. A GraphQL API that supports mutations (NOT read-only APIs like Countries API)
  # 2. Proper test data setup for variables (e.g., "UserVariables" key in test data with JSON values)
  # 
  # The Countries API (countries.trevorblades.com) is read-only and will FAIL these tests.
  # To skip mutation tests, exclude @graphql-mutation tag: @graphql and not @graphql-mutation
  # 
  # Example test data for GraphQLTest4:
  # In your test data file, add: UserVariables={"id":"1","name":"Updated Name"}
  Scenario Outline: Execute GraphQL mutation to modify data
    Given Access GraphQL endpoint "<url>" with "<headers>" for "<tc_id>"
    When Execute GraphQL mutation "<mutation>" with variables "<variables>"
    Then verify GraphQL request is success with status "<code>"
    And verify GraphQL response has no errors
    And verify GraphQL data path "<dataPath>" exists

    Examples:
      | tc_id         | url                    | headers | mutation                                                                 | variables      | code | dataPath           |
      | GraphQLTest3  | GraphQLEndpoint        | header2 | mutation { createUser(name: \"Test User\", email: \"test@example.com\") { id name } } | NA             | 200  | createUser.id       |
      | GraphQLTest4  | GraphQLEndpoint        | header2 | mutation UpdateUser($id: ID!, $name: String!) { updateUser(id: $id, name: $name) { id name } } | UserVariables  | 200  | updateUser.name     |

  @graphql
  Scenario Outline: Execute GraphQL query from file
    Given Access GraphQL endpoint "<url>" with "<headers>" for "<tc_id>"
    When Execute GraphQL query from file "<queryFile>"
    Then verify GraphQL request is success with status "<code>"
    And verify GraphQL response has no errors
    And verify GraphQL data path "<dataPath>" is "<expectedValue>"

    Examples:
      | tc_id         | url                    | headers | queryFile          | code | dataPath           | expectedValue |
      | GraphQLTest5  | GraphQLEndpoint        | header2 | GetCountryQuery.graphql | 200  | country.capital    | Washington D.C. |

  @grpc
  Scenario Outline: Sample GRPC request
    Given login sample application using grpc request for "<tc_id>"

    Examples:
      | tc_id   |
      | gRPC001 |
