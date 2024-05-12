Feature: Validate Subscription Packages

  Scenario Outline: Validate Subscription Packages
    Given User navigate to stctv page
    When User select <country> with <countryID> code
    Then User validate currency is <currency>
    And User validate subscription package for lite price is <lite>
    And User validate subscription package for classic price is <classic>
    And User validate subscription package for premium price is <premium>

    Examples:
      | country | countryID | currency | lite | classic | premium |
      | KSA     | sa        | SAR      | 15   | 25      | 60      |
      | Bahrain | bh        | BHD      | 2    | 3       | 6       |
      | Kuwait  | kw        | KWD      | 1.2  | 2.5     | 4.8     |


