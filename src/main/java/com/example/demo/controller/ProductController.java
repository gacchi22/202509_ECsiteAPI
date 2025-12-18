package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 存在意義不明
    @GetMapping("/api/products/test")
    public String listString() {
        return "商品一覧（USER or ADMIN両方OK）";
    }

    // 全件取得
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // 1件取得
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // 新規登録
    @PostMapping
    public Product createProduct(@RequestBody Product product) { // Springの@RequestBody
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productService.saveProduct(product);
    }

    // 更新
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        // 既存のエンティティを取得
        Product existingProduct = productService.getProductById(id);

        // 必要なフィールドだけ更新
        existingProduct.setName(productDetails.getName());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setStock(productDetails.getStock());
        existingProduct.setUpdatedAt(LocalDateTime.now());

        // 保存
        return productService.saveProduct(existingProduct);
    }

    // 削除
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);

        if (deleted) {
            return ResponseEntity.ok("商品を削除しました");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
