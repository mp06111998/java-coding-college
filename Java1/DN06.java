//package javaprogrami;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

/**
 *
 * @author Marcel
 */
public class DN06 {

    public static void main(String[] args) throws Exception {
        //pretvori(args[0]);
        pretvori(args[0]);
    }

    public static void pretvori(String datoteka) throws Exception {
        Scanner sc = new Scanner(new File(datoteka));
        int k = 0;
        String zacasni = "";
        while (sc.hasNextLine()) {
            char[] deli = sc.nextLine().toCharArray();
            for (int j = k; j < (deli.length / 8); j++) {
                for (int i = k; i < k + 8; i++) {
                    //System.out.print(deli[i]);
                    zacasni = zacasni + deli[i];
                }
                int st = Integer.parseInt(zacasni, 2);
                char crka = (char) st;
                System.out.print(crka);
                zacasni = "";
                k += 8;
            }
            k = 0;
        }
		sc.close();
        System.out.println();
    }
}
