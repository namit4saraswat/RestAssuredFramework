package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utils;

public class PlaceValidation extends Utils {

	RequestSpecification reqspec;
	ResponseSpecification resspec;
	Response response;
	TestData obj = new TestData();

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		reqspec = given().spec(requestSpecification()).body(obj.addPlacePayload(name, language, address));

	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions
		resspec = new ResponseSpecBuilder().expectStatusCode(200).build();
		if (method.equalsIgnoreCase("POST")) {
			reqspec.when().post(APIResources.valueOf(resource).toString());
		}
		if (method.equalsIgnoreCase("GET")) {
			reqspec.when().get(APIResources.valueOf(resource).toString());
		}

	}

	@Then("the API returns {int} status code")
	public void the_api_returns_status_code(Integer statusCode) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in reponse is {string}")
	public void in_reponse_is(String key, String value) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(getJSONPathValue(response, key), value);

	}

}
