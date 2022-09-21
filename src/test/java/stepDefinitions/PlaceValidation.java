package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import resources.Utils;

public class PlaceValidation extends Utils {

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
		req.given().spec(requestSpecification()).body(objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(obj.addPlacePayload(name, language, address)));
	}

}
