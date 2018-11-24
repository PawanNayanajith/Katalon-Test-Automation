package testPackage;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class BrokenLinks {
	
  public void RestAssuredGet() {
	  RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	  RequestSpecification req = RestAssured.given();
	  Response resp = req.request(Method.GET, "/jaffna");
			 
	  
	  String rbody = resp.getBody().asString();
	  System.out.println(rbody);
	  }
  
  public void secondTest() {
	  RestAssured.baseURI= "http://restapi.demoqa.com/customer";
	  RequestSpecification request = RestAssured.given();
	  JSONObject requestParams = new JSONObject();
	  requestParams.put("FirstName", "fname");//Cast
	  requestParams.put("LastName", "lname");
	  requestParams.put("UserName", "testuser");
	  requestParams.put("Password", "testpassword");
	  requestParams.put("Email", "test@gmail.com");
	  
	  //Add a header stating the request body is a JSOn
	  request.header("Content-Type","application/json");
	  //Add the Json to body of the request
	  request.body(requestParams.toJSONString());
	  //Post the request and check the response
	  Response response = request.post("/register");
	  
	  Integer statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, "200");
	  String successCode = response.jsonPath().get("SuccessCode");
	  Assert.assertEquals("Correct Success code was returned", successCode,"Operation Success");
  }

}

