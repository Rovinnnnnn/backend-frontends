package com.rovinn.backendfrontends.Controller;

import com.rovinn.backendfrontends.Service.ProductServiceInterface;
import com.rovinn.backendfrontends.model.ProductDTO;
import com.rovinn.backendfrontends.model.ProductRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceInterface  productService;
    public ProductController(ProductServiceInterface productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.showAllProducts());
    }
    @GetMapping("/search")
    public ResponseEntity<ProductDTO> showProductByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.showProductByName(name));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductRegisterDTO product, @PathVariable Long id) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }
    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductRegisterDTO product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
