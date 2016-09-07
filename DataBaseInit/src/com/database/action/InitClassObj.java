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
	        String sotreDirName = rootPath+"/"+Constants.getStorepath();
	        String viewDirName = rootPath+"/"+Constants.getViewpath();
	        String controllerDirName = rootPath+"/"+Constants.getControllerpath();
	        String handlerDirName = rootPath+"/"+Constants.getHandllerpath();

	        //创建文件夹
	        FileInit.createDir(dtoDirName);  
	        FileInit.createDir(daoDirName);  
	        FileInit.createDir(serviceDirName);  
	        FileInit.createDir(sotreDirName);  
	        FileInit.createDir(viewDirName);  
	        FileInit.createDir(controllerDirName); 
	        FileInit.createDir(handlerDirName);
	        //创建文件  
	        String DtoFilePath = dtoDirName + "/"+StringUtil.getClassName(tableName)+".java";  
	        String DaoFilePath = daoDirName + "/"+StringUtil.getClassName(tableName)+"Dao.java";  
	        String ServiceFilePath = serviceDirName + "/"+StringUtil.getClassName(tableName)+"Service.java";  
	        String MapperFilePath = mapperDirName + "/"+StringUtil.getClassName(tableName)+"Mapper.xml";  
	        String StoreFilePath = sotreDirName + "/"+StringUtil.getClassName(tableName)+"Store.js";  
	        String ViewFilePath = viewDirName + "/"+StringUtil.getClassName(tableName).toLowerCase()+"/"+StringUtil.getClassName(tableName)+".js";  
	        String ControllerFilePath = controllerDirName + "/"+StringUtil.getClassName(tableName).toLowerCase()+"/"+StringUtil.getClassName(tableName)+"Controller.js";  
	        String HandlerFilePath = handlerDirName + "/"+StringUtil.getClassName(tableName)+"Handler.java";  

	        FileInit.createFile(DtoFilePath); 
	        FileInit.createFile(DaoFilePath); 
	        FileInit.createFile(ServiceFilePath);  
	        FileInit.createFile(MapperFilePath);  
	        FileInit.createFile(StoreFilePath);  
	        FileInit.createFile(ViewFilePath);  
	        FileInit.createFile(ControllerFilePath);  
	        FileInit.createFile(HandlerFilePath);  

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
	        
	        FileWriter fssotre=new FileWriter(StoreFilePath);
	        fssotre.write(InitStore.initStore(tableName));
	        fssotre.flush();
	        fssotre.close();
	        
	        FileWriter fsview=new FileWriter(ViewFilePath);
	        fsview.write(InitView.initView(tableName));
	        fsview.flush();
	        fsview.close();
	        
	        FileWriter fscontroller=new FileWriter(ControllerFilePath);
	        fscontroller.write(InitController.initController(tableName));
	        fscontroller.flush();
	        fscontroller.close();
	        
	        FileWriter fshandler=new FileWriter(HandlerFilePath);
	        fshandler.write(InitHandler.initHandler(tableName));
	        fshandler.flush();
	        fshandler.close();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
	   
		initClass("u_roles_resources","mysql");
     }
}
