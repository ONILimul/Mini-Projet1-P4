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
        CelluleDeGrille cellule_grille = null;
        for(int i=0; i<6; i++){
            for(int j=0; i<7; j++){
                grille[i][j] = null; // on attribue des cases vides a toutes les cellules grilles
            }
   
        }
    }
    
    
}
