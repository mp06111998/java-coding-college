import java.util.Scanner;
import java.io.File;

/**
 *
 * @author Marcel
 */
class Planet {
    String Ime;
    double Radij;
    
    public Planet(String Ime, double Radij){
        this.Ime = Ime;
        this.Radij = Radij;
    }
    
    double povrsina(){
        double pov = 4 * Math.PI * (Radij * Radij);
        return pov;
    }
}

public class DN08 {
    public static void main(String[] args) throws Exception{
        String prviArg = args[0];
        String drugiArg = args[1];
        ustvari(prviArg, drugiArg);
    }
    
    public static void ustvari(String datoteka, String planet) throws Exception{
		Planet[] tabela = new Planet[9];
		int indeks = 0;
		
        Scanner sc = new Scanner(new File(datoteka));
        double vsota = 0;
        
        while(sc.hasNextLine()){
            String vrstica = sc.nextLine();
            if(vrstica.contains(":")){
                String[] deli = vrstica.split(":");
                tabela[indeks] = new Planet(deli[0], Integer.parseInt(deli[1]));
                indeks ++;
            }
        }
		sc.close();
		
		String[] planeti = planet.split("\\+");
        for(int i = 0; i < planeti.length; i++){
            if(planeti[i].equals("")){
                planeti[i] = "Neobstojec";
            }
            planeti[i] = planeti[i].substring(0,1).toUpperCase() + planeti[i].substring(1).toLowerCase();
        }
        
        for(int i = 0; i < planeti.length; i++){
            for(int j = 0; j < indeks; j++){
                if(planeti[i].equals(tabela[j].Ime)){
                    vsota += tabela[j].povrsina();
                }
            }
        }
        
        double vsota1 = vsota / 1000000;
        System.out.printf("Povrsina planetov \"%s\" je %.0f milijonov km2%n", planet, vsota1);
    }
}