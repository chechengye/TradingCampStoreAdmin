package com.weichuang.mapper;

import com.weichuang.pojo.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> getProductList();

    int deleteProductByPid(int pid);

    int saveProduct(Product product);

    Product getProductByPid(int pid);

    int updateProduct(Product product);
}
