package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncidents extends BaseRequest{
	
	@Test(dependsOnMethods ="chaining.CreateIncidentWithoutBody.createIncidentWithoutBody")
	public void deleteIncidents() {
	
//		Step1: Get URl / Endpoint for the server
		// ClassName.Method()/Variable;
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
//		Step2: Authentication
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
//		Step3: Request type
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.delete(sys_id);
//		Step4: print Status code
		System.out.println(response.getStatusCode());		
//		Step5: Print ContentType
		System.out.println(response.getContentType());
//      Print Response body
		response.prettyPrint();
		
		
		
	}

}
