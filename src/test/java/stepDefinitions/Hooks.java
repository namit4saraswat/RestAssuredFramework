package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;
import resources.Utils;

public class Hooks {

	@Before
	public void beforeScenario() throws IOException {
		Utils.requestSpecification();
	}
	

}
