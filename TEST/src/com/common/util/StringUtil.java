package com.common.util;


/**
 * 
 * **********************************************************
 * 
 * copyright by 四川复兴科技有限公司
 * 
 * 
 * ==========================================================
 * 模块介绍
 * version: v0.01.
 * function: 字符串工具类
 * ==========================================================
 * created by wuhong on 2017-1-18下午1:34:29
 * description:
 * 
 * ==========================================================
 * modified by name on time 
 * description:
 * 
 *
 ***********************************************************
 */
public class StringUtil {
    
	
	/**
	 * ****************************************
	 * function: 判断对象是否为空(如果为空,return true)
	 * @param str
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-1-13下午1:11:04
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public static boolean isEmpty(Object str) {
		if ((str == null) || ("null".equals(str))) 
		{
		      return true;
	    }
	    return String.valueOf(str).length() < 1;		
	}
	
	/**
	 * ****************************************
	 * function: 判断字符串是否为空(空 ,return true)
	 * @param cs
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-1-13下午1:15:30
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public static boolean isBlank(CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0)
		{
			return true;
		}			
		for (int i = 0; i < strLen; i++)
		{
			if (!Character.isWhitespace(cs.charAt(i)))
			{
				return false;
			}
				
		}
		return true;
	}
	
}
