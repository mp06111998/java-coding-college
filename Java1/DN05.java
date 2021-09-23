//package javaprogrami;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
/**
 *
 * @author Marcel
 */
public class DN05 {
    public static void main(String[] args) throws Exception{
        if(args[0].equals("1")){
            najvec(args[1]);
        }
        
        else if(args[0].equals("2")){
			izpisi(rotiraj(duplikati(preberi(args[1])), Integer.parseInt(args[2])));
        }
		
		else if(args[0].equals("3")){
			vsota(args[1]);
		}
    }
    
    public static void najvec(String datoteka) throws Exception{
        Scanner sc = new Scanner(new File(datoteka));
        String[] izpis = new String[10];
        int i = 0;
        int najvecja = 0;
        while(sc.hasNextLine()){
            String vrstica = sc.nextLine();
            String[] deli = vrstica.split(":");
            int ocena = Integer.parseInt(deli[1]);
            if(ocena >= najvecja){
                if(ocena > najvecja){
                    i = 0;
                }
                najvecja = ocena;
                izpis[i] = deli[0];
                i++;
            }
        }
		System.out.printf("Max %d so dosegli:", najvecja);
		System.out.println();
        for(int j = 0; j < i; j++){
            System.out.println(izpis[j]);
        }
        sc.close();
    }
    
    public static Integer[] preberi(String datoteka) throws Exception{
        Scanner sc = new Scanner(new File(datoteka));
        Integer[] izpis = new Integer[sc.nextInt()];
        for(int i = 0; i < izpis.length; i++){
            izpis[i] = sc.nextInt();
        }
        sc.close();
        return izpis;
    }
    
    public static int[] duplikati(Integer[] datoteka) throws Exception{
        String[] tabela = new String[datoteka.length];
        int st = 0;
        for(int i = 0; i < datoteka.length; i++){
            for(int j = 0; j < tabela.length; j++){
                if(datoteka[i].toString().equals(tabela[j])) {
					break;
				}
				if(datoteka.length-j == 1){
					tabela[st++] = datoteka[i].toString();
				}
            }
			
        }
		int[] tabela1 = new int[st];
		for(int i = 0; i < st; i++){
			tabela1[i] = Integer.parseInt(tabela[i]);
		}
        
        /*for(int i = 0; i < tabela1.length; i++){
            System.out.println(tabela1[i]);
        }*/
        return tabela1;
    }
	
	public static int[] rotiraj(int[] datoteka, int k) throws Exception{
		int zacasni = 0;
		for(int i = 0; i < k; i++){
			for(int j = 0; j < datoteka.length-1; j++){
				zacasni = datoteka[j];
				datoteka[j] = datoteka[j+1];
				datoteka[j+1] = zacasni;
			}
		}
		/*for(int i = 0; i < datoteka.length; i++){
            System.out.println(datoteka[i]);
        }*/
		return datoteka;
	}
	
	public static void izpisi(int[] datoteka) throws Exception{
		for(int i = 0; i < datoteka.length; i++){
            System.out.print(datoteka[i] + " ");
        }
	}                                                   
	
	public static void vsota(String datoteka) throws Exception{
		Scanner sc = new Scanner(new File(datoteka));
		int prvi = sc.nextInt();
		int drugi = sc.nextInt();
		int[][] tabela = new int[prvi][drugi];
		int st = 0;
		for(int i = 0; i < prvi; i++){
			for(int j = 0; j < drugi; j++){
				tabela[i][j] = sc.nextInt();
			}
		}
		
		int index = 0;
		int[] tabelaz = new int[prvi];
		while(index < drugi){
			for(int j = 0; j < prvi; j++){
				tabelaz[j] = tabela[j][index];
			}
			Arrays.sort(tabelaz);
			for(int k = 0; k < prvi; k++){
				tabela[k][index] = tabelaz[k];
			}
			index += 1;
		}
		int vsota = 0;
		for (int i = 0; i < prvi; i++) {
            for (int j = 0; j < drugi; j++) {
                vsota += tabela[i][j];
            }
			System.out.print(vsota);
			System.out.print(" ");
			vsota = 0;
		}
		sc.close();
	}
}
