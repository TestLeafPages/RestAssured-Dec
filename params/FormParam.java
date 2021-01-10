package params;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FormParam {
	
	@Test
	public void loginLeaftaps() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "http://leaftaps.com/opentaps/control";
		RestAssured.urlEncodingEnabled = false;
		// Step 2: Request type - Post + form param
		Response post = RestAssured
			.given()
//			.contentType(ContentType.URLENC)
			.when()
			.formParam("USERNAME", "DemoCSR2")
			.formParam("PASSWORD", "crmsfa")
			.post();
			
		post.prettyPrint();
		
	}
	

}
