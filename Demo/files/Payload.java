package files;

public class Payload {

		// TODO Auto-generated method stub
		public static String AddPlace() {
			
			return "{\r\n"
					+ "  \"location\": {\r\n"
					+ "    \"lat\": -38.383494,\r\n"
					+ "    \"lng\": 33.427362\r\n"
					+ "  },\r\n"
					+ "  \"accuracy\": 50,\r\n"
					+ "  \"name\": \"Tussar Upadhyay\",\r\n"
					+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
					+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
					+ "  \"types\": [\r\n"
					+ "    \"shoe park\",\r\n"
					+ "    \"shop\"\r\n"
					+ "  ],\r\n"
					+ "  \"website\": \"http://google.com\",\r\n"
					+ "  \"language\": \"French-IN\"\r\n"
					+ "}\r\n"
					+ "";
		}
		
		
		public static String CoursePrice() {
			
			return "{\r\n"
					+ "\r\n"
					+ "\"dashboard\": {\r\n"
					+ "\r\n"
					+ "\"purchaseAmount\": 910,\r\n"
					+ "\r\n"
					+ "\"website\": \"rahulshettyacademy.com\"\r\n"
					+ "\r\n"
					+ "},\r\n"
					+ "\r\n"
					+ "\"courses\": [\r\n"
					+ "\r\n"
					+ "{\r\n"
					+ "\r\n"
					+ "\"title\": \"Selenium Python\",\r\n"
					+ "\r\n"
					+ "\"price\": 50,\r\n"
					+ "\r\n"
					+ "\"copies\": 6\r\n"
					+ "\r\n"
					+ "},\r\n"
					+ "\r\n"
					+ "{\r\n"
					+ "\r\n"
					+ "\"title\": \"Cypress\",\r\n"
					+ "\r\n"
					+ "\"price\": 40,\r\n"
					+ "\r\n"
					+ "\"copies\": 4\r\n"
					+ "\r\n"
					+ "},\r\n"
					+ "\r\n"
					+ "{\r\n"
					+ "\r\n"
					+ "\"title\": \"RPA\",\r\n"
					+ "\r\n"
					+ "\"price\": 45,\r\n"
					+ "\r\n"
					+ "\"copies\": 10\r\n"
					+ "\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "]\r\n"
					+ "\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "";
		}
		
		public static String addBookPayload(String asile, String isbn) {
			
			String Payload = "{\r\n"
					+ "\r\n"
					+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
					+ "\"isbn\":\""+isbn+"\",\r\n"
					+ "\"aisle\":\""+asile+"\",\r\n"
					+ "\"author\":\"John foe\"\r\n"
					+ "}\r\n"
					+ "";
			
			return Payload;
		}
		
		
		public static String JIRAPayload() {
			String Payload = "{\r\n"
					+ "    \"fields\": {\r\n"
					+ "        \"project\": {\r\n"
					+ "            \"key\": \"SCRUM\"\r\n"
					+ "        },\r\n"
					+ "        \"summary\": \"Website items are not-working automation rest assured\",\r\n"
					+ "        \"description\": {\r\n"
					+ "            \"type\": \"doc\",\r\n"
					+ "            \"version\": 1,\r\n"
					+ "            \"content\": [\r\n"
					+ "                {\r\n"
					+ "                    \"type\": \"paragraph\",\r\n"
					+ "                    \"content\": [\r\n"
					+ "                        {\r\n"
					+ "                            \"type\": \"text\",\r\n"
					+ "                            \"text\": \"Creating an issue using project keys and issue type names via the REST API.\"\r\n"
					+ "                        }\r\n"
					+ "                    ]\r\n"
					+ "                }\r\n"
					+ "            ]\r\n"
					+ "        },\r\n"
					+ "        \"issuetype\": {\r\n"
					+ "            \"name\": \"Bug\"\r\n"
					+ "        }\r\n"
					+ "    }\r\n"
					+ "}\r\n"
					+ "";
			
			return Payload;
		}

}
