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
import com.ahmetmesut.service.AgService;

@Controller
public class AgController {
	
	@Autowired
	AgService agService;
	
	private static final Logger logger = Logger.getLogger(AgController.class);
	
	//-------------------------------
	
	public AgController() {
		System.out.println("AgController()");
	}
	//--------------------------------

	
	 @RequestMapping("newAg")
	    public ModelAndView newAg(@ModelAttribute ArastirmaGorevlisi arastirmaGorevlisi) {
	    	logger.info("Ag ekleniyor. Bilgi : "+arastirmaGorevlisi);
	        return new ModelAndView("agForm");
	    }
	    
	    @RequestMapping("editAg")
	    public ModelAndView updateAg(@RequestParam long id, @ModelAttribute ArastirmaGorevlisi arastirmaGorevlisi) {
	    	logger.info("Ag duzenleniyor. Id : "+id);
	        arastirmaGorevlisi = agService.agAraId(id);
	        return new ModelAndView("agForm", "agObject", arastirmaGorevlisi);
	    }
	    
	    @RequestMapping("saveAg")
	    public ModelAndView saveAg(@ModelAttribute ArastirmaGorevlisi arastirmaGorevlisi) {
	    	logger.info("Ag kaydediliyor. : " + arastirmaGorevlisi);
	        if(arastirmaGorevlisi.getAgId() == 0){ 
	        	agService.agOlustur(arastirmaGorevlisi);
	        } else {
	        	agService.agGuncelle(arastirmaGorevlisi);
	        }
	        return new ModelAndView("redirect:listAllAg");
	    }
	    
	    @RequestMapping("removeAg")
	    public ModelAndView deleteAg(@RequestParam long id) {
	    	logger.info("Ag siliniyor. Id : "+id);
	        agService.agSil(id);
	        return new ModelAndView("redirect:listAllAg");
	    }
	    
	    @RequestMapping(value = {"getListAllag", "/listAllAg"})
	    public ModelAndView findAllAg() {
	    	logger.info("Butun arastirma gorevlileri.");
	        List<ArastirmaGorevlisi> agListe = agService.butunAg();
	        return new ModelAndView("agListe", "agListe", agListe);
	    }
	    
	    
	    @RequestMapping("searchAg")
	    public ModelAndView searchAg(@RequestParam("agAdi") String agAdi) { 
	    logger.info("Arama Ag. Ag isimleri: "+agAdi);
	    List<ArastirmaGorevlisi> agListe = agService.agAra(agAdi);
	    return new ModelAndView("agListe", "agListe", agListe); 
	    } 
	    
	
}
