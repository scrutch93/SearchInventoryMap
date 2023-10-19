package com.pluralsight;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;

public class Store {
    // the key is the product id, the value is a product object
    public static HashMap<Integer, Product> inventory =
            new HashMap<Integer, Product>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // this method loads product objects into inventory
    loadInventory();
    helpUser();

    while(true) {
        System.out.println("\nWould you like to look for another item?");
        String answer = scanner.nextLine().trim().toLowerCase();


        if (answer.equals("yes")) {
            helpUser();
        } else {
            System.out.println("Get out of my store!!!");
            break;
        }
    }
    }

    public static void helpUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What item # are you interested in? ");
        int id = scanner.nextInt();
        Product matchedProduct = inventory.get(id);
        if (matchedProduct == null) {
            System.out.println("We don't carry that product");
            return;
        }
        System.out.printf("We carry %s and the price is $%.2f",
                matchedProduct.getName(), matchedProduct.getPrice());


    }
    public static void loadInventory(){
        try{
           FileReader filereader = new FileReader("src/main/resources/inventory.csv") ;

            BufferedReader bufferedReader = new BufferedReader(filereader);
           String input;
         while ((input = bufferedReader.readLine()) !=null)  {
          String[] product = input.split("\\|");
          int id = Integer.parseInt(product[0]);
          String name = product[1];
          float price = Float.parseFloat(product[2]);

           inventory.put(id,new Product(id, name, price));


         }
           



        }catch(IOException e){

            e.printStackTrace();
        }


//        Inventory.put("10' 2x4  (grade B)", new Product(123, "10' 2x4  (grade B)", 5.00f ));
//        Inventory.put("Hammer", new Product (456, "Hammer", 19.49f));
//        Inventory.put("9-in-1 Ratcheting Screwdriver", new Product (456, "9-in-1 Ratcheting Screwdriver", 19.49f));
//        Inventory.put(new Product(123, "chicken", 2.00f));


    }
}