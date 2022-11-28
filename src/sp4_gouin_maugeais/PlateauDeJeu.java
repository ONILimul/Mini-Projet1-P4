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
    
    public int ajouterJetonDansColonne(Jeton jetemp, int col){
        for(int i = 6; i>=0 ; i--){
            if (grille[i][col]==null){
                grille[i][col].affecterJeton(jetemp);
                break;
            }
        return i;
            
        }
        return -1; 
    } 
    
    public boolean grilleRemplie(){
        boolean cond = true;
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                if (grille[i][j]==null){
                    cond=false;
                }
            }
        }
        
        return cond;   
        }

    
}

