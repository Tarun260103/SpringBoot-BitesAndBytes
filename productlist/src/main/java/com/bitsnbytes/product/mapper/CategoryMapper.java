package com.bitsnbytes.product.mapper;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.entity.Category;
import lombok.Data;

@Data
public class CategoryMapper {
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;

    }

    public static CategoryDTO toCategoryDTO(Category category){
        if(category == null){
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts().stream()
                .map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }
}
