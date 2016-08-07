package com.database.action;

import com.database.common.Constants;
import com.database.common.StringUtil;

public class InitService {
	
	public static String initService(String className){
		className=StringUtil.getClassName(className);
		String daoName=StringUtil.firstLower(StringUtil.getClassName(className)+"Dao");
		StringBuffer buffer= new StringBuffer();
		buffer.append("package " +Constants.getServicepath().replaceAll("/", ".").replaceAll("src.", "")+";\r\n");
		buffer.append("import " +Constants.getDtopath().replaceAll("/", ".").replaceAll("src.", "")+"."+className+";\r\n\r\n");
		buffer.append("import " +Constants.getDaopath().replaceAll("/", ".").replaceAll("src.", "")+"."+className+"Dao;\r\n\r\n");
		buffer.append("import java.util.List;\r\n\r\n");
		buffer.append("import org.springframework.stereotype.Service;\r\n\r\n");
		buffer.append("import org.springframework.beans.factory.annotation.Autowired;\r\n\r\n");
		buffer.append("@Service\r\n");
		buffer.append("public class "+className+"Service {\r\n\r\n");
		buffer.append("@Autowired\r\n");
		buffer.append("private "+className+"Dao "+daoName+";\r\n\r\n");
		insert(className,buffer,daoName);
		update(className,buffer,daoName);
		getList(className,buffer,daoName);
		getListCount(className,buffer,daoName);
		getObj(className,buffer,daoName);
		buffer.append("}");
		return buffer.toString();
		
	}
	
	private static void getListCount(String className, StringBuffer buffer,
			String daoName) {
		buffer.append("\t"+"public int  get"+className+"ListCount("+className+" "+StringUtil.firstLower(className)+"){\r\n\r\n");
		buffer.append("\t"+"\t"+"int count=0;\r\n");
		buffer.append("\t"+"\t"+"count="+daoName+".get"+className+"ListCount("+StringUtil.firstLower(className)+");\r\n");
		buffer.append("\t"+"\t"+"return count;\r\n");
		buffer.append("\t"+"}\r\n\r\n");
	}

	public static void insert(String className,StringBuffer buffer,String daoName){
		buffer.append("\t"+"public Boolean  insert"+className+"("+className+" "+StringUtil.firstLower(className)+"){"+ "\r\n\r\n");
		buffer.append("\t"+"\t"+"Boolean flag=false;\r\n");
		buffer.append("\t"+"\t"+"if("+daoName+".insert"+className+"("+StringUtil.firstLower(className)+")>0){\r\n");
		buffer.append("\t"+"\t"+"flag=true;\r\n");
		buffer.append("\t"+"\t"+"}\r\n");
		buffer.append("\t"+"\t"+"return flag;\r\n");
		buffer.append("\t"+"}\r\n\r\n");
	}
	
	public static void update(String className,StringBuffer buffer,String daoName){
		buffer.append("\t"+"public Boolean  update"+className+"("+className+" "+StringUtil.firstLower(className)+"){\r\n\r\n");
		buffer.append("\t"+"\t"+"Boolean flag=false;\r\n");
		buffer.append("\t"+"\t"+"if("+daoName+".update"+className+"("+StringUtil.firstLower(className)+")>0){\r\n");
		buffer.append("\t"+"\t"+"flag=true;\r\n");
		buffer.append("\t"+"\t"+"}\r\n");
		buffer.append("\t"+"\t"+"return flag;\r\n");
		buffer.append("\t"+"}\r\n\r\n");
	}
	public static void getList(String className,StringBuffer buffer,String daoName){
		buffer.append("\t"+"public List<"+className+">  get"+className+"List("+className+" "+StringUtil.firstLower(className)+"){\r\n\r\n");
		buffer.append("\t"+"\t"+"List<"+className+"> list=null;\r\n");
		buffer.append("\t"+"\t"+"list="+daoName+".get"+className+"List("+StringUtil.firstLower(className)+");\r\n");
		buffer.append("\t"+"\t"+"return list;\r\n");
		buffer.append("\t"+"}\r\n\r\n");
	}
	
	public static void getObj(String className,StringBuffer buffer,String daoName){
		buffer.append("\t"+"public "+className+"  get"+className+"(String id){\r\n\r\n");
		buffer.append("\t"+"\t"+className+ " obj =null;\r\n");
		buffer.append("\t"+"\t"+"obj="+daoName+".get"+className+"ById(id);\r\n");
		buffer.append("\t"+"\t"+"return obj;\r\n");
		buffer.append("\t"+"}\r\n\r\n");
	}
}
