Feature: Equality

  # This is a demo test. The goal is just to show an example of possible implementation
  # I'm using the fake API that's why i decided to implement negative scenario
  # and to compare the value from API with the value on a randomly selected site in order just to show my skill
  Scenario: The value returned by API is not equal to the value on the website

    Given Open https://www.bookdepository.com/author/1
    When Get the 1st author name in API and on the webSite
    Then Check that the 1st author name in API and on the website are not equal
    And Close the browser
