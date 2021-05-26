package com.study.springboot;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.study.springboot.dto.ProductDto;
import com.study.springboot.dto.UserDto;
import com.study.springboot.service.loginService;
import com.study.springboot.service.productService;

@Controller
public class mainController {
	@Resource
	productService service;
	@Resource 
	ProductDto dto;
	@Resource
	loginService loginservice;
	@Resource
	UserDto user;
	
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
	
	
	@RequestMapping(value="/detail.do")
	public String detail(Model model,HttpServletRequest request) {
		String pk  = request.getParameter("productPk");
		
		dto = service.selectProduct(pk);
		model.addAttribute("dto",dto);
		
		return "productDetail";
	}
	
	
	@RequestMapping(value="/addProduct.do")
	public String addProduct() {
		
		/*
		 * if(language==null || language=="") { language =
		 * request.getLocale().getLanguage(); } System.out.println("language "+
		 * language);
		 * 
		 * model.addAttribute("language",language);
		 */
		
		return "addProduct";
	}
	
	
	@RequestMapping(value="/processAddProduct.do")
	public String processAdd(Model model,HttpServletRequest request,MultipartFile multi) {
				
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
	
	@RequestMapping("/login.do")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/security_check.do")
	public String login_check(Model model, HttpServletRequest request, UserDto user) {
		
		return "Welcome";
	}
	
	@RequestMapping("/logout.do")
	public String logout() {
		return "logout";
	}
	
	@RequestMapping("/addMember.do")
	public String addMember(HttpServletRequest request) {
		
		return "addMember";
	}
	@RequestMapping("/processAddMember.do")
	public String processMember(Model model,HttpServletRequest request) {
		user.setId(request.getParameter("id"));
		user.setPw(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		
		String junum = request.getParameter("junum1")
				+	request.getParameter("junum2");
		user.setJunum(junum);
		
		user.setGrade(request.getParameter("grade"));
		
		String email = request.getParameter("mail1")
			+ request.getParameter("mail2");
		user.setEmail(email);
		
		String phone = request.getParameter("phone1")
				+request.getParameter("phone2")
				+request.getParameter("phone3");
		user.setPhone(phone);
		
		user.setAddress(request.getParameter("address"));
		
		int result = loginservice.addUser(user);
		String resultScript ="";
		System.out.println(result +" result");
		if(result==1) {
			resultScript="<script type='text/javascript'>alert('회원가입에 성공하셨습니다.');</script>";
			model.addAttribute("resultScript ",resultScript);
			return "redirect:/addMember.do";
		}else{
			resultScript="<script>alert('회원가입에 실패하셨습니다.');</script>";
			model.addAttribute("resultScript ",resultScript);
			return "forward:/addMember.do";
		}
	}
}
