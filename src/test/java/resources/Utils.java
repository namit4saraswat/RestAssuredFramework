package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {

		// For logging.txt not to append on previous log
		if (req == null) {
			PrintStream logs = new PrintStream(new FileOutputStream("logging.txt"));
			RestAssured.baseURI = getGlobalValue("baseURL");
			req = new RequestSpecBuilder().addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(logs))
					.addFilter(ResponseLoggingFilter.logResponseTo(logs)).setContentType(ContentType.JSON).build();

		}

		return req;
	}

	public String getGlobalValue(String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("C:\\Users\\namit\\eclipse-workspace\\APITests\\src\\test\\java\\resources\\global.properties")));

		return prop.get(key).toString();
	}
	
	public void getResourcePath() {
		
	}
	
	public String getJSONPathValue(Response response, String key) {
		JsonPath js = new JsonPath(response.asString());
		return js.get(key).toString();
	}

}
