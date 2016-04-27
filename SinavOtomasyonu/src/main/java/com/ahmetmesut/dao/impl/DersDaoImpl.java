package com.ahmetmesut.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ahmetmesut.dao.DersDao;
import com.ahmetmesut.model.Ders;
@SuppressWarnings("unchecked")
@Repository
public class DersDaoImpl implements DersDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	//---------------------------------------	
	public DersDaoImpl() {
		System.out.println("DersDaoImpl()");
	}
	//---------------------------------------	

	@Override
	public void derOlustur(Ders ders) {
    	sessionFactory.getCurrentSession().save(ders); 

	}

	@Override
	public List<Ders> butunDersler() {
		return sessionFactory.getCurrentSession().createQuery("FROM "+Ders.class.getName()).list();
	}

	@Override
	public List<Ders> dersAra(String arananDersAdi) {
		String sqlSorgusu = "SELECT d.* FROM Ders d WHERE d.dersAdi LIKE '"+ arananDersAdi +"%'";
		List<Object[]> dersObjects = sessionFactory.getCurrentSession().createSQLQuery(sqlSorgusu).list();        


		List<Ders> dersler = new ArrayList<Ders>();
       
		for(Object[] dersObject: dersObjects) {
			Ders ders = new Ders();
			
			long dersId = ((BigInteger) dersObject[0]).longValue();
			String dersAdi = (String) dersObject[1];
			String verildigiSene = (String) dersObject[2];
			String hocasi = (String) dersObject[3];
		
			ders.setDersId(dersId);
			ders.setDersAdi(dersAdi);
			ders.setVerildigiSene(verildigiSene);
			ders.setHocasi(hocasi);
								
			dersler.add(ders);
		}
		
		System.out.println(dersler);
		return dersler;
	}

	@Override
	public void dersSil(long dersId) {
		 Ders ders = new Ders();
		 ders.setDersId(dersId);
	     sessionFactory.getCurrentSession().delete(ders);
	}

	@Override
	public Ders dersGuncelle(Ders ders) {
		sessionFactory.getCurrentSession().update(ders); 
        return ders; 
	}

	@Override
	public Ders dersAraId(long dersId) {
		return sessionFactory.getCurrentSession().get(Ders.class, dersId);
	}

	@Override
	public List<Ders> butunDersAdlari() {
		return sessionFactory.getCurrentSession().createSQLQuery("SELECT dersAdi FROM okulveritabani.Ders").list();
	}

}
