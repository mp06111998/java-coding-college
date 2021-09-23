import java.util.Random;
public class DN04 {
    static String[] prva   = {"Miha", "Micka", "Tone", "Lojze", "Mojca", "Pepca", "Franci", "Francka"};
    static String[] druga  = {"vozi", "seka", "potrebuje", "gleda", "barva", "voha", "lomi", "popravlja"};
    static String[] tretja = {"kolo", "avto", "likalnik", "sonce", "vrtnico", "drevo", "lopato", "sekiro"};

    static String ustvariGeslo() {
        Random rnd = new Random();
        int rnd1 = rnd.nextInt(prva.length);
        int rnd2 = rnd.nextInt(druga.length);
        int rnd3 = rnd.nextInt(tretja.length);
    
        return prva[rnd1] + " " + druga[rnd2] + " " + tretja[rnd3];
    }

    public static void main(String[] args) {
        //System.out.println(ustvariGeslo());
        if(args.length == 3){
            String prvi = args[0];
            String drugi = args[1];
            String tretji = args[2];
            System.out.println(preveriGeslo(prvi, drugi, tretji));
        }
        else if(args.length != 3){
            String prvi = "!";
            String drugi = "!";
            String tretji = "!";
            System.out.println(preveriGeslo(prvi, drugi, tretji));
        }
    }

    static  Boolean preveriGeslo(String prvi1, String drugi1, String tretji1) {
        Boolean alije1 = false;
        Boolean alije2 = false;
        Boolean alije3 = false;
        /*for(int i = 0; i < prva.length; i++) {
            if(prvi1 == prva[i]){
                alije1 = true;
            }
        }
        for(int j = 0; j < druga.length; j++) {
            if(drugi1 == druga[j]){
                alije2 = true;
            }
        }
        for(int k = 0; k < tretja.length; k++) {
            if(tretji1 == tretja[k]){
                alije3 = true;
            }
        }*/
        
        for(String vsak1 : prva){
            if(prvi1.equals(vsak1)){
                alije1 = true;
            }
        }
        for(String vsak2 : druga){
            if(drugi1.equals(vsak2)){
                alije2 = true;
            }
        }
        for(String vsak3 : tretja){
            if(tretji1.equals(vsak3)){
                alije3 = true;
            }
        }
        
        if(alije1 && alije2 && alije3){
            return(true);
        }
        else{
            return(false);
        }
    }
}
