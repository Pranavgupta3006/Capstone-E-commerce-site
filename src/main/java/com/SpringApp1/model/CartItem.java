package com.SpringApp1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Cart_id", unique = true)
	private int id;
	
	private int product_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	private int userid;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CartItem{"+"Cart_id="+id+", Product_id="+product_id+'\''+"User_id="+userid+'\''+ '}';
	}
	
	
	
	
}
