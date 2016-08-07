package com.database.utils;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
/**
 * 
*    
* @项目名称：Sims
* @类名称：DateUtil
* @类描述：各类格式化以及日期计算方法
* @创建人：fukun
* @创建时间：2013-8-18 上午10:58:57
* @version： 1.0
*
 */
public class DateUtil {
	
	/**
	 * fanqh
	 */
	public static String getYearMonthDay(){
		java.util.Date  date=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	
	/**
	 * 
	 */
	public static String getSysDate(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * yyyyMMdd To yyyy_MM_dd
	 * */
	public static String yyyyMMddToyyyy_MM_dd(String str){
		if(str!=null && str.length()==8){
			return str.substring(0,4)+"-"+str.substring(4,6)+"-"+str.substring(6);
		}
		return null;
	}
	
	/**
	 * String to Timestamp
	 * */
	public static Timestamp stringToTimestamp(String str,String strFormat){
		
		if(null == str || null == strFormat
				|| "".equals(str) || "".equals(strFormat)) {
			
			return null;
		}
		
		SimpleDateFormat formatter=new SimpleDateFormat(strFormat);
		try {
			return new Timestamp(formatter.parse(str).getTime());
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * String to Timestamp
	 * */
	public static Timestamp stringToTimestamp(String str) {
		if(null == str || "".equals(str) || " ".equals(str)) {
			return null;
		}
		String strFormat = "yyyy-MM-dd";
		if(str.indexOf(":") > 0) {
			if(str.indexOf("-") > 0) {
				strFormat = "yyyy-MM-dd HH:mm:ss";
			} else {
				strFormat = "yyyyMMdd HH:mm:ss";
			}
		} else {
			if(str.indexOf("-") > 0) {
				strFormat = "yyyy-MM-dd";
			} else {
				strFormat = "yyyyMMdd";
			}			
		}
		SimpleDateFormat formatter=new SimpleDateFormat(strFormat);
		try {
			return new Timestamp(formatter.parse(str).getTime());
			
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}	
	//某一年第一天
	public static String getFirstDayOfYear(String year) throws Exception {
		year = year + "-01-01";
		
		return year;
	}
	//后一年第一天
	public static String getFirstDayOfNextYear(String year) throws Exception {
		year = Integer.toString((Integer.parseInt(year) + 1));
		year = year + "-01-01";
		return year;
	}
	//计算两个日期间隔天数
	public static int interval(String first, String last) {
	     int inter = 0;
	     java.util.Date dt_first = stringToDate(first,"yyyy-MM-dd");
	     java.util.Date dt_last = stringToDate(last,"yyyy-MM-dd");
	     inter = (int)((dt_last.getTime() - dt_first.getTime())/(3600*24000));
	     return inter;
	 }
	//由date根据strFormat格式化
	public static String dateToString(Date dt, String strFormat) {
		SimpleDateFormat sdFormat = new SimpleDateFormat(strFormat);
	    String str = "";
	    try {
	        str = sdFormat.format(dt);
	    }
	    catch(Exception e) {
	        return "";
	    }
	    if (str.equals("1900-01-01 00:00")) {
	        str = "";
	    }
        return str;
	}
	
	public static Date stringToDate(String str, String strFormat) {
	    SimpleDateFormat sdFormat = new SimpleDateFormat(strFormat);
	    Date date = null;
	    if(str==null||str.equals("")){
	      	return null;
	    }
	    try {
	        date = sdFormat.parse(str);
	    }
	    catch(Exception e) {
	        return null;
	    }
	        return date;
	}
	 
	 
	 /*
	  * 获取上个月1号Str
	  */	
	 public static String getBeforeMonthStr(String strFormat,int months){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-01");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, months);
		Date datenew = calendar.getTime();
		String str = simpleDateFormat.format(datenew);
		return str;
	 }
	 
	 public static String getBeforeMINUTEStr(String sourceDatestr,String strFormat,int minute){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormat); //"yyyy-MM-dd"
		Calendar calendar = Calendar.getInstance();
		Date sourDate = stringToDate(sourceDatestr,strFormat);			
		calendar.setTime(sourDate);			
		calendar.add(Calendar.MINUTE, minute);			
		Date datenew = calendar.getTime();
		String str = simpleDateFormat.format(datenew);
		return str;		
	}
	 
	 public static String getBeforeMonthTodayStr(String strFormat,int months,int days){
		
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormat); //"yyyy-MM-dd"
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, months);
			calendar.add(Calendar.DAY_OF_MONTH, days);
			Date datenew = calendar.getTime();
			String str = simpleDateFormat.format(datenew);
			return str;	
	 }
	 public static long getDays(String time2, String time1,String format){
		  long quot = 0;
		  SimpleDateFormat ft = new SimpleDateFormat(format);
		  try {
		   Date date1 = ft.parse( time1 );
		   Date date2 = ft.parse( time2 );
		   quot = date1.getTime() - date2.getTime();
		   quot = quot / 1000 / 60 / 60 / 24;
		  } catch (ParseException e) {
		   e.printStackTrace();
		  }
		  return quot;
	 }
		
	 public static String getBeforeMonthTodayStr(String sourceDatestr,String strFormat,int months,int days){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormat); //"yyyy-MM-dd"
			Calendar calendar = Calendar.getInstance();
			Date sourDate = stringToDate(sourceDatestr,strFormat);			
			calendar.setTime(sourDate);			
			calendar.add(Calendar.MONTH, months);
			calendar.add(Calendar.DAY_OF_MONTH, days);
			Date datenew = calendar.getTime();
			String str = simpleDateFormat.format(datenew);
			return str;
			
	}
	public static String getBeforeMonthTodayStrAll(String sourceDatestr,String strFormat,int months,int days,int second){
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormat); //"yyyy-MM-dd"
			Calendar calendar = Calendar.getInstance();
			Date sourDate = stringToDate(sourceDatestr,strFormat);			
			calendar.setTime(sourDate);			
			calendar.add(Calendar.MONTH, months);
			calendar.add(Calendar.DAY_OF_MONTH, days);
			calendar.add(Calendar.SECOND, second);
			Date datenew = calendar.getTime();
			String str = simpleDateFormat.format(datenew);
			return str;
			
	} 
	 
	 
 
