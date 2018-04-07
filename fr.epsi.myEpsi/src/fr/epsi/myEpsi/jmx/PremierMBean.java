package fr.epsi.myEpsi.jmx;

import java.io.IOException;

public interface PremierMBean {

    public String getNom() throws IOException;

    public int getValeur() throws IOException;
    public void setValeur(int valeur) throws IOException;

    public void nbAnnonce() throws IOException;

}