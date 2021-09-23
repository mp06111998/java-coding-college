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

interface Lik {   
   public double povrsina();
}

class Kvadrat implements Lik {
   private int a;
   
   public Kvadrat(int a){
       this.a = a;
   }
   
   public double povrsina(){
       return this.a * this.a;
   }
}

class Pravokotnik implements Lik {
   private int a ;
   private int b;
   
   public Pravokotnik(int a, int b){
       this.a = a;
       this.b = b;
   }
   
   public double povrsina(){
       return this.a * this.b;
   }
}

class Krog implements Lik {
   private int r;
   
   public Krog(int r){
       this.r = r;
   }
   
   public double povrsina(){
       return Math.PI * Math.pow(this.r,2);
   }
}

public class DN10 {
    static Lik[] tabela = new Lik[100];
    static int stevec = 0;
    
    static void preberi(String datoteka) throws Exception{
        Scanner sc = new Scanner(new File(datoteka));
        while(sc.hasNextLine()){
            String[] tabelaa = sc.nextLine().split(":");
            if(tabelaa[0].equals("kvadrat")){ tabela[stevec++] = new Kvadrat(Integer.parseInt(tabelaa[1])); }
            else if (tabelaa[0].equals("pravokotnik")){ tabela[stevec++] = new Pravokotnik(Integer.parseInt(tabelaa[1]),Integer.parseInt(tabelaa[2])); }
            else if (tabelaa[0].equals("krog")){ tabela[stevec++] = new Krog(Integer.parseInt(tabelaa[1])); }
        }
        sc.close();
    }
    
    static void izracunaj(){
        double vsota = 0;
        for (int i = 0; i < stevec; i++) {
            vsota += tabela[i].povrsina();
        }
        System.out.printf("%.2f",vsota);
    }
    
    public static void main(String[] args) throws Exception{
        preberi(args[0]);
        izracunaj();
    }
}
