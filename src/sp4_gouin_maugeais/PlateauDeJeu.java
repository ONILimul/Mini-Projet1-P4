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
        boolean temp1 = false;//Variable retournée
        for (int a = 0; a < 6 ;a++){ // on teste pour chaque ligne
            if (temp1 == true){ // si jamais une colonne a été déttectée comme gagnante on sorte de la 1ère boucle pour return directement le résultat
                break;
            }            
            for (int i = 0; i <= 3; i++){ // Pour une ligne testée on teste les colonnes jusqu'à "la limite" du plateau (pas besoin de tester toutes les colonnes vu qu'on le fait déjà dans la condition ci-dessous)
                if ( lireCouleurDuJeton(a,i) == couleur & lireCouleurDuJeton(a,i+1) == couleur & lireCouleurDuJeton(a, i+2) == couleur & lireCouleurDuJeton(a, i+3) == couleur) { // condition avec 4 cellules cotes a cotes en ligne avec jeton de couleur identiques
                    temp1 = true ; // alors si la condition est vérifiée on met notre variable retournée comme vraie
                    break; // on sort de la 2ème boucle 
                }
            }   
        }
    return temp1; // on retourne si il y a une couleur gagnante en ligne
    }
    
    public boolean colonneGagnantePourCouleur (String couleur ) { // Méthode renvoyant si une couleur est gagnante "en colonne" sur le plateau de jeu
       
        boolean temp2 = false;         
        for (int i = 0; i < 7 ;i++){     // on teste pour chaque colonne
            if (temp2 == true){  // si jamais une colonne a été déttectée comme gagnante on sorte de la 1ère boucle pour return directement le résultat
                break;
            }
            for (int a = 0; a <= 2; a++){ // Pour une colonne testée on teste les ligne jusqu'à "la limite" du plateau (pas besoin de tester toutes les lignes)
                if ( lireCouleurDuJeton(a,i) == couleur & lireCouleurDuJeton(a+1,i) == couleur & lireCouleurDuJeton(a+2, i) == couleur & lireCouleurDuJeton(a+3, i) == couleur) { // condition avec 4 cellules cotes a cotes en colonne avec jeton de couleur identiques
                    temp2 = true ; // alors si la condition est vérifiée on met notre variable retournée comme vraie
                    break; // on sort de la 2ème boucle 
                }
            }   
        }
    return temp2; // on retourne si il y a une couleur gagnante en colonne
    }       
        

            

    
    public boolean diagonaleMontanteGagnantePourCouleur(String couleur) { // Méthode renvoyant si une couleur est gagnante "en diaguonale montante" sur le plateau de jeu
       
        boolean temp3 = false;// Variable retournée
        for (int i = 3; i < 7 ;i++){//première bouvle pour les colonnes
            if (temp3 == true){//on sort de la 1ère boucle si on a déjà detecté une couleur gagnante
                break;
            }
            for (int a = 0; a <= 2; a++){ // 2ème boucle pour les lignes
                if ( lireCouleurDuJeton(a,i) == couleur & lireCouleurDuJeton(a+1,i-1) == couleur & lireCouleurDuJeton(a+2, i-2) == couleur & lireCouleurDuJeton(a+3, i-3) == couleur) { // conditions victoire
                    temp3 = true ;// si conditions de victoire vérifiées on met la variable retournée à true 
                    break; // on sort de la 2ème boucle 
                }
            }   
        }
        return temp3;   // on retourne la variable    
    }
    
    public boolean diagonaleDescendanteGagnantePourCouleur(String couleur) { // Méthode renvoyant si une couleur est gagnante "en diaguonale descendante" sur le plateau de jeu
      
        boolean temp4 = false; // variable retournée
        for (int i = 0; i < 4 ;i++){ // première boucle pour les colonnes
            if (temp4 == true){ // on sort de la 1ère boucle si on a déjà detecté une couleur gagnante
                break;
            }
            for (int a = 0; a <= 2; a++){ // 2ème boucle pour les lignes
                if ( lireCouleurDuJeton(a,i) == couleur & lireCouleurDuJeton(a+1,i+1) == couleur & lireCouleurDuJeton(a+2, i+2) == couleur & lireCouleurDuJeton(a+3, i+3) == couleur) {// Conditions de diaguonale gagnante
                    temp4 = true ; //On a une victoire donc la variable retournée est mise à true 
                    break;
                }
            }   
        }
        return temp4;  // on retourne la variable        
        
    }
    
    public boolean GagnantePourCouleur(String CouleurTest){ // méthode réunissant toutes les sous méthodes crées précedement 
        boolean CouleurWin = false; // variable retournée
                
        if (diagonaleDescendanteGagnantePourCouleur(CouleurTest)== true || diagonaleMontanteGagnantePourCouleur(CouleurTest) == true || colonneGagnantePourCouleur (CouleurTest ) == true || ligneGagnantePourCouleur (CouleurTest) == true){ //conditions si une des sous méthodes est validée 
            
            CouleurWin = true;// si une des sous méthodes donne une couleur gagnante alors on met la variable retournée à "true"
        
        }
    return CouleurWin;   // on retourne la variable de victoire ou non  
    }
    

}

