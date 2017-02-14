package com.common.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.util.IpUtil;


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
 * function: aop日志记录
 * ==========================================================
 * created by wuhong on 2017-1-13下午1:06:43
 * description:
 * 
 * ==========================================================
 * modified by name on time 
 * description:
 * 
 *
 ***********************************************************
 */
@Component
@Aspect
public class LogAspect {
    
	/*******日志记录*********/
	protected Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private HttpServletRequest req;
	
	@Before("execution(* com.*.controller.*.*(..))") 
    public void doBefore(JoinPoint jp) { 
/*		String ad = req.getHeader("TOKEN");
		AdminVo u = (AdminVo) redisCache.getCache(ad);
		String name = null;
		if(u!=null)
		{
			name = u.getName();    //获取操作 user
		}*/
		String ip = IpUtil.getIpAddr(req);  //获取操作IP
		//获取操作方法
		String method = jp.getTarget().getClass().getName() + " 类的 "+jp.getSignature().getName();
        String logStr = "\r\n user:"+null+";\r\n method:"+method+";\r\n ip:"+ip;
        log.info(logStr);  
    } 
}
