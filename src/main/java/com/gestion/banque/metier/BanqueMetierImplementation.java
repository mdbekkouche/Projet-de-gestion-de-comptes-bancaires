package com.gestion.banque.metier;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gestion.banque.dao.IBanqueDao;
import com.gestion.banque.entities.Client;
import com.gestion.banque.entities.Compte;
import com.gestion.banque.entities.Employe;
import com.gestion.banque.entities.Groupe;
import com.gestion.banque.entities.Operation;
import com.gestion.banque.entities.Retrait;
import com.gestion.banque.entities.Versement;

@Transactional
public class BanqueMetierImplementation implements IBanqueMetier {

	private IBanqueDao dao;
	
	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		return dao.addClient(c);
	}

	@Override
	public Employe addEmploye(Employe e, Long codeSup) {
		return dao.addEmploye(e, codeSup);
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		return dao.addGroupe(g);
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGr) {
		dao.addEmployeToGroupe(codeEmp, codeGr);
		
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
		return dao.addCompte(cp, codeCli, codeEmp);
	}

	@Override
	public void verser(double mt, String cpte, Long codeEmp) {
	    dao.addOperation(new Versement(new Date(), mt), cpte, codeEmp);
	    Compte cp = dao.consulterCompte(cpte);
	    cp.setSolde(cp.getSolde()+mt);
	}

	@Override
	public void retirer(double mt, String cpte, Long codeEmp) {
		dao.addOperation(new Retrait(new Date(), mt), cpte, codeEmp);
	    Compte cp = dao.consulterCompte(cpte);
	    cp.setSolde(cp.getSolde()-mt);
		
	}

	@Override
	public void virement(double mt, String cpte1, String cpte2, Long codeEmp) {
		retirer(mt, cpte1, codeEmp);
		verser(mt, cpte2, codeEmp);
	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		return dao.consulterCompte(codeCpte);
	}

	

	@Override
	public Client consulterClient(Long codeCli) {
		return dao.consulterClient(codeCli);
	}

	@Override
	public List<Client> consulterClients(String mc) {
		return dao.consulterClients(mc);
	}

	@Override
	public List<Compte> getComptesParClient(Long codeCli) {
		return dao.getComptesParClient(codeCli);
	}

	@Override
	public List<Compte> getComptesParEmploye(Long codeEmp) {
		return dao.getComptesParEmploye(codeEmp);
	}

	@Override
	public List<Employe> getEmployes() {
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() {
		return dao.getGroupes();
	}

	@Override
	public List<Employe> getEmployesByGroupe(Long codeGr) {
		return dao.getEmployesByGroupe(codeGr);
	}

	@Override
	public List<Operation> consulterOperations(String codeCpte, int pos, int nbOp) {
		return dao.consulterOperations(codeCpte,pos, nbOp);
	}

	@Override
	public long getNombreOperations(String codeCpte) {
		return dao.getNombreOperations(codeCpte);
	}

}
