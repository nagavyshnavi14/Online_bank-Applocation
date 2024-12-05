package com.confido.controller;

import java.io.IOException;

import com.confido.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class login extends HttpServlet {
	private HttpSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custID = request.getParameter("custID");
		String pwd = request.getParameter("pwd");
		session=request.getSession(true);
		try {
			Model m= new Model();
			m.setCustID(custID);
			m.setPwd(pwd);
			boolean b = m.login();
			
			if(b==true) {
				session.setAttribute("accno",m.getAccno());
				response.sendRedirect("/BankingApplication/Home.html");
			}else {
				response.sendRedirect("/BankingApplication/Error.html");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
