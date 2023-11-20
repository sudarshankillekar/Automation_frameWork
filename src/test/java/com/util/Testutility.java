package com.util;

import com.google.gson.Gson;

public class Testutility {
	 public static  String convertPOJOToJSON (Object data) {
		 Gson gson = new Gson();
		 String result = gson.toJson(data); 
		 return result;
	 }

}
