package com.ahmetmesut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahmetmesut.dao.SinavDao;
import com.ahmetmesut.model.Sinav;
import com.ahmetmesut.service.SinavService;

@Transactional
@Service
public class SinavServiceImpl implements SinavService {
	
	@Autowired
	private SinavDao sinavDao;
	
	//--------------------------------
	public SinavServiceImpl() {
		System.out.println("SinavServiceImpl()");
	}
	//--------------------------------
	@Override
	public void sinavOlustur(Sinav sinav) {
		sinavDao.sinavOlustur(sinav);
		
	}

	@Override
	public void sinavSil(long sinavId) {
		sinavDao.sinavSil(sinavId);
		
	}

	@Override
	public Sinav sinavGuncelle(Sinav sinav) {
		return sinavDao.sinavGuncelle(sinav);
	}

	@Override
	public List<Sinav> butunSinavlar() {
		return sinavDao.butunSinavlar();
	}

	@Override
	public List<Sinav> sinavAra(String sinavAdi) {
		return sinavDao.sinavAra(sinavAdi);
	}

	@Override
	public Sinav sinavAraId(long sinavId) {
		return sinavDao.sinavAraId(sinavId);
	}
	@Override
	public List<String> saatAyarla() {
		return sinavDao.saatAyarla();
	}

}
