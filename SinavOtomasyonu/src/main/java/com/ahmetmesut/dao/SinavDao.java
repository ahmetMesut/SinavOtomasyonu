package com.ahmetmesut.dao;

import java.util.List;

import com.ahmetmesut.model.Sinav;

public interface SinavDao {

	public void sinavOlustur(Sinav sinav);
	
	public void sinavSil(long sinavId);
	
	public Sinav sinavGuncelle(Sinav sinav);
	
	public List<Sinav> butunSinavlar();
	
	public List<Sinav> sinavAra(String sinavAdi);
	
	public Sinav sinavAraId(long sinavId);
	
	public List<String> saatAyarla();
	
	public List<String> gunAyarla();
}
