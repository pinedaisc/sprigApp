package com.x.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Direccion {
	private String calle;
	private String cp;
	private String cambio1;
	public Direccion() {
		// TODO Auto-generated constructor stub
	}
	public Direccion(String calle, String cp) {
		this.calle = calle;
		this.cp = cp;
	}
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", cp=" + cp + "]";
	}
	@Autowired
	public void setCalle(@Value("Zaragoza")String calle) {
		this.calle = calle;
	}
	@Autowired
	public void setCp(@Value("15468")String cp) {
		this.cp = cp;
	}
	
	
}
