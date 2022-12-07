/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_gouin_maugeais;

/**
 *
 * @author thoma
 */
public class Jeton {// Création de notre classe jeton 
    
    String couleur;             //Attributs définissant la couleur du jeton. On attribue une couleur à la construction du jeton 

    public Jeton(String couleur) { //Constructeur du jeton dans lequel on attribue une couleur au jeton que l'on construit 
        this.couleur = couleur;
        
        
    
    }

    public String getCouleur() {          // Méthode renvoyant la couleur d'un jeton 
        return couleur;
    }

    @Override                         // Méthode renvoyant la couleur d'un jeton 
    public String toString() {
        
        if (couleur=="rouge"){        // Affiche R si jeton rouge sinon jaune
            return "R";
        }
        else{
            return "J";
        }
    }
    
    
    
    
    
}
