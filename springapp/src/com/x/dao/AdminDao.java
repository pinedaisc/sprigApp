package com.x.dao;



import java.util.List;

import org.springframework.expression.spel.ast.Literal;

import com.x.pojo.Admin;

public interface AdminDao {
	public boolean save(Admin admin);
	
	public List<Admin> findAll();
	
	public Admin findById(int i);
	
	public List<Admin> findByName(String name);
	
	public boolean update(Admin admin);
	
	public boolean delete(int id);
}
