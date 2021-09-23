/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marcel
 */
class DinamicnaTabela {

    Object[] tabela;

    public DinamicnaTabela() {
        this.tabela = new Object[10];
    }

    public DinamicnaTabela(int velikost) {
        this.tabela = new Object[velikost];
    }

    public int size() {
        int stevec = 0;
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {
                stevec++;
            }
        }
        return stevec;
    }

    public int size2() {
        return tabela.length;
    }

    public boolean isEmpty() {
        boolean is = false;
        if (this.size() == 0) {
            is = true;
        } else {
            is = false;
        }
        return is;
    }

    public boolean contains(Object o) {
        boolean is = false;
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] == o) {
                is = true;
            }
        }
        return is;
    }

    public void add(Object o) {
        
        if (this.size2() == this.size()) {
            Object[] tabelaa = new Object[tabela.length + 1];
            for (int i = 0; i < tabela.length; i++) {
                tabelaa[i] = tabela[i];
            }
            tabela = tabelaa;
        }
        
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] == null) {
                tabela[i] = o;
                break;
            }
        }
    }

    public void addAll(Object[] array){
        for (int i = 0; i < array.length; i++) {
            this.add(array[i]);
        }
    }
    
    public void remove(Object o) {
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] == o) {
                tabela[i] = null;
                break;
            }
        }
    }

    public void removeAll(Object o) {
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] == o) {
                tabela[i] = null;
            }
        }
    }
    
    public void iterator(){
        System.out.print("[");
        for (int i = 0; i < tabela.length; i++) {
            if(i == tabela.length-1){
                System.out.print(" ");
                System.out.print(tabela[i]);
                break;
            }
            System.out.print(" ");
            System.out.print(tabela[i]);
            System.out.print(",");
        }
        System.out.print(" ]");
    }
}

public class VAJE12 {

    public static void main(String[] args) {
        DinamicnaTabela t = new DinamicnaTabela();
        System.out.println(t.size());
        System.out.println(t.size2());
        System.out.println("Empty - " + t.isEmpty());
        System.out.println("Contains - " + t.contains("cat"));
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.add("cat");
        t.remove("cat");
        System.out.println(t.size());
        Object[] table = {1,2,"3","4"};
        t.addAll(table);
        System.out.println(t.size());
        t.iterator();
    }
}
