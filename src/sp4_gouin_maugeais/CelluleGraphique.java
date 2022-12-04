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
    
    CelluleDeGrille celluleAssocie; // attribut de la classe 
    
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    
    public CelluleGraphique(CelluleDeGrille uneCellule){ //Constructeur de CelluleGraphique
        celluleAssocie = uneCellule;
    }
    
    @Override
    public void paintComponent (Graphics G){
        super.paintComponent(G);
        setIcon(img_vide); // On attribue l'image CelluleVide.png
    }
    
}
