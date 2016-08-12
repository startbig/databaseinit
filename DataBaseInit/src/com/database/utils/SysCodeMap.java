package com.database.utils;

import java.util.List;
import java.util.Map;

import com.database.po.Syscode;

public class SysCodeMap {
	private static Map<String,List<Syscode>> map;
//	private static SysCodeMap INSTANCE=new SysCodeMap();

	public static Map<String, List<Syscode>> getMap() {
		return map;
	}

	public static void setMap(Map<String, List<Syscode>> map) {
		SysCodeMap.map = map;
	}

//	public static SysCodeMap getINSTANCE() {
//		return INSTANCE;
//	}
//
//	public static void setINSTANCE(SysCodeMap iNSTANCE) {
//		INSTANCE = iNSTANCE;
//	}
}
