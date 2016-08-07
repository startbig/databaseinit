package com.database.action;

import com.database.common.Constants;
import com.database.common.StringUtil;

public class InitDao {
	
	public static String initDao(String className){
		className=StringUtil.getClassName(className);
		StringBuffer buffer= new StringBuffer();
		buffer.append("package " +Constants.getDaopath().replaceAll("/", ".").replaceAll("src.", "")+";\r\n");
		buffer.append("import " +Constants.getDtopath().replaceAll("/", ".").replaceAll("src.", "")+"."+className+";\r\n\r\n");
		buffer.append("import java.util.List;\r\n\r\n");
		buffer.append("import org.springframework.stereotype.Repository;\r\n\r\n");
		buffer.append("@Repository\r\n");
		buffer.append("public interface "+className+"Dao {\r\n\r\n");
		buffer.append("public int  insert"+className+"("+className+" "+StringUtil.firstLower(className)+");\r\n\r\n");
		buffer.append("public int  update"+className+"("+className+" "+StringUtil.firstLower(className)+");\r\n\r\n");
		buffer.append("public List<"+className+">  get"+className+"List("+className+" "+StringUtil.firstLower(className)+");\r\n\r\n");
		buffer.append("public int  get"+className+"ListCount("+className+" "+StringUtil.firstLower(className)+");\r\n\r\n");
		buffer.append("public "+className+"  get"+className+"ById(String id);\r\n\r\n");
		buffer.append("}");
		return buffer.toString();
		
	}
}
