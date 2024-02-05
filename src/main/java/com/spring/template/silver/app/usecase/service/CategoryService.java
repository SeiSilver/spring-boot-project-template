package com.spring.template.silver.app.usecase.service;

import com.spring.template.silver.app.infrastructure.entity.CategoryEntity;
import com.spring.template.silver.app.usecase.exception.DataNotFoundException;

public interface CategoryService {
  CategoryEntity getByName(Integer id) throws DataNotFoundException;

  void save(CategoryEntity categoryEntity);
}
