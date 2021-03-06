package fr.epsi.myEpsi.dao;

import java.util.List;

import fr.epsi.myEpsi.beans.Utilisateur;
//import fr.epsi.myEpsi.dao.hsqlImpl.String;

public interface IUserDao {
	List<Utilisateur> getAllUsers();

	Utilisateur getUserById(String id);
	
	void addUser(int id, String password, String nom, boolean administrateur);
}
