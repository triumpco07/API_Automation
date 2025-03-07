import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String asile) {
		RestAssured.baseURI = "http://216.10.245.166";
		String Response = given().log().all()
			.header("Content-Type", "application/json")
			.body(Payload.addBookPayload(isbn , asile))
			.when()
				.post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(Response);
		String id = js.get("ID");
		System.out.println(id);
	}
	
	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		return new Object [][] {{"erfuih", "3454"} , {"ergg", "4532"}, {"srafqegf", "2534"}};
	}

}
