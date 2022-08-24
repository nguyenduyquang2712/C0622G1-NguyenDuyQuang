package ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.controller;

import ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.service.IProductService;
import ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.service.impl.ProductService;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private IProductService productService = new ProductService();
    public void menuManageProduct() throws IOException, ClassNotFoundException {
        while(true){
            System.out.println("----------------------------------------------");
            System.out.println("Welcome to menu manager product");
            System.out.println("1.Display productlist");
            System.out.println("2.Add product to productlist");
            System.out.println("3.Search product");
            System.out.println("4.Exit");
            System.out.print("Pleas enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    productService.displayProductList();
                    break;
                case 2:
                    productService.addProductList();
                    break;
                case 3:
                    productService.searchProduct();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Your choice is wrong, please reenter your choice: ");
                    break;
            }
        }
    }

}
