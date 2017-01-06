package com.gestion.banque.dao;

import java.util.List;

import com.gestion.banque.entities.Client;
import com.gestion.banque.entities.Compte;
import com.gestion.banque.entities.Employe;
import com.gestion.banque.entities.Groupe;
import com.gestion.banque.entities.Operation;

public interface IBanqueDao {
	public Client addClient(Client c);
	public Employe addEmploye(Employe e,Long codeSup);
	public Groupe addGroupe(Groupe g);
	public void addEmployeToGroupe(Long codeEmp,Long codeGr);
	public Compte addCompte(Compte cp,Long codeCli, Long codeEmp);
	public Operation addOperation(Operation op, String codeCpte,Long codeEmp);
	public Compte consulterCompte(String codeCpte);
	public List<Operation> consulterOperations(String codeCpte, int position, int nbOp);
	public long getNombreOperations(String codeCpte);
	public Client consulterClient(Long codeCli);
	public List<Client> consulterClients(String mc);
	public List<Compte> getComptesParClient(Long codeCli);
	public List<Compte> getComptesParEmploye(Long codeEmp);
	public List<Employe> getEmployes();
	public List<Groupe> getGroupes();
	public List<Employe> getEmployesByGroupe(Long codeGr);
		
}
