
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

/**
 *
 * @author Marcel
 */
class Komponenta{
    String ime;
    double cena;
    int popust;
    
    public Komponenta(String ime, double cena, int popust){
        this.ime = ime;
        this.cena = cena;
        this. popust = popust;
    }
    
    public Komponenta(String ime, double cena){
        this.ime = ime;
        this.cena = cena;
    }
    
    public String tooString(){
        double cenaa = cenaSPopustom();
        return ime + ", cena s popustom: " + cenaa + "€";
    }
    
    public double cenaSPopustom(){
        double cenaa = cena * 1;
        return cenaa;
    }
}

class Pomnilnik extends Komponenta{
    int tip; //vrednost 0 pomeni SDRAM, 1 DDR, 2 DDR2, 3 DDR3
    int velikost;
    int hitrost;
    
    public Pomnilnik(String ime, double cena, int tip, int velikost, int hitrost){
        super(ime,cena);
        this.tip = tip;
        this.velikost = velikost;
        this.hitrost = hitrost;
    }
    
    public String tooString(){
        if (tip == 0){
            String a = super.tooString();
            return a+ "\nTip: SDRAM, velikost: "+ velikost + "GB, hitrost: " + hitrost + "MHz\n";
        }
        else if (tip == 1){
            String a = super.tooString();
            return a + "\nTip: DDR, velikost: "+ velikost + "GB, hitrost: " + hitrost + "MHz\n";
        }
        else if (tip == 2){
            String a = super.tooString();
            return a + "\nTip: DDR2, velikost: "+ velikost + "GB, hitrost: " + hitrost + "MHz\n";
        }
        else if (tip == 3){
            String a = super.tooString();
            return a + "\nTip: DDR3, velikost: "+ velikost + "GB, hitrost: " + hitrost + "MHz\n";
        }
        else{
            String a = super.tooString();
            return a + "\nNapaka\n";
        }
    } 
}

class MaticnaPlosca extends Komponenta{
    String format;
    String podnozje;
    int steviloPomnilniskihRez;
    
    public MaticnaPlosca(String ime, double cena, String format, String podnozje, int steviloPomnilniskihRez){
        super(ime,cena);
        this.format = format;
        this.podnozje = podnozje;
        this.steviloPomnilniskihRez = steviloPomnilniskihRez;
    }
    
    public String tooString(){
        String a = super.tooString();
        return a + "\nFormat: " + format +", podnozje: " + podnozje + ", stevilo pomn. rez: " + steviloPomnilniskihRez + "\n";
    }
    
    public boolean jeKompatibilna(Procesor p){
        if (podnozje.equals(p.podnozje)){
            return true;
        }
        else{
            return false;
        }
    }
}

class Procesor extends Komponenta{
    String podnozje;
    double steviloJeder;
    int hitrostJedra;
    
    public Procesor(String ime, double cena, String podnozje, double steviloJeder, int hitrostJedra){
        super(ime,cena);
        this.podnozje = podnozje;
        this.steviloJeder = steviloJeder;
        this.hitrostJedra = hitrostJedra;
    }
    
    public String tooString(){
        String a = super.tooString();
        return a + "\nPodnozje: " + podnozje + ", st. jeder: " + steviloJeder + ", hitrost jedra: " + hitrostJedra + "MHz\n";
    }
}

public class VAJE09 {
    public static Komponenta[] tabela = new Komponenta[10];
    private static int indeks = 0;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("C:/Users/Marcel/Desktop/komponente.txt"));
        while(sc.hasNextLine()){
            String vrstica = sc.nextLine();
            String[] deli = vrstica.split(";");
            
            if (deli[0].equals("Procesor")){
                Procesor p = new Procesor(deli[1],Double.parseDouble(deli[2]),deli[1],Double.parseDouble(deli[4]),Integer.parseInt(deli[5]));
                tabela[indeks] = p;
                indeks++;
            }
            
            else if (deli[0].equals("Pomnilnik")){
                Pomnilnik po = new Pomnilnik(deli[1],Double.parseDouble(deli[2]),Integer.parseInt(deli[3]),Integer.parseInt(deli[4]),Integer.parseInt(deli[5]));
                tabela[indeks] = po;
                indeks++;
            }
            
            else if (deli[0].equals("Maticna")){
                MaticnaPlosca pl = new MaticnaPlosca(deli[1],Double.parseDouble(deli[2]),deli[3],deli[4],Integer.parseInt(deli[5]));
                tabela[indeks] = pl;
                indeks++;
            }
        }
        for(int i = 0; i < indeks; i++){
            System.out.println(tabela[i].tooString());
        }
    }
}
