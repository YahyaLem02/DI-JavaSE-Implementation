package Presentation;

import DAO.Idao;
import Metier.MetierImp;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws Exception {
        // Utilisation de la classe Scanner pour lire le fichier "conf.txt"
        // qui contient les noms des classes pour l'injection de dépendances.
        Scanner scanner = new Scanner(new File("Config.txt"));

        // Lecture de la première ligne du fichier, qui est le nom de la classe de l'objet Dao
        String DaoClasseName = scanner.nextLine();

        // Utilisation de la réflexion pour charger la classe correspondante au nom lu
        Class cDao = Class.forName(DaoClasseName); // Recherche la classe par son nom
        // Instanciation dynamique de la classe Dao via réflexion
        Idao dao = (Idao) cDao.newInstance(); // Crée une instance de la classe Dao

        // Lecture de la deuxième ligne du fichier, qui est le nom de la classe de l'objet Metier
        String MetierClasseName = scanner.nextLine();

        // Utilisation de la réflexion pour charger la classe Metier
        Class cMetier = Class.forName(MetierClasseName); // Recherche la classe par son nom
        // Instanciation dynamique de la classe Metier via réflexion
        MetierImp metierImp = (MetierImp) cMetier.newInstance(); // Crée une instance de la classe Metier

        // Utilisation de la réflexion pour récupérer la méthode "setDao" de la classe Metier
        Method method = cMetier.getMethod("setDao", Idao.class); // Recherche la méthode setDao de Metier avec un paramètre de type Idao

        // Injection de la dépendance Dao dans l'objet Metier via la méthode setDao
        // Cela revient à appeler metierImp.setDao(dao), mais en utilisant la réflexion.
        method.invoke(metierImp, dao); // Exécute la méthode setDao avec l'instance dao en paramètre

        // Appel de la méthode calcul sur l'objet Metier et affichage du résultat
        System.out.println("Le resultat avant extension est: " + metierImp.calcul());
    }
}
