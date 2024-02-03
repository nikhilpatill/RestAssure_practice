package session03;

import static io.restassured.RestAssured.*;

import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import junit.framework.Assert;

public class practice {
	
	public void ptactive1()
	{
		SoftAssert act =new SoftAssert ();

		Response respo=	given().contentType("application/json")
		.when().get("https://reqres.in/api/users?page=2")
		.then().log().all().extract().response();
		
		
		  String actual = respo.header("server");
		  System.out.println("actual states "+actual);
		  
		  act.assertEquals(actual, "cloudflare"); act.assertAll();
	}

}
