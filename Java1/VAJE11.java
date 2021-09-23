package javaprogrami;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Marcel
 */
class Letalisce {

    String kratica;
    String mesto;
    String drzava;
    ArrayList prihodi;
    ArrayList odhodi;

    public Letalisce(String kratica, String mesto, String drzava) {
        this.kratica = kratica;
        this.mesto = mesto;
        this.drzava = drzava;
    }

    public Letalisce(ArrayList kratica, ArrayList mesto) {
        this.prihodi = kratica;
        this.odhodi = mesto;
    }

    public void tostring() {
        System.out.println(kratica + ": " + mesto + ", " + drzava); //LJU: Ljubljana, Slovenija
    }
}

class MrezaLetov {

    TreeMap<String, Letalisce> destinacije;

    public MrezaLetov() { //String kratica, Letalisce razred
        this.destinacije = new TreeMap();
    }

    public void preberiLetalisca(File f) throws Exception {
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String vrstica = sc.nextLine();
            String[] tabelaa = vrstica.split(" ");
            Letalisce p = new Letalisce(tabelaa[0], tabelaa[1], tabelaa[2]);
            destinacije.put(tabelaa[0], p);
        }
        sc.close();
    }

    public void izpis() {
        for (Map.Entry<String, Letalisce> entry : destinacije.entrySet()) {
            Letalisce l = entry.getValue();
            l.tostring();
        }
    }

    public void preberiPovezave(File f) throws Exception {
        Scanner sc = new Scanner(f);
        ArrayList<String> tabela1 = new ArrayList<String>();
        ArrayList<String> tabela2 = new ArrayList<String>();
        
        while (sc.hasNextLine()) {
            String vrstica = sc.nextLine();
            String[] tabelaa = vrstica.split(" ");

            Letalisce l1 = destinacije.get(tabelaa[0]);
            Letalisce l2 = destinacije.get(tabelaa[0]);
            
            destinacije.put(tabelaa[0],l1);
            destinacije.put(tabelaa[1],l2);
            
            l1 = new Letalisce(tabela1, tabela2);
        }
        
        sc.close();
    }
}

public class VAJE11 {

    public static void main(String[] args) throws Exception {
        MrezaLetov mreza = new MrezaLetov();
        File f1 = new File("C:/Users/Marcel/Desktop/prva.txt");
        mreza.preberiLetalisca(f1);
        mreza.izpis();
        File f2 = new File("C:/Users/Marcel/Desktop/druga.txt");
        mreza.preberiPovezave(f2);
    }
}
