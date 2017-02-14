package com.common.exception;

import java.io.Serializable;



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
 * function: 自定义异常
 * ==========================================================
 * created by wuhong on 2017-1-13上午10:58:05
 * description:
 * 
 * ==========================================================
 * modified by name on time 
 * description:
 * 
 *
 ***********************************************************
 */
public class MyException extends Exception implements Serializable{
    
	private static final long serialVersionUID = -8236217056080679513L;
	
	/********异常信息***********/
    private String message; 
    
    public MyException(String message){  
        super(message);  
        this.message=message; 
    }  
  
  
    public String getMessage() {  
        return message;  
    }   
    public void setMessage(String message) {  
        this.message = message;  
    } 
}
