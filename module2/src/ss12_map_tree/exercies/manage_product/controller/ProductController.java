package ss12_map_tree.exercies.manage_product.controller;

import ss12_map_tree.exercies.manage_product.service.IProductService;
import ss12_map_tree.exercies.manage_product.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private IProductService productService = new ProductService();

    public void menuManagementProduct() {
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("Welcome to Management Product");
            System.out.println("1. Display products list");
            System.out.println("2. Add product to the product list");
            System.out.println("3. Delete product by id");
            System.out.println("4. Search product by name");
            System.out.println("5. Edit product");
            System.out.println("6. Sort the product list");
            System.out.println("7. Exit");
            System.out.println("Please enter the choice 1->7");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.displayProductList();
                    break;
                case 2:
                    productService.addProduct();
                    break;
                case 3:
                    productService.deleteProduct();
                    break;
                case 4:
                    productService.searchProduct();
                    break;
                case 5:
                    productService.editProduct();
                    break;
                case 6:
                    productService.sortProduct();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Please enter the correct choice ");
                    break;
            }
        }
    }
}
