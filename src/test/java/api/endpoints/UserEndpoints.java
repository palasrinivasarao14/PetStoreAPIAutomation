package api.endpoints;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import api.payload.User;

public class UserEndpoints {
	
	public static Response createUser(User payload) {
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.post_url);
		
		return res;
		
	}
	
	public static Response getUser(String username) {
		String getUrl = Routes.base_url+"/user/"+username;
		System.out.println("get url is ::" + getUrl);
		
		Response res = 
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			//.pathParam("username", username)
					
		.when()
			.post(Routes.base_url+"/user/"+username);
		
		return res;
		
	}
	
	public static Response updateUser(String username, User payload) {
			
		
		String updateUrl = Routes.base_url+"/user/"+username;
		System.out.println("update url is ::" + updateUrl);
			Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				//.pathParam("username", username)
				.body(payload)
			
			.when()
				.put(updateUrl);
			
			return res;
			
		}
	
	public static Response deleteUser(String username) {
		
		String deleteUrl = Routes.base_url+"/user/"+username;
		System.out.println("delete url is ::" + deleteUrl);
		Response res = given()			
			//.pathParam("username", username)
					
		.when()
			.delete(deleteUrl);
		
		return res;
		
	}
	
}
