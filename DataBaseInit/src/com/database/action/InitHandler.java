package com.database.action;

import com.database.common.StringUtil;

public class InitHandler {
	public static String newline = "\r\n";
	public static String lable = "\t";
	public static String initHandler(String className){
		className=StringUtil.getClassName(className);
		StringBuffer buffer= new StringBuffer();
		initHead(buffer,className);
		initBody(buffer,className);
		return buffer.toString();
	}
	public static void initHead(StringBuffer buffer,String className){
		  buffer.append("package com.database.handler;");
		  buffer.append(newline);
		  buffer.append("import javax.annotation.Resource;");
		  buffer.append(newline);
		  buffer.append("import org.springframework.stereotype.Controller;");
		  buffer.append("import com.database.utils.PageVo;\r\n\r\n");
		  buffer.append(newline);
		  buffer.append("import org.springframework.web.bind.annotation.RequestMapping;");
		  buffer.append(newline);
		  buffer.append("import org.springframework.web.bind.annotation.ResponseBody;");
		  buffer.append(newline);
		  buffer.append("import com.database.po."+className+";");
		  buffer.append(newline);
		  buffer.append("import com.database.service."+className+"Service;");
		  buffer.append(newline);
		  buffer.append("import com.database.utils.HandlerBase;");
		  buffer.append(newline);
		  buffer.append("import com.database.utils.Constant;");
		  buffer.append(newline);
		  buffer.append("import com.database.utils.PageVo;");
		  buffer.append(newline);
		  buffer.append(newline);
		  buffer.append("@Controller");
		  buffer.append(newline);
		  buffer.append("@RequestMapping(\"/"+className.toLowerCase()+"\")");
		  buffer.append(newline);
		  buffer.append("public class "+className+"Handler  extends HandlerBase{");
		  buffer.append(newline);
		  buffer.append(lable+"private PageVo pageVo = new PageVo();");
		  buffer.append(newline);
		  buffer.append(lable+"@Resource ");
		  buffer.append(newline);
		  buffer.append(lable+"private "+className+"Service "+className.toLowerCase()+"Service;");
		  buffer.append(newline);
		  buffer.append(newline);
	}
	public static void initBody(StringBuffer buffer,String className){
		getListBody(buffer,className);
		insertBody(buffer,className);
		updateBody(buffer,className);
		buffer.append("}");
		}
	public static void getListBody(StringBuffer buffer,String className){
		buffer.append(lable+"@RequestMapping(\"/get"+className+"List\")");
		buffer.append(newline);
		buffer.append(lable+"@ResponseBody");
		buffer.append(newline);
		buffer.append(lable+"public PageVo get"+className+"List(Integer page,Integer limit, "+className+" "+className.toLowerCase()+"){");
		buffer.append(newline);
		buffer.append(lable+lable+"if("+className.toLowerCase()+"==null){");
		buffer.append(newline);
		buffer.append(lable+lable+lable+""+className.toLowerCase()+"=new "+className+"();");
		buffer.append(newline);
		buffer.append(lable+lable+"}");
		buffer.append(newline);
		buffer.append(lable+lable+""+className.toLowerCase()+".setPageSize(limit);");
		buffer.append(newline);
		buffer.append(lable+lable+""+className.toLowerCase()+".setCurrPage(page);");
		buffer.append(newline);
		buffer.append(lable+lable+"pageVo="+className.toLowerCase()+"Service.get"+className+"List("+className.toLowerCase()+");");
		buffer.append(newline);
		buffer.append(lable+lable+"pageVo.setSuccess(true);");
		buffer.append(newline);
		buffer.append(lable+lable+"return pageVo;");
		buffer.append(newline);
		buffer.append(lable+"}");
		buffer.append(newline);
		
	}
 
	public static void insertBody(StringBuffer buffer,String className){
		buffer.append(lable+"@RequestMapping(\"/insert"+className+"\")");
		buffer.append(newline);
		buffer.append(lable+"@ResponseBody");
		buffer.append(newline);
		buffer.append(lable+"public PageVo insert"+className+"("+className+" "+className.toLowerCase()+"){");
		buffer.append(newline);
		buffer.append(lable+lable+"pageVo = new PageVo();");
		buffer.append(newline);
		buffer.append(lable+lable+"String userName=Constant.getUserName(request);");
		buffer.append(newline);
		buffer.append(lable+lable+""+className.toLowerCase()+".setCreateUser(userName);");
		buffer.append(newline);
		buffer.append(lable+lable+"boolean success="+className.toLowerCase()+"Service.insert"+className+"("+className.toLowerCase()+");");
		buffer.append(newline);
		buffer.append(lable+lable+"pageVo.setSuccess(success);");
		buffer.append(newline);
		buffer.append(lable+lable+"return pageVo;");
		buffer.append(newline);
		buffer.append(lable+"}");
		buffer.append(newline);
		
	}
		
	public static void updateBody(StringBuffer buffer,String className){
		buffer.append(lable+"@RequestMapping(\"/update"+className+"\")");
		buffer.append(newline);
		buffer.append(lable+"@ResponseBody");
		buffer.append(newline);
		buffer.append(lable+"public PageVo update"+className+"("+className+" "+className.toLowerCase()+"){");
		buffer.append(newline);
		buffer.append(lable+lable+"pageVo = new PageVo();");
		buffer.append(newline);
		buffer.append(lable+lable+"boolean success="+className.toLowerCase()+"Service.update"+className+"("+className.toLowerCase()+");");
		buffer.append(newline);
		buffer.append(lable+lable+"pageVo.setSuccess(success);");
		buffer.append(newline);
		buffer.append(lable+lable+"return pageVo;");
		buffer.append(newline);
		buffer.append(lable+"}");
		buffer.append(newline);
		
	}

}



















  

	
     
    