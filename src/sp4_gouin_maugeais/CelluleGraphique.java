/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_gouin_maugeais;

import javax.swing.JButton;

/**
 *
 * @author thoma
 */
public class CelluleGraphique extends JButton { // on crée une nouvelle classe 
    
    CelluleDeGrille celluleAssocie; // attribut de la classe 
    
    public CelluleGraphique(CelluleDeGrille uneCellule){
        celluleAssocie = uneCellule;
    }
    
    
}
