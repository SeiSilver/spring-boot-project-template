package com.spring.template.silver.app.entrypoint.payload;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

  private String accessToken;

}
