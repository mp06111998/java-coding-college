
import java.util.Scanner;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Marcel
 */
class DateTime {
    int leto;
    int mesec;
    int dan;
    int ura;
    int minuta;
    
    public DateTime(int leto, int mesec, int dan, int ura, int minuta){
        this.leto = leto;
        this.mesec = mesec;
        this.dan = dan;
        this.ura = ura;
        this.minuta = minuta;
    }
    
    public boolean isGreater(DateTime cas){
        boolean a = false;
        if(leto < cas.leto) a = true;
        else if(leto == cas.leto){
            if(mesec < cas.mesec) a = true;
            else if(mesec == cas.mesec){
                if(dan < cas.dan) a = true;
                else if(dan == cas.dan){
                    if(ura < cas.ura) a = true;
                    else if(ura == cas.ura){
                        if(minuta < cas.minuta) a = true;
                        else if(leto > cas.leto) a = false;
                        else{
                            a = true;
                        }
                    }
                    else if(ura > cas.ura) a = false;
                }
                else if(dan > cas.dan) a = false;
                }
            else if(mesec > cas.mesec) a = false;
        }
        else if(leto > cas.leto) a = false;
        return a;
    }
    
    public boolean isLower(DateTime cas){
        boolean vrednost = isGreater(cas);
        if(vrednost == false){
            return true;
        }
        else{return true;}
    }
    
    public boolean isEqual(DateTime cas){
        /*boolean vrednost1 = isGreater(cas);
        boolean vrednost2 = isLower(cas);
        if(vrednost1 == false && vrednost2 == false){
            return true;
        }
        else{
            return false;
        }*/
        int minute1 = ((((leto*12+mesec)*31+dan)*24+ura)*60+minuta);
        int minute2 = ((((cas.leto*12+cas.mesec)*31+cas.dan)*24+cas.ura)*60+cas.minuta);
        if(minute1 == minute2){
            return true;
        }
        else{return false;}
    }
    
    public String toString(){
        if(minuta<10 && ura<10){
            return dan + ". " + mesec + ". " + leto + " 0" + ura + ".0" + minuta; //1. 3. 2018 17.42
        }
        else if(ura<10){
            return dan + ". " + mesec + ". " + leto + " 0" + ura + ".0" + minuta; //1. 3. 2018 17.42
        }
        else if(minuta<10){
            return dan + ". " + mesec + ". " + leto + " " + ura + ".0" + minuta; //1. 3. 2018 17.42
        }
        else{
            return dan + ". " + mesec + ". " + leto + " " + ura + "." + minuta; //1. 3. 2018 17.42
        }
    }
}

class Candle {
    DateTime dateTime;
    double open;
    double high;
    double low;
    double close;
    
    public Candle(DateTime dateTime, double open, double high, double low, double close){
        this.dateTime = dateTime; //kako
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }
    
    //GETTERJI
    public DateTime getterDateTime() { 
        return dateTime; 
    }
    public double getterOpen() { 
        return open; 
    }
    public double getterHigh() { 
        return high; 
    }
    public double getterLow() { 
        return low; 
    }
    public double getterClose() { 
        return close; 
    }
    
    public double povp(){ //ni nujno da more bit tko
        return (open+high+low+close)/4;
    }
    
