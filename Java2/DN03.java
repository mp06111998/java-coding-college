/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package ponavljanje;

/**
 *
 * @author Marcel
 */
public class DN03 {

    public static void main(String[] args) {
        String arg2 = args[1];
        double arg3 = Double.parseDouble(args[2]);
        
        if (args[0].equals("min")) 
        {
            double min = Double.parseDouble(args[1]);
            System.out.print("Minimum stevil ");
            for (int i = 1; i < args.length; i++) {
                if (Double.parseDouble(args[i]) < min) {
                    min = Double.parseDouble(args[i]);
                }
                System.out.printf("%s ", args[i]);
            }
            System.out.printf("je %.2f",min);
        }
        
        else if (args.length == 3) 
        {
            double arg1 = Double.parseDouble(args[0]);
            Izracun(arg1, arg2, arg3, args[0], args[2]);
        } 
    }

    static void Izracun(double arg1, String arg2, double arg3, String nic, String dva) {
        if (arg2.equals("+"))
        {
            System.out.printf(nic + " + " + dva + " = %.2f",arg1+arg3);
        }
        else if (arg2.equals("-"))
        {
            System.out.printf(nic + " - " + dva + " = %.2f",arg1-arg3);
        }
        else if (arg2.equals("#"))
        {
            System.out.printf(nic + " * " + dva + " = %.2f",arg1*arg3);
        }
        else if (arg2.equals("/"))
        {
            System.out.printf(nic + " / " + dva + " = %.2f",arg1/arg3);
        }
        else if (arg2.equals("^"))
        {
            System.out.printf(nic + " ^ " + dva + " = %.2f",Math.pow(arg1,arg3));
        }
    }
}

