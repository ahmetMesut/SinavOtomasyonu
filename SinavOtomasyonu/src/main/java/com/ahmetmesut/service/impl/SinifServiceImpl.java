package com.ahmetmesut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahmetmesut.dao.SinifDao;
import com.ahmetmesut.model.Sinif;
import com.ahmetmesut.service.SinifService;


@Transactional
@Service
public class SinifServiceImpl implements SinifService {
	
	@Autowired
	private SinifDao sinifDao;
	//----------------------------
	public SinifServiceImpl() {
		System.out.println("SinifServiceImpl()");
	}
	//----------------------------
	@Override
	public void sinifOlustur(Sinif sinif) {
		sinifDao.sinifOlustur(sinif);
		
	}

	@Override
	public List<Sinif> butunSiniflar() {
		return sinifDao.butunSiniflar();
	}

	@Override
	public List<Sinif> sinifAra(String sinifAdi) {
		return sinifDao.sinifAra(sinifAdi);
	}

	@Override
	public void sinifSil(long sinifId) {
		sinifDao.sinifSil(sinifId);
		
	}

	@Override
	public Sinif sinifGuncelle(Sinif sinif) {
		return sinifDao.sinifGuncelle(sinif);
	}

	@Override
	public Sinif sinifAraId(long sinifId) {
		return sinifDao.sinifAraId(sinifId);
	}
	@Override
	public List<Sinif> butunSinifAdlari() {
		return sinifDao.butunSinifAdlari();
	}


}
