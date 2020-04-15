package com.weichuang.controller;

import com.weichuang.pojo.Category;
import com.weichuang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService cs;

    @RequestMapping("/getCategoryList.do")
    public String getCategoryList(Model model){
        List<Category> categoryList =  cs.getCategoryList();
        model.addAttribute("categoryList",categoryList);
        return "product/add";
    }
}
