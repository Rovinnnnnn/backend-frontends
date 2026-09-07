package com.rovinn.backendfrontends.Service;

import com.rovinn.backendfrontends.model.ProductDTO;
import com.rovinn.backendfrontends.model.ProductRegisterDTO;

import java.util.List;

public interface ProductServiceInterface {
    List<ProductDTO> showAllProducts();
    List<ProductDTO> showProductByName(String name);
    ProductDTO updateProduct(Long id, ProductRegisterDTO upDateProduct);
    ProductDTO addProduct(ProductRegisterDTO newProduct);
    void deleteProduct(Long id);
}
