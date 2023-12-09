Feature: ToDo app smoke suite
  Scenario: Test of adding a task and its appearance in the list
    Given User launches the app
    When User adds a task
    Then Task should appear in the task list

  Scenario: Task completion test and checking the filter for completed tasks
    Given User launches the app
    When User adds a task
    When User completes the task
    Then Task should appear in the completed list