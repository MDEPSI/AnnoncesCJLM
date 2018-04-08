package fr.epsi.myEpsi.dao.hsqlImpl;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.IAnnonceDao;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.listeners.StartupListener;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDao implements IUserDao
{
	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	
	@Override
	public List<Utilisateur> getAllUsers() {
		logger.info("getAllUsers");
		List<Utilisateur> users = new ArrayList<>();
		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM USERS");

			while (results.next()) {
				Utilisateur user = new Utilisateur();
				user.setId(results.getString(1));
				user.setPassword(results.getString(2));
				user.setAdministrateur(results.getBoolean(5));
				user.setNom(results.getString(3));

				users.add(user);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public Utilisateur getUserById(String string) {
		logger.info("getUserById");
		Utilisateur user = new Utilisateur();
		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM USERS WHERE ID ='ldupont@gmail.com'");

			System.out.println("res "+results);
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

	@Override
	public void addUser(int id, String password, String nom, boolean administrateur) {
		logger.info("addUser");
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
