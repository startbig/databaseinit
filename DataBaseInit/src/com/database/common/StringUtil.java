package com.database.common;

public class StringUtil {

	public static String DealFiled(String field){
		String transform=field.toLowerCase();
		if(field.contains("_")){
			transform=transformUpper(field.split("_"));
		}
		return transform;
	}
	public static String firstUpper(String field,String type){
		
		return type+field.substring(0, 1).toUpperCase()+field.substring(1,field.length());
		
	}
	
    public static String firstLower(String field){
		
		return field.substring(0, 1).toLowerCase()+field.substring(1,field.length());
		
	}
	
	public static String getClassName(String tableName){
		return firstUpper(DealFiled(tableName),"");
	}
	public static String transformUpper(String[] field){
		String first=field[0].toLowerCase();
		String transit="";
		String other="";
		for (int i = 1; i < field.length; i++) {
			transit=field[i];
			other=transit.substring(0, 1).toUpperCase()+transit.substring(1,transit.length()).toLowerCase();
			first=first+other;
		}
		return first;
	}
	
	public static String transformNull(String content){
		return content!=null?content:"";
	}
	
	public static String transformType(String type){
		type.toUpperCase();
		switch (type) {
		case "VARCHAR2":
			type="String ";
			break;
		case "CHAR":
			type="String ";
			break;
        case "DATE":
        	type="Date ";
			break;
        case "NUMBER":
        	type="float ";
			break;
        case "datetime":
        	type="Date ";
			break;
        case "VARCHAR":
        	type="String ";
			break;
        case "DECIMAL":
        	type="double ";
			break;
		default:
			type="String ";
			break;
		}
		return type;
	}
	
	public static String transformDtoName(String tableName){
		return tableName+"Dto";
	}
	public static String transformServiceName(String tableName){
		return tableName+"Service";	
	}
	public static String transformMapperName(String tableName){
		return tableName+"Mapper";
	}
}
