package com.common.base;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;



@Service("baseService")
public class BaseService {
	
	protected Logger log = Logger.getLogger(this.getClass());
    
	@Resource(name="baseDao")
    protected BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
}
