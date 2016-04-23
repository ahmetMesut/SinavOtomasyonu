package com.ahmetmesut.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ahmetmesut.model.ArastirmaGorevlisi;
import com.ahmetmesut.model.Ders;
import com.ahmetmesut.model.Sinav;
import com.ahmetmesut.model.Sinif;
import com.ahmetmesut.service.AgService;
import com.ahmetmesut.service.DersService;
import com.ahmetmesut.service.SinavService;
import com.ahmetmesut.service.SinifService;

@Controller
public class SinavController {
	
	@Autowired
	SinavService sinavService;
	@Autowired
	DersService dersService;
	@Autowired
	SinifService sinifService;
	@Autowired
	AgService agService;

	private static final Logger logger = Logger.getLogger(SinavController.class);
	
	//-----------------------------------
	
	public SinavController() {
		System.out.println("SinavController()");
	}
	//-----------------------------------

	@RequestMapping("newSinav")
	public ModelAndView newSinav(@ModelAttribute Sinav sinav){
		logger.info("Sinav ekleniyor.Bilgi : " +sinav);
		
		List<Ders> dersler = dersService.butunDersAdlari();
		List<Sinif> siniflar = sinifService.butunSinifAdlari();
		List<ArastirmaGorevlisi> agler = agService.butunAgAdlari();
		List<String> butunSaatler = sinavService.saatAyarla();
		
		ModelAndView mav = new ModelAndView("sinavForm");
		mav.addObject("dersler", dersler);
		mav.addObject("siniflar", siniflar);
		mav.addObject("agler", agler);
		mav.addObject("saatler",butunSaatler);
		
		return mav;

	}
	@RequestMapping("saveSinav")
	public ModelAndView saveSinav(@ModelAttribute Sinav sinav){
		logger.info("Sinav kaydediliyor.Bilgi: " + sinav);
		if (sinav.getSinavId() == 0) {
			sinavService.sinavOlustur(sinav);
		} else {
			sinavService.sinavGuncelle(sinav);
		}
		return new ModelAndView("redirect:listAllSinav");
		
	}
	@RequestMapping("editSinav")
	public ModelAndView updateSinif(@RequestParam long id,@ModelAttribute Sinav sinav){
		logger.info("Sinav düzenleniyor.Bilgi Id:" +id);
		sinav =sinavService.sinavAraId(id);
		return new ModelAndView("sinavForm", "sinavObject", sinav);
	}
	
	
	@RequestMapping("removeSinav")
    public ModelAndView deleteSinav(@RequestParam long id) {
    	logger.info("Sinav siliniyor. Id : "+id);
        sinavService.sinavSil(id);
        return new ModelAndView("redirect:listAllSinav");
    }
    
    @RequestMapping(value = {"getListAllsinav", "/listAllSinav"})
    public ModelAndView findAllSinav() {
    	logger.info("Butun sinavlar");
        List<Sinav> sinavListe = sinavService.butunSinavlar();
        return new ModelAndView("sinavListe", "sinavListe", sinavListe);
    }
    
    
    @RequestMapping("searchSinav")
    public ModelAndView searchSinav(@RequestParam("sinavAdi") String sinavAdi) { 
    logger.info("Arama Sinav. Sinav isimleri: "+ sinavAdi);
    List<Sinav> sinavListe = sinavService.sinavAra(sinavAdi);
    return new ModelAndView("sinavListe", "sinavListe", sinavListe); 
    } 
	
   
}
