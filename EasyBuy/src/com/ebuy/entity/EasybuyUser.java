package com.ebuy.entity;

import java.io.Serializable;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-29
 * 用户实体类
 *
 */
public class EasybuyUser implements Serializable {
	private int Id;					//用户Id
	private String userName ;       //用户真实姓名
	private String loginName;		//用户登陆名
	private String password;     	//密码
	private int sex;				//性别，1为男，0为女
	private String identityCode;    //身份证
	private String email;			//电子邮箱
	private String mobile;          //手机
	private int type;				//用户类型 1为管理员，0为用户
	
	
	//属性的get、set方法
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		if(sex<0 || sex >1){
			sex=0;
		}
		this.sex = sex;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		if(type<0 || type>1){
			type =0;
		}
		this.type = type;
	}
	
	//无参构造
	public EasybuyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	//全参构造
	public EasybuyUser(int id, String userName, String loginName,
			String password, int sex, String identityCode, String email,
			String mobile, int type) {
		super();
		Id = id;
		this.userName = userName;
		this.loginName = loginName;
		this.password = password;
		this.sex = sex;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
	}
	
	//toString
	@Override
	public String toString() {
		return "EasybuyUser [Id=" + Id + ", userName=" + userName
				+ ", loginName=" + loginName + ", password=" + password
				+ ", sex=" + sex + ", identityCode=" + identityCode
				+ ", email=" + email + ", mobile=" + mobile + ", type=" + type
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	

}
