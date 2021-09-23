/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marcel
 */
public class DN11 {

    public static ArrayList preberi(String imeDatoteke) throws Exception {
        ArrayList<String> tabela = new ArrayList<String>();
        Scanner sc = new Scanner(new File(imeDatoteke));
        while (sc.hasNextLine()) {
            String vrstica = sc.nextLine();
            String[] tabelaa = vrstica.split(" ");
            for (int i = 0; i < tabelaa.length; i++) {
                tabela.add(tabelaa[i]);
            }
        }
        sc.close();
        return tabela;
    }

    public static void prva(String nic, String ena) throws Exception {
        int koliko = 0;
        //ArrayList<String> tabela = preberi("abc.txt"); //args[0]
        ArrayList<String> tabela = preberi(nic);
        int OMEJITEV = Integer.parseInt(ena);
        for (int i = 0; i < tabela.size(); i++) {
            int st = tabela.get(i).length();
            if (koliko + st <= OMEJITEV && koliko == 0) {
                System.out.print(tabela.get(i));
                koliko += st;
            } else if (koliko + st + 1 <= OMEJITEV) {
                System.out.print(" " + tabela.get(i));
                koliko += st + 1;
            } else {
                System.out.println();
                i -= 1;
                koliko = 0;
            }
        }
        System.out.println();
    }

    public static void druga(String nic, String ena) throws Exception {
        int koliko = 0;
        //ArrayList<String> tabela = preberi("abc.txt"); //args[0]
        ArrayList<String> tabela = preberi(nic);
        int OMEJITEV = Integer.parseInt(ena);
        for (int i = 0; i < tabela.size(); i++) {
            int st = tabela.get(i).length();
            if (koliko + st <= OMEJITEV && koliko == 0) {
                System.out.print(tabela.get(i));
                koliko += st;
            } else if (koliko + st + 1 <= OMEJITEV) {
                System.out.print(" " + tabela.get(i));
                koliko += st + 1;
            } else {
                System.out.println();
                i -= 1;
                koliko = 0;
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws Exception {
        if(args[2].equals("x")){
            druga(args[0], args[1]);
        }
        else{
            prva(args[0], args[1]);
        }
    }
}
