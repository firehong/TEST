package com.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;



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
 * function: 数据格式转换工具类
 * ==========================================================
 * created by wuhong on 2017-1-18下午1:43:25
 * description:
 * 
 * ==========================================================
 * modified by name on time 
 * description:
 * 
 *
 ***********************************************************
 */
public class DataTypeUtil {
	//日志记录
	protected static Logger log = Logger.getLogger(DataTypeUtil.class);
    
	
	
	/**
	 * ****************************************
	 * function: json字符串转实体对象(适用于单个对象的转换)
	 * @param jsonData  json字符串
	 * @param clazz  目标实体类型
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-1-18下午2:08:26
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	@SuppressWarnings("unchecked")
	public static <T> T JsonToObject(String jsonData,Class<T> clazz){
		try {
			Object pojo;
			JSONObject jsonObject = JSONObject.parseObject(jsonData);
			pojo = JSONObject.toJavaObject(jsonObject, clazz);
			return (T) pojo;
		} catch (Exception e) {
		    log.error("json字符串转实体对象失败", e);
		    return null;
		}
	}
	
	/**
	 * ****************************************
	 * function: json字符串转实体对象集合(适用于多个对象)
	 * @param jsonData 对象集合字符串
	 * @param clazz 对象类型
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-1-18下午2:27:34
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public static <T>List<T> JsonToListObject(String jsonData,Class<T> clazz){
		try {
			List<T> list = new ArrayList<T>();
			JSONArray jsonArray = JSONArray.parseArray(jsonData);
			
			for (int i = 0; i < jsonArray.size(); i++) {
				T pojo;
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				pojo = JSONObject.toJavaObject(jsonObject, clazz);
				list.add(pojo);
			}	
			return list;
		} catch (Exception e) {
		    log.error("json字符串转实体对象集合失败", e);
		    return null;
		}
	} 
	
	/**
	 * ****************************************
	 * function: Object转json字符串
	 * @param obj 
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-1-18下午2:41:10
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public static String ObjectToJson(Object obj){
		try {
			return JSON.toJSONString(obj);
		} catch (Exception e) {
		    log.error("实体对象转json字符串失败", e);
		    return null;
		}		
	}
	
        
}
