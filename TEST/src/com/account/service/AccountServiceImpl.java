package com.account.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.account.Vo.AccountVo;
import com.bean.Account;

import com.common.base.BaseService;
import com.common.util.DateFormatUtil;

@SuppressWarnings("rawtypes")
@Service()
public class AccountServiceImpl extends BaseService implements AccountService{
    
	/**
	 * 新增
	 */
	@Override
	public Serializable addNew(Account ac) {
		Object[] param = {ac.getCode(),ac.getName(),ac.getNote(),ac.getStatus(),
				ac.getCreated(),ac.getUpdated(),ac.getType(),ac.getIsactive()};
		String sql = "insert into Account(code,name,note,status,created," +
				"updated,type,isactive) values(" +
				"?,?,?,?,?,?,?,?)";
		Serializable id=baseDao.addOrUpdateOrDelete(sql,param,Account.class);
		return id;
	}
	
	/**
	 * 查询全部
	 */
	@Override
	public List selectAll() {
		String sql = "select * from  account where isactive='Y'";
		List<Account> list=baseDao.find(sql,null,Account.class);
		List<AccountVo> vo = new ArrayList<AccountVo>();
		
		for (Account account : list) 
		{
			AccountVo av = new AccountVo();
			av.setCode(account.getCode());
			av.setName(account.getName());
			av.setNote(account.getNote());
			if(account.getStatus().equals(Byte.parseByte("1")))
			{   
				av.setStatus("正常");
			}
			else if(account.getStatus().equals(Byte.parseByte("2")))
			{
				av.setStatus("异常");
			}
			else
			{
				av.setStatus("锁定");
			}
			av.setType(account.getType().toString());
			av.setCreated(DateFormatUtil.
					Dateformat("yyyy-MM-dd HH:mm:ss",account.getCreated()));
			av.setUpdated(DateFormatUtil.
					Dateformat("yyyy-MM-dd HH:mm:ss",account.getUpdated()));
			vo.add(av);
		}
		return vo;
	}
    
	/**
	 * 根据时间段查询
	 */
	@Override
	public List selectOne(Long start,Long end){
		Object[] param = {start,end};
		String sql = "select * from  account where created>? and created < ? and isactive='Y'";
		List<Account> list=baseDao.find(sql,param,Account.class);
		List<AccountVo> vo = new ArrayList<AccountVo>();
		for (Account account : list) 
		{
			AccountVo av = new AccountVo();
			av.setCode(account.getCode());
			av.setName(account.getName());
			av.setNote(account.getNote());
			if(account.getStatus().equals(Byte.parseByte("1")))
			{   
				av.setStatus("正常");
			}
			else if(account.getStatus().equals(Byte.parseByte("2")))
			{
				av.setStatus("异常");
			}
			else
			{
				av.setStatus("锁定");
			}
			av.setType(account.getType().toString());
			av.setCreated(DateFormatUtil.
					Dateformat("yyyy-MM-dd HH:mm:ss",account.getCreated()));
			av.setUpdated(DateFormatUtil.
					Dateformat("yyyy-MM-dd HH:mm:ss",account.getUpdated()));
			vo.add(av);
		}
		return vo;
	}
    
	/**
	 * 删除对象
	 */
	@Override
	public boolean deleteObject(Account ac) {
		Object[] param = {ac.getUpdated(),ac.getCode()};
		String sql = "update Account set isactive = 'N' ,updated=? where code = ? ";
		baseDao.addOrUpdateOrDelete(sql,param,Account.class);
		return true;
	}
    
	/**
	 * 根据主键查询对象
	 */
	@Override
	public Account getAccountById(Long id) {
		Object[] param = {id};
		String sql = "select * from  account where isactive='Y' and code = ?";
		List<Account> list=baseDao.find(sql,param,Account.class);
		return list.get(0);
	}

	@Override
	public Serializable updateAccount(Account ac) {
		Object[] param = {ac.getName(),ac.getStatus(),ac.getNote(),
				ac.getUpdated(),ac.getCode()};
		String sql = "update Account set name = ? , status=? " +
				" , note=? ,updated=? where code = ? ";
		baseDao.addOrUpdateOrDelete(sql,param,Account.class);
		return 1;
	}



     

}
