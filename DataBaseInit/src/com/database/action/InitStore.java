package com.database.action;

import java.util.List;

import com.database.common.DataUtil;
import com.database.common.StringUtil;

public class InitStore {
	public static String newline = "\r\n";
	public static String lable = "\t";

	public static String initStore(String className) {
		className = StringUtil.getClassName(className);
		StringBuffer buffer = new StringBuffer();
		List<String> objdto = DataUtil.objdto;
		int size = objdto.size();
		buffer.append("Ext.define(\"app.store." + className + "Store\", {");
		buffer.append(newline);
		buffer.append(lable + "extend:'Ext.data.Store',");
		buffer.append(newline);
		buffer.append(lable + "alias:'store." + className.toLowerCase()+ "store',");
		buffer.append(newline);
		buffer.append(lable + "fields:[");
		buffer.append(newline);
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				buffer.append(lable + "'" + StringUtil.DealFiled(objdto.get(i))+ "'");
				buffer.append(newline);
			} else {
				buffer.append(lable + "'" + StringUtil.DealFiled(objdto.get(i))+ "',");
				buffer.append(newline);
			}
		}
		buffer.append(lable + "],");
		buffer.append(newline);
		buffer.append(lable + "proxy: {");
		buffer.append(newline);
		buffer.append(lable + lable + "type: 'ajax',");
		buffer.append(newline);
		buffer.append(lable + lable + "url: '" + className.toLowerCase()+ "/get" + className + "List',");
		buffer.append(newline);
		buffer.append(lable + lable + "reader: {");
		buffer.append(newline);
		buffer.append(lable + lable + lable + "type: 'json',");
		buffer.append(newline);
		buffer.append(lable + lable + lable + "rootProperty: 'root',");
		buffer.append(newline);
		buffer.append(lable + lable + lable + "totalProperty:'total'");
		buffer.append(newline);
		buffer.append(lable + lable + "}");
		buffer.append(newline);
		buffer.append(lable + "},");
		buffer.append(newline);
		buffer.append(lable + "pageSize: 20");
		buffer.append(newline);
		buffer.append("});");
		return buffer.toString();
	}

}
