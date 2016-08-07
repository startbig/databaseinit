package com.database.action;

import java.sql.SQLException;
import java.util.List;
import com.database.common.DataUtil;
import com.database.common.StringUtil;

public class InitDto {
	public static String initDto(String tableName,String path) throws ClassNotFoundException, SQLException{
		StringBuffer buffer= new StringBuffer();
		buffer.append("package "+ path+";\r\n");
		buffer.append("import java.util.Date;\r\n");
		buffer.append("public class "+StringUtil.getClassName(tableName)+"{"+"\r\n\r\n");
		initObj(DataUtil.objdto,DataUtil.objdtoType,DataUtil.objdtoComments,buffer);
		initGetSet(DataUtil.objdto,DataUtil.objdtoType,buffer);
		buffer.append("}");
		return buffer.toString();
	}
	//初始化private对象
	private static void initObj(List<String> objdto, List<String> objdtoType,
			List<String> objdtoComments, StringBuffer buffer) {
		for (int i = 0; i < objdto.size(); i++) {
			String comments=objdtoComments.get(i);
			String dataType=objdtoType.get(i);
			String columnName=objdto.get(i);
			if(comments!=null){
				buffer.append("\t"+"//"+comments+"\r\n");
			}else{
				buffer.append("\t"+"//\r\n");
			}
			buffer.append("\t"+"private "+StringUtil.transformType(dataType)+ StringUtil.DealFiled(columnName)+";\r\n");
		}
		buffer.append("\r\n");
	}

	
    //拼接getset方法
	public static void initGetSet(List<String> objdto,List<String> objdtoType,StringBuffer buffer){
		for (int i = 0; i < objdto.size(); i++) {
			String field=StringUtil.DealFiled(objdto.get(i));
			String type=StringUtil.transformType(objdtoType.get(i));
			//get方法
			buffer.append("\t"+"public " +type+" "
		    +StringUtil.firstUpper(field,"get")+"(){"+"\r\n");
			buffer.append("\t"+"\t"+"return "+ field+";"+"\r\n");
			buffer.append("\t"+"}"+"\r\n\r\n");
			//set方法
			buffer.append("\t"+"public void " +StringUtil.firstUpper(field,"set")+"( "+type+" "+field+" ){"+"\r\n");
			buffer.append("\t"+"\t"+"this."+ field+"="+field+";"+"\r\n");
			buffer.append("\t"+"}"+"\r\n\r\n");
		}
	}
	
}
