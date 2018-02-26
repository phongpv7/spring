package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
public class oderDetail {

	@Id
	@Column(name = "OrderID")
	private int OrderID;
	
	@JoinColumn(name = "ProductID")
	@ManyToOne
	private Product Product;
	
	@Column(name = "UnitPrice")
	private float UnitPrice;
	
	@Column(name = "Quantity")
	private int Quantity;
	
	@Column(name = "Discount")
	private float Discount;

	public oderDetail() {
		super();
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public float getDiscount() {
		return Discount;
	}

	public void setDiscount(float discount) {
		Discount = discount;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}
	
}
