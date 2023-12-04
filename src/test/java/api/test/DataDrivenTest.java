package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;
import api.utilities.*;

public class DataDrivenTest {

	@Test(priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
	public void testPostUsers(String userID, String userName, String firstName, String lastName, String Email, String password, String phone) {
		
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		Response response = UserEndpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);		
	}
	
	@Test(priority = 2, dataProvider = "users", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {		
		Response resp = UserEndpoints.deleteUser(userName);
		Assert.assertEquals(resp.getStatusCode(), 200); 
	}
}
