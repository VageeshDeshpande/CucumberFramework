Feature: Search and place the order for products

  @OffersPage
  Scenario Outline: Search Experience for product search in both home and offers page
    Given User is on GreenCart landing page
    When User searched with shortname <Name> and extracted actual name of the product
    Then User search for <Name> in offer page
    And Validate product name in offers page matches with Landing page

    Examples: 
      | Name |
      | Tom  |
      | Beet |
