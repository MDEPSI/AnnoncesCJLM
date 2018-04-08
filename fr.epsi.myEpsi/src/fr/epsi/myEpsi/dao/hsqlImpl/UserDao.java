package fr.epsi.myEpsi.dao.hsqlImpl;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.IAnnonceDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao
{
	public static List<Utilisateur> getAllUsers() {
		List<Utilisateur> users = new ArrayList<>();
		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM UTILISATEURS");

			while (results.next()) {
				Utilisateur user = new Utilisateur();
				user.setId(results.getString(1));
				user.setPassword(results.getString(2));
				user.setAdministrateur(results.getBoolean(3));
				user.setNom(results.getString(4));

				users.add(user);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public static Utilisateur getUserById(int id) {
		Utilisateur user = new Utilisateur();
		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM UTILISATEURS WHERE ID = ?");

			if(results.next()){
				user.setId(results.getString(1));
				user.setPassword(results.getString(2));
				user.setAdministrateur(results.getBoolean(3));
				user.setNom(results.getString(4));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void addUser(int id, String password, String nom, boolean administrateur) {
		Utilisateur user = new Utilisateur();
		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("INSERT INTO UTILISATEURS (ID , PASSWORD ,  NAME, ISADMINISTRATOR) VALUES (?,?,?,?)");
			
			user.setId(results.getString(1));
			user.setPassword(results.getString(2));
			user.setAdministrateur(results.getBoolean(4));
			user.setNom(results.getString(3));
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
