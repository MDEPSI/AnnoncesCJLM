package fr.epsi.myEpsi.dao.hsqlImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.IAnnonceDao;
import fr.epsi.myEpsi.listeners.StartupListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnnonceDao implements IAnnonceDao{
	
	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	
	@Override
	public Annonce getAnnonceById(int id) {
		logger.info("getAnnonceById");
		Annonce annonce = new Annonce();

		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM ANNONCES WHERE ID =  ?");
			stmt.setInt(1, id);
			
			ResultSet results = stmt.executeQuery();
			System.out.println("res , "+results);

//			if (results.next()) {
				annonce = new Annonce();
				annonce.setId(results.getInt(1));
				annonce.setTitre(results.getString(2));
//				annonce.setDescription(results.getString(3));
//				annonce.setVendeur(UserDao.getUserById(results.getString(4)));
//				annonce.setCreation(results.getDate(5));
//				annonce.setModification(results.getDate(6));
//				annonce.setNbVues(results.getInt(10));
				annonce.setStatut(results.getInt(7));
				if (results.getString(8) != null) {
//					annonce.setAcheteur(UserDao.getUserById(results.getString(8)));
//					annonce.setAchat(results.getDate(9));
				}
//				annonce.setPrix(results.getDouble(11));
//			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return annonce;
	}
	
	@Override
	public Annonce setAnnonceById(int id, String titre) {
		logger.info("setAnnonceById");
		Annonce annonce = new Annonce();

		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");

			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("UPDATE ANNONCES set title = '"+titre+"' WHERE ID = '"+id+"'");

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return annonce;
	}
	
	@Override
	public List<Annonce> getAllAnnonces() {
		logger.info("getAllAnnonces");
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
//		    	annonce.setDescription(results.getString(3));
//		    	annonce.setVendeur(UserDao.getUserById(results.getString(4)));
//		    	annonce.setCreation(results.getDate(5));
//		    	annonce.setModification(results.getDate(6));
//		    	annonce.setNbVues(results.getInt(10));
		    	annonce.setStatut(results.getInt(8));
		    	if(results.getString(8) != null) {
//		    		annonce.setAcheteur(UserDao.getUserById(results.getString(8)));
//		    		annonce.setAchat(results.getDate(9));
		    	}	    
		    	offers.add(annonce);
		    }
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}
	
	@Override
	public int getNbAnnonces() {
		logger.info("getNbAnnonces");
        int nbAnnonces = 0;
        String url = "127.0.0.1:9003";
        Connection con;
        try {
        	con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("SELECT COUNT(ID) FROM ANNONCES");
			while(results.next()) {
				nbAnnonces = results.getInt(1);
			}
            
            System.out.println("nbAnnonces "+ nbAnnonces);
            con.close();
        }  catch (SQLException e) {
        	e.printStackTrace();
        }
        return nbAnnonces;
    }

	@Override
	public void addAnnonce(int id, String titre, String description, Double prix, Utilisateur vendeur, Date creation,
			int statut) {
		logger.info("addAnnonce");
		Annonce annonce = new Annonce();
		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("INSERT INTO ANNONCES (ID , TITLE , CONTENT , USER_ID, CREATION_DATE, PRICE , STATUS) VALUES (?,?,?,?,?,?,?)");
		    	annonce.setId(results.getInt(1));
		    	annonce.setTitre(results.getString(2));
		    	annonce.setDescription(results.getString(3));
//		    	annonce.setPrix(results.getString(6));
//		    	annonce.setVendeur(UserDao.getUserById(results.getString(4)));
		    	annonce.setCreation(results.getDate(5));
		    	annonce.setStatut(results.getInt(7));    
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteAnnonce(int id) {
		logger.info("deleteAnnonce");
		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("DELETE FROM ANNONCES WHERE ID = ?");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
