import java.util.*;
import java.io.*;
class Spiel
{   
    public Spieler spieler1;
    public Spieler spieler2;
    public Scanner scan; 
    public Kartendeck deck;
    Spieler[] spieler = new Spieler[2];
    
    
    //Spielvariablen, werden für den Spielablauf gebraucht.
    int spielerindex; //Spieler 1 -> 0 | Spieler 2 ->  1)
    int pluskarte = 0;
    boolean aussetzen; //Aussetzer
    boolean bereitsgezogen; //Wenn eine Karte schon gezogen wurde
    boolean customtxt = false;
    

    public Spiel() throws IOException
    {
        spieler1 = new Spieler();
        spieler2 = new Spieler();
        scan = new Scanner(System.in);
        deck = new Kartendeck();
        spieler[0] = spieler1;
        spieler[1] = spieler2;
        spielerindex = 0;
        if(customtxt == false)
        {
        deck.fülleArray("kartencheat.txt");
        }
        
        
        bereitsgezogen = false;
        
    }

    public void teileKartenaus() //Muss erweitert werden wenn mehr Spieler möglich sind.
    {
        

        do
        {
            spieler1.fügeKartehinzu(deck.gibzufallKarte());  
           
        }while(spieler1.gibarraygröße()<7);
        
        do
        {
            spieler2.fügeKartehinzu(deck.gibzufallKarte());  
           
        }while(spieler2.gibarraygröße()<7);
        

    }


