package com.database.action;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import com.database.common.Constants;
import com.database.common.DataUtil;
import com.database.common.FileInit;
import com.database.common.StringUtil;

public class InitClassObj {
	
	public static void initClass(String tableName,String type) throws ClassNotFoundException, SQLException, IOException{
		    if("oracle".equals(type)){
		    	  DataUtil.initOracleData(tableName);	
		    }else{
		    	  DataUtil.initMysqlData(tableName);
		    	  Constants.setDatatype("mysql");
		    }
		    String rootPath=System.getProperty("user.dir"); 
	        String dtoDirName = rootPath+"/"+Constants.getDtopath();  
	        String daoDirName = rootPath+"/"+Constants.getDaopath(); 
	        String serviceDirName = rootPath+"/"+Constants.getServicepath(); 
	        String mapperDirName = rootPath+"/"+Constants.getMapperpath();
	        //创建文件夹
	        FileInit.createDir(dtoDirName);  
	        FileInit.createDir(daoDirName);  
	        FileInit.createDir(serviceDirName);  
	        //创建文件  
	        String DtoFilePath = dtoDirName + "/"+StringUtil.getClassName(tableName)+".java";  
	        String DaoFilePath = daoDirName + "/"+StringUtil.getClassName(tableName)+"Dao.java";  
	        String ServiceFilePath = serviceDirName + "/"+StringUtil.getClassName(tableName)+"Service.java";  
	        String MapperFilePath = mapperDirName + "/"+StringUtil.getClassName(tableName)+"Mapper.xml";  
	        
	        FileInit.createFile(DtoFilePath); 
	        FileInit.createFile(DaoFilePath); 
	        FileInit.createFile(ServiceFilePath);  
	        FileInit.createFile(MapperFilePath);  
	      
	        FileWriter fdto=new FileWriter(DtoFilePath);
	        fdto.write(InitDto.initDto(tableName,Constants.getDtopath().replaceAll("/", ".").replaceAll("src.", "")));
	        fdto.flush();
	        fdto.close();
	        FileWriter fdao=new FileWriter(DaoFilePath);
	        fdao.write(InitDao.initDao(tableName));
	        fdao.flush();
	        fdao.close();
	        FileWriter fservice=new FileWriter(ServiceFilePath);
	        fservice.write(InitService.initService(tableName));
	        fservice.flush();
	        fservice.close();
	        
	        FileWriter fsmapper=new FileWriter(MapperFilePath);
	        fsmapper.write(InitMapper.initMapper(tableName));
	        fsmapper.flush();
	        fsmapper.close();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
	   
		initClass("u_device","mysql");
     }
}
