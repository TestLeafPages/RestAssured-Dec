package params;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	public static void main(String[] args) {
//		Step1: Get URl / Endpoint for the server
		// ClassName.Method()/Variable;
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
//		Step2: Authentication
//		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
				
//		Step3: Request type
		Response response = RestAssured
				.given()
				.cookie("JSESSIONID", "8AECFE87E116C820ABD53492B6584254")
				.get()
				.then().assertThat()
//				.body(JsonSchemaValidator.matchesJsonSchema(new File("./GetIncident.json")))
				.extract().response();
//		Step4: print Status code
		System.out.println(response.getStatusCode());		
//		Step5: Print ContentType
		System.out.println(response.getContentType());
//      Print Response body
		response.prettyPrint();
		
		
		Map<String, String> cookies = response.getCookies();
		
		
		for (Entry<String, String> eachEntry : cookies.entrySet()) {
			System.out.println(eachEntry.getKey()+" : "+eachEntry.getValue());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
