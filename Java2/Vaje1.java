
public class Vaje {
    public static void main(String[] args) {
        //pravokotnik(5, 3, 7);
        //trikotnik(5, 3);
        //trikotnik(1, 5);
        //okvir(0, 4, 15);
        //hisa();
        //dvaPravokotnika(5, 15, 3, 6);
        //raketa();
        X(2);
    }
    
    static void pravokotnik(int odmik, int visina, int sirina){
        for (int i = 0; i < visina; i++) {
            for (int j = 0; j < odmik; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < sirina; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    static void trikotnik(int odmik, int visina){
        int oddmik = visina-1;
        int zvez = 1;
        for (int i = 0; i < visina; i++) {
            for (int j = 0; j < odmik+oddmik; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < zvez; j++) {
                System.out.print("*");
            }
            zvez+=2;
            oddmik--;
            System.out.println();
        }
    }
    
    static void okvir(int odmik, int visina, int sirina){
        for (int i = 1; i <= visina; i++) {
            for (int j = 0; j < odmik; j++) {
                System.out.print(" ");
            }
            if(i == 1 || i == visina){
                for (int j = 0; j < sirina; j++) {
                    System.out.print("*");
                }
            }
            else{
                System.out.print("*");
                for (int j = 0; j < sirina-2; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    static void hisa(){
        trikotnik(0,10);
        okvir(2,10,15);
    }
    
    static void dvaPravokotnika(int odmik, int razmik, int visina, int sirina){
        for (int i = 0; i < visina; i++) {
            for (int j = 0; j < odmik; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < sirina; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < razmik; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < sirina; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    static void raketa(){
        trikotnik(1,7);
        pravokotnik(0,11,15);
        dvaPravokotnika(2,5,7,3);
    }
    
    static void X(int n){
        int odmik = 0;
        int razmik = (10*(n-1))-5;
        boolean ali = true;
        for (int i = 1; i <= n*2-1; i++) {
            if(i == n){
                pravokotnik(odmik,3,5);
                ali = false;
            }
            else if(ali == true){
                dvaPravokotnika(odmik,razmik,3,5);
                odmik += 5;
                razmik -= 10;
            }
            else if(ali == false){
                odmik -= 5;
                razmik += 10;
                dvaPravokotnika(odmik,razmik,3,5);
            }
        }
    }
}
