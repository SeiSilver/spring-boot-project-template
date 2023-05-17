package com.spring.template.silver.app.usecase.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class ModelMapperUtils {

  private final ModelMapper modelMapper;

  public <T> T map(Object source, Class<T> targetClass) {
    return modelMapper.map(source, targetClass);
  }

  public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
    return source
        .stream()
        .map(element -> modelMapper.map(element, targetClass))
        .toList();
  }

}
