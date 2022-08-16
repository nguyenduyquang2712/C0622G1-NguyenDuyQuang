package ss12_map_tree.exercies.manage_product.view;

import bonus_homework.work1.controller.MainController;
import ss12_map_tree.exercies.manage_product.controller.ProductController;

public class MainView {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.menuManagementProduct();
    }
}
