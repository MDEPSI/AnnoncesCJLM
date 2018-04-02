package fr.epsi.myEpsi.dao;

import java.util.List;

import fr.epsi.myEpsi.beans.Utilisateur;

public interface IUserDao {
	List<Utilisateur> getUsers(String id);

	boolean checkLogin(Utilisateur user);

	Utilisateur getUtilisateur(String id);
}
