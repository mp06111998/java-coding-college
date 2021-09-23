/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author Marcel
 */
public class DN04 {
    static String[] prva   = {"Miha", "Micka", "Tone", "Lojze", "Mojca", "Pepca", "Franci", "Francka"};
    static String[] druga  = {"Vozi", "Seka", "Potrebuje", "Gleda", "Barva", "Voha", "Lomi", "Popravlja"};
    static String[] tretja = {"Kolo", "Avto", "Likalnik", "Sonce", "Vrtnico", "Drevo", "Lopato", "Sekiro"};

    static String ustvariGeslo() {
        Random rnd = new Random();
        int rnd1 = rnd.nextInt(prva.length);
        int rnd2 = rnd.nextInt(druga.length);
        int rnd3 = rnd.nextInt(tretja.length);
    
        return prva[rnd1] + druga[rnd2] + tretja[rnd3];
    }

    public static void main(String[] args) {
        //System.out.println(ustvariGeslo());
        System.out.println(check(args[0]));

    }
    
    public static boolean check(String string){
        int koliko = 0;
        String[] tabela = string.split("(?=[A-Z])");
        if(tabela.length != 3){
            return false;
        }
        for (int i = 0; i < prva.length; i++) {
            if(prva[i].equals(tabela[0])){
                koliko++;
            }
        }
        for (int j = 0; j < druga.length; j++) {
            if(druga[j].equals(tabela[1])){
                koliko++;
            }
        }
        for (int k = 0; k < tretja.length; k++) {
            if(tretja[k].equals(tabela[2])){
                koliko++;
            }
        }
        if(koliko == 3){
            return true;
        }
        else {return false;}
    }
}
