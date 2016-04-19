package com.ahmetmesut.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ahmetmesut.model.Ders;
import com.ahmetmesut.service.DersService;

@Controller
public class DersController {
	
	@Autowired
	DersService dersService;
	
	private static final Logger logger = Logger.getLogger(DersController.class);
	
	//-------------------------------
	
	public DersController() {
		System.out.println("DersController()");
	}
	//--------------------------------

	
	 @RequestMapping("newDers")
	    public ModelAndView newDers(@ModelAttribute Ders ders) {
	    	logger.info("Ders ekleniyor. Bilgi : "+ders);
	        return new ModelAndView("dersForm");
	    }
	    
	    @RequestMapping("editDers")
	    public ModelAndView updateDers(@RequestParam long id, @ModelAttribute Ders ders) {
	    	logger.info("Ders duzenleniyor. Id : "+id);
	    	ders = dersService.dersAraId(id);
	        return new ModelAndView("dersForm", "dersObject", ders);
	    }
	    
	    @RequestMapping("saveDers")
	    public ModelAndView saveDers(@ModelAttribute Ders ders) {
	    	logger.info("Ders kaydediliyor. : " + ders);
	        if(ders.getId() == 0){ 
	        	dersService.derOluþtur(ders);;
	        } else {
	        	dersService.dersGuncelle(ders);
	        }
	        return new ModelAndView("redirect:listAllDers");
	    }
	    
	    @RequestMapping("removeDers")
	    public ModelAndView deleteDers(@RequestParam long id) {
	    	logger.info("Ders siliniyor. Id : "+id);
	        dersService.dersSil(id);
	        return new ModelAndView("redirect:listAllDers");
	    }
	    
	    @RequestMapping(value = {"getListAllders", "/listAllDers"})
	    public ModelAndView findAllDers() {
	    	logger.info("Butun dersler");
	        List<Ders> dersListe = dersService.butunDersler();
	        return new ModelAndView("dersListe", "dersListe", dersListe);
	    }
	    
	    
	    @RequestMapping("searchDers")
	    public ModelAndView searchDers(@RequestParam("dersAdi") String dersAdi) { 
	    logger.info("Arama Ders. Ders isimleri: "+dersAdi);
	    List<Ders> dersListe = dersService.dersAra(dersAdi);
	    return new ModelAndView("dersListe", "dersListe", dersListe); 
	    } 
	    

}
