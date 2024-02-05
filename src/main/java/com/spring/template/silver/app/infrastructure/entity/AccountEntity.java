package com.spring.template.silver.app.infrastructure.entity;

import com.spring.template.silver.app.infrastructure.entity.base.BaseIdAuditEntity;
import com.spring.template.silver.app.infrastructure.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@EntityListeners(AuditingEntityListener.class)
public class AccountEntity extends BaseIdAuditEntity<Integer> {

  private String email;

  private String passwordHash;

  private String fullName;

  private String avatarUrl;

  @Enumerated(EnumType.STRING)
  private AccountStatus status;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "account_role",
      joinColumns = @JoinColumn(name = "account_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<RoleEntity> roles;

}