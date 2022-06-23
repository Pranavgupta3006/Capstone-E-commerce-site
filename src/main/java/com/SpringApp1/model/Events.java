package com.SpringApp1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Eid;
	
	@Column(nullable=false, unique=true, length=45)
	private String Ename;
	
	@Column(nullable=false, length=255)
	private String Estartdate;
	
	@Column(nullable=false, length=255)
	private String Eenddate;
	
	public int getEid() {
		return Eid;
	}

	public void setEid(int eid) {
		Eid = eid;
	}

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public String getEstartdate() {
		return Estartdate;
	}

	public void setEstartdate(String estartdate) {
		Estartdate = estartdate;
	}

	public String getEenddate() {
		return Eenddate;
	}

	public void setEenddate(String eenddate) {
		Eenddate = eenddate;
	}

	@Override
	public String toString() {
		return "Events{"+"Eid="+Eid+",Ename="+Ename+'\''+"EStartdate="+Estartdate+'\''+"Eenddate="+Eenddate+'\''+'}';
	}
	
	
}
