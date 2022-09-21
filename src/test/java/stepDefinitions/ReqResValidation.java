package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import resources.Utils;

public class ReqResValidation extends Utils {

	@Given("request with queryParam key {string} and value {string}")
	public void listUserPayload(String key, String value) throws IOException {
		req.given().spec(requestSpecification()).queryParam(key, value);

	}

	@Given("createUser payload with {string} and {string}")
	public void createUser(String name, String job) throws IOException {
		req.given().spec(requestSpecification()).body(
				objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj.createUserPayload(name, job)));
	}

}
