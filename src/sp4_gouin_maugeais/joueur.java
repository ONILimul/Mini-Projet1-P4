/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_gouin_maugeais;
import java.util.ArrayList;
/**
 *
 * @author gouin
 */
public class joueur { // Création de la classe joueur
    String nom;
    String couleur;
    ArrayList<Jeton> reserveJetons = new ArrayList<Jeton>();
    int nombreDesintegrateurs;

    public joueur(String nom) {    //Constructeur de la classe
        this.nom = nom;
        this.nombreDesintegrateurs = 0;
        nombreDesintegrateurs = 0;
    }
    
    public String Nom(String nomJ){
        return nomJ;
    }
    
    public void affecterCouleur (String color) {   //Méthode permettant de d'affecter à un joueur une couleur (ici entre rouge et jaune)
        couleur = color;
    }
    public int nombreDeJetons() {   //Méthode permettant d'obtenir le nombre de jeton restant dans la réserve d'un joueur
        return reserveJetons.size();
    }
    public void ajouterJeton(Jeton newJeton){   //méthode permettant d'ajouter un jeton à la reserve d'un joueur
        reserveJetons.add(newJeton);
    }
    
    
    public Jeton jouerJeton(){    //méthode permettant de retirer un jeton de la réserve du joueur et de renvoyer une référence à celui-ci
        
        Jeton j = reserveJetons.remove(0);
        return j;
      
    }
    public void obtenirDesintegrateur() {   //méthode permettant d'ajouter un desintégrateur
        nombreDesintegrateurs += 1;
    }
    public void utiliserDesintegrateur(){   //méthode permettant d'enlever un desintégrateur
        nombreDesintegrateurs -= 1;
    }

    
    public String getCouleur(){
        return couleur;
    }

    public int getNombreDesintegrateurs() {
        return nombreDesintegrateurs;
    }
    
}
