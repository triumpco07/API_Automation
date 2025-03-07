import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ChainingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Add Place -> Update  Place  with New Address -> Get Place to Validate  if New  Address  is present in response  
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Add Place
		String Response = given()
		
			.queryParam("key", "qaclick123")
			.header("Content-Type", "application/json")
			.body(Payload.AddPlace())
			
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200)
			.body("scope", equalTo("APP"))
			.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(Response);
		
		JsonPath js = new JsonPath(Response);  //for parsing JSON
		
		String placeId = js.getString("place_id");
		
		System.out.println(placeId);
		
		//Update Place
		String newAddress = "Ward no. 2, gali no 5, Adarsh Vihar, Herbertpur";
		
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		
		
		//Get Place
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id" , placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1 = ReUsableMethods.rawToJson(getPlaceResponse);  //for parsing JSON
		
		String actualAddress = js1.getString("address");
		
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);
		
		
	}

}
