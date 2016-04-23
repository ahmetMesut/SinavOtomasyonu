package com.ahmetmesut.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ahmetmesut.dao.SinavDao;
import com.ahmetmesut.model.Sinav;
@SuppressWarnings("unchecked")
@Repository
public class SinavDaoImpl implements SinavDao {

	@Autowired
	SessionFactory sessionFactory;
	
	//-------------------------------
	public SinavDaoImpl() {
		System.out.println("SinavDaoImpl()");
	}
	//-------------------------------

	@Override
	public void sinavOlustur(Sinav sinav) {
		sessionFactory.getCurrentSession().save(sinav);
	}

	@Override
	public void sinavSil(long sinavId) {
		Sinav sinav = new Sinav();
		sinav.setSinavId(sinavId);
		sessionFactory.getCurrentSession().delete(sinav);

	}

	@Override
	public Sinav sinavGuncelle(Sinav sinav) {
		sessionFactory.getCurrentSession().update(sinav);
		return sinav;
	}

	@Override
	public List<Sinav> butunSinavlar() {
		return sessionFactory.getCurrentSession().createQuery("FROM "+Sinav.class.getName()).list();
	}

	@Override
	public List<Sinav> sinavAra(String arananSinavAdi) {
		String sqlSorgusu = "SELECT s.* FROM Sinav s WHERE s.sinavAdi LIKE '"+ arananSinavAdi +"%'";
		List<Object[]> sinavObjects = sessionFactory.getCurrentSession().createSQLQuery(sqlSorgusu).list();        


		List<Sinav> sinavlar = new ArrayList<Sinav>();
       
		for(Object[] sinavObject: sinavObjects) {
			Sinav sinav = new Sinav();
			
			long sinavId = ((BigInteger) sinavObject[0]).longValue();
			String sinavSaati = (String) sinavObject[1];
			String sinavAdi = (String) sinavObject[2];
			String sinavSinifi = (String) sinavObject[3];
			String gozetmenHocasi = (String) sinavObject[4];
		
			sinav.setSinavId(sinavId);
			sinav.setSinavSaati(sinavSaati);
			sinav.setSinavAdi(sinavAdi);
			sinav.setSinavSinifi(sinavSinifi);
			sinav.setGozetmenHocasi(gozetmenHocasi);
			
			sinavlar.add(sinav);
	}
		System.out.println(sinavlar);
		return sinavlar;
		
	}

	@Override
	public Sinav sinavAraId(long sinavId) {
		return sessionFactory.getCurrentSession().get(Sinav.class, sinavId);
	}
	@Override
	public List<String> saatAyarla() {
		List<String> saatler = new ArrayList<String>();
		saatler.add("09:00");
		saatler.add("09:30");
		saatler.add("10:00");
		saatler.add("10:30");
		saatler.add("11:00");
		saatler.add("13:00");
		saatler.add("13:30");
		saatler.add("14:00");
		saatler.add("14:30");
		saatler.add("15:00");
		saatler.add("15:30");
		saatler.add("16:00");
		saatler.add("16:30");
		saatler.add("17:00");
		
		return saatler;
	}


}
