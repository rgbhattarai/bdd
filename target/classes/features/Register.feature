Feature: Registration functionality

  Scenario: User creates an account with mandotary field
    Given User navigates to Register Account page
    When User enters the details into the below fields
      | firstname | Rushie     |
      | lastname  | Bhattarai  |
      | telephone | 8285592618 |
      | password  |      12345 |
    And User selects privacy policy
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates an account with all fields
    Given User navigates to Register Account page
    When User enters the details into the below fields
      | firstname | Rushie     |
      | lastname  | Bhattarai  |
      | telephone | 8285592618 |
      | password  |      12345 |
    And User selects Yes for Newsletter
    And User selects privacy policy
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates a duplicate account
    Given User navigates to Register Account page
    When User enters the details into below fields
      | firstname | Arun                   |
      | lastname  | Motoori                |
      | email     | amotooricap9@gmail.com |
      | telephone |             1234567890 |
      | password  |                  12345 |
    And User selects Yes for Newsletter
    And User selects privacy policy
    And User clicks on continue button
    Then User account should get proper warning message about duplicate email

  Scenario: User create an account without filling any details
    Given User navigates to Register Account page
    When User do not enters details into any fields
    And User clicks on continue button
    Then User should get proper warning messages for every mandatory fields
