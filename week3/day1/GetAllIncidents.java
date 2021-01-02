package week3.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllIncidents {

	public static void main(String[] args) {
		//		Step1: Get URl / Endpoint for the server https://dev58903.service-now.com/
		RestAssured.baseURI = "https://dev58903.service-now.com/api/now/table/incident";
		//		Step2: Authentication
		RestAssured.authentication = RestAssured.basic("admin","KU2mZu2OPlvq");
		//		Step3: Request type
		Response response = RestAssured
				.get()
				.then()
				.assertThat()
				.statusCode(200)
				.extract().response();		



		//		Step4: print Status code
		System.out.println(response.getStatusCode());		
		//		Step5: Print ContentType
		System.out.println(response.getContentType());
		//      Print Response body
		response.prettyPrint();



	}

}
