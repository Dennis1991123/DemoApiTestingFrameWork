package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;


public class UserEndPoints {
	
	User userpayload;
	
	public static Response createUser(User payload)
	{
	Response response = given()
		.contentType(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.create_user);
		
		return response;
		
	}
	
	public static Response readUser  (String username)
	{
		Response response =  given()
				           .contentType(ContentType.JSON)
				           .pathParam("username", username)
				           .when()
				           .get(Routes.get_user);
				           
		
		return response;
	}
	
	public static Response updateUser(String username,User userpayload)
	{
		Response response =  given()
		           .contentType(ContentType.JSON)
		           .pathParam("username", username)
		           .body(userpayload)
		           .when()
		           .put(Routes.update_user);
		
		return response;
		
	}
	
	public static Response deleteUser(String username)
			{
		
		Response response = given()
				            .contentType(ContentType.JSON)
				            .pathParam("username", username)
				            .when()
				            .delete(Routes.delete_user);
				           
				return response;
		
			}
	

}
