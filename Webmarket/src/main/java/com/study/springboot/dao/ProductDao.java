package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.ProductDto;

@Mapper
public interface ProductDao {

	public void addProduct(ProductDto dto);
	
	public void deleteProduct(@Param("id") String id);
	
	public List<ProductDto> selectAll();
	
	public ProductDto selectProduct (@Param("id") String id);
}
