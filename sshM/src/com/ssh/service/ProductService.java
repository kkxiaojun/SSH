package com.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.ProductDao;
import com.ssh.domain.Product;

@Transactional
public class ProductService {
	//ҵ���Ҫע��DAO����
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void save(Product product){
		System.out.println("service is executing !");
		productDao.save(product);
	}
	
}
