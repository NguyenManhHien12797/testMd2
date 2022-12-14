package product;

import java.io.Serializable;

public class Drinks implements Serializable {
    private static final long serialVersionUID = 2906642554793891381L;
    private int id;
    private String name;
    private double price;
    private int amount;
    private String describe;

    public Drinks() {
    }

    public Drinks(int id, String name, double price, int amount, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", describe='" + describe + '\'' +
                '}';
    }


}
