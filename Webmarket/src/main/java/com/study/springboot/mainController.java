package com.study.springboot;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.springboot.dto.ProductDto;
import com.study.springboot.service.productService;


@Controller
public class mainController {
	@Resource
	productService service;
	@Resource 
	ProductDto dto; 
	
	@RequestMapping("/")
	public String root() {
		return "Welcome";
	}
	
	
	@RequestMapping("/products.do")
	public String productList(Model model) {
		
		List <ProductDto> list = service.selectAll();
	  
		model.addAttribute("list",list);
		
		return "products";
	}
	
	
	@RequestMapping(value="/detail.do",method=RequestMethod.POST)
	public String detail(Model model,HttpServletRequest request) {
		String pk  = request.getParameter("productPk");
		
		dto = service.selectProduct(pk);
		model.addAttribute("dto",dto);
		
		return "productDetail";
	}
	
	
	@RequestMapping(value="/addProduct.do")
	public String addProduct() {
		return "addProduct";
	}
	
	
	@RequestMapping(value="/processAddProduct.do")
	public String processAdd(Model model,HttpServletRequest request) {
				
		String productId= request.getParameter("productId");
		String name = request.getParameter("name");
		String unitPrice = request.getParameter("unitPrice");
		String description = request.getParameter("description");
		String manufacturer = request.getParameter("manufacturer");
		String category = request.getParameter("category");
		String unitsInStock = request.getParameter("unitsInStock");
		String condition = request.getParameter("condition");
		
		Integer price;
		
		if(unitPrice.isEmpty()) {
			price =0;
		}else {
			price=Integer.valueOf(unitPrice);
		}
		
		long stock;
		
		if(unitsInStock.isEmpty()) {
			stock=0;
		}else {
			stock = Long.valueOf(unitsInStock);
		}
		
		dto.setProductId(productId);
		dto.setPname(name);
		dto.setUnitPrice(Integer.toString(price));
		dto.setDescription(description);
		dto.setManufacturer(manufacturer);
		dto.setCategory(category);
		dto.setUnitsInStock(stock);
		dto.setPcondition(condition);
		
		service.addProduct(dto);
		
		return "redirect:/products.do";
	}

}
