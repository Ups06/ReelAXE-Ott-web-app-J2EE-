package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.model.been.userbeen;
import org.model.dao.userdao;

@WebServlet("/usereg")
public class usereg extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uid=req.getParameter("uid");
		String uname=req.getParameter("name");
		String uemail=req.getParameter("email");
		String uage=req.getParameter("birthday");
		String uphn=req.getParameter("phone");
		String ugender=req.getParameter("gender");
//		String subStrt=req.getParameter("uid");
//		String subEnd=req.getParameter("uid");
//		String SubAmt=req.getParameter("uid");
		String upass=req.getParameter("pass");
		
		userbeen u=new userbeen();
		u.setUid(uid);
		u.setUname(uname);
		u.setUemail(uemail);
		u.setUage(uage);
		u.setUphn(uphn);
		u.setUgender(ugender);
		u.setUpass(upass);
		
		userdao us=new userdao();
		int i=us.insert(u);
		
		if(i!=0) {
			res.sendRedirect("sign_up.jsp?status=valid");
		}
		else {
			res.sendRedirect("sign_up.jsp?status=invalid");
		}
	}
}
