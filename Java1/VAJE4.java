package javaprogrami;

/**
 *
 * @author Marcel
 */
public class VAJE4 {
    public static void main(String[] args) {
        izpisi(71917410474557695l);
        izpisi(4342175383962075708l);
        
        izpisi(new long[] {
            4821103401091611672l, 0, 144680345680364600l, 1739555224076567106l, 
            -9114862049243683816l,1739555224076567106l, 0, 4821103401091611672l
        });
    }

    public static void izpisi(long crka){
        String s = String.valueOf(crka);
        String beseda = Long.toBinaryString(crka);
        if(s.charAt(0) == '-'){
            for(int r = 0; r < 8; r++){
                beseda = beseda.substring(0, beseda.length() - 1);
            }
        }
        for(int i = 1; i <= beseda.length(); i++){
            if((i-1) % 8 == 0){
                System.out.println();
            }
            if(beseda.charAt(i-1) == '1'){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
        }
        System.out.println();  
    }

    public static void izpisi(long crke[]){
        
    }
}
