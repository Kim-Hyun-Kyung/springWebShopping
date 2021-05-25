package com.study.springboot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.ProductDto;

public interface productService {
	
	public void addProduct(ProductDto dto);
	
	public void deleteProduct(@Param("id") String id);
	
	public List<ProductDto> selectAll();
	
	public ProductDto selectProduct (@Param("id") String id);
}
