
import java.util.Scanner;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Marcel
 */
public class DN10 {

    public static void main(String[] args) throws Exception {
        //String [] tabela = Branje(args[0]);
        if (args[1].equals("1")) {
            String[] tabela11 = Branje(args[0]);
            Prva(tabela11);
        } else if (args[1].equals("2")) {
            String[] tabela11 = Branje(args[0]);
            Druga(tabela11);
        } else {
            System.out.println("Drugi argument ni ustrezen!");
        }
        //String [] tabela = Branje("s");
        //Prva(tabela);
    }

    static String[] Branje(String datoteka) throws Exception {
        //Scanner sc = new Scanner(new File("C:/Users/Marcel/Desktop/test.txt")); //datoteka namesto C:/...
        int i = 0;
        Scanner sc = new Scanner(new File(datoteka));
        String[] tabela = new String[600];
        while (sc.hasNextLine()) {
            String vrstica = sc.nextLine();
            int j = 0;
            String[] tabelaa = vrstica.split(" ");
            for (int ii = 0; ii < tabelaa.length; ii++) {
                tabela[i] = tabelaa[j];
                i++;
                j++;
            }
        }
        String[] tabela1 = new String[i];
        for (int jj = 0; jj < tabela1.length; jj++) {
            tabela1[jj] = tabela[jj];
        }
        return tabela1;
    }

    static void Prva(String[] tabela) {
        //HashMap m = new HashMap();
        TreeMap m = new TreeMap();
        for (int i = 0; i < tabela.length; i++) {
            String str = tabela[i].replace(".", "");
            str = str.replace(",", "");
            str = str.replace("(", "");
            str = str.replace(")", "");
            str = str.replace(";", "");
            str = str.replace("-", "");
            if (m.containsKey(str)) {
                m.put(str, (int) m.get(str) + 1);
            } else {
                m.put(str, 1);
            }
        }

        for (Object key : m.keySet()) {
            System.out.print(m.get(key));
            if ((int) m.get(key) >= 10) {
                System.out.print("    ");
            } else {
                System.out.print("     ");
            }
            System.out.println(key);
        }
    }

    static void Druga(String[] tabela) {
        //HashMap m = new HashMap();
        LinkedHashMap m = new LinkedHashMap();
        for (int i = 0; i < tabela.length; i++) {
            String str = tabela[i].replace(".", "");
            str = str.replace(",", "");
            str = str.replace("(", "");
            str = str.replace(")", "");
            str = str.replace(";", "");
            str = str.replace("-", "");
            if (m.containsKey(str)) {
                m.put(str, (int) m.get(str) + 1);
            } else {
                m.put(str, 1);
            }
        }
        for (Object key : m.keySet()) {
            System.out.print(m.get(key));
            if ((int) m.get(key) >= 10) {
                System.out.print("    ");
            } else {
                System.out.print("     ");
            }
            System.out.println(key);}
}
}