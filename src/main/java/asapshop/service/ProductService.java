package asapshop.service;

import asapshop.entity.Product;

public interface ProductService {

    void createProduct(Product product);

    Product getProductById(long productId);

    boolean editProduct(Product product);

    boolean deleteProduct(Product product);
}
