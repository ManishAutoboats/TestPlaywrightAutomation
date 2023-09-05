package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resource.TestDataPayload;

import static io.restassured.RestAssured.*;

import org.junit.Assert;

import helper.Base;

public class GooglePlaceSteps {
	RequestSpecification req;
	Response res;
	TestDataPayload p= new TestDataPayload();
	
	@Given("user prepare a request with Payload")
	public void user_prepare_a_request_with_payload() {
	 req=given().log().all().spec(Base.setup())
	   .body(p.dataPayload());
	}
	
	@When("user send the {string} request")
	public void user_send_the_request(String method) {
		if(method.equals("POST")) {
		 res= req.post("maps/api/place/add/json");
	} else if(method.equals("GET")) {
		 res= req.post("maps/api/place/get/json");
	}
	}

	@When("user send the POST request")
	public void user_send_the_post_request() {
	 res= req.post("maps/api/place/add/json");
	}

	@Then("user get status code is {string}")
	public void user_get_status_code_is(String statusCode) {
		int actualCode=res.getStatusCode();
		Assert.assertEquals(String.valueOf(actualCode),statusCode);
	   
	}
	
	@Then("validate {string} value is {string}")
	public void validate_value_is(String key, String expectedValue) {
		String response= res.asString();
		JsonPath js= new JsonPath(response);
		String actualvalue=js.getString(key);
		Assert.assertEquals(actualvalue,expectedValue);
	}



}
