package com.ebuy.entity;
/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-29
 * 订单详情类
 *
 */
public class EasybuyOrderDetail {
	
	private int id;				//编号
	private int orderId;		//订单ID
	private int productId;		//商品ID
	private int quantity;		//数量
	private double cost;		//金额
	
	//各属性get、set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	//无参构造
	public EasybuyOrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//全参构造
	public EasybuyOrderDetail(int id, int orderId, int productId, int quantity,
			double cost) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	//toString
	@Override
	public String toString() {
		return "EasybuyOrderDetail [id=" + id + ", orderId=" + orderId
				+ ", productId=" + productId + ", quantity=" + quantity
				+ ", cost=" + cost + "]";
	}
	
	
	
	
}
