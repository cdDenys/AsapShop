package asapshop.service.Impl;

import asapshop.entity.Product;
import asapshop.repository.ProductRepository;
import asapshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    @Transactional
    public void createProduct(Product product) {
        if (product != null) {
            productRepository.save(product);
        }
    }

    @Override
    @Transactional
    public Product getProductById(long productId) {
        Product product = new Product();
        if (productRepository.existsById(productId)) {
            product.setId(productRepository.findById(productId).get().getId());
            product.setProductName(productRepository.findById(productId).get().getProductName());
            product.setProductDescription(productRepository.findById(productId).get().getProductDescription());
            product.setProductPrice(productRepository.findById(productId).get().getProductPrice());
        }
        return product;
    }

    @Override
    @Transactional
    public boolean editProduct(Product product) {
        boolean isEdited = false;
        if (product != null && productRepository.existsById(product.getId())){
            productRepository.save(product);
            isEdited = true;
        }
            return isEdited;
    }

    @Override
    @Transactional
    public boolean deleteProduct(Product product) {
        boolean isDeleted = false;
        if (product != null && productRepository.existsById(product.getId())){
            productRepository.delete(product);
            isDeleted = true;
        }
        return isDeleted;
    }
}
