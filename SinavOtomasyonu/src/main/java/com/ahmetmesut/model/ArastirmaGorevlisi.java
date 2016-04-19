package com.ahmetmesut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Arastirma_Gorevlisi")
public class ArastirmaGorevlisi implements Serializable {
	
	private static final long serialVersionUID = -443351262600948785L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long agId;
	@Column
	private String agAdi;
	@Column
	private String agSoyadi;
	@Column
	private String agBolumu;
	//------------------------

	public ArastirmaGorevlisi() {
		System.out.println("ArastirmaGorevlisi()");
	}
	public ArastirmaGorevlisi(String agAdi, String agSoyadi, String agBolumu) {
		this.agAdi = agAdi;
		this.agSoyadi = agSoyadi;
		this.agBolumu = agBolumu;
	}
	//-----------------------------
	public long getAgId() {
		return agId;
	}
	public void setAgId(long agId) {
		this.agId = agId;
	}
	public String getAgAdi() {
		return agAdi;
	}
	public void setAgAdi(String agAdi) {
		this.agAdi = agAdi;
	}
	public String getAgSoyadi() {
		return agSoyadi;
	}
	public void setAgSoyadi(String agSoyadi) {
		this.agSoyadi = agSoyadi;
	}
	public String getAgBolumu() {
		return agBolumu;
	}
	public void setAgBolumu(String agBolumu) {
		this.agBolumu = agBolumu;
	}

	
	
}
