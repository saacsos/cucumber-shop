Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given Stock 10 product Bread with price 20.50
    And Stock 10 product Jam with price 80.00

Scenario: Buy one product
    When I buy Bread with quantity 2
    Then total should be 41.00

Scenario: Buy multiple products
    When I buy Bread with quantity 2
    And I buy Jam with quantity 1
    Then total should be 121.00

Scenario: Buy one product and check stock
    When I buy Bread with quantity 3
    Then total should be 61.50
    And The stock left 7 of Bread

Scenario: Buy multiple products
    When I buy Bread with quantity 10
    And I buy Jam with quantity 3
    Then total should be 445.00
    And The stock left 0 of Bread
    And The stock left 7 of Jam

Scenario: Buy insufficient product
    When I buy Bread with quantity 10
    And I cannot buy Jam with quantity 12 because Insufficient product quantity
    Then total should be 205.00
    And The stock left 0 of Bread
    And The stock left 10 of Jam

