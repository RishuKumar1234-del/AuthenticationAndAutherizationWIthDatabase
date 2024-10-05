package com.security.securitywithver3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.securitywithver3.dto.Product;
import com.security.securitywithver3.entity.UserInfo;
import com.security.securitywithver3.repository.UserInfoRepository;

@Service
public class ProductService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	List<Product> productList;
	
   public ProductService(List<Product> productList) {
	   
	   productList.add(new Product(101, "Mobile"));
	   productList.add(new Product(95, "laptop"));
	   productList.add(new Product(234, "home"));
	   this.productList=productList;
   }
   
   public List<Product> getAll(){
	   
	   return productList;
   }
   
   public Product getProductByid(int id) {
	   
	   Product product=null;
	   
	   for(Product pr:productList) {
		   
		   if(pr.getId()==id) {
			   product=pr;
			   break;
		   }
	   }
	   
	   return product;
   }
   
   public String addUser(UserInfo userInfo) {
	   
	   userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	   userInfoRepository.save(userInfo);
	   
	   return "user added to system";
	   
   }
	

}
