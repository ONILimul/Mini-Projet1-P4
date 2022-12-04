/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_gouin_maugeais;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author thoma
 */
public class CelluleGraphique extends JButton { // on crée une nouvelle classe 
    
    CelluleDeGrille celluleAssociee; // attribut de la classe 
    
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png")); 
  
    
    
    
    public CelluleGraphique(CelluleDeGrille uneCellule){ //Constructeur de CelluleGraphique
        celluleAssociee = uneCellule;
    }
    
    @Override
    public void paintComponent (Graphics G){
        super.paintComponent(G);
        if(celluleAssociee.presenceTrouNoir() == true) {// si trou noir on affiche limage correspondante
            setIcon(img_trouNoir);
        }
        else{
            if(celluleAssociee.presenceDesintegrateur() == true) {// de meme avec le desintegrateur
                setIcon(img_desint);
            }
            else{
                String couleur_jeton = celluleAssociee.lireCouleurDuJeton(); // on note la couleur du jeton si il y en a un
                switch (couleur_jeton){
                    case ".": // et en fonction on affiche limage correspondante
                        setIcon(img_vide);
                        break;
                    case "rouge" : 
                        setIcon(img_jetonRouge);
                        break;
                    case "jaune" : 
                        setIcon(img_jetonJaune);
                        break;
                }
                
            }
        }
        setIcon(img_vide); // On attribue l'image CelluleVide.png
    }
    
}
