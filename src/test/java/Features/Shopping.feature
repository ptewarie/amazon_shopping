Feature: Shopping for a new tv

  Scenario: order tv
    Given I have launched the shopping App
      And the customer is logged out
    When  I log in the amazon app
      And   I search for a 65 inch television
      And   I add that item to the cart
      And   I go to shopping cart screen
      And   I go to the check out screen
    Then    the product details should be correct
