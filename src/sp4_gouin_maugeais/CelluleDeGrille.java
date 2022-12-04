/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_gouin_maugeais;

/**
 *
 * @author thoma
 */
public class CelluleDeGrille {     // Création de la classe CelluleDeGrille
    
    
    Jeton jetonCourant ;     //   Création des attributs CelluleDeGrille
    boolean avoirTrouNoir;
    boolean avoirDesintegrateur;
    
    String Couleur_jeton_actuel;
    

    public CelluleDeGrille() {    // Constructeur pour une cellule au debut on a:
        jetonCourant = null;//pas de jeton
        avoirTrouNoir = false;// pas de trou noir
        avoirDesintegrateur = false; // pas de desintegrateur
    }
    
    public boolean presenceJeton(){  // Méthode permettant de savoir si la cellule est occuppée par un jeton ou non 
        if(jetonCourant == null ){
            return false;
        }
        else{ 
            return true;
        }
    }
    
    boolean affecterJeton(Jeton jeton){   // Setter pour affecter un jeton à une cellule
        if(jetonCourant==null){
            jetonCourant = jeton ;
            return true;
        }
        return false;
    }
    
    String lireCouleurDuJeton(){// on lit la couleur du jeton actuel dans la cellule 
        if (jetonCourant!=null){// si cellule non vide
            return(jetonCourant.getCouleur());// on retourne la couleur du jeton 
        }
        else{
            return "."; // sinon on retourne vide pour indiquer que la cellule est vide
        }
    }
    
    Jeton recupererJeton(){  // Méthode pour récupérer un jeton dans une cellule, l'enlever de la cellule et le retourner
        Jeton temp = jetonCourant; // déclaration et utilisation de la variable temporaire dans laquelle on va garder temporairement le jeton qui va être suprimé afin de le retourner par la suite
        jetonCourant = null ;
        return temp;
    }
        
    boolean placerTrouNoir(){           //place un trou noir dans la cellule
        if(avoirTrouNoir){
            return false;
        }
    avoirTrouNoir =true;
        return true;
    }
    
    public void supprimerTrouNoir(){     //supprime trou noir de la cellule
        avoirTrouNoir=false;
    }
    
        boolean presenceTrouNoir(){    // Vérifie la présence d'un trou noir dans la cellule
            return avoirTrouNoir;   
    }
    
    public void supprimerJeton(){    // Supprime le jeton dans la cellule
        jetonCourant=null;
    }
    
    public boolean presenceDesintegrateur(){  // Vérifie la présence de désintégrateur dans la cellule
        return avoirDesintegrateur; 
    } 
    
    public void placerDesintegrateur(){  // Place un Désintégrateur dans la cellule
        avoirDesintegrateur = true ; 
    }
    
    public void supprimerDesintegrateur(){   // Supprime le désintégrateur présent dans la cellule
        avoirDesintegrateur = false ; 
    }
  
    public void activerTrouNoir(){   // Active le trou noir présent dans la cellule en supprimant le jeton et lui même de la cellule
        supprimerJeton();
        supprimerTrouNoir();
    }
   
   @Override                         //  création de la méthode toString permettant d'identifier ce qui est dans celluleDeGrille
    public String toString() {
        if (presenceTrouNoir()== true) {
            return "@";
        
       }else {
            if(presenceDesintegrateur()== true){
                return "D" ;
                
            }else {
                if (presenceJeton()== true){
                    return jetonCourant.toString();
                }else {
                    return ".";
                }
            }
        }
        
    }

    
}    

    

