package com.dalel.vetements.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dalel.vetements.entities.Vetement;
import com.dalel.vetements.service.VetementService;

@Controller
public class VetementController {
	
	@Autowired
	VetementService vetementService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("vetement", new Vetement());
		modelMap.addAttribute("mode", "new");
		return "createVetement";
	}
	@RequestMapping("/saveVetement")
	public String saveVetement(@Valid Vetement vetement,BindingResult bindingResult) {
	
		if (bindingResult.hasErrors()) return "formVetement";

	 vetementService.saveVetement(vetement);
	
	return "formVetement";
	}

	@RequestMapping("/ListeVetement")
	public String listeVetement(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Vetement> v = vetementService.getAllVetementParPage(page, size);
	modelMap.addAttribute("vetements", v);
	modelMap.addAttribute("pages", new int[v.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeVetement";
	}
	@RequestMapping("/supprimerVetement")
	public String supprimerVetement(@RequestParam("id") Long id,
	 ModelMap modelMap,
	 @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{ 
	vetementService.deleteVetementById(id);
	Page<Vetement> vet = vetementService.getAllVetementParPage(page, size);
	modelMap.addAttribute("vetements", vet);
	modelMap.addAttribute("pages", new int[vet.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);

	return "listeVetement";
	}
	@RequestMapping("/modifierVetement")
	public String editerVetement(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Vetement v= vetementService.getVetement(id);
	modelMap.addAttribute("vetement", v);
	modelMap.addAttribute("mode", "edit");
	return "formVetement";
	}
	@RequestMapping("/updateVetement")
	public String updateVetement(@ModelAttribute("vetement") Vetement vetement,
	@RequestParam("date") String date,
	
	 ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateprod = dateformat.parse(String.valueOf(date));
	 vetement.setDateprod(dateprod);
	 
	 vetementService.updateVetement(vetement);
	 List<Vetement> v = vetementService.getAllVetement();
	 modelMap.addAttribute("vetements", v);
	return "listeVetement";
	}
	
}
