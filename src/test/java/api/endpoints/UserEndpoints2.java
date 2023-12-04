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

import java.util.ResourceBundle;

import api.payload.User;

public class UserEndpoints2 {
	
	/**
	 * to return the urls
	 * @return
	 */
	static ResourceBundle getUrl(){
		ResourceBundle routes = ResourceBundle.getBundle("routes");  // load the properties file
		return routes;
	}
	
	public static Response createUser(User payload) {
		String post_url = getUrl().getString("post_url");
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(post_url);
		
		return res;
		
	}
	
	public static Response getUser(String username) {
		
		String get_url = getUrl().getString("get_url");
		System.out.println("get url is ::" + get_url);
		
		Response res = 
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			//.pathParam("username", username)
					
		.when()
			.post(get_url);
		
		return res;
		
	}
	
	public static Response updateUser(String username, User payload) {
			
		String update_url = getUrl().getString("update_url");
		System.out.println("update_url is ::" + update_url);
		
			Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
			
			.when()
				.put(update_url);
			
			return res;
			
		}
	
	public static Response deleteUser(String username) {
		
		String delete_url = getUrl().getString("delete_url");
		System.out.println("delete_url is ::" + delete_url);
		Response res = given()			
			.pathParam("username", username)
					
		.when()
			.delete(delete_url);
		
		return res;
		
	}
	
}
