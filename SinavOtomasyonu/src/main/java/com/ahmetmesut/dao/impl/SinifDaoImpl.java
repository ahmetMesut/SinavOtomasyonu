package com.ahmetmesut.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ahmetmesut.dao.SinifDao;
import com.ahmetmesut.model.Sinif;

@SuppressWarnings("unchecked")
@Repository
public class SinifDaoImpl implements SinifDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	//---------------------------------
	
	public SinifDaoImpl() {
		System.out.println("SinifDaoImpl()");
	}
	
	//------------------------------------
	@Override
	public void sinifOluþtur(Sinif sinif) {
		sessionFactory.getCurrentSession().save(sinif);
	}

	@Override
	public List<Sinif> butunSiniflar() {
        return sessionFactory.getCurrentSession().createQuery("FROM "+Sinif.class.getName()).list();        

	}

	@Override
	public List<Sinif> sinifAra(String arananSinifAdi) {

		String sqlSorgusu = "SELECT s.* FROM Sinif s WHERE s.sinifAdi LIKE '"+ arananSinifAdi +"%'";
		List<Object[]> sinifObjects = sessionFactory.getCurrentSession().createSQLQuery(sqlSorgusu).list();        


		List<Sinif> siniflar = new ArrayList<Sinif>();
       
		for(Object[] sinifObject: sinifObjects) {
			Sinif sinif = new Sinif();
			
			long sinifId = ((BigInteger) sinifObject[0]).longValue();
			String sinifAdi = (String) sinifObject[1];
			long sinifKapasite = ((BigInteger) sinifObject[2]).longValue();
			String bolumu = (String) sinifObject[3];
		
			sinif.setSinifId(sinifId);
			sinif.setSinifAdi(sinifAdi);
			sinif.setSinifKapasite(sinifKapasite);
			sinif.setBolumu(bolumu);
			
			siniflar.add(sinif);
	}
		System.out.println(siniflar);
		return siniflar;
		
	}

	@Override
	public void sinifSil(long sinifId) {
		Sinif sinif = new Sinif();
		sinif.setSinifId(sinifId);
        sessionFactory.getCurrentSession().delete(sinif);    		
	}

	@Override
	public Sinif sinifGuncelle(Sinif sinif) {
		sessionFactory.getCurrentSession().update(sinif); 
        return sinif; 
	}

	@Override
	public Sinif sinifAraId(long sinifId) {
		return sessionFactory.getCurrentSession().get(Sinif.class, sinifId);

	}

}
