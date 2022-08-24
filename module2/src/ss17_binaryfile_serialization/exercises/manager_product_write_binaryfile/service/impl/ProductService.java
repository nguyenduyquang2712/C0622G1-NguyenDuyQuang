package ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.service.impl;

import ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.model.Product;
import ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.service.IProductService;
import ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.utils.ReadBinary;
import ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.utils.WriteBinary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private Scanner scanner = new Scanner(System.in);
    List<Product> products = new ArrayList<>();
    private String PATH_NAME =  "src\\ss17_binaryfile_serialization\\exercises\\manager_product_write_binaryfile\\data\\Product.dat";
    @Override
    public void displayProductList() throws IOException, ClassNotFoundException {
        ReadBinary.ReadFile(PATH_NAME,products);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void addProductList() throws IOException, ClassNotFoundException {
        ReadBinary.ReadFile(PATH_NAME,products);
        Product product = this.inforProduct();
        products.add(product);
        System.out.println("Completed add product to Product List");
        WriteBinary.WriteFile(PATH_NAME,products);
    }

    private Product inforProduct() {
        System.out.println("Input the id of product");
        int productID = Integer.parseInt(scanner.nextLine());
        while (true) {
            boolean check = true;
            for (Product product : products) {
                if (product.getProductID() == productID) {
                    System.out.println("ID duplicate, reinput the id");
                    productID = Integer.parseInt(scanner.nextLine());
                    check = false;
                    break;
                }
            }
            if (check) break;
        }
        System.out.println("Input name of product");
        String nameProdcut = scanner.nextLine();
        System.out.println("Input manufacture");
        String manufacture = scanner.nextLine();
        System.out.println("Input price of product");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(productID, nameProdcut, manufacture, price);
        return product;
    }



    @Override
    public void searchProduct() throws IOException, ClassNotFoundException {
        ReadBinary.ReadFile(PATH_NAME,products);
        System.out.println("Enter name of product you want to search: ");
        String nameProduct = scanner.nextLine();
        int count = 0;
        for (Product product : products) {
            if (product.getNameProduct().equals(nameProduct)) {
                System.out.println(product);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(" Dont have product you find in product list ");
        }

    }
}
