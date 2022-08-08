package view;

import product.Drinks;
import product_Manager.DrinksManager;
import storage.IOFile;
import storage.IOFileBinary;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static IOFile<Drinks> drinksIOFile = IOFileBinary.getInstance();
    static ArrayList<Drinks> drinks = new ArrayList<>();
    private static final String PATH_DRINKS = "fileData/drinks.dat";

    public static void main(String[] args) throws IOException {


        menuProduct();
    }
    public static void menuProduct() throws IOException {
        DrinksManager drinksManager = DrinksManager.getInstance();
        Client client = new Client();
        try {
            do {
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Chương trình quản lý sản phẩm");
                System.out.println("1. Xem danh sách");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Sắp xếp");
                System.out.println("6. Tìm sản phẩm có giá đắt nhất");
                System.out.println("7. Đọc file");
                System.out.println("8. Ghi file");
                System.out.println("9. Thoát");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        drinksManager.display();
                        break;
                    case 2:
                        client.addDrinks();
                        drinksManager.display();

                        break;
                    case 3:
                        drinksManager.display();
                        System.out.println("Nhập id:");
                        Scanner inputId = new Scanner(System.in);
                        int id = inputId.nextInt();
                        System.out.println("Nhập tên mới cần sửa:");
                        Scanner inputName = new Scanner(System.in);
                        String newName = inputName.nextLine();
                        drinksManager.updateProduct(id,newName);
                        drinksManager.display();
                        break;
                    case 4:
                        drinksManager.display();
                        System.out.println("Nhập id cần xóa:");
                        Scanner inputId1 = new Scanner(System.in);
                        int id1 = inputId1.nextInt();
                        drinksManager.deleteProduct(id1);
                        drinksManager.display();
                        break;
                    case 5:
                        drinksManager.sortProduct();
                        break;
                    case 6:
                        drinksManager.searchProduct();
                        break;
                    case 7:
                        System.out.println(" Đã đọc");
                        break;
                    case 8:
                        System.out.println("Đã ghi");
                        break;
                    case 9:
                        System.out.println("                Đã Thoát !!!");
                        System.out.println("----------------------------------------------------");

                        break;
                    default:
                        System.out.println("Nhập sai lựa chọn, thử lại");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Bạn đã nhập sai rồi, nhập lại thôi");
            System.out.println("---------------------------------------------------");
        }
    }
}
