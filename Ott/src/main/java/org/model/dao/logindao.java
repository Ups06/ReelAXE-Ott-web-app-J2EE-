package org.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.misc.connectionProvider;
import org.model.been.userbeen;

import com.mysql.cj.protocol.Resultset;

public class logindao {
	
	 public boolean check(userbeen u) {
		 boolean status=false;
		 Connection con;
		 PreparedStatement p;
		 
		 ResultSet r;
		 
		 try {
			 con=connectionProvider.createC();
			 p=con.prepareStatement("select * from user where uemail=? and upass=?");
			 
			 p.setString(1, u.getUemail());
			 p.setString(2, u.getUpass());
			 r=p.executeQuery();
			 status=r.next();
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 return status;
	 }

}
