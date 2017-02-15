package com.account.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.service.AccountService;
import com.account.service.AccountServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bean.Account;
import com.common.util.DataTypeUtil;
import com.common.util.StringUtil;

 
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/account")  
public class AccountController {
    
   @Autowired
   private AccountService accountService;
	
   /**
    * ****************************************
    * function: 查询所有账户
    * @return
    * 
    * ========================================
    * created by wuhong on 2017-2-14下午2:11:19
    * description: 
    * ========================================
    * modified by name on time 
    * description:
    * 
    * 
    *****************************************
    */
   @RequestMapping(value="/all.do",method = RequestMethod.GET)  
   @ResponseBody
   public String getAllAccount(){  
	   String json = JSON.toJSONString(accountService.selectAll());
       return json;
    }
   
   /**
    * ****************************************
    * function:按开户时间查询
    * @param start
    * @param end
    * @param model
    * @return
    * 
    * ========================================
    * created by wuhong on 2017-2-14下午2:11:40
    * description: 
    * ========================================
    * modified by name on time 
    * description:
    * 
    * 
    *****************************************
    */
   @RequestMapping(value="/timeall.do",method = RequestMethod.GET)  
   @ResponseBody
   public String getTimeAccount(@RequestParam("start") String start, 
		   @RequestParam("end") String end, Model model){ 
	   
	   List<Account> ac = null;
       if(!StringUtil.isBlank(start)&&!StringUtil.isBlank(end))
       {
    	  ac = accountService.selectOne(Long.parseLong(start),
    		Long.parseLong(end));
       }
	   
	   String json = JSON.toJSONString(ac);
       return json;
    }
   
   /**
    * ****************************************
    * function:添加新的账户
    * @param name
    * @param note
    * @param type
    * @return
    * 
    * ========================================
    * created by wuhong on 2017-2-14下午2:11:59
    * description: 
    * ========================================
    * modified by name on time 
    * description:
    * 
    * 
    *****************************************
    */
   @RequestMapping(value="add.do", method = RequestMethod.POST) 
   public String addNewAccount(String name,String note,
		   String type) {  
       
       Account ac = new Account();
       ac.setName(name);
       ac.setNote(note);
       ac.setType(Byte.parseByte(type));
       ac.setStatus(Byte.parseByte("1"));
       ac.setCreated(new Date().getTime());
       ac.setUpdated(new Date().getTime());
       ac.setIsactive("Y");
       accountService.addNew(ac);        
       return "view/all";  
   }
   
   /**
    * ****************************************
    * function:更新账户信息
    * @param code
    * @param name
    * @param note
    * @param status
    * @return
    * 
    * ========================================
    * created by wuhong on 2017-2-14下午2:12:12
    * description: 
    * ========================================
    * modified by name on time 
    * description:
    * 
    * 
    *****************************************
    */
   @RequestMapping(value="updated.do", method = RequestMethod.POST) 
   public String updateAccount(String code,String name,String note,
		   String status) {  
       
       Account ac = new Account();
       ac.setCode(Long.parseLong(code));
       ac.setName(name);
       ac.setNote(note);
       ac.setStatus(Byte.parseByte(status));
       ac.setUpdated(new Date().getTime());
       accountService.updateAccount(ac);        
       return "view/all";  
   }
   
   /**
    * ****************************************
    * function:删除帐号
    * @param request
    * @return
    * 
    * ========================================
    * created by wuhong on 2017-2-14下午2:12:29
    * description: 
    * ========================================
    * modified by name on time 
    * description:
    * 
    * 
    *****************************************
    */
   @RequestMapping(value="dele.do", method = RequestMethod.GET) 
   @ResponseBody
   public String deleteAccount(HttpServletRequest request){
	   String code = request.getParameter("code");
	   Account ac = new Account();
	   ac.setCode(Long.parseLong(code));
	   ac.setUpdated(new Date().getTime());
	   accountService.deleteObject(ac);
	   return "SUCCESS";
   }
   
   /**
    * ****************************************
    * function:主页跳转
    * @return
    * 
    * ========================================
    * created by wuhong on 2017-2-14下午2:12:41
    * description: 
    * ========================================
    * modified by name on time 
    * description:
    * 
    * 
    *****************************************
    */
   @RequestMapping(value="/in.do",method = RequestMethod.GET)  
   public String index(){   

       return "view/all";
    }
   
   /**
    * ****************************************
    * function:帐号更新页跳转
    * @return
    * 
    * ========================================
    * created by wuhong on 2017-2-14下午2:12:51
    * description: 
    * ========================================
    * modified by name on time 
    * description:
    * 
    * 
    *****************************************
    */
   @RequestMapping(value="/update.do",method = RequestMethod.GET)  
   public String update(){   

       return "view/update";
    }
   
   /**
    * ****************************************
    * function:注册页 跳转
    * @return
    * 
    * ========================================
    * created by wuhong on 2017-2-14下午2:13:11
    * description: 
    * ========================================
    * modified by name on time 
    * description:
    * 
    * 
    *****************************************
    */
   @RequestMapping(value="/reg.do",method = RequestMethod.GET)  
   public String login(){   
       return "view/Register";
    }
   

    
}
