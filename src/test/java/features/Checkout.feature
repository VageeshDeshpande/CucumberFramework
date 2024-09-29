Feature: Place the order for products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and offers page
    Given User is on GreenCart landing page
    When User searched with shortname <Name> and extracted actual name of the product
    And Add "3" items of the selected product to cart
    Then User proceeds to checkout and validate the <Name> items in checkout page
    And verify user has ability to enter promocode and place the order

    Examples: 
      | Name |
      | Tom  |
      | Beet |
