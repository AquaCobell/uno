import java.util.*;
import java.io.*;

// marhassler has joined the server. 
    
class UNO
{
    Spieler spieler1 = new Spieler();
    Spieler spieler2 = new Spieler(); 
    
    public static Kartendeck deck = new Kartendeck();
    
    public static void main(String[]args) throws IOException
    {
        Spiel spiel = new Spiel();

        Scanner scan = new Scanner(System.in);

        int auswahl;
        do
        {
            
            System.out.println("┌──────────────UNO───────────────┐");
            System.out.println("│       1. Spiel starten         │");
            System.out.println("│       2. Changelog / Anleitung │");
            System.out.println("│       3. txt (coming soon)     │");
            System.out.println("│       4. Programm beenden      │");
            System.out.println("└────────────────────────────────┘");
            System.out.println("Auswahl:");
            auswahl = scan.nextInt();
            switch(auswahl) 
            {
                case 1:

                    
                    spiel.starteSpiel();
              
                break;

                case 2:
                
                    System.out.println("Anleitung UNO");
                break;

                case 3:
                    /*System.out.println("Geben Sie den Pfad oder Dateinamen der Datei ein ");
                    System.out.println("Zum Zurücksetzen geben Sie karten.txt ein");
                    scan.nextLine();
                    String datei = scan.nextLine();
                    deck.fülleArray(datei);
                    spiel.customtxt = true;
                    */
                break;

                case 4:

                    System.out.println("Danke fürs Spielen und auf Wiedersehen.");
                    System.out.println("© Rieser Nico");


                default:
            } // code block
        }while(auswahl != 4);
        /*




        }
        s
        System.out.println("test");
        
        spiel.spieler1.zeigeKarten();
        spiel.zieheKarte(spiel.spieler1);
        spiel.spieler1.zeigeKarten();
        
        spiel.spielermenu(spiel.spieler1);
    
        */
        
        //Spiel spiel = new Spiel();
        //spiel.starteSpiel();
    }
}
//to do 
/*                                                      status
UNO fertig -> debuggen                                  erledigt
karten debuggen                                         erledigt        
Menu Namen richtig formatieren -                        in Planung
+4 schwarze karte /                                     +4 geht rest in Planung
Hauptmenü                                               erledigt
karten txt im hauptmenu ändern                          in Planung
kartenleser verbessern (stop)                           code bereits geschrieben (implementierung fehlt)
code säubern                                            in planung

*/









