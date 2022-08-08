package view;

import product.Drinks;

import product_Manager.DrinksManager;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private ArrayList<Drinks> drinksList = new ArrayList<>();
    private final String PATH_PRODUCT = "fileData/product.dat";
    private final String PATH_DRINKS = "fileData/fileData/drinks.dat";


    private IOFile<Drinks> ioFileBinaryDrinks = IOFileBinary.getInstance();
    DrinksManager drinksManager = DrinksManager.getInstance();

    public Client() throws IOException {
    }
    public void addDrinks(){
        int id = drinksManager.size()+1;
        System.out.println("Nhập tên sản phẩm: ");
        Scanner inputName= new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println("Nhập giá:");
        Scanner inputPrice = new Scanner(System.in);
        double price = inputPrice.nextDouble();
        System.out.println("Nhập số lượng:");
        Scanner inputAmount = new Scanner(System.in);
        int amount = inputAmount.nextInt();
        System.out.println("Nhập mô tả:");
        Scanner inputDescribe = new Scanner(System.in);
        String describe = inputDescribe.nextLine();
        Drinks drinks = new Drinks(id,name,price,amount,describe);
        drinksManager.addProduct(drinks);

    }
}
