import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(Payload.CoursePrice());
		
		//Print No. of courses
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//Print Purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		//Print Title of the first course
		
		String titleFirstCourse = js.get("courses[2].title");
		System.out.println(titleFirstCourse);
		
		//Print All course titles and their respective Prices
		for(int i = 0; i<count; i++) {
			String courseTitles = js.get("courses["+i+"].title");
			int coursePrice = js.get("courses["+i+"].price");
			
			System.out.println(courseTitles);
			System.out.println(coursePrice);
			
		}
		
		
		//Print no of copies sold by RPA Course
//		int copiesSoldByRPA = js.get("courses[2].copies");
//		System.out.println(copiesSoldByRPA);
		
		for(int i = 0; i<count; i++) {
			String courseTitles = js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA")) {
				int copiesSoldByRPA = js.get("courses["+i+"].copies");
				System.out.println(copiesSoldByRPA);
				break;
			}
				
		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		
		
		
		
		
		
		
	}

}
