Feature: Get Products

  Scenario Outline: Fetch product details by ID
    Given the API is available
    When the user fetches the product with ID "<productId>"
    Then the response status code should be <statusCode>

    Examples:
      | productId | statusCode |
      | 1         | 200        |
      | 2         | 200        |

  Scenario: Fetch all products
    Given the API is available
    When the user fetches all products
    Then the response status code should be 200