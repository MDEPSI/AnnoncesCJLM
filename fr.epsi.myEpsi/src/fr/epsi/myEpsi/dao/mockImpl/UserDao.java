package fr.epsi.myEpsi.dao.mockImpl;

import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Statuts;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.IUserDao;

public class UserDao implements IUserDao{
	
	private static List<Utilisateur> listOfUsers;
	
	public UserDao () {
		listOfUsers = new ArrayList<>();
		
		Utilisateur user = new Utilisateur();
		user.setId("ID");
		user.setNom("NOM");
		user.setPassword("PASSWORD");
		listOfUsers.add(user);
		
		user = new Utilisateur();
		user.setId("ID2");
		user.setNom("USER");
		user.setPassword("ADMIN");
		listOfUsers.add(user);
	}
	
	
	public List<Utilisateur> getUsers(String id) {
		// TODO Auto-generated method stub
		List<Utilisateur> myUsers = new ArrayList<>();
		for (Utilisateur user : listOfUsers) {
				myUsers.add(user);
		}
		return myUsers;
	}

	public Utilisateur getUtilisateur(String id) {
		// TODO Auto-generated method stub
		Utilisateur myUser = new Utilisateur();
		for (Utilisateur user : listOfUsers) {
			if(user.getId()==id) {
				myUser = user;
			}
		}
		return myUser;
	}
	
	public boolean checkLogin(Utilisateur user) {
		boolean accesOk = false;
		Utilisateur existingUser = null;
		for(Utilisateur u : listOfUsers) {
			if(u.getId().equals(user.getId())){
				existingUser = u;
			}
		}
		return accesOk;
	}


	@Override
	public List<Utilisateur> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public Utilisateur getUserById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}




	@Override
	public Utilisateur getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addUser(int id, String password, String nom, boolean administrateur) {
		// TODO Auto-generated method stub
		
	}


}
