Feature: test case
  Scenario: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it is a friday
    Then I should be told "Nope"