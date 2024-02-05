package com.spring.template.silver.app.usecase.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "application")
@Getter
@RequiredArgsConstructor
@Validated
public class ApplicationProperties {

  @NotNull
  @Valid
  private final JwtConfig jwtConfig;

  public record JwtConfig(@NotBlank String tokenSecret, @NotNull Integer tokenExpiredSeconds) {

  }

}
