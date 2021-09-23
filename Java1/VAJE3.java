package javaprogrami;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Marcel
 */
public class VAJE3 {
    static char pik = '\u2660'; // ♠
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

    public static void main(String[] args){
        //ustvariKarte();
        
        //String karte[] = ustvariKarte();
        //izpisi(karte);
        
        //String karte[] = ustvariKarte();
        //premesajKarte(karte, 200);
        //izpisi(karte);
        
        //String karte[] = ustvariKarte();
        //preprostoStetje(karte);
        //System.out.println(preprostoStetje(karte));
        
        String karte[] = ustvariKarte();
        premesajKarte(karte, 200);
        izpisi(karte);
        System.out.println();

        System.out.println("Prvi kup kart:");
        int kupcek1= natancnoStetje(karte, true, 0, 25);

        System.out.println("Drugi kup kart:");
        int kupcek2= natancnoStetje(karte, true, 25, 54);

        System.out.println("Natancno stetje 1. kupa kart: " + kupcek1);
        System.out.println("Natancno stetje 2. kupa kart: " + kupcek2);
    }    
    
    static String[] ustvariKarte(){
        String[] tabela = new String[54];
        int i = 0;
        for(int j = 0; j < prazneRdece.length; j++){
            tabela[i] = srce + prazneRdece[j];
            i++;
        }
        for(int j = 0; j < figure.length; j++){
            tabela[i] = srce + figure[j];
            i++;
        }
        
        for(int j = 0; j < prazneRdece.length; j++){
            tabela[i] = karo + prazneRdece[j];
            i++;
        }
        for(int j = 0; j < figure.length; j++){
            tabela[i] = karo + figure[j];
            i++;
        }
        
        for(int j = 0; j < prazneRdece.length; j++){
            tabela[i] = kriz + prazneCrne[j];
            i++;
        }
        for(int j = 0; j < figure.length; j++){
            tabela[i] = kriz + figure[j];
            i++;
        }
        
        for(int j = 0; j < prazneRdece.length; j++){
            tabela[i] = pik + prazneCrne[j];
            i++;
        }
        for(int j = 0; j < figure.length; j++){
            tabela[i] = pik + figure[j];
            i++;
        }
        
        for(int j = 0; j < taroki.length; j++){
            tabela[i] = taroki[j];
            i++;
        }
        
        //System.out.println(Arrays.toString(tabela));
        return (tabela);
    }
    
    static void izpisi(String karte[]){
        for(int i = 0; i < karte.length; i++){
            if(i % 8 == 0){
                System.out.println();
            }
            System.out.print(karte[i] + " ");
        }
        System.out.println();
        //System.out.println(Arrays.toString(karte));
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
    
    static int natancnoStetje(String karte[], boolean izpis, int z, int k){
        int vsota = 0;
        int stevec = k - z;
        int kolikokrat = 0;
        for(int i = z; i < k; i++){
            String str = karte[i];
            if(stevec == 2 || stevec == 1){
                if(stevec == 2){
                    System.out.print(karte[i] + " ");
                    System.out.print(karte[i+1] + " ");
                    String[] tabela1 = new String[] {karte[i],karte[i+1]};
                    System.out.println(preprostoStetje(tabela1)-1);
                    stevec -=1;
                    vsota += preprostoStetje(tabela1)-1;
                    i += 1;
                }
                else if(stevec == 1){
                    System.out.print(karte[i] + " ");
                    String[] tabela1 = new String[] {karte[i]};
                    System.out.println(preprostoStetje(tabela1)-1);
                    vsota += preprostoStetje(tabela1)-1;
                    i += 1;
                }
                System.out.println();
            }
            else if(stevec == 3){
                System.out.print(karte[i] + " ");
                System.out.print(karte[i+1] + " ");
                System.out.print(karte[i+2] + " ");
                String[] tabela1 = new String[] {karte[i],karte[i+1],karte[i+2]};
                System.out.println(preprostoStetje(tabela1)-2);
                stevec -=2;
                vsota += preprostoStetje(tabela1)-2;
                i += 2;
            }
            else if(kolikokrat % 3 == 0){
                System.out.print(karte[i] + " ");
                System.out.print(karte[i+1] + " ");
                System.out.print(karte[i+2] + " ");
                String[] tabela1 = new String[] {karte[i],karte[i+1],karte[i+2]};
                System.out.println(preprostoStetje(tabela1)-2);
                stevec -=2;
                vsota += preprostoStetje(tabela1)-2;
                i += 2;
            }
            kolikokrat ++;
            stevec --;
        }
        return(vsota);
    }
}
