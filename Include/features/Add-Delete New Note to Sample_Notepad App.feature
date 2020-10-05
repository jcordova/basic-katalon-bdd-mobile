@tag
Feature: I want to add and delete a new Note to Sample Notepad App

  Background: 
    Given I open Sample Notepad App

  @tag1
  Scenario Outline: Add and Delete a new NOTE to Sample Notepad App
    When I add new Note's title "<noteTitle>"
    Then I add new Note's content "<noteContent>"
    And I save new Note
    Then I delete new Note

    Examples: 
      | noteTitle      | noteContent      |
      | New Note TITLE | New Note CONTENT |
