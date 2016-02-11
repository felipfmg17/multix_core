
package felpo.multix.test;


import java.util.*;
import java.io.*;
import java.net.*;
import felpo.multix.core.*;
import felpo.tools.Tool;

public class Test {
    public static void main(String[] args){
        //p1(); 
        //compareHistories();
        //testDifferences();
        //differences2();
        //serializationTest();
        //differences2();
    }
    
    public static void p1(){
       //Multix.test1();
       
        
    }
    
    public static void compareHistories(){
        Multa m1 = new Multa("c","a","a","a","a");
        Multa m2 = new Multa("d","a","a","a","a");
        
        int res = m1.compareTo(m2);
        System.out.println(res);
    }
    
    public static void testDifferences(){
        try {
            String placa1 = "3C2TP";
            String placa2 = "3C2TP";
            History old = Multix.requestHistory(placa1);
            History neww = Multix.requestHistory(placa2);
            System.out.println("Showing placa "+placa1);
            System.out.println();
            System.out.println(old);
            System.out.println("\n");
            List<Multa> dif = Multix.extractDifferences(old, neww);
            System.out.println("Differences: " + dif.size());
        } catch (Exception e) { e.printStackTrace();
        }
        
    }
    
    public static void differences2(){
        try {
            String placa = "3C2TP";
            History old = Multix.requestHistory(placa);
            old.multas.remove(1);
            System.out.println("Multa vieja \n\n");
            System.out.println(old);
            System.out.println("\n\n");
            History neww = Multix.requestHistory(placa);
            neww.multas.sort(null);
            System.out.println("Multa nueva \n\n");
            System.out.println(neww);
            System.out.println("\n\n");
            List<Multa> dif = Multix.extractDifferences(neww, neww);
            System.out.println("\n\nShowing differences:\n");
            for(Multa m: dif){
                System.out.println(m);
            }
        } catch (Exception e) {e.printStackTrace();
        }
    }
    
    public static void serializationTest(){
        try {
            String placa = "374VRA";
            History old = Multix.requestHistory(placa);
            File f = new File("C:\\Users\\Usuario\\Desktop\\test","historial.ser");
            Tool.save(old, f);
            History back = (History) Tool.loadObject(f);
            System.out.println(back);
        } catch (Exception e) {e.printStackTrace();}
    }
}
