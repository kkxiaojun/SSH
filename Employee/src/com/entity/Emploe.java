package com.entity;

import java.util.Date;

public class Emploe {
	private int eid;			//员工编号
	private String ename;		//姓名
	private String esex;		//性别	
	private Date ebir;			
	private String emarry;
	private String ephone;
	private String eaddr;
	private int did;			//部门编号
	private int pid;			//职位编号
	private String eedu;		//教育背景
	private String esalary;		//薪资
	private String epassword;	//登录密码
	private String ephoto;		//图像
	private String equestion;	//找回密码问题
	private String eanswer;		//问题答案		
	private int estatus;		//状态
	
	public Emploe(){}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsex() {
		return esex;
	}

	public void setEsex(String esex) {
		this.esex = esex;
	}

	public Date getEbir() {
		return ebir;
	}

	public void setEbir(Date ebir) {
		this.ebir = ebir;
	}

	public String getEmarry() {
		return emarry;
	}

	public void setEmarry(String emarry) {
		this.emarry = emarry;
	}

	public String getEphone() {
		return ephone;
	}

	public void setEphone(String ephone) {
		this.ephone = ephone;
	}

	public String getEaddr() {
		return eaddr;
	}

	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getEedu() {
		return eedu;
	}

	public void setEedu(String eedu) {
		this.eedu = eedu;
	}

	public String getEsalary() {
		return esalary;
	}

	public void setEsalary(String esalary) {
		this.esalary = esalary;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	public String getEphoto() {
		return ephoto;
	}

	public void setEphoto(String ephoto) {
		this.ephoto = ephoto;
	}

	public String getEquestion() {
		return equestion;
	}

	public void setEquestion(String equestion) {
		this.equestion = equestion;
	}

	public String getEanswer() {
		return eanswer;
	}

	public void setEanswer(String eanswer) {
		this.eanswer = eanswer;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
}
