package com.ahmetmesut.dao;

import java.util.List;

import com.ahmetmesut.model.ArastirmaGorevlisi;

public interface AgDao {
	
	public void agOlustur(ArastirmaGorevlisi arastirmaGorevlisi);
	
	public void agSil(long agId);
	
	public ArastirmaGorevlisi agGuncelle(ArastirmaGorevlisi arastirmaGorevlisi);
		
	public List<ArastirmaGorevlisi> butunAg();
	
	public List<ArastirmaGorevlisi> agAra(String agAdi);
	
	public ArastirmaGorevlisi agAraId(long agId);

}
