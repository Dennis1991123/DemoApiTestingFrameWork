package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	
	User userpayload;
	
	@BeforeClass
	public void setUpData()
	{
	    faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUsername(faker.name().fullName());
	}
	
	@Test(priority = 1)
	public void testCreateUser()
	{
		Response response = UserEndPoints.createUser(userpayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
			
		
	}
	
	@Test(priority = 2)
	public void testReadUser()
	{
		Response response = UserEndPoints.readUser(this.userpayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority = 3)
	public void testupdateUser()
	{
		
		userpayload.setLastName(faker.name().lastName());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
			System.out.println("Before updation "+response.body().toString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		  Response responseafter_update =  UserEndPoints.readUser(this.userpayload.getUsername());
		  System.out.println("After  updation "+response.then().log().body().toString());
		 
		
		
	}
	@Test(priority = 4)
	public void testdeleteUser()
	{
		Response response = UserEndPoints.deleteUser(this.userpayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

}
