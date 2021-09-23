import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

class Oseba {
    String ime;
    String priimek;
    String naslov;
    String mesto;
    String posta;
    String telefon;
    
    public Oseba(String ime1, String priimek1, String naslov1, String mesto1, String posta1, String telefon1){
        this.ime = ime1;
        this.priimek = priimek1;
        this.naslov = naslov1;
        this.mesto = mesto1;
        this.posta = posta1;
        this.telefon = telefon1;
    }
    
    public void izpisi(){
        System.out.print(this.ime + ", ");
        System.out.print(this.priimek + ", ");
        System.out.print(this.naslov + ", ");
        System.out.print(this.mesto + ", ");
        System.out.print(this.posta + ", ");
        System.out.print(this.telefon);
        System.out.println();
    }
}

public class VAJE08 {
    public static Oseba[] tabela = new Oseba[10];
    private static int indeks = 0;
    public static void main(String[] args) throws Exception{
        preberiOsebe("C:/Users/Marcel/Desktop/imenik.txt");
        isciOseboPoImenu("Tilen");
        isciOsebePoPosti("Ljubljana");
        /*for(int i = 0; i < tabela.length; i++){
            if(tabela[i] != null){
                tabela[i].izpisi();
            }
            else{
                System.out.println(tabela[i]);
            }
        }*/
    }
    
    public static void preberiOsebe(String datoteka) throws Exception{
        Scanner sc = new Scanner(new File(datoteka));
        while(sc.hasNextLine()){
            String vrstica = sc.nextLine();
            String[] deli = vrstica.split(", ");
            Oseba o1 = new Oseba(deli[0], deli[1], deli[2], deli[3], deli[4], deli[5]);
            //o1.Oseba(deli[0], deli[1], deli[2], deli[3], deli[4], deli[5]);
            tabela[indeks] = o1;
            indeks ++;
        }
    }
    
    public static void isciOseboPoImenu(String imee) throws Exception{
        int a = 0;
        for(int i = 0; i < indeks; i++){
            if(imee.equals(tabela[i].ime) && a == 0){
                tabela[i].izpisi();
                a++;
            }
        }
        if(a == 0){
            System.out.println("Null");
        }
    }
    
    public static void isciOsebePoPosti(String posta) throws Exception{
        int a = 0;
        for(int i = 0; i < indeks; i++){
            if(posta.equals(tabela[i].posta)){
                a++;
            }
        }
        System.out.printf("V iskani pošti živijo %d osebe%n", a);
    }
}