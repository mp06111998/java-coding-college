import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
/**
 *
 * @author Marcel
 */
interface Kodirnik{
    public String enkripcija(String besedilo);
    public String dekripcija(String besedilo);
}

class CezarjevAlgoritem implements Kodirnik{
    int zamik;
    
    public CezarjevAlgoritem(int zamik){
        this.zamik = zamik;
    }
    
    public String enkripcija(String besedilo){
        char[] tabela = besedilo.toCharArray();
        for (int i = 0; i < tabela.length; i++) {
            char crka = tabela[i];
            crka = (char) (crka + zamik);
            if (crka > 'z') {
                crka = (char) (crka - 26);
            } else if (crka < 'a') {
                crka = (char) (crka + 26);
            }
            tabela[i] = crka;
        }
        return new String(tabela);
    } 
    
    public String dekripcija(String besedilo){
        char[] tabela = besedilo.toCharArray();
        for (int i = 0; i < tabela.length; i++) {
            char crka = tabela[i];
            crka = (char) (crka - zamik);
            if (crka > 'z') {
                crka = (char) (crka + 26);
            } else if (crka < 'a') {
                crka = (char) (crka - 26);
            }
            tabela[i] = crka;
        }
        return new String(tabela);
    } 
}

class XOR implements Kodirnik{
    String geslo;
    
    public XOR(String geslo){
        this.geslo = geslo;
    }
    
    public String enkripcija(String besedilo){
        char[] tabela1 = besedilo.toCharArray();
        char[] tabela2 = geslo.toCharArray();
        int st = 0;
        for(int i = 0; i < tabela1.length; i++){
            char letter1 = tabela1[i];
            if(st > tabela2.length-1){
                st = 0;
            }
            char letter2 = tabela2[st];
            letter1 = (char) (letter1 ^ letter2+32); //+32
            
            tabela1[i] = letter1;
        }
        return new String(tabela1);
    } 
    
    public String dekripcija(String besedilo){
        char[] tabela1 = besedilo.toCharArray();
        char[] tabela2 = geslo.toCharArray();
        int st = 0;
        for(int i = 0; i < tabela1.length; i++){
            char letter1 = tabela1[i];
            if(st > tabela2.length-1){
                st = 0;
            }
            char letter2 = tabela2[st];
            letter1 = (char) (letter1 ^ letter2+32); //+32
            
            tabela1[i] = letter1;
        }
        return new String(tabela1);
    } 
}

class Kodiranje{
    public String preberiIzDatoteke(String imeDatoteke) throws Exception{
        Scanner sc = new Scanner(new File("C:/Users/Marcel/Desktop/%s", imeDatoteke));
        while(sc.hasNextLine()){
            String vrstica = sc.nextLine();
        }
        sc.close();
        return "a";
    }
}

public class VAJE10 {
    public static void main(String [] args) throws Exception{
        CezarjevAlgoritem c1 = new CezarjevAlgoritem(3);
        System.out.print("CezarjevAlgoritem enkripcija: ");
        System.out.println(c1.enkripcija("AbC"));
        System.out.print("CezarjevAlgoritem dekripcija: ");
        System.out.println(c1.dekripcija("^e`"));
        System.out.println("");
        XOR x1 = new XOR("ana");
        System.out.print("XOR enkripcija: ");
        System.out.println(x1.enkripcija("sonce"));
        System.out.print("XOR dekripcija: ");
        System.out.println(x1.dekripcija("òîïâä"));
    }
}
