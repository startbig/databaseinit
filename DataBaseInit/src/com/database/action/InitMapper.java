package com.database.action;

import java.util.List;

import com.database.common.Constants;
import com.database.common.DataUtil;
import com.database.common.StringUtil;

public class InitMapper {

	public static String initMapper(String tableName){
		String className=StringUtil.getClassName(tableName);
		StringBuffer buffer= new StringBuffer();
		buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r\n");
		buffer.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" "+"\r\n");
		buffer.append("    \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">"+"\r\n");
		buffer.append("<mapper namespace=\"" + Constants.getDaopath().replace("/", ".").replaceAll("src.", "") + "." + className + "Dao\">"+"\r\n"+"\r\n");
		base(buffer,DataUtil.objdto);
		getObj( tableName,className, buffer,DataUtil.objdto);
		getList(tableName, className, buffer,DataUtil.objdto);
		getListCount(tableName, className, buffer,DataUtil.objdto);
		insert( tableName,className, buffer,DataUtil.objdto);
		update( tableName,className, buffer,DataUtil.objdto);
		buffer.append("</mapper>"+"\r\n");
		return buffer.toString();
	}
	

	private static void base(StringBuffer buffer, List<String> objdto) {
		int size = objdto.size();
		buffer.append("\t<!-- 通用查询结果列-->"+"\r\n");
	    buffer.append("\t<sql id=\"Base_Column_List\">"+"\r\n");
	    for ( int i = 0 ; i < size ; i++ ) {
	          buffer.append("\t t." + objdto.get(i));
	          if ( i != size - 1 ) {
	            	buffer.append(",");
	          }
	        }
	    buffer.append("\r\n");
	    buffer.append("\t</sql>"+"\r\n"+"\r\n");
	}


	
	public static void getObj(String tableName,String className,StringBuffer buffer,List<String> objdto){
		buffer.append("\t<!-- 查询（根据主键ID查询） -->"+"\r\n");
        buffer.append("\t<select id=\"get"+className+"ById\" resultType=\""
                + className + "\" parameterType=\"java.lang.String\">"+"\r\n");
        buffer.append("\t\t SELECT"+"\r\n");
        buffer.append("\t\t <include refid=\"Base_Column_List\" />"+"\r\n");
        buffer.append("\t\t FROM " + tableName+" t "+"\r\n");
        buffer.append("\t\t WHERE t.id = #{id}"+"\r\n");
        buffer.append("\t</select>"+"\r\n"+"\r\n");
	}
	
	public static void getList(String tableName,String className,StringBuffer buffer,List<String> objdto){
	    int size = objdto.size();   
	    buffer.append("\t<!-- 查询（根据条件查询集合） -->"+"\r\n");
        buffer.append("\t<select id=\"get"+className+"List\" resultType=\""
                + className + "\" parameterType=\"" + className + "\">"+"\r\n");
        if(!"mysql".equals(Constants.getDatatype())){
        	 buffer.append("\t\tSELECT * FROM (SELECT A.*, ROWNUM RN FROM ("+"\r\n");
        }
        buffer.append("\t\tSELECT"+"\r\n");
        buffer.append("\t\t<include refid=\"Base_Column_List\" />"+"\r\n");
        buffer.append("\t\tFROM " + tableName+" t "+"\r\n");
        buffer.append("\t<where>"+"\r\n");
        buffer.append("\t\t<trim prefix=\" \" suffix=\" \" suffixOverrides=\" and \" >"+"\r\n");
        for ( int i = 0 ; i < size ; i++ ) {
        	String column=objdto.get(i);
        	String objcolumn= StringUtil.DealFiled(objdto.get(i));
            buffer.append("\t\t\t<if test=\"" +objcolumn + " != null  and " + objcolumn + "!=''\">"+"\r\n");
            buffer.append("\t\t\t\t t."+ column + " = #{" +objcolumn + "}"+"\r\n");
            buffer.append("\t\t\t</if>"+"\r\n");
        }
        buffer.append("\t\t </trim>"+"\r\n");
        buffer.append("\t</where>"+"\r\n");
        if("mysql".equals(Constants.getDatatype())){
        	  buffer.append("\t\t limit #{startRow},#{pageSize}"+"\r\n");
        }else{
        	  buffer.append("\t\t\t)A"+"\r\n");
        	  buffer.append("\t\t\t<![CDATA[WHERE ROWNUM <= #{end}]]>"+"\r\n");
        	  buffer.append("\t\t\t)"+"\r\n");
        	  buffer.append("\t\t\tWHERE RN > #{begin}"+"\r\n");
        }
        buffer.append("\t</select>"+"\r\n"+"\r\n");
	        
	        
	}
	
