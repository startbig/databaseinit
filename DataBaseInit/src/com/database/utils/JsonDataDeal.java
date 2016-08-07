/**
 * 
 */
package com.database.utils;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @项目名称：Sims
 * @类名称：DataDeal.java
 * @类描述：
 * @创建人：guchong
 * @创建时间：2015-1-7  下午03:03:39
 * @version： 1.0
 */
public class JsonDataDeal {
 
private static ObjectMapper objectMapper;
	
	public static ObjectMapper getMapperInstance(){
		if (objectMapper == null){
			objectMapper = new ObjectMapper();
		}
		return objectMapper;		
		
	}
	

	public  static boolean stringCheck(String json){
		  if(json.indexOf("[")!=0){
		    	return true;
		    }else{
		    	return false;
		    }
	}
	
	public static String getJsonArrString(String [] arr){
		String seachArr="";
		String str="";
		if(arr.length==1){
			seachArr="'"+arr[0]+"'";	
		}else{
			 for (int i = 0; i < arr.length; i++) {
				 if(i==0){
					 str="'"+arr[i]+"'"; 
				 }else{
					 str=",'"+arr[i]+"'"; 
				 }
				  seachArr=seachArr+str;
		    }	
		}
	
		 return seachArr;
	}
	
	public static String getArrtoString(String [] arr){
		String seachArr="";
		String str="";
		if(arr.length==1){
			seachArr=arr[0];	
		}else{
			 for (int i = 0; i < arr.length; i++) {
				 if(i==0){
					 str=arr[i]; 
				 }else{
					 str=","+arr[i]; 
				 }
				  seachArr=seachArr+str;
		    }	
		}
	
		 return seachArr;
	}
	public static void main(String[] args) {
		String a[]={"[12"};
		System.out.println(a[0].indexOf("["));
	}
}
