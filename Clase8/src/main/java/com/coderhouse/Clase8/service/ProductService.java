package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.Product;
import com.coderhouse.Clase8.model.RequestProductDetail;
import com.coderhouse.Clase8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product postProduct(Product product) throws Exception {
        return productRepository.save(product);
    }
    public Product getProduct(int id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new Exception("client with id:"+ id + " ,not found");
        } else {
            return product.get();
        }
    }
    public List<Product> getProductsById(List<RequestProductDetail> productListId) throws Exception {
        List<Product> productList = new ArrayList<>();
        for (RequestProductDetail requestProduct:
                productListId) {
            Optional<Product> productFound = productRepository.findById(requestProduct.getProductId());
            if (productFound.isEmpty()){
                throw new Exception("Product with id: " + requestProduct.getProductId() + " not found.");
            }

            productList.add(productFound.get());
        }
        return productList;
    }
}