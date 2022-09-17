package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import resources.Utils;

public class ReqResValidation extends Utils {
	
	
	@Given("listUsers payload with queryParam key {string} and value {string}")
	public void listUserPayload(String key, String value) throws IOException {
		req.given().spec(requestSpecification()).queryParam(key, value);

	}
	

}
