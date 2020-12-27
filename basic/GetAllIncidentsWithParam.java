package basic;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentsWithParam {

	public static void main(String[] args) {
		//		Step1: Get URl / Endpoint for the server
		// ClassName.Method()/Variable;
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
		//		Step2: Authentication
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
		//		Step3: Request type +query param
		Response response = RestAssured
				.given()
//				.queryParam("sysparm_fields", "number,sys_id,short_description")
//				.queryParam("sysparm_limit", "20")
				.get();
		//		Step4: print Status code
		System.out.println(response.getStatusCode());		
		//		Step5: Print ContentType
		System.out.println(response.getContentType());
		//      Print Response body
		//response.prettyPrint();

		// need to parse as json
		JsonPath jsonResponse = response.jsonPath();
		//get all incident Number
//		jsonResponse.get(path) -> to get first matching incident Number
		List<String> list = jsonResponse.getList("result.number");
		//forech -> list,set,array and map
		//for (    temp_variable    : collection object)
		for (String eachItem : list) {
			System.out.println(eachItem);
		}

	}

}