	private static void getListCount(String tableName, String className,
			StringBuffer buffer, List<String> objdto) {
		int size = objdto.size();   
	    buffer.append("\t<!-- 查询（根据条件查询集合总数） -->"+"\r\n");
        buffer.append("\t<select id=\"get"+className+"ListCount\" resultType=\"java.lang.Integer\" parameterType=\"" + className + "\">"+"\r\n");
        buffer.append("\t\tSELECT count(*) FROM " + tableName+" t "+"\r\n");
        buffer.append("\t<where>"+"\r\n");
        buffer.append("\t\t<trim prefix=\" \" suffix=\" \" suffixOverrides=\" and \" >"+"\r\n");
        for ( int i = 0 ; i < size ; i++ ) {
        	String column=objdto.get(i);
        	String objcolumn= StringUtil.DealFiled(objdto.get(i));
            buffer.append("\t\t\t<if test=\"" +objcolumn + " != null  and " + objcolumn + "!=''\">"+"\r\n");
            buffer.append("\t\t\t\t t."+ column + " = #{" +objcolumn + "}"+"\r\n");
            buffer.append("\t\t\t</if>"+"\r\n");
        }
        buffer.append("\t\t </trim>"+"\r\n");
        buffer.append("\t</where>"+"\r\n");
        buffer.append("\t</select>"+"\r\n"+"\r\n");
		
	}

	
	public static void insert(String tableName,String className,StringBuffer buffer,List<String> objdto){
		int size = objdto.size();  
		buffer.append("\t<!-- 添加 （匹配有值的字段）-->"+"\r\n");
        buffer.append("\t<insert id=\"insert"+className+"\" parameterType=\"" + className + "\">"+"\r\n");
        buffer.append("\t\tINSERT INTO " + tableName+"\r\n");
        buffer.append("\t\t<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >"+"\r\n");
        for ( int i = 0 ; i < size ; i++ ) {
        	String column=objdto.get(i);
        	String objcolumn= StringUtil.DealFiled(objdto.get(i));
            if(objcolumn.equals("id")){
            	   buffer.append("\t\t\t\t " + objcolumn + ","+"\r\n");
            }else{
            	 buffer.append("\t\t\t<if test=\"" + objcolumn + " != null and " + objcolumn + "!=''\">"+"\r\n");
                 buffer.append("\t\t\t\t " + column + ","+"\r\n");
                 buffer.append("\t\t\t</if>"+"\r\n");
            }
        }
        buffer.append("\t\t </trim>"+"\r\n");
        buffer.append("\t\t <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >"+"\r\n");
        for ( int i = 0 ; i < size ; i++ ) {
        	String objcolumn= StringUtil.DealFiled(objdto.get(i));
            if(objcolumn.equals("id")){
            	if(!Constants.getDatatype().equals("mysql")){
          		     buffer.append("\t\t\t\t sys_guid(),"+"\r\n");
            	}else{
            		  buffer.append("\t\t\t\t uuid(),"+"\r\n");
            	}
            }else{
            	 buffer.append("\t\t\t<if test=\"" + objcolumn + "!=null and " + objcolumn + "!=''\">"+"\r\n");
                 buffer.append("\t\t\t\t #{" + objcolumn + "},"+"\r\n");
                 buffer.append("\t\t\t</if>"+"\r\n");
            }
        }
        buffer.append("\t\t </trim>"+"\r\n");
        buffer.append("\t</insert>"+"\r\n"+"\r\n");
	}
	
	public static void update(String tableName,String className,StringBuffer buffer,List<String> objdto){
		    int size = objdto.size();  
		    buffer.append("\t<!-- 修 改-->"+"\r\n");
	        buffer.append("\t<update id=\"update"+className+"\" parameterType=\"" + className + "\">"+"\r\n");
	        buffer.append("\t\t UPDATE " + tableName+"\r\n");
	        buffer.append("\t\t <set>"+"\r\n");
	        for ( int i = 1 ; i < size ; i++ ) {
	        	String column=objdto.get(i);
	        	String objcolumn= StringUtil.DealFiled(objdto.get(i));
	            buffer.append("\t\t\t<if test=\"" + objcolumn + " != null and " + objcolumn + "!=''\">"+"\r\n");
	            buffer.append("\t\t\t\t " + column+ " = #{" + objcolumn + "},"+"\r\n");
	            buffer.append("\t\t\t</if>"+"\r\n");
	        }
	        buffer.append(" \t\t </set>"+"\r\n");
	        buffer.append("\t\t WHERE id = #{id}"+"\r\n");
	        buffer.append("\t</update>"+"\r\n"+"\r\n");
	}
}
