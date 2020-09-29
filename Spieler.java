import java.util.ArrayList;


public class Spieler 
{
    
    ArrayList<String> karten_spieler = new ArrayList<String>();
    //private int kartenanzahl;
    private String name; 
    

    

    public Spieler()
    {
        //System.out.print("Spieler ");
        

    }

    public void setzename(String name) //Lege Namen von Spieler fest
    {
       this.name = name;
    }

    public String gibname() //Gib Namen von Spieler zurück
    {
       return this.name;
    }

    public void fügeKartehinzu(String karte) //Ziehe Karte vom Deck
    {
       karten_spieler.add(karte);
    }

    

    public String gibkarte(int index) //gib Karte zurück 
    {
        /*if(index > kartenanzahl)
        {
            System.out.println("Karte existiert nicht");
            return null;

        }
        else
        {
            
        }*/
        
        return karten_spieler.get(index);
        
    }
    public void zeigaktion()
    {
        


    }

    public int gibarraygröße()
    {
        return karten_spieler.size();

    }

    public void zeigeKarten()
    {
        //System.out.println("┌──────────────Hand──────────────┐");
        int zaehler = 0;
        int groesse = karten_spieler.size()-1;
        while(groesse >= zaehler)
        {
            if(karten_spieler.get(zaehler).substring(0,2).equals("ro"))
            {
                if(karten_spieler.get(zaehler).substring(2,3).equals("+"))
                {
                    System.out.println("│ " + zaehler + " | " + karten_spieler.get(zaehler).substring(2,3) + karten_spieler.get(zaehler).substring(3,4) + " rot" +   "                     │");
                }
                else if( karten_spieler.get(zaehler).substring(2,3).equals("a"))
                {
                    System.out.println("│ " + zaehler + " | " + "ø" + " rot" +   "                     │");
                }
                else
                {
                    System.out.println("│ " + zaehler + " | " + karten_spieler.get(zaehler).substring(2,3) + " rot" + "                      │"); 
                }
                

            }
            else if(karten_spieler.get(zaehler).substring(0,2).equals("gr"))
            {   
                if(karten_spieler.get(zaehler).substring(2,3).equals("+"))
                {
                    System.out.println("│ " + zaehler + " | " + karten_spieler.get(zaehler).substring(2,3) + karten_spieler.get(zaehler).substring(3,4) + " grün" +   "                    │");
                }
                else if( karten_spieler.get(zaehler).substring(2,3).equals("a"))
                {
                    System.out.println("│ " + zaehler + " | " + "ø" + " grün" +   "                     │");
                }
                else
                {
                    System.out.println("│ "+ zaehler + " | " + karten_spieler.get(zaehler).substring(2,3) + " grün" + "                     │");
                }
            }
            else if(karten_spieler.get(zaehler).substring(0,2).equals("ge"))
            {
                if(karten_spieler.get(zaehler).substring(2,3).equals("+"))
                {
                    System.out.println("│ " + zaehler + " | " + karten_spieler.get(zaehler).substring(2,3) + karten_spieler.get(zaehler).substring(3,4) + " gelb" +   "                    │");
                }
                else if( karten_spieler.get(zaehler).substring(2,3).equals("a"))
                {
                    System.out.println("│ " + zaehler + " | " + "ø" + " gelb" +   "                     │");
                }
                else
                {
                     System.out.println("│ "+ zaehler + " | " + karten_spieler.get(zaehler).substring(2,3) + " gelb" + "                     │");
                }
            }
            else //(karten_spieler.get(zaehler).substring(0,2).equals("bl"))
            {
                if(karten_spieler.get(zaehler).substring(2,3).equals("+"))
                {
                    System.out.println("│ " + zaehler + " | " + karten_spieler.get(zaehler).substring(2,3) + karten_spieler.get(zaehler).substring(3,4) + " blau" +   "                     │");
                }
                else if( karten_spieler.get(zaehler).substring(2,3).equals("a"))
                {
                    System.out.println("│ " + zaehler + " | " + "ø" + " blau" +   "                     │");
                }
                else
                {
                    System.out.println("│ "+ zaehler + " | " + karten_spieler.get(zaehler).substring(2,3) + " blau" +  "                     │");
                }
                    
            }
            
            zaehler++;

        }
        System.out.println("└────────────────────────────────┘");
    }







}