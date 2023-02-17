@ui
Feature: Verify search functionality

  Background: User is on home page
    Given user navigates to home page
    And he is on home page

  Scenario Outline: Verify search for a valid item
    When he is looking to search for 'top'
    And he is clicking on '<Keyword>' suggestion
    Then he should see the title 'Search results for: \'<Keyword>\''
    And he should count '<Quantity>' found products

    Examples:
      | Keyword | Quantity |
      | Top     | 35       |

  Scenario: Verify search for an item LIST view
    When he search for a product with name 'shirt'
    Then he should see the title 'Search results for: \'shirt\''
    When he is choosing to switch to 'LIST' view
    Then he should see the following products:
      | Name                      | Price  | Sizes       | Colors             |
      | Radiant Tee               | $22.00 | XS,S,M,L,XL | Blue,Orange,Purple |
      | Circe Hooded Ice Fleece   | $68.00 | XS,S,M,L,XL | Gray,Green,Purple  |
      | Balboa Persistence Tee    | $29.00 | XS,S,M,L,XL | Gray,Green,Orange  |
      | Gobi HeatTec® Tee         | $29.00 | XS,S,M,L,XL | Black,Orange,Red   |
      | Proteus Fitness Jackshirt | $45.00 | XS,S,M,L,XL | Black,Blue,Orange  |

  Scenario: Verify search for an item GRID view
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
    When he is looking to search for 'Hoodie'
    Then he should see the following suggestions:
      | Suggestion         | Quantity |
      | Hoodie             | 20       |
      | hoodie color black | 86       |
      | hoodie bag red     | 7        |
      | hoodie@            | 20       |
      | hoodie jacket      | 41       |
      | hoodies for women  | 12       |

  Scenario: Verify items on the page
    When he search for a product with name 'shirt'
    Then he should see the title 'Search results for: \'shirt\''
    And he should see the amount '5 Items'

  Scenario: Verify items on the page with pagination
    When he search for a product with name 'shirt of blue'
    Then he should see the title 'Search results for: \'shirt of blue\''
    And he should see the amount 'Items 1-12 of 94'

  Scenario Outline: Verify '<Strategy>' sorting by '<Sort Criteria>' criteria
    When he search for a product with name 'pants'
    Then he should see the title 'Search results for: \'pants\''
    And he should see the amount 'Items 1-12 of 13'
    When he is sorting the grid '<Strategy>' by '<Sort Criteria>'
    Then he should see the grid sorted '<Strategy>' by '<Sort Criteria>'

    Examples:
      | Sort Criteria | Strategy |
      | PRODUCT_NAME  | DESC     |
      | PRICE         | ASC      |
      | PRICE         | DESC     |
      | PRODUCT_NAME  | ASC      |

  Scenario: Verify navigation to the next page
    When he search for a product with name 'pants'
    Then he should see the title 'Search results for: \'pants\''
    And he should see the amount 'Items 1-12 of 13'
    When he is looking for pages number
    Then he should see the following pages:
      | 1 |
      | 2 |
    When he is navigating to the 'next' page
    Then he should see the amount 'Items 13-13 of 13'
    And he should see the following products:
      | Name             | Price  | Sizes | Colors           |
      | Karmen Yoga Pant | $39.00 | 28,29 | Black,Gray,White |