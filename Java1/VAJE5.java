package javaprogrami;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marcel
 */
public class VAJE5 {

    static final int MAX_NAPAK = 10;

    // Seznam fraz; dopolnite ga s poljubnimi frazami
    // (vec ko jih bo, bolj zabavna bo igra)
    static String[] fraze = {"SONCE SIJE", "TRAVA RASTE", "KOLESAR BRZI",
        "ZIDAR ZIDA", "METLA POMETA", "VELIKA NOGA", "RDECA VRTNICA",
        "SLEPA ULICA", "MODRINA NEBA", "SABLJA", "NETOPIR", "KOLOVRAT",
        "SMUCANJE", "BELE STRMINE", "OTROCI SE ZOGAJO", "BABICA LIKA",
        "PROGRAMER PROGRAMIRA", "SKAF IMA LUKNJO", "VISLICE SO ZABAVNE"};

    // fraza, ki jo uganjujemo
    static String fraza;

    // katere crke smo ze uganili
    static boolean uganil[];

    static int steviloNapak;

    static boolean prvanapaka[][];
    static boolean druganapaka[][];

    static void novaIgra() {
        Random rand = new Random();
        int n = rand.nextInt(fraze.length);
        fraza = fraze[n];

        uganil = new boolean[fraza.length()];
        for (int i = 0; i < uganil.length; i++) {
            if (fraza.charAt(i) == ' ') {
                uganil[i] = true;
            }
        }
        steviloNapak = 0;
    }

    static boolean jeUganil() {
        int koliko = 0;
        for (int i = 0; i < uganil.length; i++) {
            if (uganil[i] == true) {
                koliko++;
            }
        }
        if (koliko == uganil.length) {
            return true;
        } else {
            return false;
        }
    }

    static void izpisiUganko() {
        for (int i = 0; i < uganil.length; i++) {
            char crka = fraza.charAt(i);
            if (crka == ' ') {
                System.out.print(" ");
            } else if (uganil[i] == true) {
                System.out.print(crka);
            } else if (uganil[i] == false) {
                System.out.print(".");
            }
        }
        System.out.println();
    }

    static void postaviVprasanje() {
        System.out.printf("Naredite lahko še %d napak: ", (MAX_NAPAK - steviloNapak));
        Scanner sc = new Scanner(System.in);
        String vnos = sc.nextLine();
        vnos = vnos.toUpperCase();
        if (vnos.equals(fraza)) {
            for (int i = 0; i < uganil.length; i++) {
                uganil[i] = true;
            }
        } else if (fraza.contains(vnos) && vnos.length() == 1) {
            for (int i = 0; i < uganil.length; i++) {
                String crka = Character.toString(fraza.charAt(i));
                if (vnos.equals(crka)) {
                    uganil[i] = true;
                }
            }
        } else if (!vnos.equals(fraza)) {
            steviloNapak++;
        } else {
            steviloNapak++;
        }
    }

    /*static void ustvari() {
        prvanapaka = new boolean[16][16];
        for (int i = 0; i < prvanapaka.length; i++) {
            for (int j = 0; j < prvanapaka[0].length; j++) {
                if (i == 15) {
                    prvanapaka[i][j] = true;
                }
            }
        }
        druganapaka = new boolean[16][16];
        for (int i = 0; i < druganapaka.length; i++) {
            for (int j = 0; j < druganapaka.length; j++) {
                if (j == 0) {
                    druganapaka[i][j] = true;
                }
            }
        }
    }

    static void slikca() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (prvanapaka[i][j] == true && (steviloNapak == 1 || steviloNapak == 2)) {
                    System.out.print("*");
                } else if (prvanapaka[i][j] == false && (steviloNapak == 1 || steviloNapak == 2)) {
                    System.out.print(" ");
                }

                if (druganapaka[i][j] == true && (steviloNapak == 2) && prvanapaka[i][j] == false) {
                    System.out.print("*");
                } /*else if (druganapaka[i][j] == false && (steviloNapak == 2)) {
                    System.out.print(" ");
                }*/
            }
            System.out.println();
        }
    }*/

    public static void main(String args[]) {
        novaIgra();
        //ustvari();
        while ((steviloNapak < MAX_NAPAK) && !jeUganil()) {
            //slikca();
            izpisiUganko();
            postaviVprasanje();
        }
        if (jeUganil()) {
            System.out.println(fraza);
            System.out.println("Bravo!");
        } else {
            System.out.println("Konec igre! Pravilen odgovor je: " + fraza);
        }
    }

}
