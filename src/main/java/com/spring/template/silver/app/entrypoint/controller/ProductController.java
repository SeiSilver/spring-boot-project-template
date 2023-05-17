package com.spring.template.silver.app.entrypoint.controller;

import com.spring.template.silver.app.entrypoint.controller.handler.ProductHandler;
import com.spring.template.silver.app.entrypoint.payload.NewProductRequest;
import com.spring.template.silver.app.entrypoint.payload.UpdateProductRequest;
import com.spring.template.silver.app.infrastructure.entity.ProductEntity;
import com.spring.template.silver.app.usecase.exception.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProductController {

  private final ProductHandler productHandler;

  @GetMapping("/product")
  @PreAuthorize("hasRole('ROLE_USER')")
  public List<ProductEntity> getAll() {
    return productHandler.getAllHandler();
  }

  @GetMapping("/product/{id}")
  @PreAuthorize("hasRole('ROLE_USER')")
  public ProductEntity getById(@PathVariable Integer id) throws DataNotFoundException {
    return productHandler.getByIdHandler(id);
  }

  @PostMapping("/product")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void add(NewProductRequest request) {
    productHandler.addHandler(request);
  }

  @PutMapping("/product")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void update(UpdateProductRequest request) {
    productHandler.updateHandler(request);
  }

  @DeleteMapping("/product")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void delete(Integer id) throws DataNotFoundException {
    productHandler.deleteByIdHandler(id);

  }

}