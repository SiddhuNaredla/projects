package com.example.ecommerceproject.service;


import com.example.ecommerceproject.model.Product;
import com.example.ecommerceproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product>  getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id) {

        return productRepository.findById(id).orElse(new Product(-1));
    }

    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {

        product.setImageName(image.getName());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return productRepository.save(product);
    }


    public void deleteProduct(int id) {

        productRepository.deleteById(id);
    }

    public List<Product> searchProducts(String keyword){

        return productRepository.searchProducts(keyword);
    }
}
