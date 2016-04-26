package com.ahmetmesut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sinavlar")
public class Sinav implements Serializable {
	
	private static final long serialVersionUID = 9188603163945712846L;
	//---------------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sinavId;
	@Column
	private String sinavGunu;
	@Column
	private String sinavSaati;
	@Column
	private String sinavAdi;
	@Column
	private String sinavSinifi;
	@Column
	private String gozetmenHocasi;
	
	//---------------------------------
	
	public Sinav() {
		System.out.println("Sinav()");
	}
	
	public Sinav(long sinavId, String sinavSaati, String sinavAdi, String sinavSinifi, String gozetmenHocasi) {
		this.sinavId = sinavId;
		this.sinavSaati = sinavSaati;
		this.sinavAdi = sinavAdi;
		this.sinavSinifi = sinavSinifi;
		this.gozetmenHocasi = gozetmenHocasi;
	}

	public long getSinavId() {
		return sinavId;
	}

	public void setSinavId(long sinavId) {
		this.sinavId = sinavId;
	}

	public String getSinavSaati() {
		return sinavSaati;
	}

	public void setSinavSaati(String sinavSaati) {
		this.sinavSaati = sinavSaati;
	}

	public String getSinavAdi() {
		return sinavAdi;
	}

	public void setSinavAdi(String sinavAdi) {
		this.sinavAdi = sinavAdi;
	}

	public String getSinavSinifi() {
		return sinavSinifi;
	}

	public void setSinavSinifi(String sinavSinifi) {
		this.sinavSinifi = sinavSinifi;
	}

	public String getGozetmenHocasi() {
		return gozetmenHocasi;
	}

	public void setGozetmenHocasi(String gozetmenHocasi) {
		this.gozetmenHocasi = gozetmenHocasi;
	}

	public String getSinavGunu() {
		return sinavGunu;
	}

	public void setSinavGunu(String sinavGunu) {
		this.sinavGunu = sinavGunu;
	}

	
	//---------------------------------
	
	
	

}
