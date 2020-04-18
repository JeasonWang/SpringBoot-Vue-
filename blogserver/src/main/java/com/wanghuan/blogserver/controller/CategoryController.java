package com.wanghuan.blogserver.controller;

import com.wanghuan.blogserver.entity.Category;
import com.wanghuan.blogserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/all")
    public List<Category> allCategory(){
        return categoryService.queryAll(null);
    }
    @PostMapping("/")
    public int addCategory(String cateName){
        Category category = new Category();
        category.setCateName(cateName);
        return categoryService.insert(category);
    }
    @DeleteMapping("/{id}")
    public int deleteCategory(@PathVariable Integer id){
        return categoryService.deleteById(id);
    }
    @PutMapping("/")
    public int updateCategory(@RequestBody Category category){
        return categoryService.update(category);
    }
}
