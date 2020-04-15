package com.weichuang.service.impl;

import com.weichuang.mapper.ProductMapper;
import com.weichuang.pojo.Product;
import com.weichuang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper pm;
    @Override
    public List<Product> getProductList() {
        return pm.getProductList();
    }

    @Override
    public int deleteProductByPid(int pid) {
        return pm.deleteProductByPid(pid);
    }

    @Override
    public int saveProduct(Product product) {
        product.setPid(UUID.randomUUID().toString().replaceAll("-",""));
        product.setPimage("products/1/c_0014.jpg");
        product.setPdate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        return pm.saveProduct(product);
    }

    @Override
    public Product getProductByPid(int pid) {
        return pm.getProductByPid(pid);
    }

    @Override
    public int updateProduct(Product product) {
        product.setPdate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        return pm.updateProduct(product);
    }
}
