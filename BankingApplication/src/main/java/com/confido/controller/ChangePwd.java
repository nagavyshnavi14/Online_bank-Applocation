package com.confido.controller;

import java.io.IOException;

import com.confido.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/ChangePwd")
public class ChangePwd extends HttpServlet {
	private HttpSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("npwd");
		HttpSession session = request.getSession();
		
		int accno = (int) session.getAttribute("accno");
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			m.setPwd(pwd);
			boolean b = m.ChangePwd();
			if(b==false) {
				response.sendRedirect("/BankingApplication/changepwdfail.html");
			}else {
				response.sendRedirect("/BankingApplication/changepwdsuccess.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
