package com.database.action;

import java.util.List;

import com.database.common.DataUtil;
import com.database.common.StringUtil;

public class InitController {
	public static String newline = "\r\n";
	public static String lable = "\t";
	public static String initController(String className) {
		className = StringUtil.getClassName(className);
		List<String> objdto=DataUtil.objdto;
		List<String> objdtoComments=DataUtil.objdtoComments;
		int size=objdto.size();
		int hight=110+(20*size);
		StringBuffer buffer = new StringBuffer();
	    buffer.append("Ext.define(\"app.controller."+className.toLowerCase()+"."+className+"Controller\", {");
	    buffer.append(newline);
	    buffer.append(lable+"extend: 'Ext.app.ViewController',");
	    buffer.append(newline);
	    buffer.append(lable+"alias: 'controller."+className.toLowerCase()+"controller',");
	    buffer.append(newline);
	    buffer.append(lable+"requires: [");
	    buffer.append(newline);
	    buffer.append(lable+lable+"'Ext.window.Window',");
	    buffer.append(newline);
	    buffer.append(lable+lable+"'Ext.window.Toast',");
	    buffer.append(newline);
	    buffer.append(lable+lable+"'Ext.form.*'");
	    buffer.append(newline);
	    buffer.append(lable+"],");
	    buffer.append(newline);
	    buffer.append(lable+"insert"+className+": function(){");
	    buffer.append(newline);
	    buffer.append(lable+lable+"this.operationDevice('add');");
	    buffer.append(newline);
	    buffer.append(lable+"},");	
	    buffer.append(newline);
	    buffer.append(lable+"update"+className+": function(ctx){");
	    buffer.append(newline);
	    buffer.append(lable+lable+"var records = ctx.up('grid').getSelection()[0];");
	    buffer.append(newline);
	    buffer.append(lable+lable+"this.operationDevice('edit',records);");
	    buffer.append(newline);
	    buffer.append(lable+"},");	
	    buffer.append(newline);
	    buffer.append(lable+"operationDevice: function(type,rec) {");	
	    buffer.append(newline);
	    buffer.append(lable+lable+"var window = Ext.create('Ext.window.Window', {");	
	    buffer.append(newline);
	    buffer.append(lable+lable+lable+"modal: true,");	
	    buffer.append(newline);
	    buffer.append(lable+lable+lable+"layout: 'fit',");	
	    buffer.append(newline);
	    buffer.append(lable+lable+lable+"width: 400,");	
	    buffer.append(newline);
	    buffer.append(lable+lable+lable+"height: "+hight+",");	
	    buffer.append(newline);
	    buffer.append(lable+lable+lable+"closable: true,");	
	    buffer.append(newline);
	    buffer.append(lable+lable+lable+"modelValidation: true,");	
	    buffer.append(newline);
	    buffer.append(lable+lable+lable+"title: type=='add'?'新增':'修改',");	
	    buffer.append(newline);
	    buffer.append(lable+lable+lable+"items: {");	
	    buffer.append(newline);
	    buffer.append(lable+lable+lable+lable+"xtype: 'form',");	
	    buffer.append(newline);    
	    buffer.append(lable+lable+lable+lable+"url: type=='add'?'"+className.toLowerCase()+"/insert"+className+"':'"+className.toLowerCase()+"/update"+className+"',");	
	    buffer.append(newline);    
	    buffer.append(lable+lable+lable+lable+"bodyPadding: 10,");	
	    buffer.append(newline);    
	    buffer.append(lable+lable+lable+lable+"border: false,");	
	    buffer.append(newline);    
	    buffer.append(lable+lable+lable+lable+"layout: {");	
	    buffer.append(newline);    
	    buffer.append(lable+lable+lable+lable+lable+"type: 'vbox',");	
	    buffer.append(newline);  
	    buffer.append(lable+lable+lable+lable+lable+"align: 'stretch'");	
	    buffer.append(newline);  
	    buffer.append(lable+lable+lable+lable+"},");	
	    buffer.append(newline);  
	    buffer.append(lable+lable+lable+lable+"defaultType: 'textfield',");	
	    buffer.append(newline);  
	    buffer.append(lable+lable+lable+lable+"items: [");	
	    buffer.append(newline);  
	    for (int i = 0; i < size; i++) {
        	 if(i==size-1){
        		 buffer.append(lable+lable+lable+lable+"{");
        		 buffer.append(newline);
        		 buffer.append(lable+lable+lable+lable+lable+"name:'"+StringUtil.DealFiled(objdto.get(i))+"',");
                 buffer.append(newline); 
                 buffer.append(lable+lable+lable+lable+lable+"allowBlank: false");
                 buffer.append(newline); 
        		 buffer.append(lable+lable+lable+lable+"}");
        		 buffer.append(newline);

        	 }else{
        		 buffer.append(lable+lable+lable+lable+"{");
        		 buffer.append(newline);
        		 buffer.append(lable+lable+lable+lable+lable+"name:'"+StringUtil.DealFiled(objdto.get(i))+"',");
                 buffer.append(newline); 
                 if(objdto.get(i).equals("id")){
                	 buffer.append(lable+lable+lable+lable+lable+"hidden:true");
                     buffer.append(newline); 
        		 }else{
        			 buffer.append(lable+lable+lable+lable+lable+"fieldLabel: '"+objdtoComments.get(i)+"'");
                     buffer.append(newline); 
        		 }
               
        		 buffer.append(lable+lable+lable+lable+"},");
        		 buffer.append(newline);
        	 }
        	
		}
	    buffer.append(lable+lable+lable+lable+"],");	
	    buffer.append(newline);  
	    buffer.append(lable+lable+lable+lable+"buttons: [{");	
	    buffer.append(newline);
	    buffer.append(lable+lable+lable+lable+lable+"text: '保存',");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+"handler: function() {");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+"var form = window.items.get(0).getForm();");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+"if (form.isValid()) {");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+"form.submit({");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+"method: 'post',");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+lable+lable+"waitMsg: '上传中...',");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+"success: function(form, action) {");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+lable+"var grid = Ext.ComponentQuery.query('"+className.toLowerCase()+"panel')[0];");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+lable+"grid.getStore().load();");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+lable+lable+lable+"window.close();");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+lable+"app.Constant.showMsg(app.Constant.addSuccessMsg);");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+"},");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+"failure: function(form, action) {");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+lable+"var msg = action.result.msg;");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+lable+"if(msg){");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+lable+lable+lable+"showToast(msg)");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+lable+"}");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+lable+"showToast(app.Constant.systemErrorMsg);");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+lable+lable+"}");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+lable+"})");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+lable+lable+lable+"}");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+"}");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+"},");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+"{");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+"text: '重置',");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+"handler: function(ctx) {");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+lable+"ctx.up('window').down('form').reset();");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+"}");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+"},");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+"{");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+"text: '取消',");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+"handler: function() {");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+lable+"window.close();");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+lable+"}");
        buffer.append(newline);
        buffer.append(lable+lable+lable+lable+"}");
        buffer.append(newline);
        buffer.append(lable+lable+lable+"]");
        buffer.append(newline); 
        buffer.append(lable+lable+"}");
        buffer.append(newline); 
        buffer.append(lable+lable+"});");
        buffer.append(newline);  
        buffer.append(lable+lable+"if(rec){");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+"var form = window.down('form');");
        buffer.append(newline); 
        buffer.append(lable+lable+lable+"form.loadRecord(rec)");
        buffer.append(newline);
        buffer.append(lable+lable+"}");
        buffer.append(newline);
        buffer.append(lable+lable+"window.show();");
        buffer.append(newline);
	    buffer.append(lable+"}");	
	    buffer.append(newline);
	    buffer.append("})");	
	    buffer.append(newline);
	    return buffer.toString();
	}
	
}
