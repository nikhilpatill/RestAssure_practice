package nikGorestwithjava;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
//https://reqres.in/api/users/2

	@Test
	public void getmethod() {
		Response repo = given().contentType("application/Json")

				.when().get("https//reqres.in/api/users page=2")

				.then().log().all().extract().response();

		JsonPath js = new JsonPath(repo.asPrettyString());

		String name = js.getString("data.name");

		System.out.println(name);

	}

	@Test(enabled = false)
	public void GetSingleUser() {
		// specify base URL
		baseURI = "https://reqres.in/api/users/19";

		// Get Request specifcation of the request
		RequestSpecification requestSpec = given();

		// call get method
		Response response = requestSpec.get();

		// gets response code
		int statusCode = response.getStatusCode();

		// validate actual status code with expected

		// Assert.assertEquals(statusCode/*actual status code*/,200/*expected status
		// code*/,"incorrect status code received");

		String statusLine = response.getStatusLine();

		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "incorrect status line returned");

	}

	@Test(enabled = false)
	public void GetSingleUserUsingValidatableResponse() {
		// specify base URL
		baseURI = "https://reqres.in/api/users/19";

		// Get Request specifcation of the request
		RequestSpecification requestSpec = given();

		// call get method
		Response response = requestSpec.get();

		ValidatableResponse validateRes = response.then();

		// status code
		// validateRes.statusCode(200);

		// System.out.println("second validation");
		// status line
		validateRes.statusLine("HTTP/1.1 200 OK");

	}

	@Test
	public void practice() {
		SoftAssert act = new SoftAssert();

		Response respo = given().contentType("application/json").when().get("https://reqres.in/api/users?page=2").then()
				.log().all().extract().response();

		String actual = respo.header("server");
		System.out.println("actual states " + actual);

		act.assertEquals(actual, "cloudflare");
		act.assertAll();
	}

	@Test
	public void GetSingleUser_BDDStyle() {
		given()

				.when().get("https://reqres.in/api/users/2")

				.then().statusCode(200).statusLine("HTTP/1.1 200 OK");
	}

}
