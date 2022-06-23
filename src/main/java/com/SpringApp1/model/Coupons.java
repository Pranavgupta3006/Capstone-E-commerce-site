package com.SpringApp1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupons")
public class Coupons {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cid;
	
	public int getCid() {
		return Cid;
	}


	public void setCid(int cid) {
		Cid = cid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public int getCcategoryid() {
		return Ccategoryid;
	}


	public void setCcategoryid(int ccategoryid) {
		Ccategoryid = ccategoryid;
	}


	public String getDiscount_percentage() {
		return discount_percentage;
	}


	public void setDiscount_percentage(String discount_percentage) {
		this.discount_percentage = discount_percentage;
	}


	public String getCcode() {
		return Ccode;
	}


	public void setCcode(String ccode) {
		Ccode = ccode;
	}


	@Column(nullable=false, length=45)
	private String description;
	
	@Column(nullable=false)
	private int eid;
	
	@Column(nullable=true)
	private int Ccategoryid;
	
	@Column(nullable=false, length=20)
	private String discount_percentage;
	
	@Column(nullable=false,unique=true, length=6)
	private String Ccode;
	
	
	@Override
	public String toString() {
		return "Coupons{"+"Cid="+Cid+", description="+description+'\''+"eid="+eid+'\''+"Ccategoryid="+Ccategoryid+'\''+"discount_percentage="+discount_percentage+'\''+"Ccode="+Ccode+'\''+ '}';
	}
	
}
