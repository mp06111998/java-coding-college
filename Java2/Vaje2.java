/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponavljanje;

/**
 *
 * @author Marcel
 */
public class Vaje2 {
    public static void main(String[] args) {
        System.out.println("  n            n!               Stirling(n)         napaka (%)");
        System.out.println("--------------------------------------------------------------");
        for (int i = 1; i <= 100; i++) {
            double napaka = (fakultetaD(i) - stirlingD(i)) / (double) fakultetaD(i) * 100;
            System.out.printf("%3d%21.9E%21.9E%16.7f\n",i,fakultetaD(i),stirlingD(i),napaka);
        }
    }
    
    public static double fakultetaD(int n){
        double rezultat = 1;
        for (int i = 2; i <= n; i++) {
            rezultat = rezultat * i;
        }
        return rezultat;
    }
    
    public static double stirlingD(int n){
        return Math.sqrt(2*Math.PI*n)*Math.pow((n/Math.E),n);
    }
    
    /*public static void main(String[] args) {
        System.out.println("  n            n!               Stirling(n)         napaka (%)");
        System.out.println("--------------------------------------------------------------");
        for (int i = 1; i <= 20; i++) {
            double napaka = (fakultetaL(i) - stirlingL(i)) / (double) fakultetaL(i) * 100;
            System.out.printf("%3d%21d%21d%16.7f\n",i,fakultetaL(i),stirlingL(i),napaka);
        }
    }
    
    public static long fakultetaL(int n){
        long rezultat = 1;
        for (int i = 2; i <= n; i++) {
            rezultat = rezultat * i;
        }
        return rezultat;
    }
    
    public static long stirlingL(int n){
        return Math.round(Math.sqrt(2*Math.PI*n)*Math.pow((n/Math.E),n));
    }*/
}
