/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package ponavljanje;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Marcel
 */
public class DN05 {

    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            analizirajTemperature(args[0]);
        } else if (args.length == 4) {
            if(preveriSudoku(preberiResitevSudoku(args[0]))){
                System.out.println("Resitev je pravilna.");
            }
            else{
                System.out.println("Resitev NI pravilna.");
            }
            vsotaPoDiagonali(preberiResitevSudoku(args[0]));
            zamenjajStolpca(preberiResitevSudoku(args[0]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
        }
    }
    
    public static void zamenjajStolpca(int[][] tabela, int j, int k){
        for (int i = 0; i < 25; i++) {
            int zac = tabela[i][j-1];
            tabela[i][j-1] = tabela[i][k-1];
            tabela[i][k-1] = zac;
        }
    }
    
    public static void vsotaPoDiagonali(int[][] tabela) {
        int prva = 0;
        //diagonala iz leve zgoraj proti desni spodaj
        for (int i = 0; i < 25; i++) {
            prva += tabela[i][i];
        }
        
        int druga = 0;
        //diagonala iz desne zgoraj proti levi spodaj
        for (int i = 0; i < 25; i++) {
            druga += tabela[i][24-i];
        }
        
        int tretja = 0;
        //vsi kvadratki
        for (int i = 0; i < 25; i++) {
            if(i==0 || i==5 || i==10 || i==15 || i==20){
                tretja += tabela[i][0]+tabela[i][4]+tabela[i][5]+tabela[i][9]+tabela[i][10]+tabela[i][14]+tabela[i][15]+tabela[i][19]+tabela[i][20]+tabela[i][24];
            }
            else if(i==1 || i==6 || i==11 || i==16 || i==21){
                tretja += tabela[i][1]+tabela[i][3]+tabela[i][6]+tabela[i][8]+tabela[i][11]+tabela[i][13]+tabela[i][16]+tabela[i][18]+tabela[i][21]+tabela[i][23];
            }
            else if(i==2 || i==7 || i==12 || i==17 || i==22){
                tretja += tabela[i][2]+tabela[i][7]+tabela[i][12]+tabela[i][17]+tabela[i][22];
            }
            else if(i==3 || i==8 || i==13 || i==18 || i==23){
                tretja += tabela[i][1]+tabela[i][3]+tabela[i][6]+tabela[i][8]+tabela[i][11]+tabela[i][13]+tabela[i][16]+tabela[i][18]+tabela[i][21]+tabela[i][23];
            }
            else if(i==4 || i==9 || i==14 || i==19 || i==24){
                tretja += tabela[i][0]+tabela[i][4]+tabela[i][5]+tabela[i][9]+tabela[i][10]+tabela[i][14]+tabela[i][15]+tabela[i][19]+tabela[i][20]+tabela[i][24];
            }
        }
        
        System.out.printf("Vsota na diagonalah je %d, %d in %d.\n",prva,druga,tretja);
    }

    public static int[][] popraviResitev(int[][] tabela) {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                for (int k = 0; k < 25; k++) {
                    if (tabela[i][j] == tabela[i][k] && j != k) {
                        tabela[i][j] = 0;
                        tabela[i][k] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                for (int k = 0; k < 25; k++) {
                    if (tabela[j][i] == tabela[k][i] && j != k) {
                        tabela[j][i] = 0;
                        tabela[k][i] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < 25; i += 5) { //row
            for (int j = 0; j < 25; j += 5) { //col
                for (int k = 0; k < 25; k++) {
                    for (int k2 = 0; k2 < 25; k2++) {
                        int prvi = i + k %5;
                        int drugi = j + k /5;
                        int tretji = i + k2 %5;
                        int cetrti = j + k2 /5;
                        if (tabela[prvi][drugi] == tabela[tretji][cetrti] && k != k2) {
                            tabela[prvi][drugi] = 0;
                            tabela[tretji][cetrti] = 0;
                        }
                    }
                }
            }
        }
        return tabela;
    }

    public static boolean preveriSudoku(int[][] tabela) {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (tabela[i][j] < 1 || tabela[i][j] > 25) {
                    //System.out.println("false");
                    return false;
                }
                for (int k = 0; k < 25; k++) {
                    if (tabela[i][j] == tabela[i][k] && j != k) {
                        //System.out.println("false");
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                for (int k = 0; k < 25; k++) {
                    if (tabela[j][i] == tabela[k][i] && j != k) {
                        //System.out.println("false");
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < 25; i += 5) { //row
            for (int j = 0; j < 25; j += 5) { //col
                for (int k = 0; k < 25; k++) {
                    for (int k2 = 0; k2 < 25; k2++) {
                        int prvi = i + k %5;
                        int drugi = j + k /5;
                        int tretji = i + k2 %5;
                        int cetrti = j + k2 /5;
                        if (tabela[prvi][drugi] == tabela[tretji][cetrti] && k != k2) {
                            //System.out.println("false");
                            return false;
                        }
                    }
                }
            }
        }

        //System.out.println("true");
        return true;
    }

    public static int[][] preberiResitevSudoku(String datoteka) throws Exception {
        int[][] tabela = new int[25][25];
        Scanner sc = new Scanner(new File(datoteka));
        int i = 0;
        while (sc.hasNextInt()) {
            for (int j = 0; j < 25; j++) {
                tabela[i][j] = sc.nextInt();
            }
            i++;
        }
        sc.close();
        return tabela;
    }

    public static void analizirajTemperature(String datoteka) throws Exception {
        double[] tabela = {-10, -10, -10, -10, -10};
        double vsota = 0;
        int koliko = 0;
        Scanner sc = new Scanner(new File(datoteka));

        while (sc.hasNext()) {
            String trenutni = sc.next();
            double vrednost = Double.parseDouble(trenutni.replace(",", "."));
            koliko++;
            vsota += vrednost;

            double najmanjsa = 100;
            int indeks = 0;
            for (int i = tabela.length - 1; i >= 0; i--) {
                if (tabela[i] <= najmanjsa) {
                    najmanjsa = tabela[i];
                    indeks = i;
                }
            }
            if (vrednost > najmanjsa) {
                tabela[indeks] = vrednost;
            }
        }

        sc.close();

        String a = String.format("%.2f", Double.valueOf(vsota / koliko));

        System.out.printf("Povprecje zapisanih temperatur je %s.", a.replace(".", ","));
        System.out.println("");
        System.out.println("Najvisjih 5 temperatur:");

        int kolikoo = 0;
        while (kolikoo < 5) {
            double max = -10;
            int ind = 0;
            for (int i = 0; i < tabela.length; i++) {
                if (tabela[i] > max) {
                    max = tabela[i];
                    ind = i;
                }
            }
            tabela[ind] = -10;
            String aa = String.format("%.2f", Double.valueOf(max));
            System.out.printf("%s\n", aa.replace(".", ","));
            kolikoo++;
        }
    }
}
