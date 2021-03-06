package com.ahmetmesut.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahmetmesut.dao.DersDao;
import com.ahmetmesut.model.Ders;
import com.ahmetmesut.service.DersService;

@Transactional
@Service
public class DersServiceImpl implements DersService {
	
	@Autowired
	private DersDao dersDao;
	
	//-----------------------------
	public DersServiceImpl() {
		System.out.println("DersServiceImpl()");
	}
	//-----------------------------


	@Override
	public void derOlustur(Ders ders) {
		dersDao.derOlustur(ders);
		
	}

	@Override
	public List<Ders> butunDersler() {
		return dersDao.butunDersler();
	}

	@Override
	public List<Ders> dersAra(String dersAdi) {
		return dersDao.dersAra(dersAdi);
	}

	@Override
	public void dersSil(long dersId) {
		dersDao.dersSil(dersId);
		
	}

	@Override
	public Ders dersGuncelle(Ders ders) {
		return dersDao.dersGuncelle(ders);
	}

	@Override
	public Ders dersAraId(long dersId) {
		return dersDao.dersAraId(dersId);
	}


	@Override
	public List<Ders> butunDersAdlari() {
		return dersDao.butunDersAdlari();
	}

	
}
