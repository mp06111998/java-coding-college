/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprogrami;
import java.lang.Math;
/**
 *
 * @author Marcel
 */
public class VAJE2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //fakultetaL(6);
        //stirlingL(6);
        //fakulteta1(20);
        //fakultetaD(6);
        //stirlingD(6);
        fakulteta2(100);
    }
    
    static long fakultetaL(long n){
        long produkt = 1;
        for (int i = 1; i <= n; i++){
            produkt = produkt * i;
        }
        return produkt;
    }
    
    static long stirlingL(long n){
        double produkt = Math.sqrt(2*Math.PI*n)* Math.pow((n/Math.E),n);
        produkt = Math.round(produkt); 
        long l = (new Double(produkt)).longValue();
        return l;
    } 
    
    static void fakulteta1(int n){
        System.out.println("  n            n!               Stirling(n)         napaka (%)");
        System.out.println("--------------------------------------------------------------");
        for (int j = 1; j <= n; j++){
            double napaka = ((fakultetaL(j) - stirlingL(j)) / (double) fakultetaL(j) * 100);
            System.out.printf("%3d%21d%21d%16f\n", j, fakultetaL(j), stirlingL(j), napaka);
        }
    }
    
    //Do vrednosti n = 20 je ta tip še primeren za izračun vrednosti fakultete
    
    static double fakultetaD(long n){
        double produkt = 1;
        for (int i = 1; i <= n; i++){
            produkt = produkt * i;
        }
        //System.out.println(produkt);
        return produkt;
    }
    
    static double stirlingD(long n){
        double produkt = Math.sqrt(2*Math.PI*n)* Math.pow((n/Math.E),n);
        //produkt = Math.round(produkt); 
        //System.out.println(produkt);
        return produkt;
    }
    
    static void fakulteta2(int n){
        System.out.println("  n            n!               Stirling(n)         napaka (%)");
        System.out.println("--------------------------------------------------------------");
        for (int j = 1; j <= n; j++){
            double napaka = (Math.abs(fakultetaD(j) - stirlingD(j)) / (double) fakultetaD(j) * 100);
            System.out.printf("%3d%21.9E%21.9E%16.7f\n", j, fakultetaD(j), stirlingD(j), napaka);
        }
    }
}
