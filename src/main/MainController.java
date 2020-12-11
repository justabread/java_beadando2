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
    
    public static void main(String[] args) {
        MainWindow mainW = new MainWindow();       
        
        loadProducts();
        
        productMap.forEach((k,v) -> 
                mainW.getPriceTableModel().addRow(new Object[] {v.getName(), v.getPrice(), v.getType(), v.getStored()})
        );       
        mainW.setVisible(true);
    }
    
    public static HashMap<Integer, Part> getProductMap() {
        return productMap;
    }
}
