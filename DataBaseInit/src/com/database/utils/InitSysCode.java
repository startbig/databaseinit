package com.database.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.database.dao.SyscodeDao;
import com.database.po.Syscode;

public class InitSysCode {
	@Resource 
	private SyscodeDao syscodeDao;
	
	
	public void initSysCode(){
		List<Syscode> list = null;
		List<Syscode> list2=syscodeDao.getSyscodeAll();
		Map<String,List<Syscode>> keymap=new HashMap<String,List<Syscode>>();
		int size=list2.size();
		for (int i = 0; i < size; i++) {
			Syscode code=list2.get(i);
			if(keymap.containsKey(code.getSystype())){
				list.add(code);
			}else{
				list=new ArrayList<Syscode>();
				keymap.put(code.getSystype(), list);
				list.add(code);
			}
		}
		SysCodeMap.setMap(keymap);
	}
	
}
