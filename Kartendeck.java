import java.util.*;
import java.io.*;
public class Kartendeck //Klasse welche Zufallskarten aus den Deck zurückgibt.
{
    
    Random zufall = new Random();
    ArrayList<String> karten = new ArrayList<String>();
    ArrayList<String> verbrauchteKarten = new ArrayList<String>();
    //private int kartenanzahl = 0; //Anzahl der bereits gezogenen Karten
    public String deckkarte; //Aktuelle Deckkarte
    

    //Hallo i bims der Hamdi
    //ArrayList befüllen Methode
   
    //public Spieler[] spielerarray;
    
    public Kartendeck() 
    {
        /*int zufall1 = zufall.nextInt(107);  //zufallskarte generieren
        kartenanzahl++;
        
        deckkarte = karten.get(zufall1);    //Zufallskarte aus Arraylist in Deckkarte speichern
        karten.remove(zufall1);             //Zufallskarte aus Arraylist entfernen
        
        */
        /*spielerarray = new Spieler[2];
      
        spielerarray[0] = spieler1;
        spielerarray[1] = spieler2; */
        karten.add("ro0");
        karten.add("ro1");
        karten.add("ro2");
        
       
    }

  

    public void fülleArray(String dateiname) throws IOException
    {
        FileReader fr = new FileReader(dateiname);
        BufferedReader br = new BufferedReader(fr); 
        String zeile = br.readLine();
        
        while(!zeile.equals("stop")) // Solange Zeile nicht stop ist
        {
            zeile = br.readLine();
            if(!zeile.isEmpty()) //Wenn Zeile nicht null ist
            {
                karten.add(zeile);
            }
        }
    } 


    public String gibzufallKarte() //Zieht eine Zufallskarte vom Kartendeck und entfernt sie auch somit gleich vom Deck.
    {   
            int zufall1 = zufall.nextInt(karten.size()-1);       //Zufallsindex generieren
            String karte = karten.get(zufall1);                     //Karte aus ArrayList in Variable speichern
            karten.remove(zufall1);                                 //Karte aus Arraylist entfernen
            //kartenanzahl++; 
            return karte; //fertig bis auf zufallindex
    }

    public boolean legKarteab(String karte)
    {
        if(karte.substring(0,2).equals(deckkarte.substring(0,2)) || karte.substring(2,3).equals(deckkarte.substring(2,3)))
        {
            verbrauchteKarten.add(deckkarte);
            deckkarte = karte;
            

            return true;
        }
        else
        {

            return false;
        }
        
        

    }

    

    public String gibDeckKarte()
    {
        return deckkarte;
        
    }

}
