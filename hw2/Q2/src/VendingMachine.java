import java.util.HashMap;

public class VendingMachine {

    private int id;
    private int saleCount;
    private int saleAmount;
    private HashMap<Product, Integer> products = new HashMap<>();

    public VendingMachine(int id) {
        this.id = id;
    }

    public void addProduct(Product p, int amount){
        products.put(p, products.getOrDefault(p, 0) + amount);
    }

    public boolean buy (Product product) {
        int productCount = products.get(product);
        if (productCount == 0) {
            return false;
        }
        products.put(product, productCount - 1);
        saleCount++;
        saleAmount += product.getPrice();
        return true;
    }

    @Override
    public String toString() {
        return id + ":" + saleCount + "," + saleAmount;
    }


//    @Override
//    public String toString() {
//        return "VendingMachine{" +
//                "id=" + id +
//                ", saleCount=" + saleCount +
//                ", saleAmount=" + saleAmount +
//                ", products=" + products +
//                '}';
//    }
}
