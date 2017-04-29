package com.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.domain.Product;
import com.ssh.service.ProductService;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	//ģ������ʹ�õ��ࣻ
	private Product product = new Product();
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	private static final long serialVersionUID = 1L;
	
	//Struts����Spring�����а������Զ�ע����� 
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String save() {
		
//		String name = this.product.getPname();
//		Double price = this.product.getPrice();
//		System.out.println("name:"+ name+" price:"+ price);
//		//System.out.println("action is executing!");
		productService.save(product);
		return NONE;
	}
}
