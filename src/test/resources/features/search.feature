Feature: Sample

  @ui @pageobject
  Scenario: Should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product from the input box
    Then the result should be displayed

  @ui @screenplay
  Scenario: Should be able to search for a product from the input box (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he searches for a product from the input box (screenplay)
    Then the result should be displayed (screenplay)

  @ui @pageobject
  Scenario: Should be able to search for a product from the drop-down menu
    Given John is viewing the Etsy landing page
    When he clicks on "Clothing & Accessories"
    And he clicks on subnav "Accessories"
    Then the accessories page should be displayed

  @ui @wip
  Scenario: Should be able to search for a product from the icons (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he clicks on an icon "Home & Living" (screenplay)
    Then he should be taken to "Home & Living" products page (screenplay)

