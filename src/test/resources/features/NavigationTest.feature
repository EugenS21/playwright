@ui
Feature: Verify navigation through main menu

  Scenario Outline: Verify navigation through main menu for the following <Path>
    When user navigates to home page
    Then he is on home page
    When he choose to navigate to the following path '<Path>'
    Then he should see the title '<Title>'
    And he should see the amount '<Items>'
    When he is choosing to switch to 'LIST' view
    Then he should see the amount '<List Items>'

    Examples:
      | Path                               | Items            | Title                 | List Items       |
      | Women>>Tops>>Tees                  | 12 Items         | Tees                  | Items 1-10 of 12 |
      | Women>>Tops>>Jackets               | 12 Items         | Jackets               | Items 1-10 of 12 |
      | Women>>Tops>>Hoodies & Sweatshirts | 12 Items         | Hoodies & Sweatshirts | Items 1-10 of 12 |
      | Women>>Tops>>Bras & Tanks          | Items 1-12 of 14 | Bras & Tanks          | Items 1-10 of 14 |
      | Gear>>Bags                         | Items 1-12 of 14 | Bags                  | Items 1-10 of 14 |