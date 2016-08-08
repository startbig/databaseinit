package com.database.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//数据库初始化
public class DataUtil {
	private static Connection conn;
    public static List<String> objdto=new ArrayList<String>();
    public static List<String> objdtoType=new ArrayList<String>();
    public static List<String> objdtoComments=new ArrayList<String>();
	public static Connection initOracleConnection() throws SQLException, ClassNotFoundException{
		if(conn!=null){
			return conn;
		}
		Class.forName(Constants.driverNameOracle);
		return conn = DriverManager.getConnection(Constants.dbURLOracle, Constants.userNameOracle, Constants.userPwdOracle);
	}
	
	public static Connection initMysqlConnection() throws SQLException, ClassNotFoundException{
		if(conn!=null){
			return conn;
		}
		Class.forName(Constants.driverNameMysql);
		return conn = DriverManager.getConnection(Constants.dbURLMysql, Constants.userNameMysql, Constants.userPwdMysql);
	}
	
	public static void closeAll(Connection con, PreparedStatement s, ResultSet rs) {
		try {
			if (null != rs) {
				rs.close();
				rs = null;
			}
			if (null != s) {
				s.close();
				s = null;
			}
			if (null != con) {
				con.close();
				con = null;
			}
		} catch (SQLException sqle) {
		}
	}
	public static void initOracleData(String tableName) throws ClassNotFoundException, SQLException{
		conn= initOracleConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql="SELECT  C.COLUMN_NAME,C.DATA_TYPE,M.COMMENTS FROM USER_TAB_COLUMNS  C RIGHT JOIN USER_COL_COMMENTS M "
				 + " ON C.COLUMN_NAME=M.COLUMN_NAME AND C.TABLE_NAME=M.TABLE_NAME WHERE C.TABLE_NAME='"+tableName.toUpperCase()+"'";
		try {
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				objdto.add(rs.getString("COLUMN_NAME"));
				objdtoType.add(rs.getString("DATA_TYPE"));
				objdtoComments.add(rs.getString("COMMENTS"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pst, rs);
		}
	}
	
	public static void initMysqlData(String tableName) throws ClassNotFoundException, SQLException{
		conn= initMysqlConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
	    String sql = "show full fields from "+tableName;
		try {
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				objdto.add(rs.getString("FIELD"));
				objdtoType.add(rs.getString("TYPE"));
				objdtoComments.add(rs.getString("COMMENT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pst, rs);
		}
	}
}
