package product_Manager;

public interface Manager<E> {
    void display();
    void addProduct(E e);
    void updateProduct(int id, String newName);
    void deleteProduct(int id);
    void sortProduct();
    void searchProduct();

}
