package com.ahmetmesut.service;

import java.util.List;

import com.ahmetmesut.model.Sinif;

public interface SinifService {
	
	public void sinifOlustur(Sinif sinif);
	
	public List<Sinif> butunSiniflar();
	
	public List<Sinif> sinifAra(String sinifAdi);
	
	public void sinifSil(long sinifId);
	
	public Sinif sinifGuncelle(Sinif sinif);
	
	public Sinif sinifAraId(long sinifId);
	
	public List<Sinif> butunSinifAdlari();

}
