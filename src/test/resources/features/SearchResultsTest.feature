@ui
Feature: Verify search functionality

  Background: User is on home page
    Given user navigates to home page
    And he is on home page

  Scenario: Verify invalid search with less than 3 characters
    When he search for a product with name 'shirt'
    Then he should see the title 'Search results for: \'shirt\''
    And he should see the following products:
      | Name                      | Price  | Sizes       | Colors             |
      | Radiant Tee               | $22.00 | XS,S,M,L,XL | Blue,Orange,Purple |
      | Circe Hooded Ice Fleece   | $68.00 | XS,S,M,L,XL | Gray,Green,Purple  |
      | Balboa Persistence Tee    | $29.00 | XS,S,M,L,XL | Gray,Green,Orange  |
      | Gobi HeatTec® Tee         | $29.00 | XS,S,M,L,XL | Black,Orange,Red   |
      | Proteus Fitness Jackshirt | $45.00 | XS,S,M,L,XL | Black,Blue,Orange  |

  Scenario: Verify search form auto complete
    When he is looking to search for 'top'
    Then he should see the following suggestions:
      | Suggestion       | Quantity |
      | Top              | 35       |
      | tops             | 4        |
      | tops women       | 6        |
      | tops and bottoms | 159      |
      | top blue         | 102      |

  Scenario: Verify search for a valid item
    When user navigates to home page
    Then he is on home page

    Examples:
      | Keyword          | Quantity |
      | Top              | 35       |
      | tops             | 4        |
      | tops women       | 6        |
      | tops and bottoms | 159      |
      | top blue         | 102      |
