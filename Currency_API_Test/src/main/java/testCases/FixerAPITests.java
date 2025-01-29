package testCases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ConfigUtil;
import utils.ExtentReportManager;

public class FixerAPITests {

	private String accessKey;
	private Response response;
	private ExtentTest test;

	public void initializeServiceCallwithValidAPI(String testmessage) {

		test = ExtentReportManager.createTest(testmessage);
		accessKey = ConfigUtil.get("access_key");
		test.info("Access Key: " + accessKey);
		if (accessKey.isEmpty()) {
			boolean b = accessKey.isEmpty();
			test.fail("Access key is not supplied");
			Assert.assertTrue(b, "Access key is not supplied");

		} else {
			test.pass("Valid access key" + accessKey);
			Assert.assertNotNull(accessKey, "API key should not be null");
		}

		Assert.assertNotNull(accessKey, "API key should not be null");
	}

	public void generateCurrencyConvertAPIcall(String symbols) {

		RestAssured.baseURI = ConfigUtil.get("base.url");
		if (accessKey.isEmpty()) {
			response = given().queryParam("symbols", symbols).when().get();
			test.fail("Access key is not supplied");
		} else {
			response = given().queryParam("access_key", accessKey).queryParam("symbols", symbols).when().get();
			test.pass("Request sent successfully");
		}
		test.info("Response code:" + response.asString());

	}

	public void currencyCoversionIsInvoked(int expectedStatusCode) {
		test.info("Actual Status code:" + response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code should match");
		test.pass("Status code genereated successfully");
	}

	public void validateResponsewithMultipleCurrencies(String currency1, String currency2) {

		test.info("Rate for " + currency1 + " is " + response.jsonPath().getString("rates." + currency1));
		test.info("Rate for " + currency2 + " is " + response.jsonPath().getString("rates." + currency2));
		Assert.assertNotNull("Rate for " + currency1 + " should be present",
				response.jsonPath().getString("rates." + currency1));
		Assert.assertNotNull("Rate for " + currency2 + " should be present",
				response.jsonPath().getString("rates." + currency2));
		test.pass("Conversion rates generated successfully");

	}

	public void validateResponsewithSingleCurrency(String currency) {
		test.info("Rate for " + currency + " is " + response.jsonPath().getString("rates." + currency));
		Assert.assertNotNull("Rate for " + currency + " should be present",
				response.jsonPath().getString("rates." + currency));
		test.pass("Conversion rates generated successfully");
	}

	public void initializeServiceCallwithInvalidAPI() {
		test = ExtentReportManager.createTest("Request without an API key");
		accessKey = "";
		if (accessKey.isEmpty()) {
			boolean b = accessKey.isEmpty();
			test.info("Acces key is not supplied");
			Assert.assertTrue(b, "Acces key is not supplied");

		} else {
			test.info("Access key is supplied:" + accessKey);
			Assert.assertTrue(false, "Acces key is supplied");
		}
	}

	public void generateCurrencyConvertInvalidAPIcall(String symbols) {
		RestAssured.baseURI = ConfigUtil.get("base.url");
		if (accessKey.isEmpty()) {
			response = given().queryParam("symbols", symbols).when().get();
			test.pass("Request sent without Access key");
		} else {
			response = given().queryParam("access_key", accessKey).queryParam("symbols", symbols).when().get();
			test.fail("Request sent successfully");
		}
		test.info("Response code:" + response.asString());
	}

	public void validateInvalidKeyErrorcode(int errorCode) {
		test.info("Error code:" + response.jsonPath().getInt("error.code"));
		Assert.assertEquals(response.jsonPath().getInt("error.code"), errorCode, "Error code should match");
	}

	public void validateInvalidAccesKeyErrorMessage(String expectedError) {
		test.info("Expected Error: " + expectedError);
		test.info("Error message: " + response.jsonPath().getString("error.info"));
		Assert.assertTrue(response.asString().contains(expectedError),
				"Error message should contain: " + expectedError);
		test.pass("Error message generated succesfully");
	}

	public void validateInvalidSymbolsErrorMessage(String expectedErrorField) {
		test.info("Response " + response.asString());
		Assert.assertTrue(response.asString().contains(expectedErrorField),
				"Error message should mention: " + expectedErrorField);
		test.info("Error message: " + response.jsonPath().getString("error.info"));
		test.pass("Error message generated succesfully");
	}

}
