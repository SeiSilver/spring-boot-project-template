package com.spring.template.silver.app.infrastructure.entity;

import com.spring.template.silver.app.infrastructure.entity.base.BaseIdEntity;
import com.spring.template.silver.app.infrastructure.enums.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "role")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends BaseIdEntity<Integer> {

  @Enumerated(EnumType.STRING)
  private RoleType roleName;

}