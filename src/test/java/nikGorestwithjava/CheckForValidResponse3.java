package nikGorestwithjava;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse3 {
	public static void main(String[] args) throws IOException {
		int createuserid;

		
		SoftAssert act =new SoftAssert();
		HashMap data =new HashMap();
		data.put("name", "kkk");
		data.put("job", "zion jjj");
		
		JsonPath js=given().contentType("application/json").body(data).log().all()
		.when().put("https://reqres.in/api/users/").
		
		then().extract().response().jsonPath();
			
		
	
		System.out.println("-----"+js.getString("name"));
		System.out.println("-----"+js.getString("job"));
		
		act.assertTrue(js.getString("name").equals("morpheus"));
		act.assertTrue(js.getString("job").equals("zion resident"));
		
		
	
	
	}
}
