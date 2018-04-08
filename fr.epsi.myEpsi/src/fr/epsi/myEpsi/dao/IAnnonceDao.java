package fr.epsi.myEpsi.dao;

import java.util.Date;
import java.util.List;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;
//import fr.epsi.myEpsi.dao.hsqlImpl.Date;
//import fr.epsi.myEpsi.dao.hsqlImpl.Double;
//import fr.epsi.myEpsi.dao.hsqlImpl.String;

public interface IAnnonceDao {
	List<Annonce> getAllAnnonces();

	Annonce getAnnonceById(int id);
	
	int getNbAnnonces();
	
	void addAnnonce(int id, String titre, String description, Double prix, Utilisateur vendeur, Date creation, int statut);
	
	void deleteAnnonce(int id);

	Annonce setAnnonceById(int id, String titre);
}
