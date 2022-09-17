package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utils;

public class PlaceValidation extends Utils {

	ResponseSpecification resspec;
	Response response;
	TestData obj = new TestData();

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {

		req.given().spec(requestSpecification()).body(obj.addPlacePayload(name, language, address));

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		if (method.equalsIgnoreCase("POST")) {
			req.when().post(APIResources.valueOf(resource).getResource().toString());
		}
		if (method.equalsIgnoreCase("GET")) {
			response =	RestAssured.given(req)
			.when()
				.get(APIResources.valueOf(resource).getResource().toString());
		}

	}

	@Then("the API returns {int} status code")
	public void the_api_returns_status_code(Integer statusCode) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in reponse is {string}")
	public void in_reponse_is(String key, String value) {
		assertEquals(getJSONPathValue(response, key), value);
	}

}
