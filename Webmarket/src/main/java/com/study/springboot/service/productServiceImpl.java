package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ProductDao;
import com.study.springboot.dto.ProductDto;

@Service
public class productServiceImpl implements productService {

	@Autowired
	ProductDao dao;
	
	@Override
	public void addProduct(ProductDto dto) {
		dao.addProduct(dto);
	}

	@Override
	public void deleteProduct(String id) {
		dao.deleteProduct(id);
	}

	@Override
	public List<ProductDto> selectAll() {
		
		List<ProductDto> productList = dao.selectAll();
		
		System.out.println("servicelmpl");
		System.out.println(productList);
		
		return productList;
	}

	@Override
	public ProductDto selectProduct(String id) {
		
		ProductDto productview = dao.selectProduct(id);
		return productview;
	}

}
