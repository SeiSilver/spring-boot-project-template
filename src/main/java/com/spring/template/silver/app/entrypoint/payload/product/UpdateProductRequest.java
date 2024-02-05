package com.spring.template.silver.app.entrypoint.payload.product;

import lombok.*;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

  @NotNull
  private Integer id;

  private String name;

  private String description;

  private Integer price;

  private Integer categoryId;

}
