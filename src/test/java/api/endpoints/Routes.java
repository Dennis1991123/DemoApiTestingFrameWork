package api.endpoints;

//https://petstore.swagger.io/v2/user
//https://petstore.swagger.io/v2/user/{dennis}
//https://petstore.swagger.io/v2/user/{dennis}
//https://petstore.swagger.io/v2/user/{dennis}

public class Routes {
 
  public static String base_url = "https://petstore.swagger.io/v2";
  
  public static String  create_user =base_url+"/user";
  public static String  get_user =base_url+"/user/{username}";
  public static String  update_user =base_url+"/user/{username}";
  public static String  delete_user =base_url+"/user/{username}";
  
  
}