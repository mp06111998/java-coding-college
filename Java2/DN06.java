/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Marcel
 */
public class DN06 {
    public static void main(String[] args) throws Exception{
        izpis(args[0]);
    }
    
    public static void izpis(String datoteka)throws Exception{
        Scanner sc = new Scanner(new File(datoteka));
        while (sc.hasNextLine()) {
            String crka = "";
            char[] deli = sc.nextLine().toCharArray();
            for (int i = 0; i < deli.length; i+=8) {
                crka += deli[i];
                crka += deli[i+1];
                crka += deli[i+2];
                crka += deli[i+3];
                crka += deli[i+4];
                crka += deli[i+5];
                crka += deli[i+6];
                crka += deli[i+7];
                int st = Integer.parseInt(crka, 2);
                char crka1 = (char) st;
                crka = "";
                System.out.print(crka1);
            }
        }
        System.out.println("");
        sc.close();
    }
}
