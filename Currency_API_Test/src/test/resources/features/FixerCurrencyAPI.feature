Feature: Currency API testing
As a user I want to validate the currency conversion rates using Fixer.io API

Scenario: Retreieve conversion rate for multiple currencies.

	Given I have valid API key
	When I request conversion rates for "USD,DKK"
	Then the response status should be 200
	And the response should contain conversion rates for "USD" and "DKK"


Scenario: Retrieve conversion rate for a single currency
    Given I have a valid API key
    When I request conversion rates for "USD"
    Then the response status code should be 200
    And the response should contain "USD" rate
    
Scenario: Request without an API key
    Given I do not provide an API key
    When I request the conversion rates for "USD"
    Then the response error code should be 101
    And the response should contain an error message "false"
    
Scenario: Request with invalid symbols
    Given I have the valid API key
    When I request conversion rates for an "INVALID_CURRENCY"
    Then the response error code should be 202
    And the response should contain an error mentioning "false"