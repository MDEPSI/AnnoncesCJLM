package fr.epsi.myEpsi.dao.mockImpl;

import java.util.List;
import java.util.ArrayList;

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

	@Override
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

}