	 /**    
	    * 计算两个日期之间相差的月数    
	    * @param date1    
	    * @param date2    
	    * @return    
	    */
	 public static int getMonths(Date date1, Date date2){      
	       int iMonth = 0;      
	       int flag = 0;      
	       try{      
	           Calendar objCalendarDate1 = Calendar.getInstance();      
	           objCalendarDate1.setTime(date1);      
	     
	           Calendar objCalendarDate2 = Calendar.getInstance();      
	           objCalendarDate2.setTime(date2);      
	     
	           if (objCalendarDate2.equals(objCalendarDate1))      
	               return 0;      
	           if (objCalendarDate1.after(objCalendarDate2)){      
	               Calendar temp = objCalendarDate1;      
	               objCalendarDate1 = objCalendarDate2;      
	               objCalendarDate2 = temp;      
	           }      
	           if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1.get(Calendar.DAY_OF_MONTH))      
	               flag = 1;      
	     
	           if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))      
	               iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR))      
	                       * 12 + objCalendarDate2.get(Calendar.MONTH) - flag)      
	                       - objCalendarDate1.get(Calendar.MONTH);      
	           else     
	               iMonth = objCalendarDate2.get(Calendar.MONTH)      
	                       - objCalendarDate1.get(Calendar.MONTH) - flag;      
	     
	       } catch (Exception e){      
	        e.printStackTrace();      
	       }      
	       return iMonth;      
	   }   
	 
	 
	 public static String getEncoding(String str) {   
	        String encode = "GB2312";   
	        try {   
	            if (str.equals(new String(str.getBytes(encode), encode))) {   
	                String s = encode;   
	                return s;   
	            }   
	        } catch (Exception exception) {   
	        }   
	        encode = "ISO-8859-1";   
	        try {   
	            if (str.equals(new String(str.getBytes(encode), encode))) {   
	                String s1 = encode;   
	                return s1;   
	            }   
	        } catch (Exception exception1) {   
	        }   
	        encode = "UTF-8";   
	        try {   
	            if (str.equals(new String(str.getBytes(encode), encode))) {   
	                String s2 = encode;   
	                return s2;   
	            }   
	        } catch (Exception exception2) {   
	        }   
	        encode = "GBK";   
	        try {   
	            if (str.equals(new String(str.getBytes(encode), encode))) {   
	                String s3 = encode;   
	                return s3;   
	            }   
	        } catch (Exception exception3) {   
	        }   
	        return "";   
	    }   

	
	public static String getEqualTime(String time1,String time2)
	{
		
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String res="";
		try {
			if(time2==null||"".equals(time2)){
			return res;	
			}	
			java.util.Date begin=dfs.parse(time1);
			java.util.Date end = dfs.parse(time2);
			long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒 
			//long day1=between/(24*3600); 
			//long hour1=between%(24*3600)/3600; 
			long hour1=between/3600;
			long minute1=between%3600/60; 
//			long second1=between%60/60; 
			//res=day1+"天"+hour1+"小时"+minute1+"分";//+second1+"秒";
			res=hour1+"小时"+minute1+"分";//+second1+"秒";
			//System.out.println("3333===="+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 获得上一年的当前月的上个月的月末
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getBeforeYearToday(int year,int month){
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.YEAR, year-1);
		calendar.set(Calendar.MONTH, month-2);
		//设置一个月的最大天数
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(calendar.getTime());
	}
	/**
	 * 获得上一年的当前月的上个月的月末(参数月份可以是01，02这种样式)
	 * @param year
	 * @param month 
	 * @return
	 */
	public static String getBeforeYearToday(String year,String month){
		String str="";
		try{
			int month1;
			if(month.indexOf("0")!=-1){
				month=month.substring(1);
			}
			int year1=Integer.parseInt(year);
			month1=Integer.parseInt(month);
			Calendar calendar=Calendar.getInstance();
			calendar.set(Calendar.YEAR, year1-1);
			calendar.set(Calendar.MONTH, month1-2);
			//设置一个月的最大天数
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			str=sdf.format(calendar.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 获得前一年的当前月月初
	 * @param date
	 * @return
	 */
	public static String getBefore2YearToday(String date){
		String str="";
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date1=sdf.parse(date);
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(date1);
			calendar.set(calendar.get(Calendar.YEAR)-1, calendar.get(Calendar.MONTH)+1, 1);
			str=sdf.format(calendar.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 获得前一年的当前月月初
	 * @param date
	 * @return
	 */
	public static String getBefore2YearToday(Date date){
		String str="";
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(calendar.get(Calendar.YEAR)-1, calendar.get(Calendar.MONTH)+1, 1);
			str=sdf.format(calendar.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 比较两个字符串日期大小
	 * @param date1
	 * @param date2
	 * @param format
	 * @return 如果date2>date1 返回true
	 */
	public static boolean compareDate(String date1,String date2,String format){
		SimpleDateFormat dfs = new SimpleDateFormat(format); //"yyyy-MM-dd HH:mm:ss"
//		String res="";
		try {
			
			java.util.Date begin=dfs.parse(date1);
			java.util.Date end = dfs.parse(date2);
			//如果date2 大于 date1 则返回 true
			if(end.getTime()-begin.getTime()>0){
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			
		}
		return true;
	}
	
	public static boolean compareDate(Date begin,Date end,String format){
//		String res="";
		try {
			
		
			//如果date2 大于 date1 则返回 true
			if(end.getTime()-begin.getTime()>0){
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			
		}
		return true;
	}
	
	
	public static String getPath(String path) {
		Properties properties = System.getProperties();
		String disk = (String) properties.getProperty("user.dir");
		return (disk.substring(0, 2) + path);
	}
	//小数点保留位数
	public static String a(Double d)
	{
		if(d!=null)
		{
			DecimalFormat df1 = new DecimalFormat("##.00");
			return df1.format(d);
		}
		else
			return null;
	}
	
	public static String getDayName(Date date){
		int flag=date.getDay();
		if(flag==1){
			return "星期一";
		}if(flag==2){
			return "星期二";
		}if(flag==3){
			return "星期三";
		}if(flag==4){
			return "星期四";
		}if(flag==5){
			return "星期五";
		}if(flag==6){
			return "星期六";
		}if(flag==7){
			return "星期天";
		}
		return null;
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
//		Date date=new Date();
		System.out.println(new DateUtil().getSysDate());
		
	}

}

