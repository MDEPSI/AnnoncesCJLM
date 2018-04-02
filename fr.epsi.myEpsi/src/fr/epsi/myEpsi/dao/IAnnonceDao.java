package fr.epsi.myEpsi.dao;

import java.util.List;

import fr.epsi.myEpsi.beans.Annonce;

public interface IAnnonceDao {
	List<Annonce> getAnnonces(String id);

	Annonce getAnnonce(int i);
}
