package com.ebuy.entity;

import java.io.Serializable;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-29
 * 商品分类实体类
 *
 */
public class EasybuyProductCategory implements Serializable {
	
	private int id;  				//分类id
	private String name;			//分类名字
	private int parentId;			//父级分类id
	private int type;				//分类类型  1:一级分类；2：二级分类；3：三级分类
	
	//各属性get、set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		if(type<1||type>3){
			type =1;
		}
		this.type = type;
	}
	
	//无参构造
	public EasybuyProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	//全参构造
	public EasybuyProductCategory(int id, String name, int parentId, int type) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
	}
	
	//toString
	@Override
	public String toString() {
		return "EasybuyProductCategory [id=" + id + ", name=" + name
				+ ", parentId=" + parentId + ", type=" + type + "]";
	}
	
	
	
	
	
}
