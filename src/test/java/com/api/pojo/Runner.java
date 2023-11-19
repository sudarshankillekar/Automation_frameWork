package com.api.pojo;

import com.google.gson.*;

public class Runner {
	
	public static void main(String[] args) {


	LoginApiPojo loginApiPojo = new LoginApiPojo("username", "password");
	String data = convertPOJOToJSON(loginApiPojo);
	 System.out.println(data);
	}
	
	 public static  String convertPOJOToJSON (Object data) {
		 Gson gson = new Gson();
		 String result = gson.toJson(data); 
		 return result;
	 }
	 
	
}

