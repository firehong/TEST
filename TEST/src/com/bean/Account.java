package com.bean;

import java.io.Serializable;

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
 * created by wuhong on 2017-2-11下午12:53:02
 * description: 帐号实体类
 * 
 * ==========================================================
 * modified by name on time 
 * description:
 * 
 *
 ***********************************************************
 */
public class Account implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3402311157906873178L;
	private Long code; //编码
	private String name;//名称
	private String note;//备注
	private Byte status;//状态
	private Byte type; //账户类型
	private Long created;//创建时间
	private Long updated;//更新时间
	public String isactive; //有效状态  ‘Y’有效  ‘N’无效
		
	public Account() {
		super();
	}
	
	
	public Account(Long code, String name, String note,
			Byte status, Byte type, Long created, Long updated,String isactive) {
		super();
		this.code = code;
		this.name = name;
		this.note = note;
		this.status = status;
		this.type = type;
		this.created = created;
		this.updated = updated;
		this.isactive = isactive;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}
	public Long getCreated() {
		return created;
	}
	public void setCreated(Long created) {
		this.created = created;
	}
	public Long getUpdated() {
		return updated;
	}
	public void setUpdated(Long updated) {
		this.updated = updated;
	}


	public String getIsactive() {
		return isactive;
	}


	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	
	
	
}
