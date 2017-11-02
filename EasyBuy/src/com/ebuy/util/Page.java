package com.ebuy.util;

import java.util.List;

import com.ebuy.entity.EasybuyProduct;

/**
 * 
 * @author awwensheng
 * @version 2017.11.01
 *分页工具类
 */
public class Page {

	private int currentNo;//当前页
	private int pageSize;//页量
	private int count;//商品总条数
	private int totalPageCount;//总页数
	private List<EasybuyProduct> productList;//存放查到的新闻列表
	
	public List<EasybuyProduct> getProductList() {
		return productList;
	}
	public void setProductList(List<EasybuyProduct> productList) {
		this.productList = productList;
	}
	public int getCurrentNo() {
		return currentNo;
	}
	public void setCurrentNo(int currentNo) {
		if (currentNo>0) {
			
			this.currentNo = currentNo;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if (pageSize>0) {
			this.pageSize = pageSize;
		}
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		if (count>=0) {
			this.count = count;
			//计算总页数
			totalPageCount=this.count%this.pageSize==0 ? 
					(this.count/this.pageSize):(this.count/this.pageSize+1);
		}
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	
	
	
}
