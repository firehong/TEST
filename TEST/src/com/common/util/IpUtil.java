package com.common.util;

import javax.servlet.http.HttpServletRequest;


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
 * function: IP地址工具类
 * ==========================================================
 * created by wuhong on 2017-1-13下午1:18:43
 * description:
 * 
 * ==========================================================
 * modified by name on time 
 * description:
 * 
 *
 ***********************************************************
 */
public class IpUtil {
  
  /**
   * ****************************************
   * function:  获取用户ip地址
   * @param request
   * @return
   * 
   * ========================================
   * created by wuhong on 2017-1-13下午1:19:48
   * description: 
   * ========================================
   * modified by name on time 
   * description:
   * 
   * 
   *****************************************
   */
  public static String getIpAddr(HttpServletRequest request) {
      String ip = request.getHeader("x-forwarded-for");
      if (ip == null || ip.length() ==   0 || "unknown".equalsIgnoreCase(ip)) 
      {
          ip = request.getHeader("Proxy-Client-IP");
      }
      if (ip == null || ip.length() ==   0 || "unknown".equalsIgnoreCase(ip)) 
      {
          ip = request.getHeader("WL-Proxy-Client-IP");
      }
      if (ip == null || ip.length() ==   0 || "unknown".equalsIgnoreCase(ip)) 
      {
          ip = request.getRemoteAddr();
      }
      if (ip.equals("0:0:0:0:0:0:0:1")) 
      {
          ip = "本地";
      }
      if (ip.split(",").length >   1) 
      {
          ip = ip.split(",")[  0];
      }
      return ip;
  }


  /**
   * ****************************************
   * function: 获取用户真实ip地址
   * @param request
   * @return
   * 
   * ========================================
   * created by wuhong on 2017-1-13下午1:20:36
   * description: 
   * ========================================
   * modified by name on time 
   * description:
   * 
   * 
   *****************************************
   */
  public static String getTrueIpAddr(HttpServletRequest request) {
      String ip = request.getHeader("X-Real-IP");
      if (!StringUtil.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) 
      {
          return ip;
      }
      ip = request.getHeader("X-Forwarded-For");
      if (!StringUtil.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) 
      {
          // 多次反向代理后会有多个IP值，第一个为真实IP。
          int index = ip.indexOf(',');
          if (index != -1) 
          {
              return ip.substring(0, index);
          } 
          else 
          {
              return ip;
          }
      } 
      else 
      {
          return request.getRemoteAddr();
      }
  }

  
}