package com.account.Vo;

import java.io.Serializable;

public class AccountVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9216374301953873120L;
	
	private Long code; //编码
	private String name;//名称
	private String note;//备注
	private String status;//状态
	private String type; //账户类型
	private String created;//创建时间
	private String updated;//更新时间
	
	
	public AccountVo() {
		super();
	}
	
	
	public AccountVo(Long code, String name, String note, String status,
			String type, String created, String updated) {
		super();
		this.code = code;
		this.name = name;
		this.note = note;
		this.status = status;
		this.type = type;
		this.created = created;
		this.updated = updated;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
