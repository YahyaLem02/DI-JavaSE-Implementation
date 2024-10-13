package Metier;

import DAO.Idao;

public class MetierImp implements Imetier {
    //couplage faible
    private Idao dao;
    //injection dans la variable DAO un objet
    // d une classe qui implements l interfcae Idao
    public void setDao(Idao dao) {
        this.dao = dao;
    }

    public Idao getDao() {
        return dao;
    }

    @Override
    public double calcul() {
        double temperatrure = dao.getData();
        double resultat = temperatrure+100;
        return resultat;
    }
}
