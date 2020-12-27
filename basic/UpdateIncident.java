package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident {
	
	@Test
	public void deleteIncidents() {
//		Step1: Get URl / Endpoint for the server
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/";
//		Step2: Authentication
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
//		Step3: Request type
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.pathParams("sysId", "4946dcd6079d20101945f2ae7c1ed080")
				.body("{\"short_description\":\"update Incident with Rest Assured\"}")
				.put("incident/{sysId}");
		
//		Step4: print Status code
		System.out.println(response.getStatusCode());		
//		Step5: Print ContentType
		System.out.println(response.getContentType());
//      Print Response body
		response.prettyPrint();
		
		
		
	}

}
