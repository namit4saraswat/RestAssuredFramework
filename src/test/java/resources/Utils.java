package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	protected TestData obj = new TestData();
	protected ObjectMapper objectMapper = new ObjectMapper();

	public static RequestSpecification requestSpecification() throws IOException {
		// For logging.txt not to append on previous log
		if (req == null) {
			PrintStream logs = new PrintStream(new FileOutputStream("logging.txt"));
			RestAssured.baseURI = getGlobalValue("baseURL");
			req = new RequestSpecBuilder().addFilter(RequestLoggingFilter.logRequestTo(logs))
					.addFilter(ResponseLoggingFilter.logResponseTo(logs)).setContentType(ContentType.JSON).build();

		}

		return req;
	}

	public static String getGlobalValue(String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File(
				"C:\\Users\\namit\\eclipse-workspace\\APITests\\global.properties")));

		return prop.get(key).toString();
	}

	public String getJSONPathValue(Response response, String key) {
		JsonPath js = new JsonPath(response.asString());
		return js.get(key).toString();
	}
	
	public static String getResourcePath(String file) {
		Resource resource = new ClassPathResource(file);
		try {
			return resource.getFile().getAbsolutePath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
