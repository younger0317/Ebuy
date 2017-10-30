package com.ebuy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author linbingyang
 * @version 1.1 2017-10-30
 * 用户地址实体类
 *
 */
public class EasybuyUserAddress implements Serializable {
	
	private int id;   				//地址id
	private int userId;				//用户id
	private String address;			//地址
	private Date createTime;		//创建时间
	private int isDefault;			//是否是默认地址，1是，0否
	private String remark;			//备注
	
	//各属性的get、set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		if(isDefault<0 || isDefault>1){
			isDefault=0;
		}
		this.isDefault = isDefault;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	//无参构造
	public EasybuyUserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	//全参构造
	public EasybuyUserAddress(int id, String address, Date createTime,
			int userId, int isDefault, String remark) {
		super();
		this.id = id;
		this.address = address;
		this.createTime = createTime;
		this.userId = userId;
		this.isDefault = isDefault;
		this.remark = remark;
	}
	
	//toString
	@Override
	public String toString() {
		return "EasyBuyUserAddress [id=" + id + ", address=" + address
				+ ", createTime=" + createTime + ", userId=" + userId
				+ ", isDefault=" + isDefault + ", remark=" + remark + "]";
	}
	

	
	
	
	
}
