package com.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

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
 * function: 全局异常处理器
 * ==========================================================
 * created by wuhong on 2017-1-13上午10:55:30
 * description:
 * 
 * ==========================================================
 * modified by name on time 
 * description:
 * 
 *
 ***********************************************************
 */
public class CommonExceptionResolver implements HandlerExceptionResolver{
	
	/********日志记录***********/
	protected Logger log = Logger.getLogger(this.getClass());
	//系统抛出的异常 
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
        //handler就是处理器适配器要执行的Handler对象(只有method)  
        //解析出异常类型。  

        //如果该 异常类型是系统 自定义的异常，直接取出异常信息，在错误页面展示。  
		MyException myException=null;
		if(ex instanceof MyException)
		{  
			myException=(MyException)ex;              
        }
		else
		{  
            //如果该 异常类型不是系统 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）。  
        	myException=new MyException("未知错误");  
        }  
		//获取方法名
		String method = request.getRequestURI();
        //日志记录
		log.error("\r\n方法-->"+method+"-->出现异常信息如下:\r\n"+ex.getMessage(),ex); 
        //错误信息  
        String message=myException.getMessage();  
          
        ModelAndView modelAndView=new ModelAndView();  
        
        //将错误信息传到页面  
        modelAndView.addObject("message",message);  
        
        //指向到错误界面  
        modelAndView.setViewName("error/error");    
        
        return modelAndView;  

	}

}
