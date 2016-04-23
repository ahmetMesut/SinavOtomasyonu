package com.ahmetmesut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ders")
public class Ders  implements Serializable{
	
	
	private static final long serialVersionUID = -1627478848433713216L;
	
	//---------------------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long dersId;
	@Column
	private String dersAdi;
	@Column
	private String verildigiSene;
	@Column
	private String hocasi;

	//----------------------
	public Ders() {
		System.out.println("Ders()");
	}

	public Ders(String dersAdi, String verildigiSene, String hocasi) {
		this.dersAdi = dersAdi;
		this.verildigiSene = verildigiSene;
		this.hocasi = hocasi;
	}
	//--------------------------

	public String getDersAdi() {
		return dersAdi;
	}

	public void setDersAdi(String dersAdi) {
		this.dersAdi = dersAdi;
	}

	public String getVerildigiSene() {
		return verildigiSene;
	}

	public void setVerildigiSene(String verildigiSene) {
		this.verildigiSene = verildigiSene;
	}

	public String getHocasi() {
		return hocasi;
	}

	public void setHocasi(String hocasi) {
		this.hocasi = hocasi;
	}

	public long getId() {
		return dersId;
	}

	public void setDersId(long dersId) {
		this.dersId = dersId;
	}
	 public long getDersId() {
		return dersId;
	}
	

}
