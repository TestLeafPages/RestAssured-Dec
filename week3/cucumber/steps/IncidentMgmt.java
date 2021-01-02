package steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class IncidentMgmt {
	
	ValidatableResponse validatableResponse;

	@Given("setUp the endpoint")
	public void setEndpoint() {
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
	}
	
	@And("set authentication with valid credential")
	public void setAathentication() {
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
	}
	
	@When("user post the request")
	public void postRequest() {
		 validatableResponse = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post()
				.then()
				.assertThat();
	}
	
	@When("user post the request with body as (.*)$")
	public void postRequest(String fileName) {
		 validatableResponse = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(new File("./data/"+fileName+".json"))
				.post()
				.then()
				.assertThat();
	}
	
	@Then("verify the status code as {int}")
	public void verifyStatuCode(int code) {
		validatableResponse.statusCode(code);		
	}
	
	@And("verify the content type")
	public void verifyContentType() {
		validatableResponse.contentType(ContentType.JSON);
	}
}
