package com.x;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.x.dao.AdminDao;
import com.x.pojo.Admin;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

		AdminDao adminDao = (AdminDao) applicationContext.getBean(AdminDao.class);

		Timestamp timeStamp = new Timestamp(new Date().getTime());
		Admin admin = new Admin();
//		admin.setCargo("subgerente");
//		admin.setNombre("ernesto");
//		admin.setFechaCreacion(timeStamp);

		try{
//			if(adminDao.save(admin)){
//				System.out.println("Dato insertado correctamente");
//			}else{
//				System.out.println("Error al insertar el dato");
//			}
//			
//			List<Admin> admins = adminDao.findAll();
//			for (Admin admin2 : admins) {
//				System.out.println(admin2);
//			}
//			
//			System.out.println(adminDao.findById(3));
//			System.out.println(adminDao.findByName("ern").toString());
			
			admin = adminDao.findById(1);
			System.out.println("admin con el id 1 : " + admin);
			admin.setCargo("papanatas");
			adminDao.update(admin);
			System.out.println("cargo del admin 1 actualizado: " + admin);
			Admin admin2 = new Admin("mefistofeles", "enbaucador siniesto", timeStamp);
			adminDao.save(admin2);
			System.out.println("adminsitradores actuales: "+adminDao.findAll());
			adminDao.delete(6);
			System.out.println("eliminado el id 6 (lucifago) ");
			System.out.println("adminsitradores actuales: "+adminDao.findAll());
			
			
			
		}catch(CannotGetJdbcConnectionException ex){
			ex.printStackTrace();
		}catch(DataAccessException ex){
			ex.printStackTrace();
		}

		((ClassPathXmlApplicationContext)applicationContext).close();

	}
}
