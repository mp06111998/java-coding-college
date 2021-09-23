/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package ponavljanje;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Marcel
 */
public class DN11 {

    public static void main(String[] args) throws Exception {
        TreeMap<String, Integer> slovar = new TreeMap<String, Integer>();
        Scanner sc = new Scanner(new File(args[0]));
        while (sc.hasNext()) {
            String naslednji = sc.next();
            naslednji = naslednji.replace(".", "");
            naslednji = naslednji.replace(",", "");
            naslednji = naslednji.replace("(", "");
            naslednji = naslednji.replace(")", "");
            naslednji = naslednji.replace(";", "");
            naslednji = naslednji.replace("-", "");
            if (slovar.containsKey(naslednji)) {
                slovar.put(naslednji, slovar.get(naslednji) + 1);
            } else {
                slovar.put(naslednji, 1);
            }
        }
        sc.close();

        if (args[1].equals("1")) {
            for (String key : slovar.keySet()) {
                if (slovar.get(key) < 10) {
                    System.out.println(slovar.get(key) + "     " + key);
                } else {
                    System.out.println(slovar.get(key) + "    " + key);
                }
            }
        } else if (args[1].equals("2")) {
            int st = 30;
            while (st > 0) {
                for (String key : slovar.keySet()) {
                    if (slovar.get(key) < 10 && st == slovar.get(key)) {
                        System.out.println(slovar.get(key) + "     " + key);
                    } else if (st == slovar.get(key)) {
                        System.out.println(slovar.get(key) + "    " + key);
                    }
                }
                st--;
            }
        }
    }
}
