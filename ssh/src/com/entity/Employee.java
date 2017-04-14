package com.entity;

import java.util.Date;

/**
 * Employee entity. @hope Eclipse Tools
 */

public class Employee implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 员工id
	private Integer eid;
	// 员工部门
	private Department department;
	// 员工name
	private String ename;
	// 员工sex
	private String sex;
	// 生日
	private Date birthday;
	// 加入时间
	private Date joinDate;
	// 员工编号
	private String eno;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** full constructor */
	public Employee(Department department, String ename, String sex,
			Date birthday, Date joinDate, String eno, String username,
			String password) {
		this.department = department;
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.joinDate = joinDate;
		this.eno = eno;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getEno() {
		return this.eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}