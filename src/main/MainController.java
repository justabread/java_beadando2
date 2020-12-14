package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainController {
    private static HashMap<Integer, Part> productMap = new LinkedHashMap();
    
    public static void loadProducts(){
        int id = 1;
        try {
            File productsObj = new File("termekek.txt");
            Scanner productsReader = new Scanner(productsObj);
            while (productsReader.hasNextLine()) {
                String data = productsReader.nextLine();
                String[] productSplit = data.split(";");
                
                Part p1 = new Part(productSplit[0], Integer.parseInt(productSplit[1]), productSplit[2], Integer.parseInt(productSplit[3]));
                productMap.put(id, p1);
                id++;
            }
            productsReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("termekek file was not found.");
            e.printStackTrace();
        }
    }
    
    public static void loadKosar(MainWindow mainW){
        try {
            File kosarObj = new File("kosarFile.txt");
            Scanner kosarReader = new Scanner(kosarObj);
            while (kosarReader.hasNextLine()) {
                String data = kosarReader.nextLine();
                String[] kosarSplit = data.split(";");
                
                mainW.getKosarTableModel().addRow(new Object[] {kosarSplit[0], kosarSplit[1], kosarSplit[2]});
            }
            kosarReader.close();
        } catch (FileNotFoundException e) {
            
        }
    }  
    
    public static void loadWishList(MainWindow mainW){
        try {
            File wishObj = new File("wishFile.txt");
            Scanner wishReader = new Scanner(wishObj);
            while (wishReader.hasNextLine()) {
                String data = wishReader.nextLine();
                String[] wishSplit = data.split(";");
                
                mainW.getWishTableModel().addRow(new Object[] {wishSplit[0], wishSplit[1]});
            }
            wishReader.close();
        } catch (FileNotFoundException e) {
            
        }
    }
    
    public static void main(String[] args) {
        MainWindow mainW = new MainWindow();       
        
        loadProducts();
        loadKosar(mainW);
        loadWishList(mainW);
        
        productMap.forEach((k,v) -> 
                mainW.getPriceTableModel().addRow(new Object[] {v.getName(), v.getPrice(), v.getType(), v.getStored()})
        );       
        mainW.setVisible(true);
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        public void run() {
            System.gc();
        }
        }, "Shutdown-thread"));
    }
    
    
    public static HashMap<Integer, Part> getProductMap() {
        return productMap;
    }
}
