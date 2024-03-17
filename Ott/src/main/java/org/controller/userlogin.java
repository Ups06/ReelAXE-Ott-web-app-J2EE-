package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import org.model.been.userbeen;
import org.model.dao.logindao;
import org.model.dao.isSUB;
@WebServlet("/userlogin")

public class userlogin extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uemail=req.getParameter("uemail");
		String upass=req.getParameter("upass");
		
		userbeen ul=new userbeen();
		
		ul.setUemail(uemail);
		ul.setUpass(upass);
		
		HttpSession session=req.getSession();
		
		PrintWriter p=res.getWriter();
		logindao l=new logindao();
		
		isSUB s=new isSUB();
		
		
		if(l.check(ul)) {
			
			
			session.setAttribute("EMAIL", uemail);
			s.isOver(ul);
			if(s.hasSubscription(ul))
			{
			res.sendRedirect("home.jsp");
			}
			else {
				res.sendRedirect("subscribe.jsp");
			}
			
		}
		else {
			res.sendRedirect("login.jsp?msg=invalid");
		}
				
	}



}