    public boolean isBullish(){
        if(close > open){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean isBearish(){
        if(close < open){
            return true;
        }
        else{
            return false;
        }
    }
}

class FinancialInstrument{
    String candles;
    String currency1;
    String currency2;
    String[] tabela = new String[4000];
    //ArrayList<String> tabela = new ArrayList<String>();
    
    public FinancialInstrument(String candles, String currency1, String currency2) throws Exception{
        int i = 0;
        Scanner sc = new Scanner(new File(candles));
        while(sc.hasNextLine()){
            this.tabela[i] = sc.nextLine();
            //this.tabela.add(sc.nextLine());
            i++;
        //sc.close();
        
        this.currency1 = currency1;
        this.currency2 = currency2;
    }
    } 
    
    public FinancialInstrument(String candles, String currency1) throws Exception{
        int i = 0;
        Scanner sc = new Scanner(new File(candles));
        while(sc.hasNextLine()){
            this.tabela[i] = sc.nextLine();
            //this.tabela.add(sc.nextLine());
            i++;
        //sc.close();
        
        this.currency1 = currency1;
    }
    }
    
    public void movingAverage(DateTime dateTime, int windowSize){ //movingAverage 30 EURUSD.csv 2018.03.14 12:34
        int Index = 0;
        for(int i = 0; i < tabela.length-1; i++){
            if(tabela[i+1] != null){
                String[] del1 = tabela[i].split(",");
                String[] datum1 = del1[0].split("\\.");
                String[] ura1 = del1[1].split("\\:");
                DateTime t1 = new DateTime(Integer.parseInt(datum1[0]),Integer.parseInt(datum1[1]),Integer.parseInt(datum1[2]),Integer.parseInt(ura1[0]),Integer.parseInt(ura1[1]));

                String[] del2 = tabela[i+1].split(",");
                String[] datum2 = del2[0].split("\\.");
                String[] ura2 = del2[1].split("\\:");
                DateTime t2 = new DateTime(Integer.parseInt(datum2[0]),Integer.parseInt(datum2[1]),Integer.parseInt(datum2[2]),Integer.parseInt(ura2[0]),Integer.parseInt(ura2[1]));

                if(dateTime.isEqual(t1)){
                    Index = i;
                }
                /*if(dateTime.isEqual(t2)){
                    Index = i+1;
                }
                else if(dateTime.isGreater(t1) && dateTime.isLower(t2)){
                    Index = i;
                }*/ //TO SE NE DELUJE!!!!
            }
        }
        int Index1 = Index - windowSize;
        double vsota = 0;
        for(int i = Index1+1; i <= Index; i++){
            String[] del1 = tabela[i].split(",");
            //System.out.println(del1[5]);
            vsota += Double.parseDouble(del1[5]);
        }
        System.out.printf("%f",(vsota/windowSize));
    }
    
    public void maxValue(DateTime t1, DateTime t2){
        double max = 0;
        boolean a = false;
        for(int i = 0; i < tabela.length; i++){
            if(tabela[i] != null){
                String[] del1 = tabela[i].split(",");
                String[] datum1 = del1[0].split("\\.");
                String[] ura1 = del1[1].split("\\:");
                DateTime t11 = new DateTime(Integer.parseInt(datum1[0]),Integer.parseInt(datum1[1]),Integer.parseInt(datum1[2]),Integer.parseInt(ura1[0]),Integer.parseInt(ura1[1]));
                if(t11.isEqual(t1)){
                    a = true;
                }
                if(a == true){
                    if(Double.parseDouble(del1[5]) > max){
                        max = Double.parseDouble(del1[5]);
                    }
                    else if(Double.parseDouble(del1[4]) > max){
                        max = Double.parseDouble(del1[4]);
                    }
                    else if(Double.parseDouble(del1[3]) > max){
                        max = Double.parseDouble(del1[3]);
                    }
                    else if(Double.parseDouble(del1[2]) > max){
                        max = Double.parseDouble(del1[2]);
                    }
                }
                if(t11.isEqual(t2)){
                    a = false;
                }
            }
        }
        System.out.printf("Najvisja vrednost za dani interval: %f",max);
    }
    
    public void minValue(DateTime t1, DateTime t2){
        double min = 2;
        boolean a = false;
        for(int i = 0; i < tabela.length; i++){
            if(tabela[i] != null){
                String[] del1 = tabela[i].split(",");
                String[] datum1 = del1[0].split("\\.");
                String[] ura1 = del1[1].split("\\:");
                DateTime t11 = new DateTime(Integer.parseInt(datum1[0]),Integer.parseInt(datum1[1]),Integer.parseInt(datum1[2]),Integer.parseInt(ura1[0]),Integer.parseInt(ura1[1]));
                if(t11.isEqual(t1)){
                    a = true;
                }
                if(a == true){
                    if(Double.parseDouble(del1[5]) < min){
                        min = Double.parseDouble(del1[5]);
                    }
                    else if(Double.parseDouble(del1[4]) < min){
                        min = Double.parseDouble(del1[4]);
                    }
                    else if(Double.parseDouble(del1[3]) < min){
                        min = Double.parseDouble(del1[3]);
                    }
                    else if(Double.parseDouble(del1[2]) < min){
                        min = Double.parseDouble(del1[2]);
                    }
                }
                if(t11.isEqual(t2)){
                    a = false;
                }
            }
        }
        System.out.printf("Najnizja vrednost za dani interval: %f",min);
    }
}

class CurrencyPair extends FinancialInstrument{
    public CurrencyPair(String candles, String currency1, String currency2)  throws Exception{
        super(candles, currency1, currency2);
    }
    
    public void nonBusinessDays(DateTime t1, DateTime t2){
        boolean a = false;
        int koliko = 0;
        for(int i = 0; i < tabela.length-1; i++){
            if(tabela[i+1] != null){
                String[] del1 = tabela[i].split(",");
                String[] datum1 = del1[0].split("\\.");
                String[] ura1 = del1[1].split("\\:");
                DateTime t11 = new DateTime(Integer.parseInt(datum1[0]),Integer.parseInt(datum1[1]),Integer.parseInt(datum1[2]),Integer.parseInt(ura1[0]),Integer.parseInt(ura1[1]));

                String[] del22 = tabela[i+1].split(",");
                String[] datum2 = del22[0].split("\\.");
                String[] ura2 = del22[1].split("\\:");
                DateTime t22 = new DateTime(Integer.parseInt(datum2[0]),Integer.parseInt(datum2[1]),Integer.parseInt(datum2[2]),Integer.parseInt(ura2[0]),Integer.parseInt(ura2[1]));
                
                if(t11.isEqual(t1)){
                    a = true;
                }
                
                if(a == true){
                    int minute1 = ((((t11.leto*12+t11.mesec)*31+t11.dan)*24+t11.ura)*60+t11.minuta);
                    int minute2 = ((((t22.leto*12+t22.mesec)*31+t22.dan)*24+t22.ura)*60+t22.minuta);
                    if(minute2 - minute1 > 6*60 && t11.dan == t22.dan){
                        koliko++;
                    }
                }
                
                if(t11.isEqual(t2)){
                    a = false;
                }
            }
        }
        System.out.printf("Trgovanja prostih dni: %s",koliko);
    }
    
    public void masterCandles(DateTime t1, DateTime t2){
        boolean a = false;
        int koliko = 0;
        int stevec = 0;
        for(int i = 0; i < tabela.length-4; i++){
            if(tabela[i+4] != null){
                String[] del1 = tabela[i].split(",");
                String[] datum1 = del1[0].split("\\.");
                String[] ura1 = del1[1].split("\\:");
                DateTime t11 = new DateTime(Integer.parseInt(datum1[0]),Integer.parseInt(datum1[1]),Integer.parseInt(datum1[2]),Integer.parseInt(ura1[0]),Integer.parseInt(ura1[1]));

                String[] del22 = tabela[i+1].split(",");
                String[] datum2 = del22[0].split("\\.");
                String[] ura2 = del22[1].split("\\:");
                DateTime t22 = new DateTime(Integer.parseInt(datum2[0]),Integer.parseInt(datum2[1]),Integer.parseInt(datum2[2]),Integer.parseInt(ura2[0]),Integer.parseInt(ura2[1]));
                
                String[] del33 = tabela[i+2].split(",");
                String[] datum3 = del33[0].split("\\.");
                String[] ura3 = del33[1].split("\\:");
                DateTime t33 = new DateTime(Integer.parseInt(datum3[0]),Integer.parseInt(datum3[1]),Integer.parseInt(datum3[2]),Integer.parseInt(ura3[0]),Integer.parseInt(ura3[1]));
                
                String[] del44 = tabela[i+3].split(",");
                String[] datum4 = del44[0].split("\\.");
                String[] ura4 = del44[1].split("\\:");
                DateTime t44 = new DateTime(Integer.parseInt(datum4[0]),Integer.parseInt(datum4[1]),Integer.parseInt(datum4[2]),Integer.parseInt(ura4[0]),Integer.parseInt(ura4[1]));
                
                String[] del55 = tabela[i+4].split(",");
                String[] datum5 = del55[0].split("\\.");
                String[] ura5 = del55[1].split("\\:");
                DateTime t55 = new DateTime(Integer.parseInt(datum5[0]),Integer.parseInt(datum5[1]),Integer.parseInt(datum5[2]),Integer.parseInt(ura5[0]),Integer.parseInt(ura5[1]));
                
                
                if(t11.isEqual(t1)){
                    a = true;
                }
                
                if(a == true){
                    if(Double.parseDouble(del1[3]) > Double.parseDouble(del22[3]) && Double.parseDouble(del1[4]) < Double.parseDouble(del22[4])){
                        stevec++;
                    }
                    if(Double.parseDouble(del1[3]) > Double.parseDouble(del33[3]) && Double.parseDouble(del1[4]) < Double.parseDouble(del33[4])){
                        stevec++;
                    }
                    if(Double.parseDouble(del1[3]) > Double.parseDouble(del44[3]) && Double.parseDouble(del1[4]) < Double.parseDouble(del44[4])){
                        stevec++;
                    }
                    if(Double.parseDouble(del1[3]) > Double.parseDouble(del55[3]) && Double.parseDouble(del1[4]) < Double.parseDouble(del55[4])){
                        stevec++;
                    }
                }
                
                if(stevec == 4){
                    koliko ++;
                }
                
                stevec = 0;
                
                if(t11.isEqual(t2)){
                    a = false;
                }
            }
        }
        System.out.println("Med " + t1.toString() + " in " + t2.toString() + " je bilo " + koliko +" master sveck.");
    }
}

class CryptoCurrency extends FinancialInstrument{
    public CryptoCurrency(String candles, String currency1, String currency2)  throws Exception{
        super(candles, currency1, currency2);
    }
    
    public void convert(CurrencyPair f2, DateTime t1){
        //this.currency2 = f2.currency1;
        //this.getCloseValue(t1) / cp.getCloseValue(dt);
        //System.out.printf("Kriptovaluta '" + cp.currency1 + "' je bila " + t1.toString() + " vredna " + 6508.254 + " EUR");
        boolean a = true;
        double prvi = 0;
        double drugi = 0;
        for(int i = 0; i < this.tabela.length; i++){
            if(this.tabela[i] != null){
                String[] del1 = this.tabela[i].split(",");
                String[] datum1 = del1[0].split("\\.");
                String[] ura1 = del1[1].split("\\:");
                DateTime t11 = new DateTime(Integer.parseInt(datum1[0]),Integer.parseInt(datum1[1]),Integer.parseInt(datum1[2]),Integer.parseInt(ura1[0]),Integer.parseInt(ura1[1]));
                
                if(a == true){
                    prvi = Double.parseDouble(del1[5]);
                }
                
                if(t1.isEqual(t11)){
                    a = false;
                }
            }
        }
        for(int i = 0; i < f2.tabela.length; i++){
            if(f2.tabela[i] != null){
                String[] del2 = f2.tabela[i].split(",");
                String[] datum2 = del2[0].split("\\.");
                String[] ura2 = del2[1].split("\\:");
                DateTime t22 = new DateTime(Integer.parseInt(datum2[0]),Integer.parseInt(datum2[1]),Integer.parseInt(datum2[2]),Integer.parseInt(ura2[0]),Integer.parseInt(ura2[1]));
                
                if(a == true){
                    drugi = Double.parseDouble(del2[5]);
                }
                
                if(t1.isEqual(t22)){
                    a = false;
                }
            }
        }
        System.out.printf("Kriptovaluta '" + this.currency1 + "' je bila " + t1.toString() + " vredna %.3f EUR", prvi/drugi);
    }
}

public class DN09 {
    public static void main(String[] args) throws Exception{
        if(args[0].equals("dateTime")){ //dateTime 2018.03.13 17:42
            String[] deli1 = args[1].split("\\.");
            String[] deli2 = args[2].split("\\:");
            DateTime t = new DateTime(Integer.parseInt(deli1[0]),Integer.parseInt(deli1[1]),Integer.parseInt(deli1[2]),Integer.parseInt(deli2[0]),Integer.parseInt(deli2[1])); //13. 3. 2018 17.42
            System.out.println(t.toString());
        }
        
        else if(args[0].equals("candle")){ //candle 2018.03.05 02:08 1.226140 1.226270 1.226080 1.226210 0
            String[] deli1 = args[1].split("\\.");
            String[] deli2 = args[2].split("\\:");
            DateTime t = new DateTime(Integer.parseInt(deli1[0]),Integer.parseInt(deli1[1]),Integer.parseInt(deli1[2]),Integer.parseInt(deli2[0]),Integer.parseInt(deli2[1])); //13. 3. 2018 17.42
            System.out.print(t.toString() + ": ");
            
            Candle c = new Candle(t, Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5]), Double.parseDouble(args[6]));
            System.out.print(c.povp());
        }
        
        else if(args[0].equals("movingAverage")){ //movingAverage 30 EURUSD.csv 2018.03.14 12:34
            String ime = args[2];
            
            StringBuilder sb1 = new StringBuilder();
            sb1.append(ime.charAt(0));
            sb1.append(ime.charAt(1));
            sb1.append(ime.charAt(2));
            String currency1 = sb1.toString();
            
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ime.charAt(3));
            sb2.append(ime.charAt(4));
            sb2.append(ime.charAt(5));
            String currency2 = sb2.toString();
            
            FinancialInstrument f = new FinancialInstrument(args[2], currency1, currency2);
            int size = Integer.parseInt(args[1]);
            
            String[] deli1 = args[3].split("\\.");
            String[] deli2 = args[4].split("\\:");
            DateTime t = new DateTime(Integer.parseInt(deli1[0]),Integer.parseInt(deli1[1]),Integer.parseInt(deli1[2]),Integer.parseInt(deli2[0]),Integer.parseInt(deli2[1]));
            
            f.movingAverage(t,size);
        }
        
