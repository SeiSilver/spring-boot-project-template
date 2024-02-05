package com.spring.template.silver.app.usecase.service.impl;

import com.spring.template.silver.app.infrastructure.entity.CategoryEntity;
import com.spring.template.silver.app.infrastructure.jpa.CategoryRepository;
import com.spring.template.silver.app.usecase.exception.DataNotFoundException;
import com.spring.template.silver.app.usecase.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  @Override
  public CategoryEntity getByName(Integer id) throws DataNotFoundException {
    return categoryRepository.findById(id).orElseThrow(
        () -> new DataNotFoundException("Category not found!")
    );
  }

  @Override
  @Transactional
  public void save(CategoryEntity categoryEntity) {
    categoryRepository.save(categoryEntity);
  }

}
