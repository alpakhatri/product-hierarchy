Feature: Product Hierarchy

Scenario: Search for a product and check availability

Given A product name and its category

When I search the product name in that category 

Then I get the product with price back 


Scenario: Search for a product and check availability

Given A product name and its category

When I search the product name in that category 

Then I get the product with price back 



Scenario: Search price in a given category and get all the available products

Given A price and a category

When I search for price in that category

Then I get all the products a customer can buy in a given price



Scenario: Find a category and price of a product given a name

Given A product Name

When I search name across the categories

Then I get category and price of the product