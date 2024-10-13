package Presentation;

import DAO.DaoImp;
import DAO.DaoImp2;
import Metier.MetierImp;

public class Main {
    public static void main(String[] args) {
        DaoImp2 dao = new DaoImp2();
        MetierImp metier = new MetierImp();
        metier.setDao(dao);
        double res = metier.calcul();

        System.out.println("Le resultat avnt extention est: "+res);
    }
}