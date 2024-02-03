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
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class serialization {

	public static void main(String[] args) {
//		Serialization is recommended to use when request payload is complex 
//		https://restful-booker.herokuapp.com/booking

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

//		1. create the object of map
	    
		HashMap<String, Object> s=new HashMap();
		s.put("firstname", "sampatil");
		s.put("lastname", "kam");
		s.put("totalprice",111);
		
		
		
		s.put("additionalneeds","lunch");
		
		HashMap<String, Object> date=new HashMap();
		date.put("checkin", "2018-01-01");
		
		date.put("checkout","2019-01-01");
		
	    s.put("bookingdates", date);
	    
	    //pojo class object pass in body as parameter 
	    //give content type as per the document 
	    given().log().all().header("Content-Type", "application/json").body(s).contentType(ContentType.JSON)
		.when().post("booking").then().log().all().assertThat().statusCode(200);
	}
}
