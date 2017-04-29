package com.ssh.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ssh.domain.Product;

public class ProductDao extends HibernateDaoSupport{
	public void save(Product product) {
		System.out.println("dao is exeing;");
		this.getHibernateTemplate().save(product);
	}
}
