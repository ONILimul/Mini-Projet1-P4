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
    
    
    private Jeton jetonCourant ;     //   Création des attributs CelluleDeGrille
    private boolean avoirTrouNoir;
    private boolean avoirDesintegrateur;
    String Couleur_jeton_actuel;
    

    public CelluleDeGrille(Jeton jetonCourant, boolean avoirTrouNoir, boolean avoirDesintegrateur) {    // Constructeur pour une cellule
        this.jetonCourant = null;
        this.avoirTrouNoir = false ;
        this.avoirDesintegrateur = false ;
    }
    
    public boolean presenceJeton(){  // Méthode permettant de savoir si la cellule est occuppée par un jeton ou non 
        if(jetonCourant == null ){
            return false;
        }
        else{ 
            return true;
        }
    }
    
    public void affecterJeton(Jeton jeton){   // Setter pour affecter un jeton à une cellule
        jetonCourant = jeton ;
    }
    
    public String lireCouleurDuJeton(){// on lit la couleur du jeton actuel dans la cellule 
        if (jetonCourant!=null){// si cellule non vide
            return(jetonCourant.getCouleur());// on retourne la couleur du jeton 
        }
        else{
            return "vide"; // sinon on retourne vide pour indiquer que la cellule est vide
        }
    }
    
    public Jeton recupererJeton(){  // Méthode pour récupérer un jeton dans une cellule, l'enlever de la cellule et le retourner
        Jeton temp ; // déclaration et utilisation de la variable temporaire dans laquelle on va garder temporairement le jeton qui va être suprimé afin de le retourner par la suite
        temp = jetonCourant ;
        jetonCourant = null ;
        return temp;
    }
        
    public void placerTrouNoir(){           //place un trou noir dans la cellule
        avoirTrouNoir=true;
    }
    
    public void supprimerTrouNoir(){     //supprime trou noir de la cellule
        avoirTrouNoir=false;
    }
    
    public boolean presenceTrouNoir(){    // Vérifie la présence d'un trou noir dans la cellule
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
   
   
}
    
    

    

