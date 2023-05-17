package com.spring.template.silver.app.entrypoint.controller.handler;

import com.spring.template.silver.app.entrypoint.payload.NewProductRequest;
import com.spring.template.silver.app.entrypoint.payload.UpdateProductRequest;
import com.spring.template.silver.app.infrastructure.entity.ProductEntity;
import com.spring.template.silver.app.usecase.exception.DataNotFoundException;
import com.spring.template.silver.app.usecase.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductHandler {

  private final ProductService productService;

  public List<ProductEntity> getAllHandler() {
    return productService.getAll();
  }

  public ProductEntity getByIdHandler(Integer id) throws DataNotFoundException {
    return productService.getById(id);
  }


  public void addHandler(NewProductRequest request) {
    ProductEntity productEntity = ProductEntity.builder()
        .name(request.getName())
        .description(request.getDescription())
        .price(request.getPrice())
        .category(request.getCategory())
        .build();
    productService.save(productEntity);
  }

  public void updateHandler(UpdateProductRequest request) {
    ProductEntity productEntity = ProductEntity.builder()
        .id(request.getId())
        .name(request.getName())
        .description(request.getDescription())
        .price(request.getPrice())
        .category(request.getCategory())
        .build();
    productService.save(productEntity);
  }

  public void deleteByIdHandler(Integer id) throws DataNotFoundException {
    productService.deleteById(id);

  }

}
