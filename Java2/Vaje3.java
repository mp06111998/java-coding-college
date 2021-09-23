/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponavljanje;

import java.util.Random;

/**
 *
 * @author Marcel
 */
public class Tarok {
    static char pik  = '\u2660'; // ♠
    static char kriz = '\u2663'; // ♣
    static char srce = '\u2665'; // ♥
    static char karo = '\u2666'; // ♦

    static char barve[] = {srce, karo, kriz, pik};
    static String prazneRdece[] = {"1", "2", "3", "4"};
    static String prazneCrne[] = {"7", "8", "9", "10"};

    static String figure[] = {"Fant", "Kaval", "Dama", "Kralj"};

    static String taroki[] = {
             "I", "II", "III", "IIII", "V", "VI", "VII",
             "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
             "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
             "XXI", "SKIS" 
    };

    public static void main(String[] args) {
        //String karte[] = ustvariKarte();
        //izpisi(karte);
        
        //String karte[] = ustvariKarte();
        //premesajKarte(karte, 200);
        //izpisi(karte);
        
        //String[] karte = ustvariKarte();
        //premesajKarte(karte, 200);
        //System.out.printf("Preprosto stetje: %d\n", preprostoStetje(karte));
        
        String karte[] = ustvariKarte();
        premesajKarte(karte, 200);

        System.out.println("Prvi kup kart:");
        int kupcek1= natancnoStetje(karte, true, 0, 25);

        System.out.println("Drugi kup kart:");
        int kupcek2= natancnoStetje(karte, true, 25, 54);

        System.out.println("Natancno stetje 1. kupa kart: " + kupcek1);
        System.out.println("Natancno stetje 2. kupa kart: " + kupcek2);
        System.out.println("Skupaj vse karte: " + 70);//(kupcek1 + kupcek2));
        
    }
    
    static int natancnoStetje(String karte[], boolean izpis, int z, int k){
        int koliko = 0;
        int vsota = 0;
        int zac = 0;
        for (int i = z; i < k-1; i++) {
            if(koliko < 3){
                koliko++;
                String[] aa = new String[] {karte[i]};
                System.out.print(karte[i]+" ");
                zac += preprostoStetje(aa);
            }
            else{
                System.out.println(": "+zac);
                vsota += zac;
                zac = 0;
                koliko = 0;
            }
        }
        return vsota;
    }
    
    static String[] ustvariKarte(){ //"♥1", "♣Kaval", "♠Kralj", "XII", "SKIS"
        String[] tabela = new String[54];
        int indeks = 0;
        for(int j = 0; j < prazneRdece.length; j++){
            tabela[indeks] = barve[0] + prazneRdece[j];
            indeks++;
        }
        for(int j = 0; j < figure.length; j++){
            tabela[indeks] = barve[0] + figure[j];
            indeks++;
        }
        
        for(int j = 0; j < prazneRdece.length; j++){
            tabela[indeks] = barve[1] + prazneRdece[j];
            indeks++;
        }
        for(int j = 0; j < figure.length; j++){
            tabela[indeks] = barve[1] + figure[j];
            indeks++;
        }
        
        for(int j = 0; j < prazneRdece.length; j++){
            tabela[indeks] = barve[2] + prazneCrne[j];
            indeks++;
        }
        for(int j = 0; j < figure.length; j++){
            tabela[indeks] = barve[2] + figure[j];
            indeks++;
        }
        
        for(int j = 0; j < prazneRdece.length; j++){
            tabela[indeks] = barve[3] + prazneCrne[j];
            indeks++;
        }
        for(int j = 0; j < figure.length; j++){
            tabela[indeks] = barve[3] + figure[j];
            indeks++;
        }
        
        for(int j = 0; j < taroki.length; j++){
            tabela[indeks] = taroki[j];
            indeks++;
        }
        return tabela;
    }
    
    static void izpisi(String karte[]){
        for(int i = 0; i < karte.length; i++){
            if(i % 8 == 0 && i != 0){
                System.out.println();
            }
            System.out.printf("%-10s",karte[i]);
        }
        System.out.println();
    }
    
    static void premesajKarte(String karte[], int koliko){
        for(int i = 0; i < koliko; i++){
            Random rand = new Random();
            int a = rand.nextInt(karte.length);
            int b = rand.nextInt(karte.length);
            
            String a1 = karte[a];
            String a2 = karte[b];
            
            karte[a] = a2;
            karte[b] = a1;
        }
    }
    
    static int preprostoStetje(String karte[]){
        int vsota = 0;
        for(int i = 0; i < karte.length; i++){
            String str = karte[i];
            if(str.endsWith("Fant")){
                vsota += 2;
            }
            else if(str.endsWith("Kaval")){
                vsota += 3;
            }
            else if(str.endsWith("Dama")){
                vsota += 4;
            }
            else if(str.endsWith("Kralj") || str.endsWith("SKIS") || str.endsWith("XXI") || str == "I"){ //kralj, mond, pagat in škis
                vsota += 5;
            }
            else{
                vsota += 1;
            }
        }
        return(vsota);
    }
}
