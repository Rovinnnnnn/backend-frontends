package com.rovinn.backendfrontends.Service;

import com.rovinn.backendfrontends.Repository.ProductRepository;
import com.rovinn.backendfrontends.model.Product;
import com.rovinn.backendfrontends.model.ProductDTO;
import com.rovinn.backendfrontends.model.ProductRegisterDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductServiceInterface{
    private final ProductRepository productRepository;
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
     public List<ProductDTO> showAllProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setCategory(product.getCategory());
            productDTO.setDescription(product.getDescription());
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }
    @Override
    public List<ProductDTO> showProductByName(String name){
        List<Product> product = productRepository.findByNameContainingIgnoreCase(name).orElseThrow(()-> new RuntimeException("product is not found"));
        List<ProductDTO> result = new ArrayList<>();
        for (Product products : product) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(products.getId());
            productDTO.setName(products.getName());
            productDTO.setPrice(products.getPrice());
            productDTO.setCategory(products.getCategory());
            productDTO.setDescription(products.getDescription());
            result.add(productDTO);
        }
        return result;
    }
    @Override
    public ProductDTO updateProduct(Long id, ProductRegisterDTO upDateProduct) {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found"));
        product.setName(upDateProduct.getName());
        product.setPrice(upDateProduct.getPrice());
        product.setDescription(upDateProduct.getDescription());
        product.setCategory(upDateProduct.getCategory());
        productRepository.save(product);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategory(product.getCategory());
        return productDTO;
    }
    @Override
    public ProductDTO addProduct(ProductRegisterDTO newProduct){
        Product products = new Product();
        products.setName(newProduct.getName());
        products.setPrice(newProduct.getPrice());
        products.setCategory(newProduct.getCategory());
        products.setDescription(newProduct.getDescription());
        productRepository.save(products);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(products.getId());
        productDTO.setName(products.getName());
        productDTO.setPrice(products.getPrice());
        productDTO.setCategory(products.getCategory());
        productDTO.setDescription(products.getDescription());
        return  productDTO;
    }
    @Override
    public void deleteProduct(Long id){
        productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.deleteById(id);
    }
   }

