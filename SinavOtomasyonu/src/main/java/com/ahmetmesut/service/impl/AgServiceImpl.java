package com.ahmetmesut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahmetmesut.dao.AgDao;
import com.ahmetmesut.model.ArastirmaGorevlisi;
import com.ahmetmesut.service.AgService;

@Transactional
@Service
public class AgServiceImpl implements AgService {
	
	@Autowired
	private AgDao agDao;
	
	//----------------------------
	
	public AgServiceImpl() {
		System.out.println("AgServiceImpl()");
	}
	//----------------------------

	@Override
	public void agOlustur(ArastirmaGorevlisi arastirmaGorevlisi) {
		agDao.agOlustur(arastirmaGorevlisi);
		
	}

	@Override
	public void agSil(long agId) {
		agDao.agSil(agId);
		
	}

	@Override
	public ArastirmaGorevlisi agGuncelle(ArastirmaGorevlisi arastirmaGorevlisi) {
		return agDao.agGuncelle(arastirmaGorevlisi);
	}

	@Override
	public List<ArastirmaGorevlisi> butunAg() {
		return agDao.butunAg();
	}

	@Override
	public List<ArastirmaGorevlisi> agAra(String agAdi) {
		return agDao.agAra(agAdi);
	}

	@Override
	public ArastirmaGorevlisi agAraId(long agId) {
		return agDao.agAraId(agId);
	}

	

}
