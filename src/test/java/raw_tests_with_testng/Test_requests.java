package raw_tests_with_testng;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.matcher.*;
import io.restassured.response.Response;


public class Test_requests {

	/* 
	 * ### Test 1. given() get() then() statusCode(int)
	 */
	@Test
	public void test1() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(200);
	}

	
	/*
	 * ### Test 2. given() get() then() statusCode(Matcher) 
	 */
	@Test
	public void test2() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().statusCode(equalTo(200));
	}

	/*
	 *  ### Test 3. given() get() then() assertThat() statusCode()
	 */
	@Test
	public void test3() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().assertThat().statusCode(200);
	}

	/*
	 *  ### Test 4. given() get() then() body() containsString()
	 */
	@Test
	public void test4() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation"));
	}

	/*
	 *  ### Test 5. given() get() then() root() body(String�path,ResponseAwareMatcher<R>�responseAwareMatcher)
	 */
	@Test
	public void test5() {

		/*
		 * For Content-Type=application/json
		 * for java v1.7 or less we use ResponseAwareMatchers
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().body("lname",
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("girdher");
					}
				});

		/*
		 * For Content-Type=application/json
		 * for java v1.8 we use lambda expressions
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().body("lname",
				response -> equalTo("girdher"));
		
		
		
		/*
		 * For Content-Type=application/xml
		 * for java v1.7 or less we use ResponseAwareMatchers
		 */
		given().get("http://localhost:3000/get_200_OK_SimpleXML_Response").then().root("root").body("lname",
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("girdher");
					}
				});
		
		/*
		 * For Content-Type=application/xml
		 * for java v1.8 we use lambda expressions
		 */
		given().get("http://localhost:3000/get_200_OK_SimpleXML_Response").then().root("root").body("lname",
				response -> equalTo("girdher"));
		
	}

	/*
	 *  ### Test 6. given() get() then() body(List<Argument>�arguments,ResponseAwareMatcher<R>�responseAwareMatcher)
	 */
	@Test
	public void test6() {
		
		/*
		 * For Content-Type=application/xml
		 * for java v1.7 or less we use ResponseAwareMatchers
		 */
		given().get("http://localhost:3000/get_200_OK_SimpleXML_Response").then().root("root.%s").body(withArgs("lname"),
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("girdher");
					}
				});		
		
		/*
		 * For Content-Type=application/json
		 * for java v1.7 or less we use ResponseAwareMatchers
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().root("%s").body(withArgs("lname"),
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("girdher");
					}
				});
		
		/*
		 * For Content-Type=application/json
		 * for java v1.8 we use lambda expressions
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().root("%s").body(withArgs("lname"),
				response -> equalTo("girdher"));
		
		/*
		 * For Content-Type=application/xml
		 * for java v1.8 we use lambda expressions
		 */
		given().get("http://localhost:3000/get_200_OK_SimpleXML_Response").then().root("root.%s").body(withArgs("lname"),
				response -> equalTo("girdher"));

	}

	/*
	 *  ### Test 7. given() get() then() body(String�path,List<Argument>�arguments, ResponseAwareMatcher<R>�responseAwareMatcher)
	 */
	@Test
	public void test7() {
		/*
		 * For Content-Type=application/json
		 * for java v1.7 or less we use ResponseAwareMatchers
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().body("website%s", withArgs("1"),
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("https://extremeExcel.com");
					}
				});		
	
		/*
		 * For Content-Type=application/json
		 * for java v1.8 we use lambda expressions
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().body("website%s",withArgs("1"),
				response -> equalTo("https://extremeExcel.com"));
		
	}

	/*
	 *  ### Test 8. given() get() then() assertThat() body(List<Argument>�arguments,
	 *  org.hamcrest.Matcher�matcher, Object...�additionalKeyMatcherPairs)
	 */
	@Test
	public void test8() {
		//unable to find usage of Object(3rd argument)
	}

	/*
	 *  ### Test 9. given() get() then()  body(String�path,
	 *  List<Argument>�arguments,org.hamcrest.Matcher�matcher,
	 *  Object...�additionalKeyMatcherPairs)
	 */
	@Test
	public void test9() {
		//Unable to to find usage of Object (4th argument)
	}

	/*
	 *  ### Test 10. given() get() then() body(String�path,
	 *  org.hamcrest.Matcher�matcher, Object...�additionalKeyMatcherPairs)
	 */
	@Test
	public void test10() {
		//Unable to to find usage of Object (3rd argument)
	}

	
	/*
	 *  ### Test 11. given() get() then() assertThat() body() containsString() and()
	 */
	@Test
	public void test11() {
		given().get("http://localhost:3000/get_200_OK_SIMPLE_BODY_MESSAGE").then().body(containsString("Operation"))
				.and().body(containsString("Successful"));
	}

	/*
	 *  ### Test 12. given() get() then() content()
	 */
	@Test
	public void test12() {
		/*
		 * For Content-Type=application/json
		 * for java v1.7 or less we use ResponseAwareMatchers
		 * 
		 * For now I see no difference in .body() and .content(). If you have answer, please
		 * reply on stackoverflow https://stackoverflow.com/questions/56408253/difference-between-restassured-body-and-content
		 */
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().content("website%s", withArgs("1"),
				new ResponseAwareMatcher<Response>() {
					public Matcher<?> matcher(Response response) {
						return equalTo("https://extremeExcel.com");
					}
				});		
	
	}

	/*
	 *  ### Test 13. given() get() then() contentType()
	 */
	@Test
	public void test13() {
		
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().contentType(equalTo("application/json; charset=utf-8"));
		
		given().get("http://localhost:3000/get_200_OK_SingleNode_Response").then().contentType("application/json; charset=utf-8");
	}


	/*
	 *  ### Test 14. given() get() then() Cookies [ getDetailedCookies(), get() , getValue()]  
	 */
	@Test
	public void test14() {
		
		Cookies allCookies = get("https://www.stackoverflow.com").getDetailedCookies();

		Cookie myCookie = allCookies.get("prov");
		
		System.out.println("Cookie value is : " + myCookie.getValue());
		
	}

	
}
