package WebService.WebServiceCall;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
/**
 
 */
public class App 
{
    public static void main( String[] args )
    {
    	Response resp =get5Param("1","2","3","4","5");
    	//Gelen cevabı json a çevirip ilgili kolondaki veri alındı
    	String sum=resp.jsonPath().getString("sum");
        String mean=resp.jsonPath().getString("mean");
        
        System.out.println("SUM="+sum );
        System.out.println("MEAN="+mean );
        
        Response resp2 =getStd(sum,mean);
        String std=resp2.jsonPath().getString("std");
        System.out.println("STANDART SAPMA="+std );
        
        Response resp3 = getWithoutParam();
        String result=resp3.jsonPath().getString("res");
        System.out.println("Result = "+result);
        
        Response postres =PostMethod();
        String responsePost =postres.jsonPath().getString("square");
        System.out.println("Square = "+responsePost);
        
    }
    
    
    private static  Response get5Param(String input1 ,String input2,String input3,String input4,String input5) {
    	
    	 //Url 5 parametre olarak yazıldı
      	 String url =String.format("http://localhost:50721/api/Service/get5Param?input1=%s&input2=%s&input3=%s&input4=%s&input5=%s",input1,input2,input3,input4,input5);
      	 // gönderdiğimiz request header bilgisine içerik tipi json belirtildi ve get metodu kullanıldı
      	 //daha sonra gelen cevabın status kodu 200 olduğı kontrol edildi ve cevap geldi
      	 Response resp =given().contentType("application/json").accept("application/json").
      		        when().
      		        get(url).
      		        then().statusCode(200).contentType("application/json").
      		        extract().response();
      	 
      	 return resp;
      }
    
    private static  Response getStd(String sum ,String mean) {
    	
   	 String url =String.format("http://localhost:50721/api/Service/std?sum=%s&mean=%s",sum,mean);

   	 Response resp =given().contentType("application/json").accept("application/json").	
   		        when().
   		        get(url).
   		        then().statusCode(200).contentType("application/json").
   		        extract().response();
   	 
   	 return resp;
   }

    private static  Response getWithoutParam() {
    	
      	 String url =String.format("http://localhost:50721/api/Service/getWithoutParam");
      	 Response resp =given().contentType("application/json").accept("application/json").	
      		        when().
      		        get(url).
      		        then().statusCode(200).contentType("application/json").
      		        extract().response();
      	 
      	 return resp;
      }
    
    private static  Response PostMethod() {
    	
     	 String url =String.format("http://localhost:50721/api/Service/PostMethod");
      	 // gönderdiğimiz request header bilgisine içerik tipi json , body kısmına is {"value":"5"} eklendi. Ve post metodu kullanıldı
      	 //daha sonra gelen cevabın status kodu 200 olduğı kontrol edildi ve cevap geldi
    
     	 Response resp =given().contentType("application/json").accept("application/json").body("{\"value\":\"5\"}").
     		        when().
     		        post(url).
     		        then().statusCode(200).contentType("application/json").
     		        extract().response();
     	 
     	 return resp;
     }
}
