import java.util.Scanner;

public class Main {

    private static Product[] products;
    private static VendingMachine[] machines;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        products = new Product[sc.nextInt()];
        for (int i = 0; i < products.length; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int price = sc.nextInt();
            products[i] = new Product(id, name, price);
        }

        machines = new VendingMachine[sc.nextInt()];
        for (int i = 0; i < machines.length; i++) {
            machines[i] = new VendingMachine(i + 1);
            int p = sc.nextInt();
            for (int j = 0; j < p; j++) {
                int pID = sc.nextInt();
                machines[i].addProduct(getById(pID), 1);
            }
        }

        int b = sc.nextInt();
        for (int i = 0; i < b; i++) {
            int machineID = sc.nextInt();
            int productID = sc.nextInt();
            machines[machineID - 1].buy(getById(productID));
        }

        for (int i = 0; i < machines.length; i++) {
            System.out.println(machines[i].toString());
        }

    }

    public static Product getById(int id) {
        for (Product p : products) {
            if (id == p.getId()) return p;
        }
        return null;
    }
}
