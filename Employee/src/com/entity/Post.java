package com.entity;

public class Post {
	private int pid;
	private String pname;
	private int pstatus;
	
	public Post(){}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPstatus() {
		return pstatus;
	}

	public void setPstatus(int pstatus) {
		this.pstatus = pstatus;
	}
	
}
