package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setData() {
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		System.out.println("this user name ::"+ this.userPayload.getUsername());
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
		Response response = UserEndpoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);		
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		System.out.println("this user name ::"+ this.userPayload.getUsername());
		Response resp = UserEndpoints.getUser(this.userPayload.getUsername());
		resp.then().log().all();
		Assert.assertEquals(resp.getStatusCode(), 200);  	  	
	}
	
	@Test(priority = 3)
	public void testUpdateUserByName() {
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		System.out.println("this user name ::"+ this.userPayload.getUsername());
		Response resp = UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);
		resp.then().log().body();
		Assert.assertEquals(resp.getStatusCode(), 200);  
		
		//checking the data after update
		Response respAfterUpdate = UserEndpoints.getUser(this.userPayload.getUsername());
		respAfterUpdate.then().log().all();
		Assert.assertEquals(respAfterUpdate.getStatusCode(), 200);  
		
	}
	
	//@Test(priority = 4)
	public void testDeleteUser() {
		System.out.println("this user name ::"+ this.userPayload.getUsername());
		Response resp = UserEndpoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(resp.getStatusCode(), 200); 
	}
}
