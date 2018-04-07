package fr.epsi.myEpsi.jmx;

import fr.epsi.myEpsi.dao.IAnnonceDao;
import fr.epsi.myEpsi.dao.mockImpl.AnnonceDao;

public class Premier implements PremierMBean {

    private static String nom = "PremierMBean";
    private int valeur = 100;

    public String getNom() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }

    public synchronized void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void nbAnnonce() {
        System.out.println("Compte le nombre d'annonce");
        IAnnonceDao annonceDao = new AnnonceDao();
        int nbAnnonce = annonceDao.countAnnonces();

    }

    public Premier() {

    }
}