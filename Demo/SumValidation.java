import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumOfCourses() {
		
		JsonPath js = new JsonPath(Payload.CoursePrice());
		int count  = js.getInt("courses.size()");
		int sumOfAllCourses = 0;

		for(int i = 0; i<count; i++) {
			int prices = js.getInt("courses["+i+"].price");
			int copies = js.get("courses["+i+"].copies");
			int costOfOneCourse = prices * copies;
			
			sumOfAllCourses += costOfOneCourse;
			
		}
		
		System.out.println(sumOfAllCourses);
		int purchaseAmount = js.get("dashboard.purchaseAmount");
		
		Assert.assertEquals(purchaseAmount, sumOfAllCourses);
	}
}
