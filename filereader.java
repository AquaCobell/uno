


//nur ein Testprogramm zum austesten von Funktionen
//kann ignoriert bzw gelöscht werden


import java.util.*;
import java.io.*;
class File
{
    ArrayList<String> test = new ArrayList<String>();
    File()
    {




    }

    public void liesein(String dateiname) throws IOException
    {
        FileReader fr = new FileReader(dateiname);
        BufferedReader br = new BufferedReader(fr);
        String zeile = br.readLine();
        
        while(!zeile.equals("stop")) // Solange Zeile nicht stop ist
        {
            zeile = br.readLine();
            if(!zeile.isEmpty()) //Wenn Zeile nicht null ist
            {
                test.add(zeile);
            }
            
            
            
        }
       
    }

}

class test
{
    public static void main(String[]args)  throws IOException
    {
        File file = new File();
        file.liesein("karten.txt");
        System.out.println("Fertig");



    }


}