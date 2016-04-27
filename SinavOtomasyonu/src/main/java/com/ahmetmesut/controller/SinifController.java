package com.ahmetmesut.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ahmetmesut.model.Sinif;
import com.ahmetmesut.service.SinifService;

@Controller
public class SinifController {
	
	@Autowired
	SinifService sinifService;
	
	private static final Logger logger = Logger.getLogger(SinifController.class);
	
	//-------------------------------
	
	public SinifController() {
		System.out.println("SinifController()");
	}
	//--------------------------------

	
	 @RequestMapping("newSinif")
	    public ModelAndView newSinif(@ModelAttribute Sinif sinif) {
	    	logger.info("Sinif ekleniyor. Bilgi : "+sinif);
	        return new ModelAndView("sinifForm");
	    }
	    
	    @RequestMapping("editSinif")
	    public ModelAndView updateSinif(@RequestParam long id, @ModelAttribute Sinif sinif) {
	    	logger.info("Sinif duzenleniyor. Id : "+id);
	    	sinif = sinifService.sinifAraId(id);
	        return new ModelAndView("sinifForm", "sinifObject", sinif);
	    }
	    
	    @RequestMapping("saveSinif")
	    public ModelAndView saveSinif(@ModelAttribute Sinif sinif) {
	    	logger.info("Ders kaydediliyor. : " + sinif);
	        if(sinif.getSinifId() == 0){ 
	        	sinifService.sinifOlustur(sinif);
	        } else {
	        	sinifService.sinifGuncelle(sinif);
	        }
	        return new ModelAndView("redirect:listAllSinif");
	    }
	    
	    @RequestMapping("removeSinif")
	    public ModelAndView deleteSinif(@RequestParam long id) {
	    	logger.info("Ders siliniyor. Id : "+id);
	        sinifService.sinifSil(id);
	        return new ModelAndView("redirect:listAllSinif");
	    }
	    
	    @RequestMapping(value = {"getListAllsinif", "/listAllSinif"})
	    public ModelAndView findAllSinif() {
	    	logger.info("Butun siniflar");
	        List<Sinif> sinifListe = sinifService.butunSiniflar();
	        return new ModelAndView("sinifListe", "sinifListe", sinifListe);
	    }
	    
	    
	    @RequestMapping("searchSinif")
	    public ModelAndView searchSinif(@RequestParam("sinifAdi") String sinifAdi) { 
	    logger.info("Arama Sinif. Sinif isimleri: "+ sinifAdi);
	    List<Sinif> sinifListe = sinifService.sinifAra(sinifAdi);
	    return new ModelAndView("sinifListe", "sinifListe", sinifListe); 
	    } 
	    


}
