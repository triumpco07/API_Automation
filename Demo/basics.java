import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import files.Payload;

import static io.restassured.RestAssured.*;


public class basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Validate to AddPlace  API  is working as expected
		
		//given when then
		
		//given -- All input details
		//when -- Submit the API -- resource and http method
		//then -- Validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given()
			.log().all()
			.queryParam("key", "qaclick123")
			.header("Content-Type", "application/json")
			.body(Payload.AddPlace())
			
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
			.body("scope", equalTo("APP"))
			.header("Server", "Apache/2.4.52 (Ubuntu)");
		
		
		//Add Place -> Update  Place  with New Address -> Get Place to Validate  if New  Address  is present in response  
			
			
		
	}

}
