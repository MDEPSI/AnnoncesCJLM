package fr.epsi.myEpsi.dao.hsqlImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.dao.IAnnonceDao;

public class AnnonceDao implements IAnnonceDao{
	
	public static Annonce getAnnonceById(int id) {
		Annonce annonce = new Annonce();

		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");

			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM ANNONCES WHERE ID = ?");

			if (results.next()) {
				annonce = new Annonce();
				annonce.setId(results.getInt(1));
				annonce.setTitre(results.getString(2));
				annonce.setDescription(results.getString(3));
				annonce.setVendeur(UserDao.getUserById(results.getString(4)));
				annonce.setCreation(results.getDate(5));
				annonce.setModification(results.getDate(6));
				annonce.setNbVues(results.getInt(10));
				annonce.setStatut(results.getInt(7));
				if (results.getString(8) != null) {
					annonce.setAcheteur(UserDao.getUserById(results.getString(8)));
					annonce.setAchat(results.getDate(9));
				}
				annonce.setPrix(results.getDouble(11));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return annonce;
	}
	
	public static List<Annonce> getAllAnnonces() {
		List<Annonce> offers = new ArrayList<>();
		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM ANNONCES");
		    while (results.next()) {
		    	Annonce annonce = new Annonce();
		    	annonce.setId(results.getInt(1));
		    	annonce.setTitre(results.getString(2));
		    	annonce.setDescription(results.getString(3));
		    	annonce.setVendeur(UserDao.getUserById(results.getString(4)));
		    	annonce.setCreation(results.getDate(5));
		    	annonce.setModification(results.getDate(6));
		    	annonce.setNbVues(results.getInt(10));
		    	annonce.setStatut(results.getInt(7));
		    	if(results.getString(8) != null) {
		    		annonce.setAcheteur(UserDao.getUserById(results.getString(8)));
		    		annonce.setAchat(results.getDate(9));
		    	}	    
		    	offers.add(annonce);
		    }
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}
}
