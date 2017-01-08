package com.gestion.banque;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestion.banque.entities.Client;
import com.gestion.banque.entities.Compte;
import com.gestion.banque.entities.CompteCourant;
import com.gestion.banque.entities.CompteEpargne;
import com.gestion.banque.entities.Employe;
import com.gestion.banque.entities.Groupe;
import com.gestion.banque.entities.Operation;
import com.gestion.banque.metier.IBanqueMetier;

public class TestJPA {

	ClassPathXmlApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = 
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}

	
	// // // @Test
	// // // public void test1() {
	// // // IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");
	// // // metier.addClient(new Client("Client1","AD1"));
	// // // metier.addClient(new Client("Client2","AD2"));
	// // // metier.addEmploye(new Employe("Employe1"), null);
	// // // metier.addEmploye(new Employe("Employe2"), 1L);
	// // // metier.addEmploye(new Employe("Employe3"), 1L);
	// // // metier.addEmploye(new Employe("Employe4"), 2L);
	// // // metier.addEmploye(new Employe("Employe5"), 3L);
	// // // metier.addGroupe(new Groupe("Groupe1"));
	// // // metier.addGroupe(new Groupe("Groupe2"));
	// // // metier.addEmployeToGroupe(1L, 1L);
	// // // metier.addEmployeToGroupe(2L, 1L);
	// // // metier.addEmployeToGroupe(3L, 2L);
	// // // metier.addEmployeToGroupe(4L, 2L);
	// // // metier.addEmployeToGroupe(5L, 2L);
	// // //
	// // // metier.addCompte(new CompteCourant("CC1", new Date(), 9000, 8000),
	// 1L,
	// // // 2L);
	// // // metier.addCompte(new CompteEpargne("CE1", new Date(), 9000, 8000),
	// 2L,
	// // // 2L);
	// // //
	// // // metier.verser(10000, "CC1", 2L);
	// // // metier.retirer(5000, "CC1", 2L);
	// // // metier.virement(4000, "CC1", "CE1", 1L);
	// // //
	// // // }
	
	@Test
	public void test2() {
		IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");
		Compte compte = metier.consulterCompte("CC1");

		System.out.println("Date de création : " + compte.getDateCreation());
		System.out.println("Le solde : " + compte.getSolde());
		System.out.println("Client " + compte.getClient().getNomClient());
		System.out.println("Employe " + compte.getEmploye().getNomEmploye());

////		List<Operation> operations = metier.consulterOperations("CC1");
//
//		for (Operation operation : operations) {
//			System.out.println("Num de l'opération : "
//					+ operation.getNumeroOperation());
//			System.out.println("Date de création : "
//					+ operation.getDateOperation());
//			System.out.println("Employe : "
//					+ operation.getEmploye().getNomEmploye());
//			System.out.println("Type de l'opération : "
//					+ operation.getClass().getSimpleName());
//		}

	}

}
