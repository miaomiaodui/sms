package com.ts.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.student.pojo.Company;

import util.Page;


public class CompanyDao extends BaseDao{
	QueryRunner runner=new QueryRunner(pool);
	public boolean add(Company c) {
		String sql="insert into company (name,sname,filepath) values(?,?,?)";
		try {
			int i = runner.update(sql, c.getName(),c.getSname(),c.getFilepath());
			System.out.println(i);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Company> list() {
		String sql="select * from company";
		try {
			return runner.query(sql, new BeanListHandler<Company>(Company.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Company getById(int id) {
		/*openConnection();
		String sql="select * from company where id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				return new Company(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("sname"),
						rs.getString("filepath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;*/
		String sql="select * from company where id=?";
		try {
			return  runner.query(sql, new BeanHandler<Company>(Company.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean update(Company c) {
		String sql="update company set name=?,sname=?,filepath=? where id=?";
		try {
			int i = runner.update(sql, c.getName(),c.getSname(),c.getFilepath(),c.getId());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean del(int id) {
		String sql="delete from company where id=?";
		try {
			int i = runner.update(sql, id);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	public int getCount(String name) {
		String sql="select count(*) from company where name like ?";
		try {
			 return ((Long)runner.query(sql, new ScalarHandler<>(1), "%"+name+"%")).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Company getByName(String name) {
		String sql="select * from company where name=?";
		try {
			return  runner.query(sql, new BeanHandler<Company>(Company.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
