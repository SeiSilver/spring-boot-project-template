package com.spring.template.silver.app.security.dto;

import com.spring.template.silver.app.infrastructure.entity.AccountEntity;
import com.spring.template.silver.app.infrastructure.enums.AccountStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public record CustomUserDetails(AccountEntity accountEntity) implements UserDetails {

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getAuthorityList(accountEntity);
  }

  public static List<GrantedAuthority> getAuthorityList(AccountEntity accountEntity) {
    List<GrantedAuthority> grantList = new ArrayList<>();
    accountEntity.getRoles().forEach(
        roleEntity -> grantList.add(new SimpleGrantedAuthority(roleEntity.getRoleName().name()))
    );
    return grantList;
  }

  @Override
  public String getPassword() {
    return accountEntity.getPasswordHash();
  }

  @Override
  public String getUsername() {
    return accountEntity.getFullName();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return accountEntity.getStatus() == AccountStatus.ACTIVE;
  }

}
