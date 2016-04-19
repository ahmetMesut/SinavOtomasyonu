package com.ahmetmesut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sinif")
public class Sinif implements Serializable {
	
	private static final long serialVersionUID = -6870757754704293004L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sinifId;
	@Column
	private String sinifAdi;
	@Column
	private long sinifKapasite;
	@Column
	private String bolumu;
	
	//------------------------

		public Sinif() {
		System.out.println("Sinif()");
	}

	public Sinif(String sinifAdi, int sinifKapasite, String bolumu) {
		this.sinifAdi = sinifAdi;
		this.sinifKapasite = sinifKapasite;
		this.bolumu = bolumu;
	}
	//--------------------------

	public String getSinifAdi() {
		return sinifAdi;
	}

	public void setSinifAdi(String sinifAdi) {
		this.sinifAdi = sinifAdi;
	}

	public long getSinifKapasite() {
		return sinifKapasite;
	}

	public void setSinifKapasite(long sinifKapasite) {
		this.sinifKapasite = sinifKapasite;
	}

	public String getBolumu() {
		return bolumu;
	}

	public void setBolumu(String bolumu) {
		this.bolumu = bolumu;
	}

	public long getSinifId() {
		return sinifId;
	}
	public void setSinifId(long sinifId) {
		this.sinifId = sinifId;
	}
	
	

}