    public boolean legeKarteAb(Spieler aktuellerSpieler, int index ) //Legt eine Karte vom Spieler ab, gibt zurück ob das Ablegen erfolgreich war
    {
        if(aktuellerSpieler.gibkarte(index).substring(0,2).equals(deck.gibDeckKarte().substring(0,2)) 
        || aktuellerSpieler.gibkarte(index).substring(2,3).equals(deck.gibDeckKarte().substring(2,3)))
        {

            if(aktuellerSpieler.gibkarte(index).substring(2,3).equals("+")) //Wenn die Karte eine Additionskarte ist
            {
                this.pluskarte = Integer.parseInt(aktuellerSpieler.gibkarte(index).substring(3,4));


            }
            if(aktuellerSpieler.gibkarte(index).substring(2,3).equals("a")) //Wenn die Karte eine Aussetzkarte ist
            {
                aussetzen = true;

            }
            deck.verbrauchteKarten.add(deck.deckkarte);
            deck.deckkarte = aktuellerSpieler.gibkarte(index);
            aktuellerSpieler.karten_spieler.remove(index);
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public void zieheKarte(Spieler aktuellerSpieler) //Zieht eine Karte für den jeweiligen Spieler vom Kartendeck
    {
       
        aktuellerSpieler.fügeKartehinzu(deck.gibzufallKarte());
        //aktuellerSpieler.zeigeKarten();
        

    }

    public void zeigespielerkarten(Spieler spieler) //kann weggelassen werden
    {  
        spieler.zeigeKarten();
    }
    
    public void wechslespieler() //Wechselt den Spieler, muss bei mehr Spieler verbessert werden
    {
        if(spielerindex == 0)
        {
            spielerindex++;
        }
        else
        {
            spielerindex--;
        }
    }

    public void spielermenu(Spieler spieler) //Gibt das Spielermenü aus
    {
        //int spielerlänge = spieler[spielerindex];

        
        System.out.println("┌──────────────Menü──────────────┐");
        if(spieler == spieler1 && spieler1.gibname() != null )
        {
            System.out.println("│            " + spieler1.gibname() + "           |");
            /*if(spieler1.gibname().length()<9)
            {
                while(spieler1.gibname)
                {


                }
            }
            else
            {
                System.out.println("│            " + spieler1.gibname() + "           |");
            }*/
            
        }
        else if(spieler == spieler1 && spieler1.gibname() == null )
        {
            System.out.println("│            Spieler 1           |");
        }
        else if(spieler == spieler2 && spieler2.gibname() != null )
        {
            
            System.out.println("│            " + spieler2.gibname() + "           |");
        }
        else
        {
            System.out.println("│            Spieler 2           |");
        }
        
        System.out.println("├────────────────────────────────┤");
        System.out.println("│        Zugmöglichkeiten        │");
        System.out.println("│         1. Karte legen         │");
        System.out.println("│         2. Karte ziehen        │");
        System.out.println("│         3. Gewinnzug           │");
        if(bereitsgezogen == true)
        {
            System.out.println("│         4. Zug Beenden         │");

        }
        System.out.println("│                                │");
        System.out.println("├────────────Karten──────────────┤");
        System.out.println("│Deckkarte: " + deck.gibDeckKarte() +      "                  │");
        zeigespielerkarten(spieler);
        System.out.println("Deine Wahl? ->");

    }
    
    
    
    
    public void starteSpiel() throws IOException
    {   
        
        teileKartenaus();
        System.out.println("Geben Sie Namen für Spieler 1 ein: ");
        spieler1.setzename(scan.nextLine());
        System.out.println("Geben Sie Namen für Spieler 2 ein: ");
        spieler2.setzename(scan.nextLine());
        deck.deckkarte = deck.gibzufallKarte();
        int auswahl = 0;
        boolean zug = false;
        boolean win = false;
        boolean erneutversuchen = false;
        boolean uno_spieler1 = false;
        int uno_spieler1durchlauf = 0;
        boolean uno_spieler2 = false;
        int uno_spieler2durchlauf = 0;
        
        while(win == false) //Solange Siegesbedinung nicht erfüllt ist
        
        {
            
            System.out.println(spieler[spielerindex].gibname() + " ist an der Reihe."); 
            System.out.println("Die aktuelle Karte ist " + deck.gibDeckKarte() );
            while(zug == false) // Solange der Zug nicht beendet ist
            {
                
                spielermenu(spieler[spielerindex]);
                if(uno_spieler1durchlauf==2)
                {
                    uno_spieler1 = false;
                    uno_spieler1durchlauf = 0;
                }
                if(uno_spieler1 == true)
                {
                    uno_spieler1durchlauf++;
                }

                if(uno_spieler2durchlauf==2)
                {
                    uno_spieler2 = false;
                    uno_spieler2durchlauf = 0;
                }
                if(uno_spieler2 == true)
                {
                    uno_spieler2durchlauf++;
                }


                auswahl=scan.nextInt();
                switch(auswahl) {
                case 1: //Karte ablegen
                
                    do
                    {
                        System.out.println("Welche Karte wollen Sie ablegen? [Index]");
                        System.out.println("Die aktuelle Karte ist " + deck.gibDeckKarte() );
                        int auswahl1 = scan.nextInt();
                        if(legeKarteAb(spieler[spielerindex], auswahl1) == true)
                        {
                            System.out.println("Karte wurd erfolgreich abgelegt. Zug beendet.");
                            //wechslespieler(); //Spieler wird gewechselt
                            zug = true; //Zug beendet
                            erneutversuchen = false; //nicht erneut versuchnen
                        
                        }
                        else
                        {
                            System.out.println("Karte konnte nicht abgelegt werden. Wollen Sie es erneut versuchen?[true / false]");
                            erneutversuchen = scan.nextBoolean();
                            
                           
                        }            
                    }while(erneutversuchen == true &&  zug == false); //Solange nicht Zug beendet ist oder erneut versuchen auf false gesetzt worden ist.
                    break;

                case 2: //Karte ziehen
                    if(bereitsgezogen != true) //wenn noch keine Karte gezogen wurde
                    {
                        System.out.println("Karte wird gezogen");
                        zieheKarte(spieler[spielerindex]);
                        bereitsgezogen = true;
                    }
                    else
                    {
                        System.out.println("Sie haben bereits eine Karte gezogen. Beenden Sie ihren Zug");


                    }
                    
                  break;

                
                case 3: //Sieg fordern
                    if(spielerindex == 0)
                    {
                        uno_spieler1 = true;

                    }
                    else
                    {

                        uno_spieler2 = true;
                    }
                    break;

                case 4:
                    if(bereitsgezogen == true) //wenn bereits karte gezogen wurde
                    {
                        //wechslespieler();
                        zug = true;
                        erneutversuchen = false;

                    }
                    else
                    {
                        System.out.println("Diese Option gibt es nicht!");

                    }

                
                
                
                
                
                default:
                    System.out.println("Diese Option gibt es nicht");
                    break;

              }


            }
            //Spieler zug beendet.
            zug = false;
            bereitsgezogen = false;
            System.out.println("├───────────Spielerwechsel──────────────┤");
            if(spieler1.karten_spieler.size() == 0 && uno_spieler1 == true)
            {
                win = true;
                System.out.println("Spieler 1 hat gewonnen !");
                

            }
            else if(spieler1.karten_spieler.size() == 0 && uno_spieler1 == false)
            {
                zieheKarte(spieler1);
                System.out.println("UNO vergessen. 1 Karte wird gezogen");


            }
            if(spieler2.karten_spieler.size() == 0 && uno_spieler2 == true)
            {
                win = true;
                System.out.println("Spieler 2 hat gewonnen !");

            }
            else if(spieler2.karten_spieler.size() == 0 && uno_spieler2 == false)
            {
                zieheKarte(spieler2);
                System.out.println("UNO vergessen. 1 Karte wird gezogen");
            }
            
            if(aussetzen != true)
            {
                wechslespieler();

            }
            aussetzen = false;
           
            if(pluskarte == 2)
            {
                zieheKarte(spieler[spielerindex]);
                zieheKarte(spieler[spielerindex]);
                pluskarte = 0;
            }
            if(pluskarte == 4)
            {
                zieheKarte(spieler[spielerindex]);
                zieheKarte(spieler[spielerindex]);
                zieheKarte(spieler[spielerindex]);
                zieheKarte(spieler[spielerindex]);
                pluskarte = 0;
            }
           
           

        }
        System.out.println("Vielen Dank fürs Spielen.");
        System.out.println("Dieses Spiel wurde von Nico erstellt");
        System.out.println("Wollen Sie eine neue Runde beginnnen? [true/false]");
        boolean frage = scan.nextBoolean();
        if(frage == true)
        {
            starteSpiel();
        }
        else if (frage == false)
        {
            System.out.println("Spiel wird beendet, auf Wiedersehen");
        }
        else
        {
            System.out.println("Diese Option existiert nicht");
        }
    }
}
//ring map