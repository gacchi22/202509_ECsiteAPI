package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    // コンストラクタインジェクション
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 全件取得
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 1件取得
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("商品が見つかりません (id=" + id + ")"));
    }

    // 登録・更新
    public Product saveProduct(Product product) {
        // バリデーション例：商品名は必須
        if (product.getName() == null || product.getName().isBlank()) {
            throw new IllegalArgumentException("商品名は必須です");
        }
        if (product.getPrice() == null || product.getPrice().intValue() < 0) {
            throw new IllegalArgumentException("価格は0以上で指定してください");
        }
        if (product.getStock() == null || product.getStock().intValue() < 0) {
            throw new IllegalArgumentException("在庫は0以上で指定してください");
        }

        return productRepository.save(product);
    }

    // 削除
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
