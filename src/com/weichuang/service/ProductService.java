package com.weichuang.service;

import com.weichuang.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();

    int deleteProductByPid(int pid);

    int saveProduct(Product product);

    Product getProductByPid(int pid);

    int updateProduct(Product product);
}
