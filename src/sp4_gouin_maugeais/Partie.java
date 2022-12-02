/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_gouin_maugeais;
import java.util.Scanner;
import sp4_gouin_maugeais.Jeton;
import sp4_gouin_maugeais.joueur;
import sp4_gouin_maugeais.PlateauDeJeu;
import sp4_gouin_maugeais.CelluleDeGrille; //on importe les classses nécessaires

/**
 *
 * @author gouin
 */
public class Partie {
    private joueur[] listeJoueurs=new joueur[2];

    private joueur joueurCourant;

    private PlateauDeJeu plateau;


    public Partie (joueur joueur1,joueur joueur2){  //création du constructeur 

        listeJoueurs[0]=joueur1;

        listeJoueurs[1]=joueur2;

        plateau=new PlateauDeJeu();

    }
    public joueur[] getListeJoueurs() {  //méthode renvoyant une liste des joueurs

        return listeJoueurs;

    }


    public void attribuerCouleurAuxJoueurs(){   //méthode permettant de donner une couleur aléatoire aux joueurs entre jaune et rouge

        int valeur=(int) (Math.random() * (2)); //on choisi un chiffre entre 0 et 1

        if (valeur==0){ //si le chiffre est 0, l'un des joueurs sera rouge et l'autre jaune

            listeJoueurs[0].affecterCouleur("rouge");

            listeJoueurs[1].affecterCouleur("jaune");

        }

        else{  //si le chiffre est 1, l'ordre des couleurs est inversé

            listeJoueurs[0].affecterCouleur("jaune");

            listeJoueurs[1].affecterCouleur("rouge");

        }

       

    }

 

    public void creerEtAffecterJeton(joueur j1){  //méthode qui va créer 30 objets de type Jeton pour chaque couleur et les donnes aux joueurs

        if ("rouge".equals(j1.getCouleur())){

            for (int i=0;i<31;i++){ //on créer une boucle pour créer les 30 jetons pour le joueur rouge

                Jeton jeton=new Jeton ("rouge");

                j1.ajouterJeton(jeton);

            }

           

        }

        if ("jaune".equals(j1.getCouleur())){ //on créer une boucle pour créer les 30 jetons pour le joueur jaune

            for (int i=0;i<31;i++){

                Jeton jeton=new Jeton ("jaune");

                j1.ajouterJeton(jeton);

            }

           

        }

    }

 
    public void placerTrousNoirsEtDesintegrateurs(){  //méthode qui va créer 5 trous noirs et désintegrateurs et va cacher certains desintegrateurs derrière des trous noirs

        int i=0;

        while (i<3){

            int x=(int) (Math.random() * (9-3)); //on choisi aléatoirement des cases pour placer les trous noirs et desintégrateurs

            int y=(int) (Math.random() * (8-3));

            if (plateau.presenceDesintegrateur(x,y)==false){

                if (plateau.presenceTrouNoir(x,y)==false){

                    plateau.placerTrouNoir(x,y);

                    plateau.placerDesintegrateur(x,y);

                    i+=1;

                }

            }

               

        }

        while (i<5){  //on répète cette étape jusqu'a ce que le bon nombre de trou noirs et désintégrateurs soit présent

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

 


    public void initialiserPartie(){   //Méthode faisant appels à toutes celles créées dernièrement afin d'initialiser la partie 

        attribuerCouleurAuxJoueurs();

        creerEtAffecterJeton(listeJoueurs[1]);

        creerEtAffecterJeton(listeJoueurs[0]);

        placerTrousNoirsEtDesintegrateurs();

    }

   

    public void lancerPartie(){  //méthode permettant de lancer une partie 

        int n=0;

        joueurCourant = listeJoueurs[0];

        while(plateau.GagnantePourCouleur(joueurCourant.getCouleur()) == false){

            if (n%2 == 0){

                joueurCourant = listeJoueurs[0];

                System.out.println("Que voulez vous faire, si vous voulez jouer un jeton tapez '1', si vous voulez récupérer un jeton, tapez '2' et si vous voulez utiliser un désintegrateur, tapez'3'");//on demande au joueur ce qu'il souhaite faire

                Scanner reponse = new Scanner (System.in); //on récupère sa réponse

                int choix = reponse.nextInt();

                if (choix == 1){ //on execute cette partie du code si le joueur veut jouer un jeton

                    int cln=10;

                    Scanner colonne = new Scanner (System.in);

                    while (cln>7){

                        System.out.println("Dans quelle colonne voulez vous placer votre jeton"); //le joueur doit choisir sa colonne 

                        cln = colonne.nextInt();

                    }

                    plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), cln-1);

                    n +=1;

                }

                if (choix == 2){  //on execute cette partie du code si le joueur veut récuperer un jeton

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

                if (choix == 3){   //on execute cette partie du code si le joueur veut utiliser un désintégrateur

                    int cln=10;

                    int lgn=10;

                    if (joueurCourant.getNombreDesintegrateurs()==0){ //on vérifie si le joueur possède des desintégrateurs

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

            if (n%2 == 1){  //on passe au tour du joueur suivant et on lui propose les même choix que pour le joueur 1

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
