package com.ebuy.entity;

import java.io.Serializable;

/**
 * 
 * @author linbingyang
 * @version 1.1 2017-10-30
 * 商品实体类
 *
 */
public class EasybuyProduct implements Serializable{
	private int id;						//商品id
	private String name;				//商品名
	private String description; 		//商品描述
	private float price;				//商品价格
	private int stock;					//商品库存
	private int categoryLevel1Id;			//所属分类ID
	private int categoryLevel2Id;			//所属二级分类ID
	private int categoryLevel3Id;			//所属三级分类ID
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryLevel1Id() {
		return categoryLevel1Id;
	}
	public void setCategoryLevel1Id(int categoryLevel1Id) {
		this.categoryLevel1Id = categoryLevel1Id;
	}
	public int getCategoryLevel2Id() {
		return categoryLevel2Id;
	}
	public void setCategoryLevel2Id(int categoryLevel2Id) {
		this.categoryLevel2Id = categoryLevel2Id;
	}
	public int getCategoryLevel3Id() {
		return categoryLevel3Id;
	}
	public void setCategoryLevel3Id(int categoryLevel3Id) {
		this.categoryLevel3Id = categoryLevel3Id;
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
	public EasybuyProduct(int id, String name, String description, float price,
			int stock, int categoryLevel1Id, int categoryLevel2Id,
			int categoryLevel3Id, String fileName, int isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryLevel1Id = categoryLevel1Id;
		this.categoryLevel2Id = categoryLevel2Id;
		this.categoryLevel3Id = categoryLevel3Id;
		this.fileName = fileName;
		this.isDelete = isDelete;
	}
	
	//toString
	@Override
	public String toString() {
		return "EasybuyProduct [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", stock=" + stock
				+ ", categoryLevel1Id=" + categoryLevel1Id
				+ ", categoryLevel2Id=" + categoryLevel2Id
				+ ", categoryLevel3Id=" + categoryLevel3Id + ", fileName="
				+ fileName + ", isDelete=" + isDelete + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
