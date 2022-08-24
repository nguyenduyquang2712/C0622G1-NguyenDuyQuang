package ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.service;

import java.io.IOException;

public interface IProductService {
    void displayProductList() throws IOException, ClassNotFoundException;

    void addProductList() throws IOException, ClassNotFoundException;

    void searchProduct() throws IOException, ClassNotFoundException;
}
