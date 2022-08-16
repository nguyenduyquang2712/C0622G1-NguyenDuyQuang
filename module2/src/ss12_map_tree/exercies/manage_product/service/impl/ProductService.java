package ss12_map_tree.exercies.manage_product.service.impl;

import ss12_map_tree.exercies.manage_product.model.Product;
import ss12_map_tree.exercies.manage_product.service.IProductService;

import java.util.*;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "oto", 99.5));
        products.add(new Product(4, "car", 124.6));
        products.add(new Product(2, "truck", 124.7));
    }

    @Override
    public void displayProductList() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void addProduct() {
        Product product = this.inforProduct();
        products.add(product);
        System.out.println("Completed add product to Product List");
    }

    @Override
    public void deleteProduct() {
        Product product = this.findProduct();
        if (product == null) {
            System.out.println("Cant find prdocut");
        } else {
            System.out.println("Do you want to delete product " + product.getId() + "?");
            System.out.println("1 . Yes");
            System.out.println("2 . No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                products.remove(product);
                System.out.println("Completed Delete the product");
            }
        }


    }

    @Override
    public void editProduct() {
        Product product = this.findProduct();
        if (product == null) {
            System.out.println("Dont have product you want to edit in product list ");
        } else {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == product.getId()) {
                    products.set(i, this.inforProduct());
                }
            }
        }
    }

    @Override
    public void sortProduct() {

        System.out.println("1.Increasing");
        System.out.println("2.Deincresing");
        System.out.println("3.Exit");
        System.out.println("Choose type of sorting product");
        int choice = Integer.parseInt(scanner.nextLine());
        while (true) {
            switch (choice) {
                case 1:
                    Collections.sort(products, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getPrice() > o2.getPrice() ? 1 : -1;
                        }
                    });
                    System.out.println("Completed sorting increasing product list by price");
                    return;
                case 2:
                    Collections.sort(products, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getPrice() > o2.getPrice() ? -1 : 1;
                        }
                    });
                    System.out.println("Completed sorting Decreasing Product list by price");
                    return;
                case 3:
                    return;
                default:
                    System.out.println("Reenter your choice");
                    break;


            }
        }
    }

    @Override
    public void searchProduct() {
        System.out.println("Enter name of product you want to search: ");
        String name = scanner.nextLine();
        int count = 0;
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(" Dont have product you find in product list ");
        }

    }

    private Product findProduct() {
        System.out.print("Input ID you want to delete or edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private Product inforProduct() {
        System.out.println("Input the id of product");
        int id = Integer.parseInt(scanner.nextLine());
        while (true) {
            boolean check = true;
            for (Product product : products) {
                if (product.getId() == id) {
                    System.out.println("ID duplicate, reinput the id");
                    id = Integer.parseInt(scanner.nextLine());
                    check = false;
                    break;
                }
            }
            if (check) break;
        }
        System.out.println("Input name of product");
        String name = scanner.nextLine();
        System.out.println("Input price of product");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, price);
        return product;
    }

}
