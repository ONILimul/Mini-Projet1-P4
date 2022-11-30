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
        int ret = -1 ;
        for(int i = 6; i>=0 ; i--){
            if (grille[i][col]==null){ // Dès qu'une cellule de la colonne est vide on peut y placer le jeton 
                grille[i][col].affecterJeton(jetemp);  // Donc on affecte le jeton à la cellule
                ret = i ;
                break;    // Puis on sort de la boucle afin de ne pas ajouter le même jeton dans les cellules au dessus
            }
        }    
        return ret ; // On retourne la ligne à laquelle on a ajouté le jeton si la colonne est pleine on retourne - 1 signifiant qu'on ne peut pas ajouter de jeton dans cette colonne.
    }    
         
        
    public boolean grilleRemplie(){  // Méthode qui vérifie si notre grille est totalement remplie ou non 
        boolean cond = true;  
        for(int i=0; i<7; i++){  // On vérifie toutes les cellules de notre 1ère ligne
            if (grille[0][i]==null){ // si une seule cellule est vide
                cond=false; // alors notre tableau n'est pas complètement plein
            }
        
        }
       return cond;   // on retourne si notre grille est remplie ou non  FALSE: il reste une place TRUE: le tableau est plein
    }
    public void afficherGrilleSurConsole() {  // Méthode qui permet d'afficher la grille de jeu sur la console
        System.out.println(grille.toString());
    }

    public boolean presenceJeton(int x, int y){  // Méthode réutilisant la méthode de cellule pour l'appliquer à une cellule de la grille de jeu 
        return grille[x][y].presenceJeton();
    }
    public String lireCouleurDuJeton(int x, int y){ // Méthode réutilisant la méthode de cellule pour l'appliquer à une cellule de la grille de jeu
        return grille[x][y].lireCouleurDuJeton();
    }
    
    public boolean ligneGagnantePourCouleur (String couleur) { // Cette (sous) méthode indique si une couleur que l'on donne est gagnante sur une ligne de notre plateau de jeu ou non 
        boolean temp1 = false;
        for (int a = 0; a < 6 ;a++){
            for (int i = 0; i <= 3; i++){
                if ( lireCouleurDuJeton(a,i) == couleur & lireCouleurDuJeton(a,i+1) == couleur & lireCouleurDuJeton(a, i+2) == couleur & lireCouleurDuJeton(a, i+3) == couleur) {
                    temp1 = true ;
                    break;
                }
            }   
        }
    return temp1; // Retourne si il y a une ligne gagnante : TRUE la couleur gagne FALSE la couleur de ne gagne pas en ligne
    }
    
    public boolean colonneGagnantePourCouleur (String couleur ) {
       
        boolean temp2 = false;
        for (int i = 0; i < 7 ;i++){
            for (int a = 0; a <= 2; a++){
                if ( lireCouleurDuJeton(a,i) == couleur & lireCouleurDuJeton(a+1,i) == couleur & lireCouleurDuJeton(a+2, i) == couleur & lireCouleurDuJeton(a+3, i) == couleur) {
                    temp2 = true ;
                    break;
                }
            }   
        }
    return temp2;
    }       
        

            

    
    public diagonaleMontanteGagnantePourCouleur(String couleur) {
            
    }
    
    public diagonaleDescendanteGagnantePourCouleur(String couleur) {
            
    }

}

