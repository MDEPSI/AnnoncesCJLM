package fr.epsi.myEpsi.dao.mockImpl;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Statuts;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.IAnnonceDao;

public class AnnonceDao implements IAnnonceDao {

	private static List<Annonce> listOfAnnonces;
	
	public AnnonceDao() {
		listOfAnnonces = new ArrayList<>();
		
		Annonce annonce = new Annonce();
		annonce.setId(1);
		annonce.setTitre("Title 1");
		annonce.setVendeur(new Utilisateur());
		annonce.getVendeur().setId("ADMIN");
		annonce.setStatut(Statuts.PUBLIE);
		listOfAnnonces.add(annonce);
		
		annonce = new Annonce();
		annonce.setId(2);
		annonce.setTitre("Title 2");
		annonce.setVendeur(new Utilisateur());
		annonce.getVendeur().setId("ADMIN");
		annonce.setStatut(Statuts.PUBLIE);
		listOfAnnonces.add(annonce);
		
		annonce = new Annonce();
		annonce.setId(3);
		annonce.setTitre("Title 3");
		annonce.setVendeur(new Utilisateur());
		annonce.getVendeur().setId("TEST");
		annonce.setStatut(Statuts.ANNULE);
		listOfAnnonces.add(annonce);
		
	}

	public List<Annonce> getAnnonces(String id) {
		// TODO Auto-generated method stub
		List<Annonce> myAnnonces = new ArrayList<>();
		for (Annonce annonce : listOfAnnonces) {
			if(annonce.getVendeur().getId().equals(id)
					|| annonce.getStatut() == Statuts.PUBLIE) {
				myAnnonces.add(annonce);
			}
		}
		return myAnnonces;
	}


	public Annonce getAnnonce(int id) {
		// TODO Auto-generated method stub
		Annonce myAnnonce = new Annonce();
		for (Annonce annonce : listOfAnnonces) {
			if(annonce.getId()==id) {
				myAnnonce = annonce;
			}
		}
		return myAnnonce;
	}

	@Override
	public List<Annonce> getAllAnnonces() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Annonce getAnnonceById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	@Override
	public int getNbAnnonces() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Annonce getAnnonceById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAnnonce(int id, String titre, String description, Double prix, Utilisateur vendeur, Date creation,
			int statut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAnnonce(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Annonce setAnnonceById(int id, String titre) {
		// TODO Auto-generated method stub
		return null;
	}

}
