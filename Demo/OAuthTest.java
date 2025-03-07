import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class OAuthTest {

	@Test
	
	public static void OAuth() {
		
		String response = given()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String token = js.getString("access_token");
		
		
		String response2 = given()
			.queryParam("access_token", token)
		.when().log().all()
			.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
		
		System.out.println(response2);
		
	}
	


}
