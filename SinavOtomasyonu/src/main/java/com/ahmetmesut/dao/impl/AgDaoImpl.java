package com.ahmetmesut.dao.impl;

import java.math.BigInteger;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ahmetmesut.dao.AgDao;
import com.ahmetmesut.model.ArastirmaGorevlisi;


@SuppressWarnings("unchecked")
@Repository
public class AgDaoImpl implements AgDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	//------------------------------------------
	
	public AgDaoImpl() {
		System.out.println("AgDaoImpl()");
	}

	//------------------------------------------
	
	@Override
	public void agOlustur(ArastirmaGorevlisi arastirmaGorevlisi) {
		sessionFactory.getCurrentSession().save(arastirmaGorevlisi);
	}

	@Override
	public void agSil(long agId) {
		ArastirmaGorevlisi ag = new ArastirmaGorevlisi();
		ag.setAgId(agId);
		sessionFactory.getCurrentSession().delete(ag);
	}

	@Override
	public ArastirmaGorevlisi agGuncelle(ArastirmaGorevlisi arastirmaGorevlisi) {
		sessionFactory.getCurrentSession().update(arastirmaGorevlisi);
		return arastirmaGorevlisi;
	}

	@Override
	public List<ArastirmaGorevlisi> butunAg() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM " + ArastirmaGorevlisi.class.getName()).list();
	}

	@Override
	public List<ArastirmaGorevlisi> agAra(String arananAg) {
		
		String sqlSorgusu = "SELECT a.* FROM ArastirmaGorevlisi a WHERE a.agAdi LIKE '"+ arananAg +"%'";
		
		List<Object[]> agObjects = sessionFactory.getCurrentSession().createSQLQuery(sqlSorgusu).list();        


		List<ArastirmaGorevlisi> agLer = new ArrayList<ArastirmaGorevlisi>();
       
		for(Object[] agObject: agObjects) {
			ArastirmaGorevlisi ag = new ArastirmaGorevlisi();
			
			long agId = ((BigInteger) agObject[0]).longValue();
			String agAdi = (String) agObject[1];
			String agSoyadi = (String) agObject[2];
			String agBolumu = (String) agObject[3];
			
			ag.setAgId(agId);
			ag.setAgAdi(agAdi);
			ag.setAgSoyadi(agSoyadi);
			ag.setAgBolumu(agBolumu);
		
			agLer.add(ag);
		}
		
		System.out.println(agLer);
		return agLer;
	}


	@Override
	public ArastirmaGorevlisi agAraId(long agId) {
		return sessionFactory.getCurrentSession().get(ArastirmaGorevlisi.class, agId);
	}

}
