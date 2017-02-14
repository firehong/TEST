package com.common.base;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;


@SuppressWarnings("rawtypes")
@Repository("baseDao")
public class BaseDao implements Serializable{

	private static final long serialVersionUID = -8801380828163126776L;
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    /**
     * ****************************************
     * function: 查询
     * @param sql sql语句
     * @param params 参数object[] 可为空
     * @param tClass 查询对象class
     * @return
     * 
     * ========================================
     * created by wuhong on 2017-2-10下午8:42:07
     * description: 
     * ========================================
     * modified by name on time 
     * description:
     * 
     * 
     *****************************************
     */
    public <T> List<T> find(String sql, Object[] params, Class<T> tClass) {
        List<T> resultList = null;
        if (params != null && params.length > 0)
        {
            resultList = jdbcTemplate.query(sql, 
            		params, new BeanPropertyRowMapper<T>(tClass));
        }
        else
        {
        	  // BeanPropertyRowMapper是自动映射实体类的
            resultList = jdbcTemplate.query(sql, 
            		new BeanPropertyRowMapper<T>(tClass));
        } 
        return resultList;
    }
    
    /**
     * ****************************************
     * function: 添加或者更新对象
     * @param sql sql
     * @param params 参数 object[]
     * @param tClass 
     * @return
     * 
     * ========================================
     * created by wuhong on 2017-2-10下午8:47:38
     * description: 
     * ========================================
     * modified by name on time 
     * description:
     * 
     * 
     *****************************************
     */
    public <T> int addOrUpdateOrDelete(String sql, 
    		final Object[] params, Class<T> tClass) {
        int num = 0;
        if (params == null || params.length == 0)
        {
        	 num = jdbcTemplate.update(sql);
        }              
        else
        {
        	 num = jdbcTemplate.update(sql, new PreparedStatementSetter() 
             {
                  public void setValues(PreparedStatement ps) 
                  		throws SQLException 
                  {
                      for (int i = 0; i < params.length; i++)
                          ps.setObject(i + 1, params[i]);
                  }
             });
        }     
        return num;
    }



}
