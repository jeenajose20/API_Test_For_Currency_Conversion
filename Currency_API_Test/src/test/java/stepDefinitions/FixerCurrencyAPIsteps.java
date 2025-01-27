package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testCases.FixerAPITests;

public class FixerCurrencyAPIsteps {

	FixerAPITests fixer = new FixerAPITests();

	@Given("I have valid API key")
	public void i_have_valid_api_key() {

		String testmessage = "Retrieve conversion rate for multiple currencies";
		fixer.initializeServiceCallwithValidAPI(testmessage);
	}

	@When("I request conversion rates for {string}")
	public void i_request_conversion_rates_for(String symbols) {

		fixer.generateCurrencyConvertAPIcall(symbols);
	}

	@Then("the response status should be {int}")
	public void the_response_status_should_be(int expectedStatusCode) {

		fixer.currencyCoversionIsInvoked(expectedStatusCode);

	}

	@Then("the response should contain conversion rates for {string} and {string}")
	public void the_response_should_contain_conversion_rates_for_and(String currency1, String currency2) {

		fixer.validateResponsewithMultipleCurrencies(currency1, currency2);
	}

	@Given("I have a valid API key")
	public void i_have_a_valid_api_key() {

		String testmessage = "Retrieve conversion rate for single currencies";
		fixer.initializeServiceCallwithValidAPI(testmessage);
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int expectedStatusCode) {

		fixer.currencyCoversionIsInvoked(expectedStatusCode);
	}

	@Then("the response should contain {string} rate")
	public void the_response_should_contain_rate(String currency) {

		fixer.validateResponsewithSingleCurrency(currency);
	}

	@Given("I do not provide an API key")
	public void i_do_not_provide_an_api_key() {

		fixer.initializeServiceCallwithInvalidAPI();

	}

	@When("I request the conversion rates for {string}")
	public void i_request_the_conversion_rates_for(String symbols) {

		fixer.generateCurrencyConvertInvalidAPIcall(symbols);
	}

	@Then("the response should contain an error message {string}")
	public void the_response_should_contain_an_error_message(String expectedError) {

		fixer.validateInvalidAccesKeyErrorMessage(expectedError);
	}

	@Given("I have the valid API key")
	public void i_have_the_valid_api_key() {

		String testmessage = "Request for Valid API and Invalid symbols";
		fixer.initializeServiceCallwithValidAPI(testmessage);
	}

	@When("I request conversion rates for an {string}")
	public void i_request_conversion_rates_for_an(String symbols) {

		fixer.generateCurrencyConvertAPIcall(symbols);
	}

	@Then("the response should contain an error mentioning {string}")
	public void the_response_should_contain_an_error_mentioning(String expectedErrorField) {

		fixer.validateInvalidSymbolsErrorMessage(expectedErrorField);
	}

}

