package com.weichuang.service.impl;

import com.weichuang.mapper.CategoryMapper;
import com.weichuang.pojo.Category;
import com.weichuang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper cm;

    @Override
    public List<Category> getCategoryList() {
        return cm.getCategoryList();
    }
}
