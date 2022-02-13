Feature: Feature to test Login

  Scenario: Check login
    Given browser is chrome and user navigates to Outlook
    And user enters "username" and "password"
    When user enters value in To, subject and in body
    And user clicks on Send
    Then email should be delivered