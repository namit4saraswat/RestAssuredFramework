package stepDefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.Utils;

public class Common extends Utils {

	ResponseSpecification resspec;
	Response response;

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		if (method.equalsIgnoreCase("POST")) {
			response = RestAssured.given(req).when().post(APIResources.valueOf(resource).getResource().toString());
		}
		if (method.equalsIgnoreCase("GET")) {
			response = RestAssured.given(req).when().get(APIResources.valueOf(resource).getResource().toString());
		}
		if(method.equalsIgnoreCase("PUT")) {
			response = RestAssured.given(req).when().put(APIResources.valueOf(resource).getResource().toString());
		}

	}

	@Then("the API returns {int} status code")
	public void the_api_returns_status_code(int statusCode) {
		assertEquals(response.getStatusCode(), statusCode);
	}

	@Then("{string} in reponse is {string}")
	public void in_reponse_is(String key, String value) {
		assertEquals(getJSONPathValue(response, key), value);
	}

}
