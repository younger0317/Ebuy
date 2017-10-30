package com.ebuy.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author linbingyang
 * @version 1.1 2017-10-30
 * 资讯实体类
 *
 */
public class EasybuyNews implements Serializable {
	private int id; 				//编号
	private String title;			//标题
	private String content;			//内容
	private String createTime;		//录入日期
	
	//各属性的get、set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	//无参构造
	public EasybuyNews() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//全参构造
	public EasybuyNews(int id, String title, String content, String createTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}
	
	//toString
	@Override
	public String toString() {
		return "EasybuyNews [id=" + id + ", title=" + title + ", content="
				+ content + ", createTime=" + createTime + "]";
	}
	
	
	
	
	
	
	
}
