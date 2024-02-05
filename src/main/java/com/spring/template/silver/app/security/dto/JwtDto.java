package com.spring.template.silver.app.security.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtDto {

  private String accessToken;

}