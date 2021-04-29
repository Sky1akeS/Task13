Feature: Buy the specified product on the Amazon website


  Scenario Outline: finding the specified product and buying it through the "Buy Now" button
    Given open Amazon website
    When enter a product "<product>" and proceed to search results
    Then find the desired product "<product>", click "Buy now"
    And close browser
    Examples:
      |product                                                                          |
      |SAMSUNG: EVO Select 128GB                                                        |
      |Fitbit Charge 4 Fitness and Activity Tracker with Built-in GPS                   |
      |Roku Streaming Stick+                                                            |
