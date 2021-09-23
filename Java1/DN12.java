
import java.io.File;

/**
 *
 * @author Marcel
 */
public class DN12 {

    public static int stevec = 0;
    public static void notranji(String pot) {
        File f = new File(pot);
        String[] seznam = f.list();
        for (String imeDatoteke : seznam) {
            File ff = new File(pot+"/"+imeDatoteke);
            if(ff.isDirectory()){
                System.out.print("  ");
                for(int i = 0; i < stevec; i++){
                    System.out.print("|  ");
                }
                System.out.println("|___"+imeDatoteke);
                stevec ++;
                notranji(ff.getAbsolutePath());
                stevec --;
            }
            else{
                System.out.print("  ");
                for(int i = 0; i < stevec; i++){
                    System.out.print("|  ");
                }
                System.out.println("|___"+imeDatoteke);
            }
        }
    }

    public static void main(String[] args) {
        //String pot = "C:/Users/Marcel/Desktop/a";
        System.out.println(args[0]);
        notranji(args[0]); //pot
        //System.out.println(f.isDirectory());
        //System.out.println("Datoteke folderja " + f.getAbsolutePath());

    }
}
