package com.SpringApp1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data

public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="product_id")
	private int id;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
//	public int Stock() {
//		return stock;
//	}
//	public void setStock(int stock) {
//		this.stock = stock;
//	}
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private Category category;
	private Double price;
	private String description;
	private String image;
	private String stock;
	private int Quantity;
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Products(String name, Category category, Double price, String description, String image, String stock,
			int quantity) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
		this.image = image;
		this.stock = stock;
		Quantity = quantity;
	}
	public Products() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", description=" + description + ", image=" + image + ", stock=" + stock + ", Quantity=" + Quantity
				+ "]";
	}
	
	
	
	

}
