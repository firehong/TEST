package com.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	/**
	 * ****************************************
	 * function:时间戳转字符型日期
	 * @param pattern
	 * @param time
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2016年11月8日上午9:43:24
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public static String Dateformat(String pattern,Long time){
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		Date date=new Date(time);
		return sdf.format(date);
	}
	

}