        else if(args[0].equals("najvisja")){ //najvisja EURUSD.csv 2018.03.13 08:00 2018.03.14 08:00
            String ime = args[1];
            
            StringBuilder sb1 = new StringBuilder();
            sb1.append(ime.charAt(0));
            sb1.append(ime.charAt(1));
            sb1.append(ime.charAt(2));
            String currency1 = sb1.toString();
            
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ime.charAt(3));
            sb2.append(ime.charAt(4));
            sb2.append(ime.charAt(5));
            String currency2 = sb2.toString();
            
            FinancialInstrument f = new FinancialInstrument(args[1], currency1, currency2);
            
            String[] deli1 = args[2].split("\\.");
            String[] deli2 = args[3].split("\\:");
            DateTime t1 = new DateTime(Integer.parseInt(deli1[0]),Integer.parseInt(deli1[1]),Integer.parseInt(deli1[2]),Integer.parseInt(deli2[0]),Integer.parseInt(deli2[1]));
            
            String[] deli11 = args[4].split("\\.");
            String[] deli22 = args[5].split("\\:");
            DateTime t2 = new DateTime(Integer.parseInt(deli11[0]),Integer.parseInt(deli11[1]),Integer.parseInt(deli11[2]),Integer.parseInt(deli22[0]),Integer.parseInt(deli22[1]));
            
