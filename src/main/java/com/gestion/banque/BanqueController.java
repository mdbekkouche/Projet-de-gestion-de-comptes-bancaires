package com.gestion.banque;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion.banque.entities.Compte;
import com.gestion.banque.entities.Operation;
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
		chargerCompte(bf);
		model.addAttribute("banqueForm", bf);
		return "banque";
	}
	
	@RequestMapping(value="/saveOperation")
	public String saveOperation(@Valid BanqueForm bf, BindingResult bindingResult) {
		
			try {
				if (bindingResult.hasErrors()) {
					return "banque";
				}
				if (bf.getAction() != null) {
					if (bf.getTypeOperation().equals("VERSEMENT")) {
						metier.verser(bf.getMontant(), bf.getCode(), 1L);
					} else if (bf.getTypeOperation().equals("RETRAIT")) {
						metier.retirer(bf.getMontant(), bf.getCode(), 1L);
					} else if (bf.getTypeOperation().equals("VIREMENT")) {
						metier.virement(bf.getMontant(), bf.getCode(),
								bf.getCode2(), 1L);
					}
				}
			} catch (Exception e) {
				bf.setException(e.getMessage());
			}
			chargerCompte(bf);
			
		return "banque";
    }
	
	public void chargerCompte(BanqueForm bf) {
			try {
				Compte compte = metier.consulterCompte(bf.getCode());
				bf.setTypeCompte(compte.getClass().getSimpleName());
				bf.setCompte(compte);
				int pos = bf.getNbLignes() * bf.getPage();				
				List<Operation> ops = metier.consulterOperations(bf.getCode(), pos, bf.getNbLignes());
				bf.setOperations(ops);
				long npOp = metier.getNombreOperations(bf.getCode());
				bf.setNbpages((int)(npOp/bf.getNbLignes())+1);
			} catch (Exception e) {
				bf.setException(e.getMessage());
			}

	}

}
