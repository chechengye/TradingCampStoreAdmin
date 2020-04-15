package com.weichuang.controller;

import com.weichuang.pojo.Product;
import com.weichuang.service.CategoryService;
import com.weichuang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService ps;

    @Autowired
    CategoryService cs;
    @RequestMapping("/getProductList.do")
    public String getProductList(Model model){
        List<Product> productList = ps.getProductList();
        System.out.println("productList =" + productList.size());
        model.addAttribute("productList",productList);
        return "product/list";
    }

    @RequestMapping("/deleteProduct.do")
    public String deleteProduct(int pid , Model model){
        int rows = ps.deleteProductByPid(pid);
        if(rows > 0){
            List<Product> productList = ps.getProductList();
            System.out.println("productList =" + productList.size());
            model.addAttribute("productList",productList);
        }
        return "product/list";
    }

    @RequestMapping("/saveProduct.do")
    public String saveProduct(Product product, Model model){
        int rows = ps.saveProduct(product);
        if(rows > 0){
            List<Product> productList = ps.getProductList();
            System.out.println("productList =" + productList.size());
            model.addAttribute("productList",productList);
            return "product/list";
        }else{
            return "product/add";
        }

    }

    @RequestMapping("/editProduct.do")
    public String editProduct(int pid, Model model){
        Product product =  ps.getProductByPid(pid);
        model.addAttribute("product" , product);
        model.addAttribute("categoryList" , cs.getCategoryList());
        return "product/edit";
    }
    @RequestMapping("/updateProduct.do")
    public String updateProduct(Product product, Model model){
        int rows = ps.updateProduct(product);
        if(rows > 0){
            List<Product> productList = ps.getProductList();
            System.out.println("productList =" + productList.size());
            model.addAttribute("productList",productList);
            return "product/list";
        }else{
            return "product/edit";
        }
    }

}
