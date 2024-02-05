package com.spring.template.silver.app.entrypoint.payload.product;

import lombok.*;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewProductRequest {

  @NotNull
  private String name;

  @NotNull
  private String description;

  @NotNull
  private Integer price;

  private Integer categoryId;

}
