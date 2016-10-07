package com.x.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AdminRowMapper implements RowMapper<Admin>{

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		
		admin.setIdAd(rs.getInt("idAd"));
		admin.setNombre(rs.getString("nombre"));
		admin.setCargo((rs.getString("cargo")));
		admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
		return admin;
	}

	
}
