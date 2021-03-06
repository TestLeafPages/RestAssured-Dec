package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsString {
	
	@Test
	public void createIncidentWithBodyAsString() {
		
//		Step1: Get URl / Endpoint for the server
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
//		Step2: Authentication
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
//		Step3: Request type + post + body
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\":\"Create Incident with Rest assured\",\"category\":\"Software\",\"state\": \"2\"}")
				.post();
//		Step4: print Status code
		System.out.println(response.getStatusCode());		
//		Step5: Print ContentType
		System.out.println(response.getContentType());
//      Print Response body
		response.prettyPrint();
		
		
		
	}

}
