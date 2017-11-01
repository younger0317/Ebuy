package com.ebuy.entity;

import java.util.List;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-11-1
 * 分页实体类
 *
 */
public class Page<T> {
	private int currentNo;			//当前页
	private int pageSize;			//页大小
	private int totalCount;			//总条数
	private int totalPageCount;		//总页数
	private List<T> pageList;		//页面集合
	
	//get、set方法
	public int getCurrentNo() {
		return currentNo;
	}
	public void setCurrentNo(int currentNo) {
		this.currentNo = currentNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	
	//无参构造
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	//有参构造
	public Page(int currentNo, int pageSize, int totalCount,
			int totalPageCount, List<T> pageList) {
		super();
		this.currentNo = currentNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPageCount = totalPageCount;
		this.pageList = pageList;
	}
	
	
	
	
}
