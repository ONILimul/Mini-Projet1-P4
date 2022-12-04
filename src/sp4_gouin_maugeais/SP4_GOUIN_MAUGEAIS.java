/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_gouin_maugeais;

/**
 *
 * @author gouin
 */
public class SP4_GOUIN_MAUGEAIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Jeton Jaune1 = new Jeton("jaune");    // Création des 2 premiers jetons et test de toString
        System.out.println(Jaune1);
        
        Jeton Rouge1 = new Jeton("rouge");
        System.out.println(Rouge1);
        
       
        joueur Thomas = new joueur("Thomas", 0);
        joueur Robin = new joueur("Robin", 0);
        
        Partie test = new Partie(Thomas,Robin);
        test.initialiserPartie();
        test.lancerPartie();


    }
}         