            f.maxValue(t1,t2);
            
        }
        
        else if(args[0].equals("najnizja")){ //najvisja EURUSD.csv 2018.03.13 08:00 2018.03.14 08:00
            String ime = args[1];
            
            StringBuilder sb1 = new StringBuilder();
            sb1.append(ime.charAt(0));
            sb1.append(ime.charAt(1));
            sb1.append(ime.charAt(2));
            String currency1 = sb1.toString();
            
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ime.charAt(3));
            sb2.append(ime.charAt(4));
            sb2.append(ime.charAt(5));
            String currency2 = sb2.toString();
            
            FinancialInstrument f = new FinancialInstrument(args[1], currency1, currency2);
            
            String[] deli1 = args[2].split("\\.");
            String[] deli2 = args[3].split("\\:");
            DateTime t1 = new DateTime(Integer.parseInt(deli1[0]),Integer.parseInt(deli1[1]),Integer.parseInt(deli1[2]),Integer.parseInt(deli2[0]),Integer.parseInt(deli2[1]));
            
            String[] deli11 = args[4].split("\\.");
            String[] deli22 = args[5].split("\\:");
            DateTime t2 = new DateTime(Integer.parseInt(deli11[0]),Integer.parseInt(deli11[1]),Integer.parseInt(deli11[2]),Integer.parseInt(deli22[0]),Integer.parseInt(deli22[1]));
            
            f.minValue(t1,t2);
            
        }
        
        else if(args[0].equals("nonBusiness")){ //nonBusiness EURUSD.csv 2018.03.13 00:00 2018.03.15 23:59
            String ime = args[1];
            
            StringBuilder sb1 = new StringBuilder();
            sb1.append(ime.charAt(0));
            sb1.append(ime.charAt(1));
            sb1.append(ime.charAt(2));
            String currency1 = sb1.toString();
            
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ime.charAt(3));
            sb2.append(ime.charAt(4));
            sb2.append(ime.charAt(5));
            String currency2 = sb2.toString();
            
            CurrencyPair c = new CurrencyPair(args[1], currency1, currency2);
            
            String[] deli1 = args[2].split("\\.");
            String[] deli2 = args[3].split("\\:");
            DateTime t1 = new DateTime(Integer.parseInt(deli1[0]),Integer.parseInt(deli1[1]),Integer.parseInt(deli1[2]),Integer.parseInt(deli2[0]),Integer.parseInt(deli2[1]));
            
            String[] deli11 = args[4].split("\\.");
            String[] deli22 = args[5].split("\\:");
            DateTime t2 = new DateTime(Integer.parseInt(deli11[0]),Integer.parseInt(deli11[1]),Integer.parseInt(deli11[2]),Integer.parseInt(deli22[0]),Integer.parseInt(deli22[1]));
            
            c.nonBusinessDays(t1,t2);
        }
        
        else if(args[0].equals("masterCandles")){ //masterCandles EURUSD.csv 2018.03.13 08:00 2018.03.13 18:00
            String ime = args[1];
            
            StringBuilder sb1 = new StringBuilder();
            sb1.append(ime.charAt(0));
            sb1.append(ime.charAt(1));
            sb1.append(ime.charAt(2));
            String currency1 = sb1.toString();
            
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ime.charAt(3));
            sb2.append(ime.charAt(4));
            sb2.append(ime.charAt(5));
            String currency2 = sb2.toString();
            
            CurrencyPair c = new CurrencyPair(args[1], currency1, currency2);
            
            String[] deli1 = args[2].split("\\.");
            String[] deli2 = args[3].split("\\:");
            DateTime t1 = new DateTime(Integer.parseInt(deli1[0]),Integer.parseInt(deli1[1]),Integer.parseInt(deli1[2]),Integer.parseInt(deli2[0]),Integer.parseInt(deli2[1]));
            
            String[] deli11 = args[4].split("\\.");
            String[] deli22 = args[5].split("\\:");
            DateTime t2 = new DateTime(Integer.parseInt(deli11[0]),Integer.parseInt(deli11[1]),Integer.parseInt(deli11[2]),Integer.parseInt(deli22[0]),Integer.parseInt(deli22[1]));
            
            c.masterCandles(t1,t2);
            //Med 13. 3. 2018 08.00 in 13. 3. 2018 18.00 je bilo 15 master sveck.
        }
        
        else if(args[0].equals("convert")){ //convert BTC.csv EURUSD.csv 2018.03.14 22:22
            String ime = args[1];
            
            StringBuilder sb1 = new StringBuilder();
            sb1.append(ime.charAt(0));
            sb1.append(ime.charAt(1));
            sb1.append(ime.charAt(2));
            String currency1 = sb1.toString();
            
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ime.charAt(3));
            sb2.append(ime.charAt(4));
            sb2.append(ime.charAt(5));
            String currency2 = sb2.toString();
            
            CryptoCurrency f1 = new CryptoCurrency(args[1], currency1, currency2);
            
            String imee = args[2];
            
            StringBuilder sb11 = new StringBuilder();
            sb1.append(imee.charAt(0));
            sb1.append(imee.charAt(1));
            sb1.append(imee.charAt(2));
            String currency11 = sb11.toString();
            
            StringBuilder sb22 = new StringBuilder();
            sb2.append(imee.charAt(3));
            sb2.append(imee.charAt(4));
            sb2.append(imee.charAt(5));
            String currency22 = sb22.toString();
            
            CurrencyPair f2 = new CurrencyPair(args[2], currency11, currency22);
            
            String[] deli1 = args[3].split("\\.");
            String[] deli2 = args[4].split("\\:");
            DateTime t1 = new DateTime(Integer.parseInt(deli1[0]),Integer.parseInt(deli1[1]),Integer.parseInt(deli1[2]),Integer.parseInt(deli2[0]),Integer.parseInt(deli2[1]));
            
            f1.convert(f2,t1);
        }
    }
}