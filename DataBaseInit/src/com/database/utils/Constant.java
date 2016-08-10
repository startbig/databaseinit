package com.database.utils;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.database.po.User;

public class Constant {

//	提示信息
	public static final String EXIST_MSG="已经存在";
	public static final String ERRORINFO_MSG="用户名或密码错误";
	private static User loginUser;
	public static String getUserName(HttpServletRequest request){
		if(loginUser==null){
			loginUser = (User) request.getSession().getAttribute("loginUser");  
		}
     	String userName=loginUser.getUserName();
		return userName;
	}
	public static String getUserId(HttpServletRequest request){
		if(loginUser==null){
			loginUser = (User) request.getSession().getAttribute("loginUser");  
		}
     	String userName=loginUser.getId();
		return userName;
	}
	public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        //去掉“-”符号 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    } 

}
