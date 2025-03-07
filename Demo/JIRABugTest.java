import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JIRABugTest {
	@Test
	public void BugTest() {
		
		RestAssured.baseURI = "https://tussarupadhyay00.atlassian.net";
		
		String CreateIssue = given()
		.header("Content-Type", "application/json")
		.header("Authorization", "Basic dHVzc2FydXBhZGh5YXkwMEBnbWFpbC5jb206QVRBVFQzeEZmR0YwTHV0SHRpbmxRYmtfSmpMZkxuMXdGZHBQR3RMSkl5c2s4clNsTWxoR250cFJndW5CT2EwZ1J4aDd2aXlaYzdYc0FWaXJYUHZ1dTlFSkRfZ2hXNEVUa19HSDZQZmtwVk1OVWRFRHBwdThiX0ZENWFPS05kcXJDc0s4cFktTV9od091dE1VbVM2R2VtYUVremF2eUp6ZTRldlZEY0NxZ19wRVlFM2dsWk5jdkNvPTM1NkVGRUI3")
		.body(Payload.JIRAPayload()).log().all()
		
		.when().post("/rest/api/3/issue")
		
		.then().log().all().assertThat().statusCode(201)
		.extract().response().asString();
		
		JsonPath js = new JsonPath(CreateIssue);
		String issueId = js.getString("id");
		
		System.out.println(issueId);
		
		//Add Attachment
		
		given()
			.header("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>").pathParam("key", issueId)
			.header("X-Atlassian-Token", "no-check")
			.header("Authorization", "Basic dHVzc2FydXBhZGh5YXkwMEBnbWFpbC5jb206QVRBVFQzeEZmR0YwTHV0SHRpbmxRYmtfSmpMZkxuMXdGZHBQR3RMSkl5c2s4clNsTWxoR250cFJndW5CT2EwZ1J4aDd2aXlaYzdYc0FWaXJYUHZ1dTlFSkRfZ2hXNEVUa19HSDZQZmtwVk1OVWRFRHBwdThiX0ZENWFPS05kcXJDc0s4cFktTV9od091dE1VbVM2R2VtYUVremF2eUp6ZTRldlZEY0NxZ19wRVlFM2dsWk5jdkNvPTM1NkVGRUI3")
			.multiPart("file", new File("/Users/user/Downloads/20250130_120428 (1).jpg")).log().all()
			
		.when().post("rest/api/3/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);
		
	}
}
