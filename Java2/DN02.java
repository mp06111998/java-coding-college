public class DN02 {
    public static void main(String[] args) {
        int najdaljsa = 0;
        for (int i = 0; i < args.length; i++) {
            if(args[i].length() > najdaljsa){
                najdaljsa = args[i].length();
            }
        }
        
        for (int i = 0; i < najdaljsa+4; i++) {
            System.out.print("*");
        }
        System.out.println("");
        
        for (int i = 0; i < args.length; i++) {
            System.out.print("* ");
            int presledki = najdaljsa - args[i].length();
            for (int j = 0; j < presledki/2; j++) {
                System.out.print(" ");
            }
            System.out.print(args[i]);
            for (int j = 0; j < presledki/2; j++) {
                System.out.print(" ");
            }
            if(args[i].length()%2 != 0 && najdaljsa > args[i].length() && najdaljsa%2 == 0){System.out.print(" ");}
            System.out.println(" *");
        }
        
        for (int i = 0; i < najdaljsa+4; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}