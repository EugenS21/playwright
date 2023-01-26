@ui
Feature: Verify the structure of the header

  Scenario: Verify header panel welcome message
    When user navigates to home page
    Then he is on home page
    When he is investigating the header panel structure
    Then he should see the following welcome message: 'Default welcome msg!'

  Scenario: Verify header panel structure
    When user navigates to home page
    Then he is on home page
    When he is investigating the header panel structure
    Then he should see the following links:
      | Link              | Displayed | Clickable |
      | Sign In           | true      | true      |
      | Create an Account | true      | true      |
