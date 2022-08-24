package ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.view;


import ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.controller.ProductController;

import java.io.IOException;

public class Mainview {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProductController productController = new ProductController();
        productController.menuManageProduct();
    }
}
