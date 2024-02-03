package nikGorestwithjava;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse2 {
	public static void main(String[] args) throws IOException {
		int createuserid;

		HashMap<String, Object> create = new HashMap();

		// {"name":"ram", "gender":"male", "email":"rampal@pal", "status":"active"}

		// data carete kela post kela ki postman madhe javun
		// delete karacha nahi tar hash map madhe request body change karav lagel every
		// time . same data nahi post karu shakat

		create.put("name", "sham");
		create.put("email", "ra@pal");
		create.put("gender", "Male");
		create.put("status", "active");

		System.out.println("----------post request-----------------------------------------");
		RestAssured.baseURI = "https://gorest.co.in";
		// post request
		Response jp = given().log().all().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 056278d6c3665daac1d6de4e265003df80fad5c1491e34f2ff39fc8b31b390d7")
				.pathParams("path1", "users").body("active").when().post("public/v2/{path1}").then().log().all()
				.extract().response();
		System.out.println("this is responce body "+jp.asPrettyString());
		System.out.println(jp.getStatusCode());
		String athith =jp.getHeader("Bearer");
		System.out.println(athith);
		
	
 

		

		System.out.println("-------------GetRequest-------------------------------------------------");
		// get request
		Response res = given().log().all().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 056278d6c3665daac1d6de4e265003df80fad5c1491e34f2ff39fc8b31b390d7")
				.pathParams("path1", "users").when().get("public/v2/{path1}")
				.then().log().all().extract().response();
		
		System.out.println("this is responce body "+res.asPrettyString());
		System.out.println(res.getStatusCode());
		
		
		
		
		

		System.out.println("-------------Delete Request-------------------------------------------------");
		// get request
		given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 056278d6c3665daac1d6de4e265003df80fad5c1491e34f2ff39fc8b31b390d7")
				.pathParams("path1", "users").when()
				.delete("public/v2/{path1}").then().log().all();

		System.out.println("----------put request-----------------------------------------");
		
		RestAssured.baseURI = "https://gorest.co.in";
		// post request
		given().log().all().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 056278d6c3665daac1d6de4e265003df80fad5c1491e34f2ff39fc8b31b390d7")
				.pathParams("path1", "users").body("Active").when()
				.put("public/v2/{path1}").then().log().all().extract().response().jsonPath();

	}

}

