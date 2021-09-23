package javaprogrami;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

/**
 *
 * @author Marcel
 */
public class VAJE06 {

    public static void main(String[] args) throws Exception {
        odkodiraj("C:/Users/Marcel/Desktop/pesem.txt", "C:/Users/Marcel/Desktop/kodirano.txt");
        //kodiraj("C:/Users/Marcel/Desktop/pesem.txt", "pomlad pomlad pomlad");
    }

    static void odkodiraj(String kodirnaKnjiga, String koda) throws Exception {
        Scanner pesem = new Scanner(new File(kodirnaKnjiga));
        Scanner code = new Scanner(new File(koda));
        int maxcrk = 0;
        /*naredi tabelo besed*/
        String[] deli = new String[100];
        int i = 0;
        while (pesem.hasNextLine()) {
            String vrstica = pesem.nextLine();
            String[] vrst = vrstica.split(" ");
            for (int j = 0; j < vrst.length; j++) {
                deli[i] = vrst[j];
                if(vrst[j].length() > maxcrk){
                    maxcrk = vrst[j].length();
                }
                i++;
            }
        }
        /*naredi tabelo kode*/
        int a = 0;
        while (code.hasNextInt()) {
            int naslednja = code.nextInt();
            if (naslednja > i) {
                int naslednja2 = code.nextInt();
                if(a == 1){
                    a = 0;
                }
                else if(a == 2){
                    System.out.print(" ");
                    a = 0;
                }
                else if(a == 3){
                    System.out.println();
                    a = 0;
                }
                System.out.print("?");
            } else if (naslednja == 0) {
                a++;
            } else if (naslednja > 0) {
                int naslednja2 = code.nextInt();
                if(naslednja2 > maxcrk){
                        if(a == 1){
                            a = 0;
                        }
                        else if(a == 2){
                            System.out.print(" ");
                            a = 0;
                        }
                        else if(a == 3){
                            System.out.println();
                            a = 0;
                        }
                        System.out.print("?");
                }
                else if (a == 1) {
                    String zac = deli[naslednja - 1];
                    char crka = zac.charAt(naslednja2 - 1);
                    crka = Character.toUpperCase(crka);
                    System.out.print(crka);
                    a = 0;
                } else if (a == 2) {
                    System.out.print(" ");
                    String zac = deli[naslednja - 1];
                    char crka = zac.charAt(naslednja2 - 1);
                    System.out.print(crka);
                    a = 0;
                } else if (a == 3) {
                    System.out.println();
                    String zac = deli[naslednja - 1];
                    char crka = zac.charAt(naslednja2 - 1);
                    System.out.print(crka);
                    a = 0;
                } else if (a == 0) {
                    String zac = deli[naslednja - 1];
                    char crka = zac.charAt(naslednja2 - 1);
                    System.out.print(crka);
                }
            }
        }
        System.out.println();

        /*for (int k = 0; k < i; k++) {
            System.out.println(deli[k]);
        }*/
        //Regrat cveti,
        //cebela hiti!
        pesem.close();
        code.close();
    }
    
    static void kodiraj(String kodirnaKnjiga, String niz) throws Exception {
        Scanner pesemca = new Scanner(new File(kodirnaKnjiga));
        /*naredi tabelo besed*/
        String[] deli = new String[100];
        int i = 0;
        while (pesemca.hasNextLine()) {
            String vrstica = pesemca.nextLine();
            String[] vrst = vrstica.split(" ");
            for (int j = 0; j < vrst.length; j++) {
                deli[i] = vrst[j];
                i++;
            }
        }
        for(int ii = 0; ii < niz.length(); ii++){
            char c = niz.charAt(ii);
            String crka = Character.toString(c);
            for(int jj = 0; jj < i; jj++){
                if(deli[jj].contains(crka)){
                    /*for (int q = 0; q < deli[jj].length(); q++){
                        char cq = deli[jj].charAt(q);
                        if (cq == c){
                            deli[jj] = deli[jj].substring(0,4)+'%'+deli[jj].substring(q);
                        }
                    }*/
                    System.out.println("T");
                }
                else{
                    System.out.println("F");
                }
            }
        }
        /*for (int k = 0; k < i; k++) {
            System.out.println(deli[k]);
        }*/
    }
}
