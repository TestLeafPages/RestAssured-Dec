package week3.day1;

import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithoutBody {
	
	public static void main(String[] args) {
//		Step1: Get URl / Endpoint for the server
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
//		Step2: Authentication
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
//		Step3: Request type 
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post()
				.then()
				.assertThat()
				.statusCode(201)
				.contentType(ContentType.JSON)
				.extract().response()
				;
//		Step4: print Status code
		System.out.println(response.getStatusCode());		
//		Step5: Print ContentType
		System.out.println(response.getContentType());
//      Print Response body
		response.prettyPrint();
		
		
		
	}

}
