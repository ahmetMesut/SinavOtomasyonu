package com.ahmetmesut.dao;

import java.util.List;

import com.ahmetmesut.model.Ders;

public interface DersDao {
	
	public void derOluþtur(Ders ders);
	
	public List<Ders> butunDersler();
	
	public List<Ders> dersAra(String dersAdi);
	
	public void dersSil(long dersId);
	
	public Ders dersGuncelle(Ders ders);
	
	public Ders dersAraId(long dersId);

}
