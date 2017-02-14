package com.account.service;

import java.io.Serializable;
import java.util.List;

import com.bean.Account;

/**
 * 
 * 
 * **********************************************************
 * 
 * copyright by 
 * 
 * 
 * ==========================================================
 * 模块介绍
 * version: v0.01.
 * function: 
 * ==========================================================
 * created by wuhong on 2017-2-13下午10:14:18
 * description:
 * 
 * ==========================================================
 * modified by name on time 
 * description:
 * 
 *
 ***********************************************************
 */
public interface AccountService {
	/**
	 * ****************************************
	 * function: 新增
	 * @param ac
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-2-13下午10:14:12
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public Serializable addNew(Account ac);
	
	/**
	 * ****************************************
	 * function:更新对象
	 * @param ac
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-2-14下午1:27:35
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public Serializable updateAccount(Account ac);
	/**
	 * ****************************************
	 * function: 查询全部
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-2-13下午10:14:33
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public List selectAll();
	/**
	 * ****************************************
	 * function:根据code查询对象
	 * @param id
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-2-13下午10:14:47
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public Account getAccountById(Long id);
	/**
	 * ****************************************
	 * function:根据时间查询集合对象
	 * @param start
	 * @param end
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-2-13下午10:15:05
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public List selectOne(Long start,Long end);
	/**
	 * ****************************************
	 * function:删除对象（伪删除）
	 * @param ac
	 * @return
	 * 
	 * ========================================
	 * created by wuhong on 2017-2-13下午10:15:25
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public boolean deleteObject(Account ac);
}
