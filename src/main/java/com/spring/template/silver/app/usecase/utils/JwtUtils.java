package com.spring.template.silver.app.usecase.utils;

import com.spring.template.silver.app.infrastructure.entity.AccountEntity;
import com.spring.template.silver.app.usecase.config.ApplicationProperties;
import com.spring.template.silver.app.usecase.exception.InvalidJsonException;
import com.spring.template.silver.app.usecase.security.dto.JwtDto;
import io.jsonwebtoken.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
@AllArgsConstructor
@Log4j2
public class JwtUtils {

  private final PayloadUtils payloadUtils;
  private final ApplicationProperties applicationProperties;

  public JwtDto createToken(AccountEntity accountEntity) {

    Date current = new Date();
    Calendar expiredDate = Calendar.getInstance();
    expiredDate.setTime(current);
    expiredDate.add(Calendar.SECOND, applicationProperties.getJwtConfig().tokenExpiredSeconds());

    String token = Jwts.builder()
        .setId(accountEntity.getEmail())
        .setSubject(payloadUtils.parseObjectToString(accountEntity))
        .setIssuedAt(current)
        .setExpiration(expiredDate.getTime())
        .signWith(SignatureAlgorithm.HS256, applicationProperties.getJwtConfig().tokenSecret())
        .compact();

    return JwtDto.builder()
        .accessToken(token)
        .build();
  }

  public AccountEntity getAccountFromJWT(String token) throws InvalidJsonException {
    Claims claims = Jwts.parser()
        .setSigningKey(applicationProperties.getJwtConfig().tokenSecret())
        .parseClaimsJws(token)
        .getBody();
    String subject = claims.getSubject();
    return payloadUtils.parseJson(subject, AccountEntity.class);
  }

  public boolean validateToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(applicationProperties.getJwtConfig().tokenSecret()).parseClaimsJws(authToken);
      return true;
    } catch (MalformedJwtException ex) {
      log.error("Invalid JWT token");
    } catch (ExpiredJwtException ex) {
      log.error("Expired JWT token");
    } catch (UnsupportedJwtException ex) {
      log.error("Unsupported JWT token");
    } catch (IllegalArgumentException ex) {
      log.error("JWT claims string is empty.");
    }
    return false;
  }

}