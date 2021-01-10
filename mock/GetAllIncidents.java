package mock;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	public static void main(String[] args) {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
		Response response = RestAssured
				.given()
				.queryParam("sysparm_limit", "1")
				.get()
				.then().assertThat()
				.extract().response();
		System.out.println(response.getStatusCode());		
		System.out.println(response.getContentType());
		response.prettyPrint();
		
		
		
	}

}
