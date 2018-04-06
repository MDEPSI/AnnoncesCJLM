package fr.epsi.myEpsi.dao;

import java.util.List;

import fr.epsi.myEpsi.beans.Utilisateur;

public interface IUserDao {
	List<Utilisateur> getAllUsers();

	Utilisateur getUserById(int id);
}
