Feature: Search Functionality 

Scenario: User searches for valid product
Given User enters the Aplication
When  User enters valid product "HP" into Search box filed
And 	User clicks on Search button
Then 	User should get a valid product displayed in search results

Scenario: User searches for invalid product
Given User enters the Aplication
When  User enters invalid product "Honda" into Search box filed
And 	User clicks on Search button
Then 	User should get a message about no product matching

Scenario: User searches with out any product
Given User enters the Aplication
When  User does not enter any product name  into Search box filed
And 	User clicks on Search button
Then 	User should get a message about no product matching

