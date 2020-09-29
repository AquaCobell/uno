import java.util.*;

class reader
{
    public static void main(String[]args)
    {   
        class test
        {
            test()
            {

                Spieler spieler1 = new Spieler();               
            }

        }

        System.out.println("Hallo");
        String karte = "ro0";
        String deckkarte = "ge5";
        if(karte.substring(0,2).equals(deckkarte.substring(0,2)) || karte.substring(2,3).equals(deckkarte.substring(2,3)))
            {
                System.out.println("yeahhh");

                
            }   
       // test hallo = new test();
        
    }



}