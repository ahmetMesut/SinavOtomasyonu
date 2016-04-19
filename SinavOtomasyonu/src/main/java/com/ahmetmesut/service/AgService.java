package com.ahmetmesut.service;

import java.util.List;

import com.ahmetmesut.model.ArastirmaGorevlisi;

public interface AgService {

		
	public void agOlustur(ArastirmaGorevlisi arastirmaGorevlisi);
	
	public void agSil(long agId);
	
	public ArastirmaGorevlisi agGuncelle(ArastirmaGorevlisi arastirmaGorevlisi);
		
	public List<ArastirmaGorevlisi> butunAg();
	
	public List<ArastirmaGorevlisi> agAra(String agAdi);
	
	public ArastirmaGorevlisi agAraId(long agId);
}
