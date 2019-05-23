package com.student.pojo;

public class Company {
	private int id;
	private String name;
	private String sname;
	private String filepath;
	public Company() {
		super();
	}
	public Company(int id, String name, String sname, String filepath) {
		super();
		this.id = id;
		this.name = name;
		this.sname = sname;
		this.filepath = filepath;
	}
	public Company(String name, String sname, String filepath) {
		super();
		this.name = name;
		this.sname = sname;
		this.filepath = filepath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", sname=" + sname + ", filepath=" + filepath + "]";
	}
	


}
