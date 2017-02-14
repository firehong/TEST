package com.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;


/**
 * 
 * **********************************************************
 * 
 * copyright by 
 * 
 * 
 * ==========================================================
 * 模块介绍
 * version: v0.01.
 * function: aop异常日志记录
 * ==========================================================
 * created by wuhong on 2017-1-13上午11:08:22
 * description:
 * 
 * ==========================================================
 * modified by name on time 
 * description:
 * 
 *
 ***********************************************************
 */
public class ExceptionAspect {
	  
	  /********日志记录***********/
	  private Logger logger = Logger.getLogger(this.getClass());  
	  
	  public void doThrowing(JoinPoint jp, Throwable ex) {  
		    //获取方法名
		    String method = 
		    		jp.getTarget().getClass().getName() + 
		    		"--> "+jp.getSignature().getName();
		  
	        //获取参数名  
	        Signature signature = jp.getSignature();  
	        MethodSignature methodSignature = (MethodSignature) signature;  
	        String[] paramNameArr = methodSignature.getParameterNames();  
	  
	        //获取参数值  
	        Object[] paramValueArr = jp.getArgs();  
	        StringBuilder sbd = new StringBuilder("pparam-->");  
	        for(int i=0;i<paramValueArr.length;i++){  
	            sbd.append(paramNameArr[i]+":"+paramValueArr[i]+",");  
	        }  
	        //日志记录
	        logger.error(method+"-->"+sbd);  
	    }  
}
