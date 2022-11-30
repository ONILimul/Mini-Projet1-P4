/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_gouin_maugeais;
import java.util.Scanner;
import sp4_gouin_maugeais.Jeton;
import sp4_gouin_maugeais.joueur;
import sp4_gouin_maugeais.PlateauDeJeu;
import sp4_gouin_maugeais.CelluleDeGrille;

/**
 *
 * @author gouin
 */
public class Partie {
    private joueur[] listeJoueurs=new joueur[2];

    private joueur joueurCourant;

    private PlateauDeJeu plateau;


    public Partie (joueur joueur1,joueur joueur2){

        listeJoueurs[0]=joueur1;

        listeJoueurs[1]=joueur2;

        plateau=new PlateauDeJeu();

    }
    public joueur[] getListeJoueurs() {

        return listeJoueurs;

    }


    public void attribuerCouleurAuxJoueurs(){

        int valeur=(int) (Math.random() * (2));

        if (valeur==0){

            listeJoueurs[0].affecterCouleur("rouge");

            listeJoueurs[1].affecterCouleur("jaune");

        }

        else{

            listeJoueurs[0].affecterCouleur("jaune");

            listeJoueurs[1].affecterCouleur("rouge");

        }

       

    }

 

    public void creerEtAffecterJeton(joueur j1){

        if ("rouge".equals(j1.getCouleur())){

            for (int i=0;i<31;i++){

                Jeton jeton=new Jeton ("rouge");

                j1.ajouterJeton(jeton);

            }

           

        }

        if ("jaune".equals(j1.getCouleur())){

            for (int i=0;i<31;i++){

                Jeton jeton=new Jeton ("jaune");

                j1.ajouterJeton(jeton);

            }

           

        }

    }

 
    public void placerTrousNoirsEtDesintegrateurs(){

        int i=0;

        while (i<3){

            int x=(int) (Math.random() * (9-3));

            int y=(int) (Math.random() * (8-3));

            if (plateau.presenceDesintegrateur(x,y)==false){

                if (plateau.presenceTrouNoir(x,y)==false){

                    plateau.placerTrouNoir(x,y);

                    plateau.placerDesintegrateur(x,y);

                    i+=1;

                }

            }

               

        }

        while (i<5){

            int x=(int) (Math.random() * (9-3));

            int y=(int) (Math.random() * (8-3));

            if (plateau.presenceDesintegrateur(x,y)==false){

                if (plateau.presenceTrouNoir(x,y)==false){

                    plateau.placerTrouNoir(x,y);

                    i+=1;

                }

            }

        }

        while(i<7){

            int x=(int) (Math.random() * (9-3));

            int y=(int) (Math.random() * (8-3));

            if (plateau.presenceDesintegrateur(x,y)==false){

                if (plateau.presenceTrouNoir(x,y)==false){

                    plateau.placerDesintegrateur(x,y);

                    i+=1;

                }

            }

        }

    }

 


    public void initialiserPartie(){

        attribuerCouleurAuxJoueurs();

        creerEtAffecterJeton(listeJoueurs[1]);

        creerEtAffecterJeton(listeJoueurs[0]);

        placerTrousNoirsEtDesintegrateurs();

    }

   

    public void lancerPartie(){

        int n=0;

        joueurCourant = listeJoueurs[0];

        while(plateau.GagnantePourCouleur(joueurCourant.getCouleur()) == false){

            if (n%2 == 0){

                joueurCourant = listeJoueurs[0];

                System.out.println("Que voulez vous faire, si vous voulez jouer un jeton tapez '1', si vous voulez récupérer un jeton, tapez '2' et si vous voulez utiliser un désintegrateur, tapez'3'");

                Scanner reponse = new Scanner (System.in);

                int choix = reponse.nextInt();

                if (choix == 1){

                    int cln=10;

                    Scanner colonne = new Scanner (System.in);

                    while (cln>7){

                        System.out.println("Dans quelle colonne voulez vous placer votre jeton");

                        cln = colonne.nextInt();

                    }

                    plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), cln-1);

                    n +=1;

                }

                if (choix == 2){

                    int cln=10;

                    int lgn=10;

                    Scanner colonne = new Scanner (System.in);

                    Scanner ligne = new Scanner (System.in);

                    while (cln>7){

                        System.out.println("De quelle colonne voulez vous récupérer votre jeton");

                        cln = colonne.nextInt();

                    }

                    while (lgn>6){

                        System.out.println("De quelle ligne voulez vous récuprer votre jeton");

                        lgn = ligne.nextInt();

                    }

                   

                    plateau.recupererJeton(lgn-1, cln-1);

                    n +=1;

                }

                if (choix == 3){

                    int cln=10;

                    int lgn=10;

                    if (joueurCourant.getNombreDesintegrateurs()==0){

                        System.out.println("Le joueur n'a pas de désintegrateurs");

                        continue;

                    }

                    Scanner colonne = new Scanner (System.in);

                    Scanner ligne = new Scanner (System.in);

                    while (cln>7){

                        System.out.println("Dans quelle colonne voulez vous placer votre jeton");

                        cln = colonne.nextInt();

                    }

                    while (lgn>6){

                        System.out.println("Dans quelle ligne voulez vous placer votre jeton");

                        lgn = ligne.nextInt();

                    }

                    plateau.utiliserDesintegrateur(lgn-1, cln-1,joueurCourant);

                    n +=1;

                }              

            }

            if (n%2 == 1){

                joueurCourant = listeJoueurs[1];

                System.out.println("Que voulez vous faire, si vous voulez jouer un jeton tapez '1', si vous voulez récupérer un jeton, tapez '2' et si vous voulez utiliser un désintegrateur, tapez'3'");

                Scanner reponse = new Scanner (System.in);

                int choix = reponse.nextInt();

                if (choix == 1){

                    int cln=10;

                    Scanner colonne = new Scanner (System.in);

                    while (cln>7){

                        System.out.println("Dans quelle colonne voulez vous placer votre jeton");

                        cln = colonne.nextInt();

                    }

                    plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), cln-1);

                    n +=1;

                }

                if (choix == 2){

                    int cln=10;

                    int lgn=10;

                    Scanner colonne = new Scanner (System.in);

                    Scanner ligne = new Scanner (System.in);

                    while (cln>7){

                        System.out.println("De quelle colonne voulez vous récupérer votre jeton");

                        cln = colonne.nextInt();

                    }

                    while (lgn>6){

                        System.out.println("De quelle ligne voulez vous récuprer votre jeton");

                        lgn = ligne.nextInt();

                    }

                   

                    plateau.recupererJeton(lgn-1, cln-1);

                    n +=1;

                }

                if (choix == 3){

                    int cln=10;

                    int lgn=10;

                    if (joueurCourant.getNombreDesintegrateurs()==0){

                        System.out.println("Le joueur n'a pas de désintegrateurs");

                        continue;

                    }

                    Scanner colonne = new Scanner (System.in);

                    Scanner ligne = new Scanner (System.in);

                    while (cln>7){

                        System.out.println("Dans quelle colonne voulez vous utiliser votre desintegrateur");

                        cln = colonne.nextInt();

                    }

                    while (lgn>6){

                        System.out.println("Dans quelle ligne voulez vous utiliser votre desintegrateur");

                        lgn = ligne.nextInt();

                    }

                    plateau.utiliserDesintegrateur(lgn-1, cln-1,joueurCourant);

                    n +=1;

                }              

                

            }       

        }

    }

 

}
