package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	public static void main(String[] args) {
//		Step1: Get URl / Endpoint for the server
		// ClassName.Method()/Variable;
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
//		Step2: Authentication
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
//		Step3: Request type
		Response response = RestAssured.get();//ctrl+2,l
//		Step4: print Status code
		System.out.println(response.getStatusCode());		
//		Step5: Print ContentType
		System.out.println(response.getContentType());
//      Print Response body
		response.prettyPrint();
		
		
		
	}

}
