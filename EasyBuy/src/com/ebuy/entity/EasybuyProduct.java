package com.ebuy.entity;

import java.io.Serializable;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-29
 * 商品实体类
 *
 */
public class EasybuyProduct implements Serializable{
	private int id;						//商品id
	private String name;				//商品名
	private String description; 		//商品描述
	private double price;				//商品价格
	private int stock;					//商品库存
	private int categoryLevel1;			//所属分类ID
	private int categoryLevel2;			//所属二级分类ID
	private int categoryLevel3;			//所属三级分类ID
	private String fileName;			//上传的文件名字
	private int isDelete;				//是否删除，1为删除，0为未删除
	
	//各属性的get、set方法
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryLevel1() {
		return categoryLevel1;
	}
	public void setCategoryLevel1(int categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}
	public int getCategoryLevel2() {
		return categoryLevel2;
	}
	public void setCategoryLevel2(int categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}
	public int getCategoryLevel3() {
		return categoryLevel3;
	}
	public void setCategoryLevel3(int categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		if(isDelete<0 || isDelete>1){
			isDelete=0;
		}
		this.isDelete = isDelete;
	}
	
	//无参构造
	public EasybuyProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	//全参构造
	public EasybuyProduct(int id, String name, String description,
			double price, int stock, int categoryLevel1, int categoryLevel2,
			int categoryLevel3, String fileName, int isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryLevel1 = categoryLevel1;
		this.categoryLevel2 = categoryLevel2;
		this.categoryLevel3 = categoryLevel3;
		this.fileName = fileName;
		this.isDelete = isDelete;
	}
	
	//toString
	@Override
	public String toString() {
		return "EasybuyProduct [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", stock=" + stock
				+ ", categoryLevel1=" + categoryLevel1 + ", categoryLevel2="
				+ categoryLevel2 + ", categoryLevel3=" + categoryLevel3
				+ ", fileName=" + fileName + ", isDelete=" + isDelete + "]";
	}
	
	
	
	
	
	
	
	
}
