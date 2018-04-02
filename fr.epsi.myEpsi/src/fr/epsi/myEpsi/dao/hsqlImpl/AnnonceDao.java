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
	
	public List<Annonce> getAnnonces(String loginId){
		List<Annonce> annonces = new ArrayList<>();
		String url = "127.0.0.1:9003";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://"+url, "SA", "");
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM ANNONCES");
			
			while(results.next()) {
				Annonce annonce = new Annonce();
				annonce.setId(results.getInt(0));
				
				annonces.add(annonce);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return annonces;
	}

	@Override
	public Annonce getAnnonce(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
