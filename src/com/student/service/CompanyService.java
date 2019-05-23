package com.student.service;

import java.util.List;

import com.student.pojo.Company;
import com.ts.dao.CompanyDao;

import util.Page;

public class CompanyService {
	CompanyDao dao=new CompanyDao();
	public boolean add(Company company) {
		return dao.add(company);
		
	}
	public List<Company> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}
	public Company getById(int id) {
		return dao.getById(id);
		
	}
	public boolean update(Company company) {
		return dao.update(company);
		
	}
	public boolean del(int id) {
		return dao.del(id);
	}
	public int getCount(String name) {
		return 	this.dao.getCount(name);
	}
	public Company getByName(String name) {
		return dao.getByName(name);
		
	}
	
}
