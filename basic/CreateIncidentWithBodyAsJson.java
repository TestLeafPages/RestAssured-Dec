package basic;

import java.io.File;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsJson {
	
	@DataProvider(name = "fetchData")
	public String[] getData() {
		// String[] -> file path 
		String[] allFile = new String[2];
		allFile[0] = "./data/incident1.json";
		allFile[1] = "./data/incident2.json";
		return allFile;
	}
	
	@Test(dataProvider = "fetchData")
	public void createIncidentWithBodyAsJson(String filePath) {
//		Step1: Get URl / Endpoint for the server
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
//		Step2: Authentication
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
//		Step3: Request type + post + body
		File file = new File(filePath);
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(file)
				.post();
//		Step4: print Status code
		System.out.println(response.getStatusCode());		
//		Step5: Print ContentType
		System.out.println(response.getContentType());
//      Print Response body
		response.prettyPrint();
		
		
		
	}

}
