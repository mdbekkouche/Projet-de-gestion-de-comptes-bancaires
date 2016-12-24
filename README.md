# Projet de gestion de comptes bancaires #####################

===========================================================

Le but de ce projet consiste à implémenter une application Web Java EE permettant la gestion de comptes bancaires. Ce projet concerne la mise en oeuvre des technologies JPA, Hibernate, Spting IOC (pour l'inversion de controle) et Spring MVC (pour la couche web de l'application).

===========================================================

 * Chaque compte est défini par un numéro, un solde et une date de création ;
 * Il existe deux types de comptes : les comptes courants et les comptes épargnes ; 
 * Un compte courant est un compte qui possède en plus un découvert ; 
 * Un compte épargne est un compte qui possède en plus un taux d'intérêt ;
 * Chaque compte appartient à un client et créé par un employé ;
 * Chaque client est défini par son code et som nom ;
 * Un employé est défini aussi par son code et son nom ;
 * Chaque employé peut appartenir à plusieurs groupes ;
 * Chaque groupe est défini par un code et un nom ;
 * Les groupes peuvent contenir plusieurs employés ;
 * Chaque compte peut subir plusieurs opérations ;
 * Il existe deux types d'opérations : versement et retrait ;
 * Chaque opération est effectuée par un employé ;
 * Chaque opération est définie par son numéro et sa date de création.

===========================================================

## L'application permet de réaliser les opérations suivantes :


 - Ajouter un client, un employé, un groupe, un employé à un groupe, un compte et une opération ;
 - Créer des comptes bancaires ;
 - Effectuer un versement d'un montant dans un compte ;
 - Effectuer un retrait d'un montant dans un compte :
      1. Pour un compte épargne, le retrait ne peux s'effectuer que si le solde est supperieur au montant à retirer ;
      2. Pour un compte courant, le retrait peut s'effectuer à condition que le solde final ne soit pas inférieur à découvert.
 - Effectuer un virement d'un montant d'un compte vers un autre, c'est-à-dire, retirer le montant du compte et le verser vers l'autre compte ;
 - Consulter le solde du compte ;
 - Consulter les comptes d'un client ;
 - Consulter les comptes créés par un employé ;
 - Consulter tous les employés ;
 - Consulter tous les groupes ;
 - Consulter les employés d'un groupe ;
 - Consulter les clients dont le nom contient un mot clé ;
 - Mettre à jour le solde du compte en tenant compte des intérêts pour les comptes épargnes ;
 - Consulter la liste des opérations effectueés sur le compte ;
 - Consulter le total des montants des retraits.

===========================================================

## L'application respecte les critères suivants : 

  + Elle se compose de trois couches : DAO, Métier et Web ;
  + L'inversion de conrôle est effectuée par le framework Spring ;
  + La couche Web est basée sur Spring MVC ;
  + La mapping ORM (Object Relationnel Mapping) est basé sur JPA et Hibernate ;
  + La gestion des transactions est assurée par Spring aussi ;
  + Le framework Spring Security assure la partie sécurité.
