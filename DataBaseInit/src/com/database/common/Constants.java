package com.database.common;

//静态变量
public class Constants {

	final static String dtoPath="src/com/database/po";
	final static String daoPath="src/com/database/dao";
	final static String servicePath="src/com/database/service";
	final static String mapperPath="src/com/database/mapping";
	final static String driverNameOracle="oracle.jdbc.driver.OracleDriver";
	final static String dbURLOracle="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	final static String userNameOracle="fcmerge";
	final static String userPwdOracle="123";
	final static String driverNameMysql="com.mysql.jdbc.Driver";
	final static String dbURLMysql="jdbc:mysql://localhost:3306/database?characterEncoding=utf8";
	final static String userNameMysql="root";
	final static String userPwdMysql="root";
	static String datatype="oracle";

	public static String getDtopath() {
		return dtoPath;
	}
	public static String getDaopath() {
		return daoPath;
	}
	public static String getServicepath() {
		return servicePath;
	}
	public static String getMapperpath() {
		return mapperPath;
	}
	
	public static String getDatatype() {
		return datatype;
	}
	public static String getDrivernameoracle() {
		return driverNameOracle;
	}
	public static String getDburloracle() {
		return dbURLOracle;
	}
	public static String getUsernameoracle() {
		return userNameOracle;
	}
	public static String getUserpwdoracle() {
		return userPwdOracle;
	}
	public static String getDrivernamemysql() {
		return driverNameMysql;
	}
	public static String getDburlmysql() {
		return dbURLMysql;
	}
	public static String getUsernamemysql() {
		return userNameMysql;
	}
	public static String getUserpwdmysql() {
		return userPwdMysql;
	}
	public static void setDatatype(String datatype) {
		Constants.datatype = datatype;
	}
	
	
	
	
}
