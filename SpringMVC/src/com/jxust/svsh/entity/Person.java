package com.jxust.svsh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 个人信息实体类
 * 注解方式配置对应数据表
 * @author Peng
 * @Date2016年12月8日下午2:54:52
 */
@Entity
@Table(name = "person")
public class Person {

	private String id;// 主键id
	private String name;// 姓名
	private String idCard;// 身份证号
	private String phone;// 手机号
	private String address;// 地址

	public Person() {
		super();
	}

	public Person(String name, String idCard, String phone, String address) {
		super();
		this.name = name;
		this.idCard = idCard;
		this.phone = phone;
		this.address = address;
	}

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GenericGenerator(name = "generator", strategy = "uuid")
	@GeneratedValue(generator = "generator")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "idCard", nullable = false, length = 32)
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "phone", nullable = false, length = 32)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	@Column(name = "address", nullable = false, length = 32)
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", idCard=" + idCard + ", phone=" + phone + ", address="
				+ address + "]";
	}

}
