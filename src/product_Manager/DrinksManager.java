package product_Manager;

import product.Drinks;
import storage.IOFile;
import storage.IOFileBinary;
import view.Client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DrinksManager implements Manager<Drinks>{
    private IOFile<Drinks> ioFileBinary = IOFileBinary.getInstance();
    private ArrayList<Drinks> drinksList;
    private static final String PATH_DRINKS = "fileData/drinks.dat";

    private static DrinksManager instance = null;

    private DrinksManager(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            drinksList = new ArrayList<>();
        } else {
            drinksList = ioFileBinary.readFile(path);
        }
    }

    public static DrinksManager getInstance() throws IOException{
        if (instance == null) instance = new DrinksManager(PATH_DRINKS);
        return instance;
    }


    @Override
    public void display() {
        drinksList = ioFileBinary.readFile(PATH_DRINKS);
        if (drinksList.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào!");
        } else {
            drinksList.forEach(System.out::println);
        }
    }

    @Override
    public void addProduct(Drinks o) {
        drinksList.add(o);
        ioFileBinary.writeFile(PATH_DRINKS,drinksList);
    }

    @Override
    public void updateProduct(int id, String newName) {
        for (Drinks p : drinksList) {
            if (p.getId() == id) {
                p.setName(newName);
            }
        }
    }


    @Override
    public void deleteProduct(int id) {
        System.out.println(ioFileBinary.readFile(PATH_DRINKS));
        drinksList.removeIf(p -> p.getId()==id);
        ioFileBinary.writeFile(PATH_DRINKS,drinksList);
    }

    @Override
    public void sortProduct() {
        drinksList.sort(Comparator.comparingDouble(Drinks::getPrice));
    }

    @Override
    public void searchProduct() {
        double max = drinksList.get(0).getPrice();
        int id=0;
        for(int i= 0; i<drinksList.size(); i++){
            if(drinksList.get(i).getPrice()> max){
                max = drinksList.get(i).getPrice() ;
                id = i;
            }
        }
        System.out.println(drinksList.get(id));


    }



}
