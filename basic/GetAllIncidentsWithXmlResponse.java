package basic;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentsWithXmlResponse {

	public static void main(String[] args) {
		//		Step1: Get URl / Endpoint for the server
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
		//		Step2: Authentication
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
//		RestAssured.useRelaxedHTTPSValidation();
		//		Step3: Request type +query param + accept
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "number,sys_id,short_description")
				.queryParam("sysparm_limit", "20")
				.accept(ContentType.XML)
				.get();
		//		Step4: print Status code
		System.out.println(response.getStatusCode());		
		//		Step5: Print ContentType
		System.out.println(response.getContentType());
		//      Print Response body
//		response.prettyPrint();

		// need to parse as XML
		XmlPath xmlPath = response.xmlPath();
		//get all incident Number
		List<String> list = xmlPath.getList("response.result.sys_id");

		for (String eachItem : list) {
			System.out.println(eachItem);
		}

	}

}
