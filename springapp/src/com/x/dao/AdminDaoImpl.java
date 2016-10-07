package com.x.dao;


import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.x.pojo.Admin;
import com.x.pojo.AdminRowMapper;

@Component
public class AdminDaoImpl implements AdminDao{
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(Admin admin) {
//		MapSqlParameterSource paramMap = new MapSqlParameterSource();
//		paramMap.addValue("nombre", admin.getNombre());
//		paramMap.addValue("cargo", admin.getCargo());
//		paramMap.addValue("fechaCreacion", admin.getFechaCreacion());
		
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		
		return jdbcTemplate.update("insert into admin(nombre, cargo, fechaCreacion) values (:nombre, :cargo, :fechaCreacion)", paramMap) == 1 ;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from admin", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();
				
				admin.setIdAd(rs.getInt("idAd"));
				admin.setNombre(rs.getString("nombre"));
				admin.setCargo((rs.getString("cargo")));
				admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
				return admin;
			}
		});
	}

	@Override
	public Admin findById(int id) {
//		return (Admin) jdbcTemplate.query("select * from admin were idAd = :idAd",
//				new MapSqlParameterSource("idAd", id),new AdminRowMapper());
		return jdbcTemplate.queryForObject("select * from admin where idAd=:idAd",
				new MapSqlParameterSource("idAd", id), new AdminRowMapper());
	}

	@Override
	public List<Admin> findByName(String name) {
		return jdbcTemplate.query("select * from admin where nombre like :nombre",
				new MapSqlParameterSource("nombre", "%"+name+"%"),new AdminRowMapper());
		
	}

	@Override
	public boolean update(Admin admin) {
		
		return jdbcTemplate.update("update admin set nombre=:nombre, cargo=:cargo, fechaCreacion=:fechaCreacion where idAd=:idAd", new BeanPropertySqlParameterSource(admin)) == 1 ;
	}

	@Override
	public boolean delete(int id) {
		return jdbcTemplate.update("delete from admin where idAd=:idAd", new MapSqlParameterSource("idAd", id)) == 1 ;
	}

}
