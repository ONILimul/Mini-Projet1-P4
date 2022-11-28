/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_gouin_maugeais;

/**
 *
 * @author thoma
 */
public class PlateauDeJeu { // Création classe Plateau de jeu 
    
    CelluleDeGrille [][] grille = new CelluleDeGrille[6][7]; // création de la grille 
    
    public PlateauDeJeu(){  // constructeur du plateau de jeu 
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                grille[i][j]= null; // on attribue des cases vides a toutes les cellules grilles
            }
   
        }
    }
    
    public int ajouterJetonDansColonne(Jeton jetemp, int col){  //méthode pour ajouter un jeton dans une colonne 
        for(int i = 6; i>=0 ; i--){
            if (grille[i][col]==null){ // Dès qu'une cellule de la colonne est vide on peut y placer le jeton 
                grille[i][col].affecterJeton(jetemp);  // Donc on affecte le jeton à la cellule
                break;    // Puis on sort de la boucle afin de ne pas ajouter le même jeton dans les cellules au dessus
            }
        return i;  // on retourne la ligne où le jeton a été affecté
            
        }
        return -1; // Si la colonne est pleine on retourne -1 signifiant que la colonne est pleine 
    } 
    
    public boolean grilleRemplie(){  // Méthode qui vérifie si notre grille est totalement remplie ou non 
        boolean cond = true;  
        for(int i=0; i<7; i++){  // On vérifie toutes les cellules de notre 1ère ligne
            if (grille[0][i]==null){ // si une seule cellule est vide
                cond=false; // alors notre tableau n'est pas complètement plein
            }
        
        }
       return cond;   // on retourne si notre grille est remplie ou non 
    }

    
}

