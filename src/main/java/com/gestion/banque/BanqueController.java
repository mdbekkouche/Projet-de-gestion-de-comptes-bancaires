package com.gestion.banque;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion.banque.entities.Compte;
import com.gestion.banque.metier.IBanqueMetier;
import com.gestion.banque.model.BanqueForm;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("banqueForm", new BanqueForm());
		return "banque";
	}
	
	@RequestMapping(value="/chargerCompte")
	public String chargerCompte(@Valid BanqueForm bf, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "banque";
		}
		try {
			Compte compte = metier.consulterCompte(bf.getCode());
			bf.setTypeCompte(compte.getClass().getSimpleName());
			bf.setCompte(compte);
		} catch (Exception e) {
			bf.setException(e.getMessage());
		}
		model.addAttribute("banqueForm", bf);
		return "banque";
	}

}
