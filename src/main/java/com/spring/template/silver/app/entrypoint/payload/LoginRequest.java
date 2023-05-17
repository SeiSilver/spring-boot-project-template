package com.spring.template.silver.app.entrypoint.payload;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

  private String email;
  private String password;

}
